package mysql;

/**
 * 1.MySQL索引类型有哪些？如何创建？分别支持那些数据类型？<br>
 * normal：普通索引。<br>
 * unique：唯一索引。该字段值不能重复，允许有空值。<br>
 * fulltext：全文索引。支持数据类型：char，varchar，text。<br>
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
 * 4.索引的优缺点？应该对那些列创建索引？<br>
 * 优点：<br>
 * a.加快查找符合where条件的行的速度。<br>
 * b.加快join操作速度。<br>
 * c.给某一行添加唯一索引，能保证这一行不重复。<br>
 * 缺点：<br>
 * a.创建和维护索引需要耗费时间。<br>
 * b.索引需要占用物理空间。<br>
 * c.修改表的数据时索引也要维护。<br>
 */
public class MySqlIndexQuestion
{
    
}