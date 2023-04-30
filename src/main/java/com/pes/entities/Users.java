
package com.pes.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

interface Users {
    
	void printUserInfo();
    String address="",phone="",name="";
    String email="",password="",status=""; int id=0;
    boolean enabled=true;

	static  public String getaddress() {
       
		return address;
	}

	static public String getphone() {
		return phone;
	}

	static public int getid() {
		return id;
	}

	static public int setid(int id) {
		return id;
	}

	static public String getname() {
		return name;
	}

	static public String setname(String name) {
		return name;
	}

	static public String getemail() {
		return email;
	}

	static public String setemail(String email) {
		return email;
	}

	public static String getpassword() {
		return password;
	}

	public static String setpassword(String password) {
		return password;
	}

	public static String getstatus() {
		return status;
	}

	public static String setstatus(String status) {
		return status;
	}

	public static boolean isenabled() {
		return enabled;
	}

	public static boolean setenabled(boolean enabled) {
		return enabled;
	}


	public static String setimageUrl(String imageUrl) {
		return imageUrl;
	}


	public static String setabout(String about) {
		return about;
	}

	public String ConverttoString() ;
	public String UserType();

}


// Student class
class student implements Users {
    @Override
    public void printUserInfo() {
        System.out.println("I am a student.");
    }
	String userType= "student";
	@Override
	public String ConverttoString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", enabled=" + enabled + ", address="
				+ address + ", phone=" + phone + "]";

	}
	@Override
	public String UserType(){
		return "student";
	}

}

// Teacher class
 class teacher implements Users {
    @Override
    public void printUserInfo() {
        System.out.println("I am a teacher.");
    }
	String userType= "teacher";
	@Override
	public String ConverttoString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", enabled=" + enabled + ", address="
				+ address + ", phone=" + phone + "]";

	}
	@Override
	public String UserType(){
		return "student";
	}
}

// Admin class
 class admin implements Users {
    @Override
    public void printUserInfo() {
        System.out.println("I am an admin.");
    }
	String userType= "admin";
	@Override
	public String ConverttoString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", enabled=" + enabled + ", address="
				+ address + ", phone=" + phone + "]";

	}
	@Override
	public String UserType(){
		return "student";
	}
}

