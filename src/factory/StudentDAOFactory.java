package factory;

import DAO.IStudentDAO;
import DAO.IStudentDAOImpl;

public class StudentDAOFactory {
    private static IStudentDAO studentDAO;
    private StudentDAOFactory()
    {
    }
    public static IStudentDAO getStudentDAO()
    {
        if(studentDAO==null)
        {
            studentDAO=new IStudentDAOImpl();
        }
        return studentDAO;
    }
}
