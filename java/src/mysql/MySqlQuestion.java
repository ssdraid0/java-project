package mysql;

import javax.swing.JList.DropLocation;

import org.apache.tools.ant.taskdefs.condition.Not;

/**
 * 
 *
 */
public class MySqlQuestion
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
 * smallint：2字节，16位，范围是2^(-15)到2^(15)-1，相当于{@link Short}。<br>
 * mediumint：3字节。<br>
 * int：4字节，相当于{@link Integer}。<br>
 * bigint：8字节，相当于{@link Long}。<br>
 * tinyint unsigned ：无符号tinyint，范围是0到2^(8)-1。<br>
 * <br>
 * 3.MySQL的text类型有几种？每种的最大长度是多少？<br>
 * tinytext：1字节，最大长度为 2^(8)-1=255 。<br>
 * text：2字节，最大长度为 2^(16)-1=65535 。<br>
 * mediumtext：3字节，最大长度为 2^(24)-1。<br>
 * longtext：4字节，最大长度为 2^(32)-1 。<br>
 * <br>
 * 4.MySQL的text类型能设置为unique吗？<br>
 * 不能。<br>
 */
class SqlDataTypesQuestion
{

}

/**
 * 1.写sql：建一个表a，有3个列： id列，类型是无符号int，是主键；<br>
 * name列，类型是char(3)，不能为空，不能重复；<br>
 * sex列，类型是char(1)，不能为空，默认'男'。<br>
 * create table a( id int unsigned primary key, name char(3) not null unique, sex char(1) not null default
 * '男')。<br>
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
 * 1.写sql：为表a添加一个列name，类型是char(3)，不能为空，不能重复，位置在id之后。<br>
 * alter table a add column name char(3) not null unique after id;<br>
 * <br>
 * 2.写sql：删除表a中的列name。<br>
 * alter table a drop column name;<br>
 */
class SqlAlertQuestion
{

}

/**
 * 1.写sql：表a有两个列，id int，name char(3)。插入一行数据，id是1，name是'abc'。<br>
 * insert into a(id,name) values(1,'abc');<br>
 */
class SqlInsertQuestion
{

}

/**
 * 1.将表a中age大于20的在表b中的salary设置为b表中的平均salary。<br>
 * update b set salary = (select avg(salary) from b) where id in (select id from a where age > 20);<br>
 */
class SqlUpdateQuestion
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
 * union会去掉重复的行，相同的行只留一个。<br>
 * <br>
 */
class SqlUnionQuestion
{
    final String createTable = "create table a(id int);create table b(id int);";
    final String insert = "insert into a values(1);insert into b values(1);";
    final String select1 = "select * from a union all select * from b;";
    final String select2 = "select * from a union all select * from b;";
}

/**
 * 1.MySQL中Left Join的作用是什么？<br>
 * 左边的表的行都返回。<br>
 */
class SqlLeftJoinQuestion
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
 * 只有Memory同时支持Hash和BTree索引，InnoDB和MyISAM只支持BTree索引。<br>
 */
class SqlEngineQuestion
{

}
