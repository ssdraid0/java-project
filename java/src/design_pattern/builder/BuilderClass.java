package design_pattern.builder;

public class BuilderClass
{
    private final int a;
    private final int b;

    public static class Builder
    {
        private final int a;
        private int b;

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
}
