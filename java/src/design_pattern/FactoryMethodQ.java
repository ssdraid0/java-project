package design_pattern;

public class FactoryMethodQ
{

    public static void main(String[] args)
    {
        try
        {
            Class<?> class2 = Integer.class.getClass();
            class2.newInstance();
        } catch (InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

}
