package Package;
import java.util.ArrayList;
import java.util.List;

public abstract class Account extends AccountInformation {

	public abstract void viewCampList();
	protected Displayer campDisplayer;
	public Account(String userID, String name,AccountStatus accountStatus, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,accountStatus,faculty,password,securityQuestion,secureAnswer);
	}
}