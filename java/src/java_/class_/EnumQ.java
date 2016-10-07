package java_.class_;

/**
 * 
 *
 */
public class EnumQ
{
    public static void main(String[] args)
    {
        char c = 'A';
        if (c == E.A.value())
        {
            System.out.println("A");
        }
    }

    private static enum E
    {
        A('A'), B('B');

        private final char c;

        E(char c)
        {
            this.c = c;
        }

        public char value()
        {
            return c;
        }
    }
}
