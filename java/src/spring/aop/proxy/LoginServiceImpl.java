package spring.aop.proxy;

public class LoginServiceImpl implements LoginService
{
    public boolean login(User user)
    {
        System.out.println(user);
        if (user == null)
        {
            return false;
        } else if (user.getUsername() == "xinchun.wang" && user.getPassword() == "123456")
        {
            return true;
        }
        return false;
    }
}
