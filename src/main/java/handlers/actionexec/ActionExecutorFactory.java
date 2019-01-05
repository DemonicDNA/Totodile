package handlers.actionexec;

import entities.actions.TotodileAction;

import java.util.Optional;

public class ActionExecutorFactory {

    public Optional<ActionExecutor> getActionExecutor(TotodileAction totodileAction){
        switch (totodileAction.getType()){
            case panorama:
                return Optional.of(new PanoramaActionExecutor());
        }
        return Optional.empty();
    }

}
