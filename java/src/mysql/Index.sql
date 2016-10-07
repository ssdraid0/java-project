1.MySQL索引类型有哪些？分别支持那些数据类型？
normal：普通索引。支持数据类型：除了text之外的。
unique：唯一索引。该字段值不能重复，允许有空值。支持数据类型：除了text之外的。
fulltext：全文索引。支持数据类型：char，varchar，text。

2.写sql：对表a上的name列创建一个名为name1的unique索引。
create unique index name1 on a(name);

3.一个表能有多个unique索引吗？ 
对。 

4.Hash索引和B-Tree索引的区别？
a.Hash索引不能用like。 
b.只有Memory引擎支持Hash索引。 
http://dev.mysql.com/doc/refman/5.6/en/index-btree-hash.html 

5.索引的优缺点？应该对那些列创建索引？
优点：
a.加快查找符合where条件的行的速度。
b.加快join操作速度。
c.给某一行添加唯一索引，能保证这一行不重复。
缺点：
a.创建和维护索引需要耗费时间。
b.索引需要占用物理空间。
c.修改表的数据时索引也要维护。
