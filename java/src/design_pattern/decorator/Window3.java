package design_pattern.decorator;

public class Window3 extends WindowDecorator
{
	public Window3(Window decoratedWindow)
	{
		super(decoratedWindow);
	}

	@Override
	public void draw()
	{
		drawWindow3();
		window.draw();
	}

	private void drawWindow3()
	{
	}

	@Override
	public String getDescription()
	{
		return window.getDescription() + "--Window3";
	}

}