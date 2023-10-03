package dto;

public class Student {
    private Integer sid;
    private String sname;
    private String semail;
    private String scity;
    private String scountry;

    public Student() {
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public String getScountry() {
        return scountry;
    }

    public void setScountry(String scountry) {
        this.scountry = scountry;
    }
    @Override
    public String toString(){
      return "Student Name="+sname+"Email="+semail+"City="+scity+"Country="+scountry;
    }

    public int getId() {
        return sid;
    }
    public void setSid(Integer sid){
        this.sid=sid;
    }
}

