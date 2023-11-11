package Package;
import java.util.ArrayList;
import java.util.List;

public abstract class Account extends AccountInformation {

	public abstract void ViewCampList();
	protected Displayer campDisplayer;
	public Account(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,faculty,password,securityQuestion,secureAnswer);
	}
}