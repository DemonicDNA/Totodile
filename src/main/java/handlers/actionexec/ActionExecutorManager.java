package handlers.actionexec;

import entities.actions.TotodileAction;
import entities.actions.TotodileActionType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionExecutorManager {


    private Map<TotodileActionType, ActionExecutor> typeToActionExecutor;
    private List<TotodileAction> actions;

    public ActionExecutorManager(List<TotodileAction> actions) {
        this.actions = actions;
        this.typeToActionExecutor = new ConcurrentHashMap<>();
        typeToActionExecutor.put(TotodileActionType.panorama, new PanoramaActionExecutor());
    }

    public void execute() {
        actions.forEach(totodileAction -> typeToActionExecutor.get(totodileAction.getType()).execute(totodileAction.getParams()));
    }
}
