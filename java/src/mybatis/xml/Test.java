package mybatis.xml;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test
{
//    static
//    {
//        PropertyConfigurator.configure("log4j.properties");
//    }

    public static void main(String[] args)
    {
        Reader reader = null;
        try
        {
            reader = Resources.getResourceAsReader("mybatis/xml/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            IStudent iStudent = session.getMapper(IStudent.class);
            List<Student> students = iStudent.getStudents();
            System.out.println(students.size());
            Student student = iStudent.getStudentById(1);
            System.out.println(student);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        } finally
        {

        }
    }

}
