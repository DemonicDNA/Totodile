package entities.actions;

import entities.actions.parameters.PanoramaParameters;

public class TotodilePanoramaAction extends TotodileAction {

    private PanoramaParameters params;

    public TotodilePanoramaAction(){
        super(TotodileActionType.panorama);
    }

    public PanoramaParameters getParams() {
        return params;
    }

    public void setParams(PanoramaParameters params) {
        this.params = params;
    }
}
