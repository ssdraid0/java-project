ls
ls -a：列出所有文件的文件名，按文件名排序，包括.和..
.  ..  d1  d2  d3  f1  f2  f3

ls或ls -A：列出所有文件的文件名，按文件名排序
d1  d2  d3  f1  f2  f3

ls -l：列出所有文件的权限，inode数量，所有者，所属用户组，文件大小，修改时间，文件名
总用量 24
drwxrwxr-x 2 ssdraid0 ssdraid0 4096 11月 28 22:50 d1
drwxrwxr-x 2 ssdraid0 ssdraid0 4096 11月 28 22:50 d2
drwxrwxr-x 2 ssdraid0 ssdraid0 4096 11月 28 22:51 d3
-rw-rw-r-- 1 ssdraid0 ssdraid0    2 11月 28 22:54 f1
-rw-rw-r-- 1 ssdraid0 ssdraid0    3 11月 28 22:54 f2
-rw-rw-r-- 1 ssdraid0 ssdraid0    4 11月 28 22:55 f3

ls -h -l：文件大小显示为可读的单位
总用量 24K
drwxrwxr-x 2 ssdraid0 ssdraid0 4.0K 11月 28 22:50 d1
drwxrwxr-x 2 ssdraid0 ssdraid0 4.0K 11月 28 22:50 d2
drwxrwxr-x 2 ssdraid0 ssdraid0 4.0K 11月 28 22:51 d3
-rw-rw-r-- 1 ssdraid0 ssdraid0    2 11月 28 22:54 f1
-rw-rw-r-- 1 ssdraid0 ssdraid0    3 11月 28 22:54 f2
-rw-rw-r-- 1 ssdraid0 ssdraid0    4 11月 28 22:55 f3

ls -t：列出所有文件的文件名，按时间从新到旧排序
f3  f2  f1  d3  d2  d1

ls -r：反向排序
f3  f2  f1  d3  d2  d1

mkdir
mkdir d：建立目录d
mkdir -p d/d：建立目录d，在目录d下再建立目录d

rm
rm -r d：删除目录d

find / -name '*java*'：查找包含java的文件名
pgrep java | xargs ps -u --pid：查找包含java的进程
