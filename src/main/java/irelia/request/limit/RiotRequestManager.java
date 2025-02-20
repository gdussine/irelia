package irelia.request.limit;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.IreliaLogger;
import irelia.request.core.RiotRequest;

public abstract class RiotRequestManager {

	protected Thread runner;
	protected Irelia irelia;
	protected List<RiotRequest<?>> queue = new ArrayList<>();
	protected Logger log;

	public RiotRequestManager(Irelia irelia) {
		this.irelia = irelia;
		this.runner = getRunner();
		this.log = IreliaLogger.LIMITER.logger(getClass());
	}

	public void start() {
		runner.setName(getName());	
		runner.start();
	}

	public void stop() throws IreliaException {
		runner.interrupt();
		try {
			runner.join();
		} catch (InterruptedException e) {
			throw IreliaException.riotRequestManagerFailedStop(this, e);
		}
	}

	private synchronized Thread getRunner() {
		return new Thread(() -> {
			synchronized (this) {
				this.log.debug("%s started.".formatted(this.getName()));
				try {
					while (true) {
						if (queue.size() <= 0) {
							this.wait();
						} else {
							run(queue.remove(0));
						}
					}
				} catch (InterruptedException e) {
					this.log.debug("%s stopped.".formatted(this.getName()));
				}
			}
		});
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	protected abstract void run(RiotRequest<?> request) throws InterruptedException;

	public CompletableFuture<HttpResponse<byte[]>> submit(RiotRequest<?> request) {
		queue.add(request);
		synchronized (this) {
			this.notifyAll();
		}
		return request.getPayload();
	}

}
