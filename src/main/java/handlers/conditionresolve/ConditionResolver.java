package handlers.conditionresolve;

import handlers.queryexec.results.Result;

public interface ConditionResolver {

    Boolean resolve(Result queryResult);

}
