package in.nitc.tnpmanagement.model;

public class User {
	private int id;
	private String name;
	private String regNo;
	private String email;
	private String phNo;
	private float cgpa;
	private String password;
	private String placStat;
	private String placComp;
	private int isPlacOff;
	
	public User() {}
	
	public User(String name, String regNo, String email, String password, String phNo, float cgpa, String placStat, String placComp, int isPlacOff) {
		super();
		this.name = name;
		this.regNo = regNo;
		this.email = email;
		this.password = password;
		this.phNo = phNo;
		this.cgpa = cgpa;
		this.placStat = placStat;
		this.placComp = placComp;
		this.isPlacOff = isPlacOff;
	}

	public User(int id, String name, String regNo, String email, String password, String phNo, float cgpa, String placStat, String placComp,  int isPlacOff) {
		super();
		this.id = id;
		this.name = name;
		this.regNo = regNo;
		this.email = email;
		this.password = password;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
