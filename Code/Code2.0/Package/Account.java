package Package;
import java.util.ArrayList;
import java.util.List;

public abstract class Account extends AccountInformation {


	public abstract void ViewCampList();

	public Account(String userID, String name,  String faculty) {
		// TODO - implement Account.Account
		super(userID,name,faculty);
	}
}