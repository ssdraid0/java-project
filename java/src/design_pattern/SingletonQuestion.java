package design_pattern;

/**
 * 1.实现饿汉式单例。<br>
 * {@link EagerSingleton}。<br>
 * 2.饿汉式单例是线程安全的吗？<br>
 * 是。<br>
 * 3.Java中有哪些单例类？<br>
 * {@link Runtime}。<br>
 */
public class SingletonQuestion
{

}

class EagerSingleton
{
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton()
    {
    }

    public static EagerSingleton getInstance()
    {
        return instance;
    }
}

/**
 * 懒汉式单例类。<br>
 */
class LazySingleton
{
    private static LazySingleton instance = null;

    private LazySingleton()
    {
    }

    public synchronized static LazySingleton getInstance()
    {
        if (instance == null)
        {
            instance = new LazySingleton();
        }
        return instance;
    }
}
