package handlers.conditionresolve;

import entities.condition.HitsTotalCondition;
import handlers.queryexec.results.Result;

public class HitsTotalConditionResolver implements ConditionResolver{

    private final HitsTotalCondition hitsTotalCondition;

    public HitsTotalConditionResolver(HitsTotalCondition hitsTotalCondition){
        this.hitsTotalCondition = hitsTotalCondition;
    }

    public Boolean resolve(Result queryResult) {
        final int hitsTotal = queryResult.getHitsTotal();
        final int expected = hitsTotalCondition.getExpected();
        switch (hitsTotalCondition.getEquality()) {
            case eq:
                return hitsTotal == expected;
            case neq:
                return hitsTotal != expected;
            case gte:
                return hitsTotal >= expected;
            case lte:
                return hitsTotal <= expected;
            default:
                System.out.println("Error: Didn't find known equality type");
                return false;

        }
    }

}
