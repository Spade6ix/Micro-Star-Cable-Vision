package microStar.employee;

public class EmployeeModel {
	
	//Attributes
	private String staffID;
	private String password;
	private String firstName;
	private String lastName;
	private char job;
	
	//Constructors
	public EmployeeModel() {
		this.staffID = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.job = 'E';
	}
	
	public EmployeeModel(String staffID, String password, String firstName, String lastName, char job) {
		this.staffID = staffID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
	}
	
	public EmployeeModel(EmployeeModel empModelObj) {
		this.staffID = empModelObj.staffID;
		this.password = empModelObj.password;
		this.firstName = empModelObj.firstName;
		this.lastName = empModelObj.lastName;
		this.job = empModelObj.job;
	}

	//Accessors and mutators
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getJob() {
		return job;
	}

	public void setJob(char job) {
		this.job = job;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Staff ID: "+ this.getStaffID()+ "\nName: "+ this.getFirstName()+ " " + this.getLastName() + "\nJob: "+ this.getJob();
	}
	
	
	
	
	
	
}
