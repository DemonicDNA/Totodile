package handlers.conditionresolve;

import entities.condition.HitsTotalCondition;
import entities.condition.TotodileCondition;

import java.util.Optional;


public class ConditionResolverFactory {

    public Optional<ConditionResolver> getResolver(TotodileCondition condition){
        switch (condition.getCheck()){
            case hits_total:
                return Optional.of(new HitsTotalConditionResolver((HitsTotalCondition) condition));
        }

        return Optional.empty();
    }

}
