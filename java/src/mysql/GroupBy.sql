表a
+----+------+
| id | name |
+----+------+
|  1 | aa   |
|  2 | aa   |
|  3 | aa   |
|  4 | ab   |
|  5 | ab   |
|  6 | ac   |
+----+------+
1.写sql：找出表a中name出现次数大于等于2的，然后按出现次数从大到小排序。
select name from a group by name having count(name) >=2 order by count(name) desc;
+------+
| name |
+------+
| aa   |
| ab   |
+------+