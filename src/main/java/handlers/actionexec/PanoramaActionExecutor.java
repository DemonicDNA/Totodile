package handlers.actionexec;

import entities.actions.parameters.TotodileActionParameters;

public class PanoramaActionExecutor implements ActionExecutor {
    @Override
    public void execute(TotodileActionParameters parameters) {
        System.out.println("print to panorama");
    }
}
