1.MySQL常见的引擎有哪些？查看数据库引擎的命令是什么？如何在建表时指定引擎？
常见的引擎：InnoDB，MyISAM，Memory （HEAP）。
查看数据库引擎命令：show engines;
在建表时指定引擎：create table xxx () engine=xxx;

2.InnoDB，MyISAM，Memory的区别？ 
Memory的数据存储在内存中，停止MySQL服务后，数据就会消失。
InnoDB支持事务，MyISAM，Memory不支持。
只有Memory同时支持Hash和B-Tree索引，InnoDB和MyISAM只支持B-Tree索引。