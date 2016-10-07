⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽
表a
 +----+------+
| id | name |
+----+------+
|  1 | aa   |
|  2 | ab   |
+----+------+
表b
+------+------+
| id   | name |
+------+------+
|    1 | ba   |
|    3 | bc   |
+------+------+
1.MySQL中有几种连接，区别是什么？
⑴.left join：左边的表的行都返回，必须和on同时使用。
例如：select * from a left join b on a.id=b.id;
+----+------+------+------+
| id | name | id   | name |
+----+------+------+------+
|  1 | aa   |    1 | ba   |
|  2 | ab   | NULL | NULL |
+----+------+------+------+
⑵.right join：右边的表的行都返回，必须和on同时使用。
例如：select * from a right join b on a.id=b.id;
⑶.inner join，join：只返回左表和右表都有的行，必须和on同时使用。
例如：select * from a inner join b on a.id=b.id;
+----+------+------+------+
| id | name | id   | name |
+----+------+------+------+
|  1 | aa   |    1 | ba   |
+----+------+------+------+
⑷.full join：返回所有的行。
例如：select * from a  full join b，不能有on。
+----+------+------+------+
| id | name | id   | name |
+----+------+------+------+
|  1 | aa   |    1 | ba   |
|  2 | ab   |    1 | ba   |
|  1 | aa   |    3 | bc   |
|  2 | ab   |    3 | bc   |
+----+------+------+------+