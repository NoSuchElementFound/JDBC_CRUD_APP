package DAO;

import dto.Student;

import java.io.IOException;
import java.sql.SQLException;

public interface IStudentDAO {
    String saveStudent(Student student) throws SQLException, IOException;   //for creation operation
    Student findStudentById(Integer id);   //for read operation
    String updateStudentById(Student student);   //for update operation
    String deleteStudentById(Integer id);   //for delete operation
}
