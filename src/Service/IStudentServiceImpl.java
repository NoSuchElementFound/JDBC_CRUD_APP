package Service;

import dto.Student;
import DAO.IStudentDAO;
import factory.StudentDAOFactory;

import java.io.IOException;
import java.sql.SQLException;

public class IStudentServiceImpl implements IStudentService{
    IStudentDAO studentDAO;

    @Override
    public String saveStudent(Student student) {
        studentDAO= StudentDAOFactory.getStudentDAO();
        try {
            return studentDAO.saveStudent(student);
        } catch (SQLException e) {
          e.printStackTrace();
          return "Failure";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @Override
    public Student findStudentById(Integer id) {
        studentDAO= StudentDAOFactory.getStudentDAO();
        return studentDAO.findStudentById(id);
    }

    @Override
    public String updateStudentById(Student student) {
        studentDAO=StudentDAOFactory.getStudentDAO();
        return studentDAO.updateStudentById(student);
    }

    @Override
    public String deleteStudentById(Integer id) {
        studentDAO=StudentDAOFactory.getStudentDAO();
        studentDAO.deleteStudentById(id);
        return null;
    }
}
