package handlers;

import entities.TotodileWatcher;
import handlers.actionexec.ActionExecutorManager;
import handlers.conditionresolve.ConditionResolver;
import handlers.queryexec.ElasticQueryExecutor;
import handlers.queryexec.QueryExecutor;
import handlers.queryexec.results.Result;

public class WatcherHandler {
    private final Integer throttling;
    private QueryExecutor queryExecutor;
    private final ConditionResolver conditionResolver;
    private final ActionExecutorManager actionExecutorManager;
    private final int MILLIS_TO_SECONDS = 1000;;

    public WatcherHandler(TotodileWatcher watcher) {
        //todo: add query type and then a map between query type to query executor
        this.queryExecutor = new ElasticQueryExecutor(watcher.getQuery());
        this.conditionResolver = new ConditionResolver(watcher.getCondition());
        this.actionExecutorManager = new ActionExecutorManager(watcher.getActions());
        this.throttling = watcher.getThrottling();
    }

    //todo: how to resolve a problem if elastic query take more than set interval? maybe get interval as minutes
    public void handle() {
        final Result queryResult = queryExecutor.query();
        Boolean answer = conditionResolver.resolve(queryResult);
        if (answer) {
            actionExecutorManager.execute();
            goToSleep(throttling);
        }
    }

    private void goToSleep(Integer throttling) {
        try {
            Thread.sleep(throttling * MILLIS_TO_SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
