package in.nitc.tnpmanagement.model;

public class User {
	private int id;
	private String regNo;
	private String email;
	private String phNo;
	private float cgpa;
	private String placStat;
	private String placComp;
	private int isPlacOff;
	
	public User() {}
	
	public User(String regNo, String email, String phNo, float cgpa, String placStat, String placComp, int isPlacOff) {
		super();
		this.regNo = regNo;
		this.email = email;
		this.phNo = phNo;
		this.cgpa = cgpa;
		this.placStat = placStat;
		this.placComp = placComp;
		this.isPlacOff = isPlacOff;
	}

	public User(int id, String regNo, String email, String phNo, float cgpa, String placStat, String placComp,  int isPlacOff) {
		super();
		this.id = id;
		this.regNo = regNo;
		this.email = email;
		this.phNo = phNo;
		this.cgpa = cgpa;
		this.placStat = placStat;
		this.placComp = placComp;
		this.isPlacOff = isPlacOff;
	}
	
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
	public int getIsPlacOff() {
		return isPlacOff;
	}

	public void setIsPlacOff(int isPlacOff) {
		this.isPlacOff = isPlacOff;
	}
	
}
