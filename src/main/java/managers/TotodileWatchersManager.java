package managers;

import entities.TotodileWatcher;
import entities.actions.TotodileAction;
import handlers.WatcherHandler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

//todo: implement as singleton
public class TotodileWatchersManager {

    private final List<TotodileWatcher> watchers;
    private final Map<String, ScheduledExecutorService> watcherNameToExecutorMap = new ConcurrentHashMap<>();

    public TotodileWatchersManager(List<TotodileWatcher> watchers) {
        this.watchers = watchers;
    }


    public boolean startAllWatchers() {
        if(watchers == null) {
            System.out.println("Error: No watchers found, fix configuration and try again");
            return false;
        }

        for(TotodileWatcher watcher : watchers){
            if (!isWatcherValid(watcher)) {
                System.out.println("Error: Found an invalid watcher, fix configuration and try again");
                return false;
            }
        }
        System.out.println("Starting Execution of all Watchers");
        final boolean[] failed = {false};
        watchers.forEach(watcher -> {
            try {
                final String watcherName = watcher.getName();
                watcherNameToExecutorMap.put(watcherName,
                        Executors.newSingleThreadScheduledExecutor());
                watcherNameToExecutorMap.get(watcherName)
                        .scheduleAtFixedRate(() -> {
                                    new WatcherHandler(watcher).handle();
                                    System.out.println("Started Handling of: " + watcherName);
                                },
                                0, watcher.getInterval(), TimeUnit.SECONDS);
            } catch (Throwable ex){
                ex.printStackTrace();
                failed[0] = true;
            }
        });
        return !failed[0];
    }

    public void stopAllWatchers() {
        System.out.println("Stopping Execution of all Watchers");
        watcherNameToExecutorMap.values().forEach(ExecutorService::shutdownNow);
    }

    private boolean isWatcherValid(TotodileWatcher watcher) {
        return  watcher.getName() != null &&
                watcher.getInterval() != null &&
                watcher.getQuery() != null &&
                watcher.getCondition() != null &&
                watcher.getActions() != null &&
                validateActions(watcher.getActions());
    }

    private boolean validateActions(List<TotodileAction> actions) {
        for(TotodileAction action : actions){
            if(action.getType() == null){
                return false;
            }
        }
        return true;
    }

}
