package Package.Display;

import Package.Account.Account;
import Package.Camp.Camp;
import Package.Student.Student;

import java.util.ArrayList;

public class RestrictedDisplay extends Displayer {

	/**
	 * 
	 * @param campList
	 */
	public void display(ArrayList<Camp> campList, Account account) {
		ArrayList<Camp> avaliableVisitCamps = new ArrayList<>();
		if(account instanceof Student)
		{
			Student student=(Student)account;
			Camp committee=student.getCommitteeStatus();
		}

		for(Camp c:campList)
		{
			if(c.getVisibility()==true&&(c.getUserGroup().contains(account.getFaculty())))
			{
				avaliableVisitCamps.add(c);
				System.out.println("add one avaliable camp."); //TODO:test
			}
		}

		if(avaliableVisitCamps.size()!=0){
			for(Camp camp:avaliableVisitCamps)
			{
				camp.printAllInformation();
			}
		}
		else {
			System.out.println("There is no camp in the camp list now.");
		}

	}

}