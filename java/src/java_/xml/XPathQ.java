package java_.xml;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1.{@link Node#getNodeValue()}和{@link Node#getTextContent()}的区别？<br/>
 * 
 * <pre>
 *     <highschool>
        <student>
            <name lang="cn">张三</name>
            <age>16</age>
        </student>
 * </pre>
 * 
 * 要找到并输出张三的年龄，分别如何实现？<br/>
 * 
 * <pre>
 * NodeList nodeList = (NodeList) xpath.evaluate("//student[name='张三']/age", doc, XPathConstants.NODESET);
 * for (int i = 0; i < nodeList.getLength(); i++)
 *     System.out.print(nodeList.item(i).getFirstChild().getNodeValue() + "，");
 * System.out.println();
 * 
 * for (int i = 0; i < nodeList.getLength(); i++)
 *     System.out.print(nodeList.item(i).getTextContent() + "，");
 * System.out.println();
 * </pre>
 * 
 * 2.<br/>
 * "//student[name[@lang]]/age"：获取所有有name节点，name节点有lang属性，的student节点，的age结点。
 * "//student[name[@lang]='张三']/age"：获取所有有name节点，name节点有lang属性，name节点值为张三，的student节点，的age结点。 <br/>
 * "//student[name[@lang='cn']='张三']/age"：获取所有有name节点，name节点有lang属性，lang属性值为cn，name节点值为张三，的student节点，的age结点。
 * <br/>
 * https://my.oschina.net/cloudcoder/blog/223359<br/>
 */
public class XPathQ
{
    public static void main(String[] args)
    {
        try
        {
            // 获取age>=15的所有student的name
            getElements("//student[name[@lang]='张三']/age");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Document getDocument() throws Exception
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream(new File("src/java_/xml/1.xml")));
        return doc;
    }

    public static XPath getXPath() throws Exception
    {
        XPathFactory factory = XPathFactory.newInstance();
        return factory.newXPath();
    }

    public static void getNodeValue() throws Exception
    {
        Document doc = getDocument();
        XPath xpath = getXPath();
        NodeList nodeList = (NodeList) xpath.evaluate("//student[name='张三']/age", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++)
            System.out.print(nodeList.item(i).getFirstChild().getNodeValue() + "，");
        System.out.println();

        for (int i = 0; i < nodeList.getLength(); i++)
            System.out.print(nodeList.item(i).getTextContent() + "，");
        System.out.println();
    }

    public static void getElements(String xPathExpression) throws Exception
    {
        Document doc = getDocument();
        XPath xpath = getXPath();
        NodeList nodeList = (NodeList) xpath.evaluate(xPathExpression, doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            System.out.print(node.getNodeName() + "：" + node.getTextContent() + "，");
        }
        System.out.println();
    }
}
