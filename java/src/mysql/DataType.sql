
1.MySQL数据类型有哪些？ 
int，char，varchar，text。

2.MySQL的int类型有几种？每种的范围是多少？
tinyint：1字节，8位，范围是2^(-7)到2^(7)-1，相当于{@link Byte}。
smallint：2字节，16位，范围是2^(-15)到2^(15)-1，相当于{@link Short}。
mediumint：3字节。
int：4字节，相当于{@link Integer}。
bigint：8字节，相当于{@link Long}。
tinyint unsigned ：无符号tinyint，范围是0到2^(8)-1。

3.MySQL的text类型有几种？每种的最大长度是多少？
tinytext：1字节，最大长度为 2^(8)-1=255 。
text：2字节，最大长度为 2^(16)-1=65535 。
mediumtext：3字节，最大长度为 2^(24)-1。
longtext：4字节，最大长度为 2^(32)-1 。

4.MySQL的text类型能设置为unique吗？
不能。
 