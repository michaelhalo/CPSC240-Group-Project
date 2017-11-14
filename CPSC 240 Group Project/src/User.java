
public class User {

	String name;
	String password;
	int userId;
	boolean admin;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public boolean getAdmin() {
		return this.admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String toString() {
		String adminYesNo;
		if(admin) adminYesNo = "Yes"; else adminYesNo = "No";
		
		String info = ("Class name: " + this.getClass().getSimpleName() + ", \n" + 
					   "Name: " + this.name + ",\n" + 
					   "Password: " + this.password + ",\n" +
					   "Admin: " + adminYesNo);
		return info;
	}
	
}
