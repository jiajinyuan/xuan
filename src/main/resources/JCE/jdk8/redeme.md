Java Cryptography Extension (JCE) 无限强度权限策略文件对于Java 8

这是因为某些国家的进口管制限制，JDK默认的加解密有一定的限制。
比如默认不允许 256 位密钥的 AES 加解密，解决方法就下载官方JCE无限制强度加密策略文件，覆盖即可。
官方网站提供了JCE无限制权限策略文件的下载：

JDK6的下载地址：
http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html

JDK7的下载地址：
http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html

JDK8的下载地址：
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

但从Java 1.8.0_151和1.8.0_152开始，为JVM启用无限制强度管辖策略 有了一种新的更简单的方法。如果不启用此功能，则不能使用AES-256：
在 jre/lib/security 文件夹中查找文件 java.security，现在用文本编辑器打开java.security，并找到定义java安全性属性crypto.policy的行，它可以有两个值limited或unlimited - 默认值是limited。将其设置为：
```
crypto.policy=unlimited
```


替换路径
```
$JAVA_HOME\jre\lib\security
```