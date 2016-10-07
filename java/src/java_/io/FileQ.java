package java_.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.实现一个方法，能够把一个文件的内容读取为{@link String}。</br>
 * </br>
 * 2.实现一个方法，能够把一个文件的内容按行读取，存储到{@link List}。</br>
 * </br>
 */
public class FileQ
{
    public static void main(String[] args)
    {
        String path = "src/java_/io/1.txt";
        System.out.println(readFileToString(path));
        List<String> list = readFileToStrings(path);
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 一次读一个字符。</br>
     */
    public static String readFileToString(String path)
    {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(new File(path)));
            int temp = 0;
            while ((temp = reader.read()) != -1)
                builder.append((char) temp);
            reader.close();
        } catch (Exception e)
        {}
        return builder.toString();
    }

    /**
     * 一次读一行。</br>
     */
    public static List<String> readFileToStrings(String path)
    {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(new File(path)));
            String tempString = null;
            while ((tempString = reader.readLine()) != null)
                list.add(tempString);
            reader.close();
        } catch (Exception e)
        {}
        return list;
    }

}
