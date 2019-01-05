package handlers.conditionresolve;

import entities.condition.TotodileCondition;
import handlers.queryexec.results.Result;

import java.util.Optional;

public class ConditionResolverManager {
    private TotodileCondition condition;
    private ConditionResolverFactory conditionResolverFactory = new ConditionResolverFactory();
    public ConditionResolverManager(TotodileCondition condition) {
        this.condition = condition;
    }

    public Boolean resolve(Result queryResult) {
        final Optional<ConditionResolver> resolverOptional = conditionResolverFactory.getResolver(condition);
        final ConditionResolver resolver;
        if (resolverOptional.isPresent()){
            resolver = resolverOptional.get();
        } else{
            System.out.println("Error: Couldn't create a resolver");
            return null;
        }
        switch (condition.getType()) {
            case compare:
                return resolver.resolve(queryResult);
        }

        return false;
    }
}
