package handlers.queryexec;

import entities.queries.TotodileQuery;
import handlers.queryexec.results.ElasticResult;
import handlers.queryexec.results.Result;

public class ElasticQueryExecutor implements QueryExecutor{

    private TotodileQuery query;

    public ElasticQueryExecutor(TotodileQuery query){
        this.query = query;
    }

    public Result query(){
        return new ElasticResult();
    }

}
