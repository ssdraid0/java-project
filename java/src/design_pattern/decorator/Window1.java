package design_pattern.decorator;

public class Window1 implements Window
{
	@Override
	public void draw()
	{
		System.out.println("draw Window1");
	}

	@Override
	public String getDescription()
	{
		return "Window1";
	}
}
