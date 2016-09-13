package io.path;

import java.net.URL;

public class A
{
    public URL getResource1()
    {
        return this.getClass().getResource("");
    }
    public URL getResource2()
    {
        return this.getClass().getResource("/");
    }
    
}
