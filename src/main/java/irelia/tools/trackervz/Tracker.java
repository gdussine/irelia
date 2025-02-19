package irelia.tools.trackervz;

import java.time.Duration;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import irelia.core.Irelia;
import irelia.data.match.Match;
import irelia.data.spectator.CurrentGameInfo;

public class Tracker<T extends Trackable> {

    protected TrackableQueue<T> afkQueue, inGameQueue;
    protected Irelia irelia;
    protected Logger log;
    protected boolean running;
    protected Thread afkThread;
    protected Thread inGameThread;

    public Tracker(Irelia irelia, Duration afkPeriod, Duration inGamePeriod) {
        this.irelia = irelia;
        this.log = LoggerFactory.getLogger(getClass());
        this.afkQueue = new TrackableQueue<>(afkPeriod);
        this.inGameQueue = new TrackableQueue<>(inGamePeriod);
        this.afkThread = new Thread(() -> afkLoop(), "Tracker AFK");
        this.inGameThread = new Thread(() -> inGameLoop(), "Tracker InGame");
    }

    public void start() {
        inGameThread.start();
        afkThread.start();
    }
    
    public void stop() {
    	inGameThread.interrupt();
    	afkThread.interrupt();
    	try {
			afkThread.join();
			inGameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    public void register(T t) {
    	if(!afkQueue.contains(t) && inGameQueue.contains(t))
    		this.afkQueue.add(t);
    }

    private final void afkLoop() {
        this.loop(afkQueue, (selected) -> {
            CurrentGameInfo spectator = irelia.spectator().byPuuid(selected.getPuuid()).exceptionally((t) -> null)
                    .join();
            if (spectator == null)
                return;
            selected.setGameId(spectator.getGameId());
            onJoinGame(selected, spectator);
            this.swap(afkQueue, inGameQueue, selected);
        });
    }

    private final void inGameLoop() {
        this.loop(inGameQueue, (selected) -> {
            CurrentGameInfo spectator = irelia.spectator().byPuuid(selected.getPuuid())
                    .exceptionally(t -> null).join();
            if (spectator != null && selected.getGameId() == spectator.getGameId())
                return;
            Match match = irelia.match().byId(irelia.getPlatform().getMatchId(selected.getGameId()))
                    .exceptionally(t -> null).join();
            if (match == null)
                return;
            onLeaveGame(selected, match);
            if (spectator == null)
                this.swap(inGameQueue, afkQueue, selected);
            else {
                selected.setGameId(spectator.getGameId());
                this.onJoinGame(selected, spectator);
            }
        });
    }

    protected final void loop(TrackableQueue<T> queue, Consumer<T> function) {
        this.running = true;
        String threadName = Thread.currentThread().getName();
        log.debug("Thread %s started!".formatted(threadName));
        while (running) {
            try {
                queue.await();
                if (queue.isEmpty())
                    continue;
                T selected = queue.getSelectedValue();
                log.debug("%s: %s <- %s".formatted(threadName, selected, queue));
                if (selected == null)
                    continue;
                function.accept(selected);
                queue.next();
            } catch (InterruptedException e) {
                running = false;
                log.debug("Thread %s stopped!".formatted(threadName));
                onTrackerStop(e, threadName);
            } catch (Exception e) {
                running = false;
                log.error("Thread %s stopped!".formatted(threadName), e);
            }
        }
    }

    private void swap(TrackableQueue<T> src, TrackableQueue<T> dst, T t) {
        src.remove(t);
        dst.add(t);
    }

    public void onJoinGame(T selected, CurrentGameInfo info) {
    }

    public void onLeaveGame(T selected, Match match) {
    }
    
    public void onRegister(T t) {
    	
    }
    
    public void onTrackerStop(InterruptedException e, String threadName) {
    	
    }
}
