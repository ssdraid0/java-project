package design_pattern.builder;

public class BuilderTest
{
    public static void main(String[] args)
    {
        BuilderClass builder = new BuilderClass.Builder(1).b(3).build();
        System.out.println(builder.toString());
    }
}
