package java_.data_type;

/**
 * 
 *
 */
@SuppressWarnings("unused")
public class IntegerQ
{
    public static void main(String[] args)
    {
        testInitValue();
    }

    private static void testInitValue()
    {
        Integer integer = 100;
        int i = integer.intValue();
        i++;
        System.out.println(i);
        System.out.println(integer);
    }
    
    private static void testEqual()
    {
        Integer s = new Integer(9);
        Integer t = new Integer(9);
        System.out.println(s.equals(t));
    }

}
