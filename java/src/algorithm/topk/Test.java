package algorithm.topk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Test
{
    public static void appendMethodA(String fileName, String content)
    {
        try
        {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            randomFile.seek(fileLength);
            randomFile.writeBytes(content + "\n");
            randomFile.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        String fileName = "src/algorithm/topk/file.txt";
        // try
        // {
        // RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
        // Random random = new Random();
        // for (int i = 0; i < 10; i++)
        // {
        // long fileLength = randomFile.length();
        // randomFile.seek(fileLength);
        // randomFile.writeBytes(random.nextInt(10) + "\n");
        // }
        // randomFile.close();
        // } catch (Exception e)
        // {
        //
        // }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null)
            {
                Integer key = Integer.parseInt(tempString);
                if (hashMap.get(key) != null)
                {
                    Integer value = hashMap.get(key);
                    value++;
                    hashMap.put(key, value);
                } else
                {
                    hashMap.put(key, 0);
                }
            }
            reader.close();
        } catch (Exception e)
        {

        }
        List<Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer, Integer>>()
        {
            // 降序排序
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Entry<Integer, Integer> mapping : list)
        {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }

        // String content = "new append!";
        // appendMethodA(fileName, content);
    }
}
