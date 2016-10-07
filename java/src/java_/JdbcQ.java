package java_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcQ
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/blog?user=root&password=123456";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into user (name,pwd) values(?,?)");
            preparedStatement.setString(1, "a");
            preparedStatement.setString(2, "123456");
            preparedStatement.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
