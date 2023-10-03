package controller;

import Service.IStudentService;
import dto.Student;
import factory.StudentServiceFactory;

public class IStudentControllerImpl implements IStudentController{
    IStudentService studentService;
    @Override
    public String saveStudent(Student student) {
        studentService= StudentServiceFactory.getStudentService();
        return studentService.saveStudent(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        studentService= StudentServiceFactory.getStudentService();
        return studentService.findStudentById(id);
    }

    @Override
    public String updateStudentById(Student student) {
        studentService=StudentServiceFactory.getStudentService();
        return studentService.updateStudentById(student);
    }

    @Override
    public String deleteStudentById(Integer id) {
        studentService=StudentServiceFactory.getStudentService();
        studentService.deleteStudentById(id);
        return null;
    }
}
