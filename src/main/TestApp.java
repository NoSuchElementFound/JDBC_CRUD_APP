package main;

import controller.IStudentController;
import dto.Student;
import factory.StudentControllerFactory;

import java.util.Scanner;

public class TestApp {
    IStudentController studentController=null;

    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        IStudentController studentController= StudentControllerFactory.getStudentController();
        String sname,scity,scountry,semail,status;
        Integer ID=null;
        while(true)
        {
            System.out.println("Press 1 for Creation");
            System.out.println("Press 2 for Reading");
            System.out.println("Press 3 for Updation");
            System.out.println("Press 4 for Deletion");
            System.out.println("Press 5 for Exit");
            System.out.print("Enter your option");
            int option=sn.nextInt();
            switch (option){
                case 1:
                    System.out.print("Enter student name:\t");
                    sname=sn.next();
                    System.out.print("\nEnter student email:\t");
                    semail=sn.next();
                    System.out.print("\nEnter student city:\t");
                    scity=sn.next();
                    System.out.print("\nEnter student country:\t");
                    scountry=sn.next();
                    Student student=new Student();
                    student.setSname(sname);
                    student.setSemail(semail);
                    student.setScity(scity);
                    student.setScountry(scountry);

                    status=studentController.saveStudent(student);
                    if(status.equalsIgnoreCase("success")){
                        System.out.println("Records inserted successfully");
                    } else if (status.equalsIgnoreCase("failure")) {
                        System.out.println("Record insertion failed..");
                    }else {
                        System.out.println("Something went wrong");
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID to fetch data:\t");
                    ID=sn.nextInt();
                    Student studentRecord=studentController.findStudentById(ID);
                    if(studentRecord!=null) {
                        System.out.println(studentRecord);
                    }else System.out.println("Data reading failed...");
                    break;
                case 3:
                    System.out.print("Enter student ID to fetch data:\t");
                    ID=sn.nextInt();
                    studentRecord = studentController.findStudentById(ID);
                    if(studentRecord!=null) {
                        Student newStudent=new Student();
                        newStudent.setSid(ID);
                        System.out.println("Old name is:"+studentRecord.getSname());
                        String newName=sn.next();
                        if(newName == null || newName.equals(""))
                        {
                           studentRecord.setSname(studentRecord.getSname());
                        }else newStudent.setSname(newName);

                        System.out.println("Old email is:"+studentRecord.getSemail());
                        String newEmail=sn.next();
                        if(newEmail == null || newEmail.equals(""))
                        {
                            studentRecord.setSemail(studentRecord.getSemail());
                        }else newStudent.setSemail(newEmail);

                        System.out.println("Old city is:"+studentRecord.getScity());
                        String newCity=sn.next();
                        if(newCity == null || newCity.equals(""))
                        {
                            studentRecord.setScity(studentRecord.getScity());
                        }else newStudent.setScity(newCity);

                        System.out.println("Old Country is:"+studentRecord.getScountry());
                        String newCountry=sn.next();
                        if(newCountry == null || newCountry.equals(""))
                        {
                            studentRecord.setScountry(studentRecord.getScountry());
                        }else newStudent.setScountry(newCountry);
                        status=studentController.updateStudentById(newStudent);
                        if(status.equalsIgnoreCase("success")){
                            System.out.println("Records updated successfully");
                        } else if (status.equalsIgnoreCase("failure")) {
                            System.out.println("Record updation failed..");
                        }else {
                            System.out.println("Something went wrong");
                        }
                    }else System.out.println("Record not available...");
                    break;
                case 4:
                    System.out.print("Enter student ID to Delete:\t");
                    ID=sn.nextInt();
                    status=studentController.deleteStudentById(ID);
                    if(status.equalsIgnoreCase("success")){
                        System.out.println("Records deleted successfully");
                    } else if (status.equalsIgnoreCase("failure")) {
                        System.out.println("Record deletion failed..");
                    }else {
                        System.out.println("Something went wrong");
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong input try again...");
                    break;
            }


        }


    }
}
