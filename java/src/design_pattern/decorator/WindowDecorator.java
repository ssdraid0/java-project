package design_pattern.decorator;

public abstract class WindowDecorator implements Window
{
	protected Window window;

	public WindowDecorator(Window window)
	{
		this.window = window;
	}
}
