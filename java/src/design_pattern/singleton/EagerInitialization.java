package design_pattern.singleton;

public class EagerInitialization
{
    private static final EagerInitialization instance = new EagerInitialization();

    private EagerInitialization()
    {
    }

    public static EagerInitialization getInstance()
    {
        return instance;
    }
}
