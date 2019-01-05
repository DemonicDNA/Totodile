# Totodile

Implamantation of WatcherAPI using Java.
1) Configure your Query
2) Add a Condition that you want to be resolved
3) Act using the Action Configuration
 
Configuration Example (Times are in seconds):
```json
[
    {
        "name": "DemonicDNA",
        "description": "Example Of Watcher API Configuration",
        "interval": 1,
        "query": {
            "query": "Kibana format query",
            "index": "Some index",
            "timeRange": ""
        },
        "condition": {
            "type": "compare",
            "check": "hits_total",
            "equality": "gte",
            "expected": 10
        },
        "actions": [
            {
                "type": "panorama",
                "params": {
                    "url": "http://",
                    "severity": 5,
                    "agent": "smith",
                    "alertGroup": "agroup",
                    "node": "Totodile",
                    "expireTime": 123,
                    "link": "http://link to fix problem",
                    "summary": "summary of problem"
                }
            }
        ],
        "throttling": 30
    }
]
```

# Support:
1) Queries:
    - Elastic's Search Query String Query format.
2) Conditions:
    - Types:
        - compare
    - Checks:
        - hits_total
    - Equalities:
        - gte - greater than equal
        - lte - lesser than equal
        - eq - equal
        - neq - not equal
3) Actions:
    - Create a log to send to Panorama
