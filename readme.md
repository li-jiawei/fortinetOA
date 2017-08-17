##question1
1. NodeUtils.java contains the method that reverses a linkedlist. 
2. Please run NodeUtilsTest for testing. 
    
##question2 - Observer Pattern
1. Scenario:
    1. An employment management system that has a hr department, a payroll department, and a list of employees.
    2. two use cases:
        1. the company hire new employee
        2. employee changes his/her essential information
    3. once one of the case occurs, the hr department and payroll department are supposed to be notified.
    
2. 3 Roles:
    1. Domain - Employee: the object that makes changes
    2. Subject - Employment management system: attach or detach observers to domain objects
    3. Observer - hr and payroll department : get notice when the domain object it is observing makes changes.
    
##question3
1. What is Session in Hibernate?
    * Session is an object that 
        * maintains the connection to database
        * make your transient object to an persistent object when save it to database. 
        * when the persistent object deleted from database, it becomes transient again.
        * when session is closed, the object might become detached.
        * bounded by the beginning and end of a logical transaction.
2. How would you control transaction with Spring & Hibernate. Answer with different scenarios.
    * difference between transaction in Spring and Hibernate
        * for Hibernate
            * transaction are specifically related to changes made within a database
            * if errors occur during your session performing CRUD operations, it can roll back and undone the changes to the database during the transaction.
        * for Spring
            * can combine transactions of the database and provides an uniform api
    * Scenarios for **Isolation**
        1. Dirty reads
            * If T1 transaction reads data from table A1 that was written by another concurrent transaction T2.If on the way T2 is rollback,the data obtained by T1 is invalid one.E.g a=2 is original data .If T1 read a=1 that was written by T2.If T2 rollback then a=1 will be rollback to a=2 in DB.But,Now ,T1 has a=1 but in DB table it is changed to a=2.
        2. Nonrepeatable reads
            * If T1 transaction reads data from table A1.If another concurrent transaction(T2) update data on table A1.Then the data that T1 has read is different from table A1.Because T2 has updated the data on table A1.E.g if T1 read a=1 and T2 updated a=2.Then a!=b.
        3. Phantom reads
            * If T1 transaction reads data from table A1 with certain number of rows. If another concurrent transaction(T2) inserts more rows on table A1.The number of rows read by T1 is different from rows on table A1
    * Solutions for **Isolation**
        * **ISOLATION_READ_UNCOMMITTED** :Allows to read changes that haven’t yet been committed.It suffer from Scenario 1 ,Scenario 2 ,Scenario 3
        
        * **ISOLATION_READ_COMMITTED**:Allows reads from concurrent transactions that have been com- mitted.It may suffer from Scenario 2 ,Scenario 3 . Because other transactions may be updating the data.
        
        * **ISOLATION_REPEATABLE_READ**:Multiple reads of the same field will yield the same results untill it is changed by itself.It may suffer from Scenario 3.Because other transactions may be inserting the data
        
        * **ISOLATION_SERIALIZABLE**: Scenario 1,Scenario 2,Scenario 3 never happens.It is complete isolation.It involves full locking.It affets performace because of locking.
     
    * Scenarios for **Propagation**
        1. if T1 transaction performs several operations and need to roll back all the operations if there is any exceptions. 
        2. if T1 transaction performs several operations, such as a, b, and c, then b fails, you don't want to roll back all, but just b.
        3. if a method must run within a transaction
        4. if a method must not run in a transaction
        5. if one transaction exist, suspend it
    * Solutions for **Propagation**
        * Scenario 1: **propagation=Propagation.REQUIRES**
        * Scenario 2: **propagation=Propagation.REQUIRES_NEW** (a, b, c in a new transaction) or **propagation=Propagation.NESTED** (a, b, c within a single transaction, but have save points)
        * Scenario 3: **propagation=Propagation.MANDATORY**
        * Scenario 4: **propagation=Propagation.NEVER**
        * Scenario 5: **propagation=Propagation.NOT_SUPPORTED**