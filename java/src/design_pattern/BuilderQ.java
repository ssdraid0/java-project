package design_pattern;

/**
 * 1.什么情况下使用构造器（builder）模式？<br>
 * 参数太多，有些可选，有些必选。<br>
 */
public class BuilderQ
{
    public static void main(String[] args)
    {
        A a = new A.Builder(1).b(3).build();
        System.out.println(a.toString());
    }
}

class A
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

        public A build()
        {
            return new A(this);
        }
    }

    private A(Builder builder)
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