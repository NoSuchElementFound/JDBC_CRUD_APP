package factory;

import Service.IStudentService;
import Service.IStudentServiceImpl;

public class StudentServiceFactory {
    private static IStudentService studentService;
    private StudentServiceFactory()
    {
    }
    public static IStudentService getStudentService()
    {
        if(studentService==null)
        {
            studentService=new IStudentServiceImpl();
        }
        return studentService;
    }
}
