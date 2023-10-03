package controller;
import dto.Student;
public interface IStudentController {
    String saveStudent(Student student);   //for creation operation
    Student findStudentById(Integer id);   //for read operation
    String updateStudentById(Student student);   //for update operation
    String deleteStudentById(Integer id);   //for delete operation
}
