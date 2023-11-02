public class Account {

	private String userID;
	private String password = "password";
	private String name;
	private Faculty faculty;

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

	public Faculty getFaculty() {
		return this.faculty;
	}

	/**
	 * 
	 * @param faculty
	 */
	public void setFaculty(int faculty) {
		// TODO - implement Account.setFaculty
		throw new UnsupportedOperationException();
	}

	public void ViewCampList() {
		// TODO - implement Account.ViewCampList
		throw new UnsupportedOperationException();
	}

}