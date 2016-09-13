package design_pattern.decorator;

public class DecoratedWindowTest
{
	public static void main(String[] args)
	{
		Window decoratedWindow = new Window3(new Window2(new Window1()));
		Window decoratedWindow2 = new Window2(new Window2(new Window1()));
		Window decoratedWindow3 = new Window2(new Window3(new Window1()));
		System.out.println(decoratedWindow.getDescription());
		System.out.println(decoratedWindow2.getDescription());
		System.out.println(decoratedWindow3.getDescription());
	}
}
