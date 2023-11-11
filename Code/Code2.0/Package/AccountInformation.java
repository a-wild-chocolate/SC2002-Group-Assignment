package Package;
import java.util.ArrayList;
import java.util.List;

public class AccountInformation extends AccountManager {

	private String userID;
	private String name;
	private Faculty faculty;
	private String password = "password";

	public AccountInformation(String userID, String name,  String faculty) {
		this.userID=userID;
		this.name=name;
		this.faculty=Converter.sringToFaculty(faculty);
	}

	public String getUserID() {
		return this.userID;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param Password
	 */
	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param faculty
	 */
	public void setFaculty(Faculty faculty) {
	this.faculty=faculty;
	}

	public Faculty getFaculty() {return this.faculty;}


}