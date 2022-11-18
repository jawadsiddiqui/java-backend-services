### Prototype Design Pattern

- Avoid costly creation
- Avoid subclassing
- Typcially doesn't use "new"
- Often utilizes an interface
- Usually implemented with a registry
- Example:
- java.lang.Object#clone()



### Prototype Vs Factory

#### Prototype 

- Lighter weight construction
  - Copy constructor or clone
-Shallow or Deep
- copy itself


Factory

- Flexible objects
  - multiple constructor
- concrete instance
- Fresh Instance
Example: 
  - Resource Bundle
  - Calendar
  - NumberFormat

- Factory is responsible for lifecycle
- common interface
- concrete class
- parameterized create method

