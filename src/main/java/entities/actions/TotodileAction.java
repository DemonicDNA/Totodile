package entities.actions;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import entities.actions.parameters.TotodileActionParameters;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TotodilePanoramaAction.class, name = "panorama")
})
public abstract class TotodileAction {

    private TotodileActionType type;

    public TotodileAction(TotodileActionType actionType) {
        this.type = actionType;
    }

    public TotodileActionType getType() {
        return type;
    }

    public void setType(TotodileActionType type) {
        this.type = type;
    }

    public abstract TotodileActionParameters getParams();

}
