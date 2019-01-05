package handlers.queryexec.results;

public class ElasticResult implements Result {

    private int size = 10;

    @Override
    public int getHitsTotal() {
        return size;
    }
}
