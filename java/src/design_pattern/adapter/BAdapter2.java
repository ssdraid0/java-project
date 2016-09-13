package design_pattern.adapter;

public class BAdapter2 implements IAB
{
    private B b;

    @Override
    public void a()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void b()
    {
        b.b();
    }

}
