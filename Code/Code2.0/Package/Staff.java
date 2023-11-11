package Package;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Staff extends Account {


	private ArrayList<Camp> createCampList;
	private CampList campList = new CampList();
	private Displayer displayer = new NormalDisplay();
	private Scanner sc = new Scanner(System.in);
	//private Converter cv = new Converter();
	//constructor
	public Staff(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		// TODO - implement Staff.Staff
		super(userID,name,faculty,password,securityQuestion,secureAnswer);
		createCampList = new ArrayList<>();
	}

	//get&set methods
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

		String campName;
		LocalDate campDate;
		LocalDate registrationDate;
		ArrayList<Faculty> userGroup=new ArrayList<Faculty>();
		String location;
		int totalSlot=0;
		int committeeSlot=0;
		String description="NA";
		boolean visibility=false;
		Camp newCamp;


// get camp name
		System.out.println("Please enter the name of camp");
		campName=sc.nextLine();

//get camp date
		System.out.println("Please enter the date of Camp");   //TODO: transfer single date to a range
		System.out.println("Enter a date (yyyy-MM-dd): ");
		String userInput = sc.nextLine();
		campDate = Converter.stringToLocalDate(userInput);

//get camp registration date
		System.out.println("Please enter the last registrate date of Camp");
		System.out.println("Please enter the date of Camp");   //TODO: transfer single date to a range
		System.out.println("Enter a date (yyyy-MM-dd): ");
		userInput = sc.nextLine();
		registrationDate = Converter.stringToLocalDate(userInput);

// get user group
		System.out.println("Available Faculties:");
		int i =0;
		for(Faculty f:Faculty.values())
		{
			System.out.println(i+1+") "+f);
			i++;
		}
		System.out.println("Please enter the number of the faculty to select the user group of the camp (0 to finish)");
		while(true){
			int userChioce = sc.nextInt();
			//quit
			if (userChioce==0) break;
			//input check
			if(userChioce<1||userChioce>Faculty.values().length)
			{
				System.out.println("Invalid selection, please  enter a valid number.");
				continue;
			}
			//add into selected faculty list
			Faculty selectedFaculty = Faculty.values()[userChioce-1];
			userGroup.add(selectedFaculty);
		}

//get location
		System.out.println("Please enter the location of the camp");
		location = sc.nextLine();

//get total slot
		do{
			System.out.println("Please enter the number of the total attendee slot (exclude committee slot)");
			totalSlot=sc.nextInt();
			if (totalSlot<=0) System.out.println("Invalid input! Please input a positive number.");
		}while(totalSlot<=0);
//get committee slot
		do{
			System.out.println("Please enter the number of the committee slot, it should be less than 10");
			committeeSlot=sc.nextInt();
			if(committeeSlot>10||committeeSlot<0) System.out.println("Invalid Input! Please input again");
		}while(committeeSlot>10||committeeSlot<0);
//get descriptio
		System.out.println("Please enter the description of the camp");
		description=sc.nextLine();
//get visibility
		while(true) {
			System.out.println("Do u want to make this camp visible to students?");
			System.out.println("0) No");
			System.out.println("1) Yes");
			int v = sc.nextInt();
			//input check
			if (v != 0 || v != 1) {
				System.out.println("Invalid input!!! Please enter agian!");
				continue;
			}
			//get visibility
			else
			{
				if (v==0) visibility=false;
				else if(v==1) visibility=true;
				break;
			}
		}

//creat new camp
		newCamp = new Camp(campName,campDate,registrationDate,userGroup,location,totalSlot,committeeSlot,description,this,visibility);
		campList.addCamp(newCamp);
		System.out.println("Successfully create a new camp! The details show below:");
		newCamp.printAllInformation();
//return to staff start.
	}

	public void editCamp() {
		// TODO - implement Staff.editCamp
		Camp currentCamp;
		int choiceCamp=-1;
		int choicePart=-1;
		String userInput;
		do
		{
			System.out.println("Please choose the camp you want to edit:");
			System.out.println("0) quit");
			for(int i =0;i<createCampList.length;i++)
			{
				System.out.printf(i+1+") "+createCampList.get(i).getCampName()+"%n");
			}
			choiceCamp=sc.nextInt();
			if (choiceCamp==0) break;
			currentCamp=createCampList.get(choiceCamp-1);
			do{
				System.out.println("Current camp information:");
				currentCamp.printAllInformation();
				System.out.printf("Which part of camp do you want to edit?%n");
				System.out.printf("1) Camp name%n2) Camp date%n3)Camp registration date%n4) Total Slot %n 5) Committee Slot%n6) Description%n7) Visibility%n8)Location%n9)User Group%n0) Quit");
				choicePart=sc.nextInt();
				switch (choicePart) {
					//Camp name
					case 1:
						System.out.println("The current camp name is: "+currentCamp.getCampName());
						System.out.println("please enter new name:");
						String name= sc.nextLine();
						currentCamp.setCampName(name);
						break;
					// Camp date
					case 2:
						System.out.println("The current camp date is: "+currentCamp.getDate());
						System.out.println("please enter new camp date:");//TODO: transfer single date to a range
						System.out.println("Enter a date in format(yyyy-MM-dd): ");
						userInput = sc.nextLine();
						LocalDate campDate = Converter.stringToLocalDate(userInput);
						currentCamp.setDate(campDate);
						break;
					//Camp registration date
					case 3:
						System.out.println("The current camp registration date is: "+currentCamp.getRegistrationDate());
						System.out.println("Please enter the last registrate date of Camp");//TODO: transfer single date to a range
						System.out.println("Enter a date in format(yyyy-MM-dd): ");
						userInput = sc.nextLine();
						LocalDate registrationDate = Converter.stringToLocalDate(userInput);
						currentCamp.setRegistrationDate(registrationDate);
						break;
					//Camp Total Slot
					case 4:
						System.out.println("Please enter new camp slot:");
						int Tslot= sc.nextInt();
						currentCamp.setTotalSlot(Tslot);
						break;
					//Camp Registration Slot
					case 5:
						System.out.println("Please enter new committee slot:");
						int Cslot= sc.nextInt();
						currentCamp.setCommitteeSlot(Cslot);
						break;
					//Camp Description
					case 6:
						System.out.println("The current description is: "+currentCamp.getDescription());
						System.out.println("Please enter new description:");
						String description = sc.nextLine();
						currentCamp.setDescription(description);
						break;
					//Camp visibility
					case 7:
						boolean visibility=currentCamp.getVisibility();
						System.out.println("The current visibility is: "+currentCamp.getVisibility());
						while(true) {
							System.out.println("Do u want to make this camp visible to students now?");
							System.out.println("0) No");
							System.out.println("1) Yes");
							int v = sc.nextInt();
							//input check
							if (v != 0 || v != 1) {
								System.out.println("Invalid input!!! Please enter agian!");
								continue;
							}
							//get visibility
							else
							{
								if (v==0) visibility=false;
								else if(v==1) visibility=true;
								break;
							}
						}
						currentCamp.setVisibility(visibility);
					//Camp Location
					case 8:
						String location;
						System.out.println("The current location is: "+currentCamp.getLocation());
						System.out.println("Please enter new location:");
						location = sc.nextLine();
						currentCamp.setDescription(location);
					//Camp user group
					case 9:
						ArrayList<Faculty> userGroup=new ArrayList<>();
						System.out.println("The current location is: ");
						for(Faculty fa:currentCamp.getUserGroup())
						{
							System.out.print(fa+" ");
						}
						System.out.print("%n");
						System.out.println("Available Faculties:");
						int i =0;
						for(Faculty f:Faculty.values())
						{
							System.out.println(i+1+") "+f);
							i++;
						}
						System.out.println("Please enter the number of the faculty to select the user group of the camp (0 to finish)");
						while(true){
							int userChioce = sc.nextInt();
							//quit
							if (userChioce==0) break;
							//input check
							if(userChioce<1||userChioce>Faculty.values().length)
							{
								System.out.println("Invalid selection, please  enter a valid number.");
								continue;
							}
							//add into selected faculty list
							Faculty selectedFaculty = Faculty.values()[userChioce-1];
							userGroup.add(selectedFaculty);
						}
						currentCamp.setUserGroup(userGroup);
					// Quit
					case 0: break;
					// Input check
					default:System.out.println("Invalid Input!!! Please try again");
						break;
				}
			}while(choicePart!=6);
			campList.editCamp(currentCamp,choiceCamp);
		}while(choiceCamp!=0);
		//Return to Start;
	}

	public void deleteCamp() {
		int i=1;
		int choice;
		int confirm;
		String name="NULL";
		System.out.println("Please choose which camp do you want to delete?");
		for(Camp c : this.createCampList)
		{
			System.out.println(i+")"+c.getCampName());
			i++;
		}
		System.out.println("0) Quit");
		while (true)
		{
			choice=sc.nextInt();
			if(choice==0) return;
			if(choice<0 || choice>this.createCampList.size())
			{
				System.out.println("Invalid Input!!! Please try again");
				continue;
			}
			name=createCampList.get(choice-1).getCampName();
			System.out.println("Warning! You are deleting"+name+"camp. Please Confirm! 0:YES 1:NO");
			confirm=sc.nextInt();
			if(confirm==1) return;
			CampList.deleteCamp(createCampList.get(choice-1).getCampName());
			System.out.println("Successfully delete "+name+" camp");
			break;
		}


	}

	public void viewCampList() {
		// TODO - implement Staff.viewCampList
		int choice=0;
		int filterChoice;
		campDisplayer=new NormalDisplay();
		campDisplayer.display(campList.getCampList(),this);
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
				// TODO - implement Staff.fliter after finish fliter
				switch (fliterChoice)
				{
					case 0: break;
					case 1: break;
					case 2: break;
					case 3: break;
					case 4: break;
					case 5: break;
					case 6: break;
					case 7: break;
					case 8: break;
					default : System.out.println("Invalid Input!!!");
				}
			}
		}while(choice!=1);

	}

	public void viewCampCreated() {
		displayer.display(this.createCampList,this);
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
				// TODO - implement Staff.fliter after finish fliter
				switch (fliterChoice)
				{
					case 0: break;
					case 1: break;
					case 2: break;
					case 3: break;
					case 4: break;
					case 5: break;
					case 6: break;
					case 7: break;
					case 8: break;
					default : System.out.println("Invalid Input!!!");
				}
			}
		}while(choice!=1);
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