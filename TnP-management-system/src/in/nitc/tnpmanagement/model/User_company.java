package in.nitc.tnpmanagement.model;

public class User_company {
	private int u_id;
	private int c_id;
	
	
	
	
	public User_company() {	}

	public User_company(int u_id, int c_id) {
		super();
		this.u_id = u_id;
		this.c_id = c_id;
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	
}
