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
1.MySQL中union和union all的区别。
union会去掉重复的行，相同的行只留一个。
例如：
select id from a union select id from b;
+------+
| id   |
+------+
|    1 |
|    2 |
|    3 |
+------+
select id from a union all select id from b;
+------+
| id   |
+------+
|    1 |
|    2 |
|    1 |
|    3 |
+------+