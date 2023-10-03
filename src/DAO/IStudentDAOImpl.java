package DAO;

import dto.Student;
import utitlity.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IStudentDAOImpl implements IStudentDAO{
    Connection connection;
    PreparedStatement pst;

    @Override
    public String saveStudent(Student student) {
        String status=null;
        try{
        connection= JDBCUtil.getJDBCconnection();
        if(connection!=null) {
            System.out.println("Connection established");
            String sqlQuery1="insert into student(SName,SEmail,SCity,SCountry) values(?,?,?,?);";
            pst=connection.prepareStatement(sqlQuery1);


            if(pst!=null)
            {
                pst.setString(1,student.getSname());
                pst.setString(2,student.getSemail());
                pst.setString(3,student.getScity());
                pst.setString(4,student.getScountry());

                int row= pst.executeUpdate();
                if(row==1)
                {
                    status="success";
                }
                else status="failure";
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        } catch (IOException e) {
            e.printStackTrace();
            return "failure";
            
        }
        return status;
    }

    @Override
    public Student findStudentById(Integer id) {
        Student student = null;
        try{
            connection= JDBCUtil.getJDBCconnection();
            if(connection!=null) {
                System.out.println("Connection established");
                String sqlQuery2="select ID,SName,SEmail,SCity,SCountry from student where ID=?;";
                pst=connection.prepareStatement(sqlQuery2);
                if(pst!=null)
                {
                  pst.setInt(1,id);
                    ResultSet resultSet = pst.executeQuery();
                    if(resultSet.next())
                    {
                       student=new Student();
                        student.setSname(resultSet.getString(2));
                        student.setSemail(resultSet.getString(3));
                        student.setScity(resultSet.getString(4));
                        student.setScountry(resultSet.getString(5));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
        return student;
    }

    @Override
    public String updateStudentById(Student student) {
        String status=null;
        try{
            connection= JDBCUtil.getJDBCconnection();
            if(connection!=null) {
                System.out.println("Connection established");
                String sqlQuery3="update student set SName=?,SEmail=?,SCity=?,SCountry=? where ID=?;";
                pst=connection.prepareStatement(sqlQuery3);

                if(pst!=null)
                {
                    pst.setString(1,student.getSname());
                    pst.setString(2,student.getSemail());
                    pst.setString(3,student.getScity());
                    pst.setString(4,student.getScountry());
                    pst.setInt(5,student.getId());
                    int row= pst.executeUpdate();
                    if(row==1)
                    {
                        status="success";
                    }
                    else status="failure";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        } catch (IOException e) {
            e.printStackTrace();
            return "failure";

        }
        return status;
    }

    @Override
    public String deleteStudentById(Integer id) {
        String status=null;
        try{
            connection= JDBCUtil.getJDBCconnection();
            if(connection!=null) {
                System.out.println("Connection established");
                String sqlQuery4="delete from student where ID=?;";
                pst=connection.prepareStatement(sqlQuery4);

                if(pst!=null)
                {
                    pst.setInt(1,id);
                    int row= pst.executeUpdate();
                    if(row==1)
                    {
                        status="success";
                    }
                    else status="failure";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return status;
        } catch (IOException e) {
            e.printStackTrace();
            return status;

        }
        return null;
    }
}
