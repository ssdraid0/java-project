package design_pattern;

/**
 * 1.使用构造器（builder）模式的好处是什么？<br>
 */
public class BuilderQuestion
{
    public static void main(String[] args)
    {
        BuilderClass builder = new BuilderClass.Builder(1).b(3).build();
        System.out.println(builder.toString());
    }
}

class BuilderClass
{
    private final int a;
    private final int b;

    public static class Builder
    {
        private final int a; // 必选
        private int b; // 可选

        public Builder(int a)
        {
            this.a = a;
        }

        public Builder b(int b)
        {
            this.b = b;
            return this;
        }

        public BuilderClass build()
        {
            return new BuilderClass(this);
        }
    }

    private BuilderClass(Builder builder)
    {
        this.a = builder.a;
        this.b = builder.b;
    }

    @Override
    public String toString()
    {
        return a + "," + b;
    }
}