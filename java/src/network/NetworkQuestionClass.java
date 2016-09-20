package network;

public class NetworkQuestionClass
{
    public static void main(String[] args)
    {

    }
}

/**
 * 1.http状态码有哪些？<br>
 * 200：请求成功。<br>
 * 304：服务器认为这个资源没有改变，让客户端从缓存中读取。<br>
 * 403：服务器拒绝请求。<br>
 * 404：找不到资源。通常是因为请求的页面不存在。<br>
 * 500：服务器不能完成请求。通常是因为代码中出现错误。<br>
 * 2.http连接过程。<br>
 * a.DNS解析：把域名转换为ip地址。<br>
 * b.请求：向服务器发送请求。<br>
 * c.应答：服务器收到请求后，进行处理，把文件内容传送给客户端。<br>
 * d.关闭连接：应答结束后，客户端与服务器断开连接。<br>
 */
class HttpQuestionClass
{

}

/**
 * 1.TCP和UDP的区别。<br>
 * a.TCP面向连接，UDP不是面向连接。<br>
 * b.TCP可靠，UDP不可靠。<br>
 * c.TCP传输慢，UDP传输快。<br>
 * <br>
 * 2.TCP模型包括哪几层？<br>
 * 网络接口层，网络层，运输层，应用层。<br>
 */
class TcpUdpQuestionClass
{

}

/**
 * 1.保留IP地址有哪些？<br>
 * 10.x.x.x<br>
 * 169.254.x.x<br>
 * 172.16.0.0-172.31.255.255<br>
 * 192.168.x.x<br>
 * 0.0.0.0，224.0.0.1，127.0.0.1，255.255.255.255<br>
 * <br>
 * 2.一网络的子网掩码为255.255.255.248，该网络的子网个数？<br>
 * 255.255.255.248=255.255.255.11111000<br>
 * 255.255.255.11111000：网络地址。<br>
 * 255.255.255.11111111：保留地址。<br>
 * 2x2x2-2=6。<br>
 */
class IpClass
{

}

/**
 * 1.对称加密算法有哪些？非对称加密算法有哪些？<br>
 * 对称加密：DES、AES、RC2、RC4、RC5。<br>
 * 非对称加密：RSA。<br>
 * 2.对称加密和非对称加密的区别？<br>
 * https://en.wikipedia.org/wiki/Symmetric-key_algorithm<br>
 */
class EncryptionClass
{

}

/**
 * 1.电子邮件协议有那些？<br>
 *SMTP、POP3、IMAP。<br>
 */
class ProtocolClass
{

}
