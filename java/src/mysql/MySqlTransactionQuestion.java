package mysql;

/**
 * 1.当多个事务访问同一数据库时可能出现哪些问题？<br>
 * 脏读：A事务读取B事务尚未提交的数据并在此基础上操作，然后B事务执行回滚，那么A读取到的数据就是脏数据。<br>
 * 不可重复读：A事务重新读取前面读取过的数据，但是该数据已经被另一个已提交的B事务修改过了。<br>
 * 幻读：A事务重新执行一个查询，返回一系列符合查询条件的行，发现其中插入了被B事务提交的行。<br>
 * <br>
 * 2.MySQL事务隔离级别有哪几种？<br>
 * READ UNCOMMITED，READ COMMITTED（不允许脏读），REPEATABLE READ（不允许脏读和不可重复读），SERIALIZABLE（不允许脏读，不可重复读和幻读） <br>
 * <br>
 * 3.设置事务隔离级别为read uncommitted的命令是什么？<br>
 * set session transaction isolation level read uncommitted;<br>
 */
public class MySqlTransactionQuestion
{

}
