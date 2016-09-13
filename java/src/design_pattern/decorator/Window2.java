package design_pattern.decorator;

public class Window2 extends WindowDecorator
{
	public Window2(Window decoratedWindow)
	{
		super(decoratedWindow);
	}
	
	@Override
	public void draw()
	{
		drawWindow2();
		window.draw();
	}

	private void drawWindow2()
	{

	}

	@Override
	public String getDescription()
	{
		return window.getDescription() + "-- Window2";
	}

}