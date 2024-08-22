package irelia.core.request.limit;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;

public abstract class RiotRequestManager {

	protected Thread runner;
	protected Irelia irelia;
	protected List<RiotRequest<?>> queue = new ArrayList<>();
	protected Logger log;
	protected RiotRequestManager next;

	public RiotRequestManager(Irelia irelia, RiotRequestManager next) {
		this(irelia);
		this.next = next;
	}

	public RiotRequestManager(Irelia irelia) {
		this.irelia = irelia;
		this.runner = getRunner();
		this.log = LoggerFactory.getLogger(this.getClass());
	}

	public void start() {
		runner.start();
	}

	public void stop() {
		runner.interrupt();
		try {
			runner.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized Thread getRunner() {
		return new Thread(() -> {
			synchronized (this) {
				try {
					while (true) {
						if (queue.size() <= 0) {
							this.wait();
						} else {
							run(queue.remove(0));
						}
					}
				} catch (InterruptedException e) {
					this.log.debug("%s stopped".formatted(this.getName()));
				}
			}
		});
	}

	protected String getName() {
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
