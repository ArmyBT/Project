package Employee;

import java.awt.EventQueue;
import java.sql.Date;

import javax.swing.JFrame;

public class SearchCus {

	private int cusid;
    private String cusname;
    private Date bdate;
    private String graduatedfrom;
    private String faculty;
    private String talent;
    private String address;
    private String phone;
    private String education;
    private String aboutme;
    private String email;
    
    
    
    public SearchCus(int Id,String Name,Date Date,String Graduatedfrom, String Faculty, String Talent, String Address, String Phone, String Education, String AboutME, String Email)
    {
    	this.cusid=Id;
    	this.cusname=Name;
    	this.bdate=Date;
    	this.graduatedfrom=Graduatedfrom;
    	this.faculty=Faculty;
    	this.talent=Talent;
    	this.address=Address;
    	this.phone=Phone;
    	this.education=Education;
    	this.aboutme=AboutME;
    	this.email=Email;
    }
    
    public int getId()
    {
        return cusid;
    }
    
    public String getName()
    {
        return cusname;
    }
    public Date getDate()
    {
    	return bdate;
    }
    public String getGraduatedfrom() 
    {
    	return graduatedfrom;
    }
    public String getFaculty() 
    {
    	return faculty;
    }
    public String getTalent()
    {
    	return talent;
    }
    public String getAddress() 
    {
    	return address;
    }
    public String getPhone() 
    {
    	return phone;
    }
    public String getEducation() 
    {
    	return education;
    }
    public String getAboutME() 
    {
    	return aboutme;
    }
    public String getEmail() 
    {
    	return email;
    }
}





      



