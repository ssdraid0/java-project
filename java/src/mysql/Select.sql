表a
+----+------+
| id | name |
+----+------+
|  1 | aa   |
|  2 | aa   |
+----+------+
1.下面3中sql语句的区别？
select name from a; 
+------+
| name |
+------+
| aa   |
| aa   |
+------+
select distinct name from a; 
+------+
| name |
+------+
| aa   |
+------+
select id,distinct name from a; 
报错。
select all name from a;
和select name from a; 相同。
