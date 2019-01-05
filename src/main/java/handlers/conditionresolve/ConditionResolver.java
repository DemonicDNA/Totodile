package handlers.conditionresolve;

import entities.condition.HitsTotalCondition;
import entities.condition.TotodileCondition;
import handlers.queryexec.results.Result;

public class ConditionResolver {
    private TotodileCondition condition;

    public ConditionResolver(TotodileCondition condition) {
        this.condition = condition;
    }

    public Boolean resolve(Result queryResult) {
        switch (condition.getType()) {
            case compare:
                switch (condition.getCheck()) {
                    case hits_total:
                        //todo: move to factory
                        final HitsTotalCondition hitsTotalCondition = (HitsTotalCondition) this.condition;
                        return new HitsTotalConditionResolver(hitsTotalCondition)
                                .resolve(queryResult);
                }
                break;
        }

        return false;
    }
}
