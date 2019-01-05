package handlers;

import entities.TotodileWatcher;
import handlers.actionexec.ActionExecutorManager;
import handlers.conditionresolve.ConditionResolverManager;
import handlers.queryexec.ElasticQueryExecutor;
import handlers.queryexec.QueryExecutor;
import handlers.queryexec.results.Result;

public class WatcherHandler {
    private final Integer throttling;
    private final String watcherName;
    private QueryExecutor queryExecutor;
    private final ConditionResolverManager conditionResolverManager;
    private final ActionExecutorManager actionExecutorManager;

    private static final int MILLIS_TO_SECONDS = 1000;

    public WatcherHandler(TotodileWatcher watcher) {
        //todo: add query type and then a map between query type to query executor
        this.queryExecutor = new ElasticQueryExecutor(watcher.getQuery());
        this.conditionResolverManager = new ConditionResolverManager(watcher.getCondition());
        this.actionExecutorManager = new ActionExecutorManager(watcher.getActions());
        this.throttling = watcher.getThrottling() != null ? watcher.getThrottling() * MILLIS_TO_SECONDS : 0;
        this.watcherName = watcher.getName();
    }

    //todo: how to resolve a problem if elastic query take more than set interval? maybe get interval as minutes
    public void handle() {
        final Result queryResult = queryExecutor.query();
        Boolean answer = conditionResolverManager.resolve(queryResult);
        if (answer != null && answer) {
            System.out.println(watcherName + " Info: Condition Resolved, Executing Actions");
            actionExecutorManager.execute();
            goToSleep();
        }
    }

    private void goToSleep() {
        try {
            System.out.println(watcherName + " Info: Going to sleep for " + throttling + " millis");
            Thread.sleep(throttling);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
