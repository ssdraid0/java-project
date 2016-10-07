package java_.basic;

/**
 * 1. switch能够使用哪些数据类型。</br>
 * byte，int，short，char，{@link String}，{@link Enum}。
 */
public class SwitchQ
{
    public static void main(String[] args)
    {
        dateType();
    }

    public static void dateType()
    {
        byte b = 0;
        switch (b)
        {
        case 0:
            break;
        }

        int i = 0;
        switch (i)
        {
        case 0:
            break;
        }
        
        short s = 0;
        switch (s)
        {
        case 0:
            break;
        }

        char c = 0;
        switch (c)
        {
        case 'a':
            break;
        }
        
        String string = "a";
        switch (string)
        {
        case "a":
            break;
        }

    }
}
