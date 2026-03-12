# HashTableFundamentalsApp

## Use Case 6 - Distributed Rate Limiter

### Objective
To limit requests per client using HashMap and time window logic.

### Concepts Used
- HashMap
- Fixed window
- Request counting
- Time-based reset

### Flow
1. Store client request details
2. Check request count
3. Reset after time window
4. Allow or deny request