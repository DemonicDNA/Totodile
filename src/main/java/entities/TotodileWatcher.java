package entities;

import entities.actions.TotodileAction;
import entities.condition.ConditionCheck;
import entities.condition.ConditionEqualityType;
import entities.condition.ConditionType;
import entities.condition.TotodileCondition;
import entities.queries.TotodileQuery;

import java.util.List;
import java.util.Map;

public class TotodileWatcher {
    private String name;
    private String description;
    private Integer interval;
    private TotodileQuery query;
    private TotodileCondition condition;
    private List<TotodileAction> actions;
    private Integer throttling;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public TotodileQuery getQuery() {
        return query;
    }

    public void setQuery(TotodileQuery query) {
        this.query = query;
    }

    public TotodileCondition getCondition() {
        return condition;
    }

    public void setCondition(TotodileCondition condition) {
        this.condition = condition;
    }

    public List<TotodileAction> getActions() {
        return actions;
    }

    public void setActions(List<TotodileAction> actions) {
        this.actions = actions;
    }

    public Integer getThrottling() {
        return throttling;
    }

    public void setThrottling(Integer throttling) {
        this.throttling = throttling;
    }
}
