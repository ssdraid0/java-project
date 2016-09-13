package io.path;

import io.path.A;

public class PathTest
{

    public static void main(String[] args)
    {
        //String string = FileUtil.getFile("src/io/1.txt");
        //System.out.println(string);
        A a = new A();
        System.out.println(a.getResource1().toString());
        System.out.println(a.getResource2().toString());

    }

}
