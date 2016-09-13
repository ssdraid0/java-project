package mybatis.xml;

import java.util.List;

public interface IStudent
{
    public List<Student> getStudents();

    public Student getStudentById(int id);
    

}
