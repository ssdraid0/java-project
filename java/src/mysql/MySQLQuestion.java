package mysql;

/**
 * 
 *
 */
public class MySQLQuestion
{
    public static void main(String[] args)
    {

    }
}

/**
 * 1.MySQL数据类型有哪些？ <br>
 * int，char，varchar，text， <br>
 * <br>
 * 2.MySQL的int类型有几种？每种的范围是多少？<br>
 * tinyint：1字节，8位，范围是2^(-7)到2^(7)-1，相当于{@link Byte}。<br>
 * tinyint unsigned ：无符号tinyint，范围是0到2^(8)-1。<br>
 * smallint：2字节，16位，范围是2^(-15)到2^(15)-1，相当于{@link Short}。<br>
 * mediumint：3字节。<br>
 * int：4字节，相当于{@link Integer}。<br>
 * bigint：8字节，相当于{@link Long}。<br>
 * <br>
 * 3.MySQL的text类型有几种？每种的最大长度是多少？<br>
 * tinytext：最大长度为 2^(8)-1=255 。<br>
 * text：最大长度为 2^(16)-1=65535 。<br>
 * mediumtext：最大长度为 2^(24)-1。<br>
 * longtext：最大长度为 2^(32)-1 。<br>
 * <br>
 */
class SqlDataTypesQuestion
{

}

/**
 * 1.建一个表a，有两个字段，id字段，类型是无符号int，是主键，name字段，类型是char(3)，不能为空，不能重复。<br>
 * create table a( id int unsigned primary key, name char(3) not null unique)。<br>
 * <br>
 * 2.这个SQL语句为什么无法在MySQL中运行？create table a(use int primary key);<br>
 * 因为use是保留关键字。<br>
 * <br>
 * 3.create table xxx as select * from xxx的含义是什么？能复制约束吗？ <br>
 * 复制结构和数据到新表，不能复制约束。<br>
 */
class SqlCreateQuestion
{

}

/**
 * 1.下面三种MySQL语句的区别？<br>
 * select name from a; <br>
 * select distinct name from a; <br>
 * select all name from a;<br>
 * <br>
 * select distinct name from a;会去掉重复的行。<br>
 * select name from a;和select all name from a;相同。<br>
 * <br>
 */
class SqlSelectQuestion
{
}

/**
 * 
 *
 */
class SqlGroupByQuestion
{

}

/**
 * 1.MySQL中union和union all的区别。<br>
 * union会去掉重复的行。<br>
 * <br>
 */
class SqlUnionQuestion
{
    static void UnionUnionAll()
    {
        final String createTable = "create table a(id int);create table b(id int);";
        final String insert = "insert into a values(1);insert into b values(1);";
        final String select1 = "select * from a union all select * from b;";
        final String select2 = "select * from a union all select * from b;";
        System.out.println(String.join("\n", createTable, insert, select1, select2));
    }
}

/**
 * 1.MySQL中Left Join的作用是什么？<br>
 * 左边的表的行都返回。<br>
 */
class SqlLeftJoinQuestion
{

}

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
class SqlTransactionQuestion
{

}

/**
 * 1.MySQL索引类型有哪些？如何创建？<br>
 * normal：普通索引。<br>
 * unique：唯一索引。该字段值不能重复，允许有空值。<br>
 * fulltext：全文索引。text类型只能使用全文索引。<br>
 * 创建normal索引：create index 索引名 on 表名(字段名);<br>
 * 创建unique索引：create unique index 索引名 on 表名(字段名);<br>
 * 创建fulltext索引：create fulltext index 索引名 on 表名(字段名);<br>
 * <br>
 * 2.一个表能有多个unique索引吗？ <br>
 * 对。 <br>
 * <br>
 * 3.Hash索引和BTree索引的区别？<br>
 * a.Hash索引不能用like。 <br>
 * {@link http://dev.mysql.com/doc/refman/5.6/en/index-btree-hash.html}。 <br>
 * <br>
 * 4.索引的优缺点？<br>
 * 
 */
class SqlIndexQuestion
{

}

/**
 * 1.避免使用select *。<br>
 */
class SqlOptimizationQuestion
{

}

/**
 * 1.MySQL常见的引擎有哪些？查看数据库引擎的命令是什么？如何在建表时指定引擎？<br>
 * 常见的引擎：InnoDB，MyISAM，Memory （HEAP），Merge 。<br>
 * 查看数据库引擎命令：show engines;<br>
 * 在建表时指定引擎：create table xxx () engine=xxx;<br>
 * <br>
 * 2.InnoDB，MyISAM，Memory的区别？ <br>
 * Memory的数据存储在内存中，停止MySQL服务后，数据就会消失。<br>
 * InnoDB支持事务，MyISAM，Memory不支持。<br>
 * Memory支持Hash和BTree索引，InnoDB和MyISAM只支持BTree索引。<br>
 */
class SqlEngineQuestion
{

}
