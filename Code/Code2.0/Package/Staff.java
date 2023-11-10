package Package;
import java.util.ArrayList;
import java.util.List;

public class Staff extends Account {


	private ArrayList<Camp> createCampList;

	public Staff(String userID, String name,  String faculty) {
		// TODO - implement Staff.Staff
		super(userID,name,faculty);
		createCampList = new ArrayList<>();
	}

	public ArrayList<Camp> getCreateCampList() {
	return this.createCampList;
	}

	/**
	 * 
	 * @param createCampList
	 */
	public void setCreateCampList(ArrayList<Camp> createCampList) {
	this.createCampList=createCampList;
	}

	public void addCamp() {

		String CampName;
		int day;
		int month;
		int year;
		Date CampDate;
		Date RegistrationDate;
		Faculty UserGroup;
		String Location;
		int TotalSlot=0;
		int committeeSlot=0;
		String description="NA";
		Camp newCamp;

		System.out.println("Please enter the name of camp");
		CampName=sc.nextLine();

		System.out.println("Please enter the date of Camp,format:day month year. (eg:02 03 2024)");
		day=sc.nextInt();
		month=sc.nextInt();
		year=sc.nextInt();
		CampDate= new Date(day,month,year);

		System.out.println("Please enter the last registrate date of Camp,format:day month year. (eg:02 03 2024)");
		day=sc.nextInt();
		month=sc.nextInt();
		year=sc.nextInt();
		RegistrationDate= new Date(day,month,year);

		System.out.println("Please select the user group");
		Faculty[] facultyList = Faculty.values();
		for (int i = 0; i < facultyList.length; i++) {
			System.out.println((i + 1) + ")" + facultyList[i]);}
		UserGroup= facultyList[sc.nextInt()];

		System.out.println("Please enter the location of the camp");
		Location = sc.nextLine();

		do{
			System.out.println("Please enter the number of the total slot");
			TotalSlot=sc.nextInt();
		}while(TotalSlot<0);

		do{
			System.out.println("Please enter the number of the committee slot, it should be less than 10");
			committeeSlot=sc.nextInt();
			if(committeeSlot>10||committeeSlot<0) System.out.println("Invalid Input! Please input again");
		}while(committeeSlot>10||committeeSlot<0);

		System.out.println("Please enter the description of the camp");
		description=sc.nextLine();
		newCamp = new Camp();
		camplist.addCamp(newCamp);
	}

	public void editCamp() {
		// TODO - implement Staff.editCamp
		Camp currentCamp;
		int choiceCamp=-1;
		int choicePart=-1;
		do
		{
			System.out.println("Please choose the camp you want to edit:");
			System.out.println("0) quit");
			for(int i =0;i<createCampList.length;i++)
			{
				System.out.printf(i+") "+createCampList[i].getCampName()+"\n");
			}
			choiceCamp=sc.nextInt();
			if (choiceCamp==0) break;
			currentCamp=createCampList[choiceCamp];
			do{
				System.out.println("Current camp information:");
				currentCamp.printInformation();
				System.out.printf("Which part of camp you want to edit?\n");
				System.out.printf("1) Camp name\n2) Camp date\n3)Camp  registration date\n4) Total Slot\n5) Committee Slot\n6) Description\n6) Quit");
				choicePart=sc.nextInt();
				switch (choicePart) {
					case 1:
						System.out.println("please enter new name:");
						String name= sc.nextLine();
						currentCamp.setCampName(name);
						break;
					case 2:
						System.out.println("please enter new camp date:");
						int day1=sc.nextInt();
						int month1=sc.nextInt();
						int year1=sc.nextInt();
						Date CampDate1= new Date(day1,month1,year1);
						currentCamp.setDate(CampDate1);
						break;
					case 3:
						System.out.println("please enter new last date of camp registration:");
						int day2=sc.nextInt();
						int month2=sc.nextInt();
						int year2=sc.nextInt();
						Date CampDate2= new Date(day2,month2,year2);
						currentCamp.setDate(CampDate2);
						break;
					case 4:
						System.out.println("please enter new camp slot:");
						int Tslot= sc.nextInt();
						currentCamp.setTotalSlot(Tslot);
						break;
					case 5:
						System.out.println("please enter new committee slot:");
						int Cslot= sc.nextInt();
						currentCamp.setTotalSlot(Cslot);
						break;
					case 6: break;
					default:
						break;
				}
			}while(choicePart!=6);
			camplist.editCamp(currentCamp,choiceCamp);
		}while(choiceCamp!=0);
	}

	public void deleteCamp() {
		// TODO - implement Staff.deleteCamp
		int choice;
		int confirm;
		System.out.println("Please which camp do you want to delete?");
		this.viewCampCreated();
		System.out.println("0) Quit");
		choice=sc.nextInt();
		if(choice==0) return;
		System.out.println("Warning! You are delete a camp. Please Confirm! 0:YES 1:NO");
		confirm=sc.nextInt();
		if(confirm==1) return;
		camplist.delete(createCampList[choice].getCampName());
	}

	public void viewCampList() {
		// TODO - implement Staff.viewCampList
		int choice=0;
		int filterChoice;
		campDisplayer. (getCampList());
		do {

			System.out.println("1) Quit; ");
			System.out.println("2) Filter; ");
			choice = sc.nextInt();
			if(choice!=1 && choice !=2) System.out.println("Invalid input! Please input again!");
			else if (choice ==2)
			{
				System.out.println("Please choose the parameter you want to filte:");
				System.out.println("1) Name;");
				System.out.println("2) Date;");
				System.out.println("3) Location;");
				System.out.println("4) RegistrationDate;");
				System.out.println("5) Total Slot Number;");
				System.out.println("6) Committee Slot Number;");
				System.out.println("7) Remain Slot Number;");
				System.out.println("8) User Group (faculty);");
				System.out.println("0) Quit;");
				fliterChoice=sc.nextInt();
				switch (fliterChoice)
				{
					case 0: break;
					case 1: break;
					default : System.out.println("Invalid Input!!!");
				}
			}
		}while(choice!=1);

	}

	public void viewCampCreated() {
		// TODO - implement Staff.viewCampCreated
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void viewEnquiry(Camp camp) {
		// TODO - implement Staff.viewEnquiry
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void replyEnquiry(Camp camp) {
		// TODO - implement Staff.replyEnquiry
		throw new UnsupportedOperationException();
	}

	public void viewSuggestion() {
		// TODO - implement Staff.viewSuggestion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void approveSuggestion(Camp camp) {
		// TODO - implement Staff.approveSuggestion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void generateStudentReport(Camp camp) {
		// TODO - implement Staff.generateStudentReport
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void generatePerformanceReport(Camp camp) {
		// TODO - implement Staff.generatePerformanceReport
		throw new UnsupportedOperationException();
	}



	public void start() {
		// TODO - implement Staff.start
		throw new UnsupportedOperationException();
	}

}