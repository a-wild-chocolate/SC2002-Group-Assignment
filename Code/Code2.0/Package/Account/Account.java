package Package.Account;
import Package.Display.Displayer;
import Package.Enum.AccountStatus;
import Package.Enum.Faculty;

public abstract class Account extends AccountInformation {

	public abstract void viewCampList();
	protected Displayer campDisplayer;
	public Account(String userID, String name, AccountStatus accountStatus, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,accountStatus,faculty,password,securityQuestion,secureAnswer);
	}
}