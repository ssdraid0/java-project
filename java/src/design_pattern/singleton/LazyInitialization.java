package design_pattern.singleton;

public class LazyInitialization
{
    private static LazyInitialization instance = null;

    private LazyInitialization()
    {
    }

    public synchronized static LazyInitialization getInstance()
    {
        if (instance == null)
        {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
