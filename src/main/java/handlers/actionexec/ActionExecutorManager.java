package handlers.actionexec;

import entities.actions.TotodileAction;
import entities.actions.TotodileActionType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ActionExecutorManager {

    private List<TotodileAction> actions;
    private ActionExecutorFactory actionExecutorFactory = new ActionExecutorFactory();

    public ActionExecutorManager(List<TotodileAction> actions) {
        this.actions = actions;
    }

    public void execute() {
        actions.forEach(totodileAction -> {
            final Optional<ActionExecutor> executorOptional = actionExecutorFactory.getActionExecutor(totodileAction);
            executorOptional.ifPresent(actionExecutor -> actionExecutor.execute(totodileAction.getParams()));
        });
    }
}
