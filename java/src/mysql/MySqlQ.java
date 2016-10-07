package mysql;

public class MySqlQ
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
 * 1.select，where，group by，having执行顺序？<br>
 * where->group by->having->select。<br>
 * <br>
 */
class SqlSelectQuestion
{}