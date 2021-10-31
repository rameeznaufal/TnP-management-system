package in.nitc.tnpmanagement.model;

public class User {
	private int id;
	private String regNo;
	private String email;
	private String phNo;
	private float cgpa;
	private String placStat;
	private String placComp;
	private boolean placOff;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public float getCgpa() {
		return cgpa;
	}
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
	public String getPlacStat() {
		return placStat;
	}
	public void setPlacStat(String placStat) {
		this.placStat = placStat;
	}
	public String getPlacComp() {
		return placComp;
	}
	public void setPlacComp(String placComp) {
		this.placComp = placComp;
	}
	public boolean isPlacOff() {
		return placOff;
	}
	public void setPlacOff(int placOff) {
		
		if (input < 0 || input > 1)
		   {
		      throw new IllegalArgumentException("input must be 0 or 1");
		   }

		   // Note we designate 1 as true and 0 as false though some may disagree
		   return input == 1;
		this.placOff = placOff;
	}
	
	

}
