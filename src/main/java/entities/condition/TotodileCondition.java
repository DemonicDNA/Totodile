package entities.condition;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "check")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HitsTotalCondition.class, name = "hits_total")
})
public abstract class TotodileCondition {

    private ConditionType type;
    private ConditionCheck check;

    public TotodileCondition(ConditionCheck check){
        this.check = check;
    }

    public ConditionType getType() {
        return type;
    }

    public void setType(ConditionType type) {
        this.type = type;
    }

    public ConditionCheck getCheck() {
        return check;
    }

    public void setCheck(ConditionCheck check) {
        this.check = check;
    }
}
