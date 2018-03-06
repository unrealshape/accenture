package Model;

/**
 * @author fatih.elmas
 *

 */
public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String group;
	private String callNumber;
	
	// Constructor
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param group
	 * @param callNumber
	 */
	public Employee(int id, String firstName, String lastName, String group, String callNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.group = group;
		this.callNumber = callNumber;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
	
	

}
