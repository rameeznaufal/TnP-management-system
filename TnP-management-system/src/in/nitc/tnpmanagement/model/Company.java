package in.nitc.tnpmanagement.model;

public class Company {
	private int id;
	private String name;
	private String role;
	private String ctc;
	private String loc;
	
	public Company() {}

	public Company(int id, String name, String role, String ctc, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.ctc = ctc;
		this.loc = loc;
	}
	
	
	public Company(String name, String role, String ctc, String loc) {
		super();
		this.name = name;
		this.role = role;
		this.ctc = ctc;
		this.loc = loc;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getctc() {
		return ctc;
	}
	public void setctc(String ctc) {
		this.ctc = ctc;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

}
