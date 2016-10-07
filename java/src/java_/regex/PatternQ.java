package java_.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1. 常见的正则表达式语法有哪些？<br/>
 * \d：一个数字字符。<br/>
 * \D：一个非数字字符。<br/>
 * \w：一个数字或字母字符。<br/>
 * \W：一个非数字非字母字符。<br/>
 * [abcd]或[a-d]：a或b或c或d。<br/>
 * [^abcd]或[^a-d]：非a非b非c非d。<br/>
 * <br/>
 * 对于 a，ab，abc，a\n，b，ba。<br/>
 * a*：匹配a，ab，abc，a\n。<br/>
 * a.：匹配ab。<br/>
 * a+：匹配ab，abc。<br/>
 * a?：匹配a，ab。<br/>
 * ^b(\\w*)：匹配b，ba。<br/>
 * (\\w*)b$：匹配ab，b。<br/>
 * (a|b)：匹配a，b。<br/>
 * <br/>
 * 对于 a，aa，aaa。<br/>
 * a{2}：匹配aa，不匹配a，aaa。<br/>
 * a{2,}：匹配aa，aaa......不匹配a。<br/>
 * a{2,3}：匹配aa，aaa......不匹配a，aaaa。<br/>
 * <br/>
 * http://www.runoob.com/java/java-regular-expressions.html<br/>
 * 2. <br/>
 */
public class PatternQ
{
    public static void main(String[] args)
    {
        // test1();
        // test2();
        // String regex = "\\*查看:\\*?(\\d+)\\*?回复:\\*?(\\d+)\\*";
        // String input = "a查看:a123a回复:a123456b";
        // String input = "a1b2c查看:abc1abc回复:abc2abc";
        // String regex = "\\*?查看\\D+(\\d+)\\D+回复\\D+(\\d+)\\D+";
        // regex(input, regex);
        // isMobilePhoneNumber("13012345678");
        // isPassword("123456");
        // isPassword("abcdefghijk");
        test1();
    }

    public static void test1()
    {
        System.out.println(Pattern.matches("^b", "b"));
        System.out.println(Pattern.matches("(\\w*)b$", "b"));
        System.out.println(Pattern.matches("(\\w*)b$", "cb"));
    }

    public static void test2()
    {
        String regex = "a+";
        String input = "aababc";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input); // 获取 matcher 对象

        while (m.find())
        {
            System.out.println(m.group());
        }
    }

    public static void regex(String input, String regex)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find())
        {
            System.out.println(m.group());
            for (int i = 0; i < m.groupCount(); i++)
            {
                System.out.println(m.group(i + 1));
            }
        }
    }

    /**
     * 必须是11位数字。<br/>
     */
    public static void isMobilePhoneNumber(String input)
    {
        String regex = "(13|14|15|18)[0-9]{9}";
        System.out.println(Pattern.matches(regex, input));
    }

    public static void isPassword(String input)
    {
        String regex = "(?![^a-zA-Z]+$)(?!\\D+$).{8,20}$";
        System.out.println(Pattern.matches(regex, input));
    }
}