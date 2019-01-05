package entities.condition;

public class HitsTotalCondition extends TotodileCondition{

    private ConditionEqualityType equality;
    private int expected;

    public HitsTotalCondition() {
        super(ConditionCheck.hits_total);
    }

    public ConditionEqualityType getEquality() {
        return equality;
    }

    public void setEquality(ConditionEqualityType equality) {
        this.equality = equality;
    }

    public int getExpected() {
        return expected;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

}
