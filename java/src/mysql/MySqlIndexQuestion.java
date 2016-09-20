package mysql;

/**
 * 1.MySQL索引类型有哪些？分别支持那些数据类型？<br>
 * normal：普通索引。支持数据类型：除了text之外的。<br>
 * unique：唯一索引。该字段值不能重复，允许有空值。支持数据类型：除了text之外的。<br>
 * fulltext：全文索引。支持数据类型：char，varchar，text。<br>
 * <br>
 * 2.写sql：对表a上的name列创建一个名为name1的unique索引。<br>
 * create unique index name1 on a(name);<br>
 * 3.一个表能有多个unique索引吗？ <br>
 * 对。 <br>
 * <br>
 * 4.Hash索引和BTree索引的区别？<br>
 * a.Hash索引不能用like。 <br>
 * {@link http://dev.mysql.com/doc/refman/5.6/en/index-btree-hash.html}。 <br>
 * <br>
 * 5.索引的优缺点？应该对那些列创建索引？<br>
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