# Cache Replacement Algorithm Sequence Diagrams

This document contains sequence diagrams illustrating the logic for LRU (Least Recently Used) and MRU (Most Recently Used) cache replacement algorithms. You can copy and paste this Markdown code into Typora or any other editor that supports Mermaid diagrams.

---

## Least Recently Used (LRU)

In this scenario, when the cache is full and a new item needs to be added, the cache evicts the item that has not been accessed for the longest amount of time.

```mermaid
sequenceDiagram
    participant Client
    participant Cache
    participant DataSource

    Client->>Cache: Request data for Key 'A'

    alt Cache Hit
        Cache-->>Client: Return cached data for 'A'
        Note right of Cache: Mark 'A' as most recently used
    else Cache Miss
        Cache->>DataSource: Fetch data for Key 'A'
        DataSource-->>Cache: Return data for 'A'

        alt Cache is Full
            Cache->>Cache: Evict LEAST recently used item (e.g., Key 'Z')
        end

        Cache->>Cache: Store data for 'A'
        Note right of Cache: Mark 'A' as most recently used
        Cache-->>Client: Return new data for 'A'
    end
```

---

## Most Recently Used (MRU)

In this scenario, when the cache is full and a new item needs to be added, the cache evicts the item that was most recently accessed. This strategy can be effective for workloads where older items are more likely to be re-used.

```mermaid
sequenceDiagram
    participant Client
    participant Cache
    participant DataSource

    Client->>Cache: Request data for Key 'B'

    alt Cache Hit
        Cache-->>Client: Return cached data for 'B'
        Note right of Cache: Mark 'B' as most recently used
    else Cache Miss
        Cache->>DataSource: Fetch data for Key 'B'
        DataSource-->>Cache: Return data for 'B'

        alt Cache is Full
            Cache->>Cache: Evict MOST recently used item (e.g., Key 'Y')
        end

        Cache->>Cache: Store data for 'B'
        Note right of Cache: Mark 'B' as most recently used
        Cache-->>Client: Return new data for 'B'
    end
```
