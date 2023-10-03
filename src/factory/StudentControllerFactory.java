package factory;

import controller.IStudentController;
import controller.IStudentControllerImpl;

public class StudentControllerFactory {
    private static IStudentController studentController;

    public static IStudentController getStudentController() {
        if(studentController ==null){
            studentController=new IStudentControllerImpl();
        }
        return studentController;
    }
}
