1.事务的4个特点。
原子性（atomicity）：事务中的所有操作要么全部提交成功，要么全部失败回滚。
一致性（consistency）：事务没有提交，所做的修改就不会存储到数据库。
隔离性（isolation）：一个事务所做的修改在提交以前，对其他事务是不可见的。
持久性（durability）：事务提交后，所做的修改会存储到数据库。

2.当多个事务访问同一数据库时可能出现哪些问题？
脏读：A事务读取B事务尚未提交的数据并在此基础上操作，然后B事务执行回滚，那么A读取到的数据就是脏数据。
不可重复读：A事务重新读取前面读取过的数据，但是该数据已经被另一个已提交的B事务修改过了。
幻读：A事务重新执行一个查询，返回一系列符合查询条件的行，发现其中插入了被B事务提交的行。

3.MySQL事务隔离级别有哪几种？
READ UNCOMMITED：都允许。
READ COMMITTED：不允许脏读。
REPEATABLE READ：不允许脏读和不可重复读。
SERIALIZABLE：不允许脏读，不可重复读和幻读 。

4.写sql：设置事务隔离级别为read uncommitted，范围为session。
set session transaction isolation level read uncommitted;
