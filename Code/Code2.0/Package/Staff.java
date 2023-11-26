package Package;
import java.awt.image.PackedColorModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Staff extends Account {


	private ArrayList<Camp> createCampList;
	private CampList campList = new CampList();
	private Displayer displayer = new NormalDisplay();
	private Scanner sc = new Scanner(System.in);
	//private Converter cv = new Converter();
	//constructor
	public Staff(String userID, String name,AccountStatus accountStatus, Faculty faculty, String password, String securityQuestion, String secureAnswer) {

		super(userID,name,accountStatus,faculty,password,securityQuestion,secureAnswer);
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

		Camp currentCamp;
		int choiceCamp=-1;
		int choicePart=-1;
		String userInput;
		do
		{
			System.out.println("Please choose the camp you want to edit:");
			System.out.println("0) quit");
			for(int i =0;i<createCampList.size();i++)
			{
				System.out.printf(i+1+") "+createCampList.get(i).getCampName()+"\n");
			}
			choiceCamp=sc.nextInt();
			if (choiceCamp==0) break;
			currentCamp=createCampList.get(choiceCamp-1);
			do{
				System.out.println("Current camp information:");
				currentCamp.printAllInformation();
				System.out.printf("Which part of camp do you want to edit?\n");
				System.out.printf("1) Camp name\n2) Camp date\n3)Camp registration date\n4) Total Slot \n 5) Committee Slot\n6) Description\n7) Visibility\n8)Location\n9)User Group\n0) Quit");
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
						while (true)
						{
							System.out.println("Please enter new committee slot:");
							int Cslot= sc.nextInt();
							if(Cslot>10||Cslot<=0)
							{
								System.out.println("Invalid input! Please enter agian.");
								continue;
							}
							else {
								currentCamp.setCommitteeSlot(Cslot);
								break;
							}
						}

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
						if(currentCamp.getStudentList().size()!=0||currentCamp.getCommitteeMemberList().size()!=0)
						{
							System.out.println("You can not edit this camp user group since there are students in this camp.");
							break;
						}
						ArrayList<Faculty> userGroup=new ArrayList<>();
						System.out.println("The current location is: ");
						for(Faculty fa:currentCamp.getUserGroup())
						{
							System.out.print(fa+" ");
						}
						System.out.print("\n");
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
			campList.editCamp(currentCamp,choiceCamp-1);
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
			//input check
			if(choice==0) return;
			if(choice<0 || choice>this.createCampList.size())
			{
				System.out.println("Invalid Input!!! Please try again");
				continue;
			}
			//cannot delete if there are students in the camp
			if(createCampList.get(choice-1).getStudentList().size()!=0||createCampList.get(choice-1).getCommitteeMemberList().size()!=0)
			{
				System.out.println("You can not delete this camp since there are students in this camp.");
				break;
			}
			//delete camp
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

		int choice=0;
		int filterChoice;

		campDisplayer=new NormalDisplay();
		campDisplayer.display(campList.getCampList(),this);
		do {
			System.out.println("1) Quit; ");
			System.out.println("2) Filter; ");
			choice = sc.nextInt();
			if(choice!=1 && choice !=2) System.out.println("Invalid input! Please input again!");
			else if (choice ==2) {
				campDisplayer.display(SearchApp.searchApp(CampList.getCampList()),this);
				return;
			}
		}while(choice!=1);

	}

	public void viewCampCreated() {
		int choice=0;
		int filterChoice;
		displayer.display(this.createCampList,this);
		do {

			System.out.println("1) Quit; ");
			System.out.println("2) Filter; ");
			choice = sc.nextInt();
			if(choice!=1 && choice !=2) System.out.println("Invalid input! Please input again!");
			else if (choice ==2)
			{
				campDisplayer.display(SearchApp.searchApp(this.getCreateCampList()),this);
			}
		}while(choice!=1);
	}


	public void viewEnquiry() {
		//no camp created
		if(this.getCreateCampList().isEmpty())
		{
			System.out.println("Sorry, you did not create any camp.");
		}
		//exist camp created
		int index=1;
		int choiceC;
		int choice;
		Camp currentCamp;
		while (true)
		{
			//get camp user want to view
			System.out.println("Please enter the index of camp you want to view enquiry: (0 Quit)");
			for(Camp camp:this.getCreateCampList())
			{
				System.out.println(index+") "+camp.getCampName());
				index++;
			}
			while (true)
			{
				choiceC=sc.nextInt();
				//quit check
				if(choiceC==0)return;
				//iput check
				if(choiceC<0 || choiceC>this.getCreateCampList().size())
				{
					System.out.println("Invalid input! Please enter again:");
					continue;
					//back to loop start
				}
				//get camp
				currentCamp=this.getCreateCampList().get(choiceC-1);
				//camp no enquiry
				if(currentCamp.getEnquiryList().isEmpty())
				{
					System.out.println("There is no enquiry in this camp");
				}
				//print enquiries
				else
				{
					for(Enquiry enquiry:currentCamp.getEnquiryList())
					{
						enquiry.printWithReply();
						System.out.println();
					}
				}
				while (true)
				{
					//continue check
					System.out.println("Do you want to view other camp?");
					System.out.println("1) Yes");
					System.out.println("0) Quit");
					choice=sc.nextInt();
					//back to start
					if(choice==0 )return;
					//back to loop start
					if(choice==1) break;
					System.out.println("Invalid input! Please enter again.");
				}
				break;
			}

		}
	}

	public void replyEnquiry()
	{

		if(this.getCreateCampList().isEmpty())
		{
			System.out.println("Sorry, there is no camp created.");
			return;
		}
		int index=1;
		int campChoice;
		Camp currentCamp;

		for(Camp camp: this.getCreateCampList())
		{
			System.out.println(index+") "+camp.getCampName());
			index++;
		}
		while (true)
		{
			System.out.println("Please select which camp enquiry you want to view: (0 Quit)");
			campChoice=sc.nextInt();
			if(campChoice==0) return;
			else {
				currentCamp=this.getCreateCampList().get(campChoice-1);
				if(currentCamp==null)
				{
					System.out.println("Invalid input! Please enter again.");
					continue;
				}
				if(currentCamp.getEnquiryList().isEmpty())
				{
					System.out.println("Sorry, this camp does not have enquiry.");
					break;
				}
				//print all enquiries
				for(Enquiry enquiry: currentCamp.getEnquiryList())
				{
					enquiry.printWithReply();
					System.out.println();
				}
				int id;
				Enquiry currentEnquiry=null;
				String reply;
				int choice;
				ArrayList<Enquiry> temp1;
				ArrayList<Enquiry> temp2;
				while (true) {
					System.out.println("Please enter the id of enquiry you want to edit: (-1 Quit)");
					id = sc.nextInt();
					if (id == -1) return;
					//find enquiry
					for (int i = 0; i < currentCamp.getEnquiryList().size(); i++) {
						if (id == currentCamp.getEnquiryList().get(i).getEnquiryId()) {
							currentEnquiry = currentCamp.getEnquiryList().get(i);
							break;
						}
					}
					if (currentEnquiry == null) {
						System.out.println("Invalid input. Please enter again.");
						continue;
					}
					//find enquiry, print it out
					System.out.println("Enquiry finds!");
					currentEnquiry.printWithoutReply();
					while (true) {
						//enter the reply
						System.out.println("Please enter your reply:");
						reply = sc.nextLine();
						System.out.println("1) Confirm");
						System.out.println("0) Quit");
						choice = sc.nextInt();
						if (choice == 0) return;
						if (choice == 2) continue;
						if (choice == 1) {
							EnquiryReply enquiryReply = new EnquiryReply(this, reply);
							temp1 = currentEnquiry.getCamp().getEnquiryList();
							temp2 = currentEnquiry.getSender().getEnquiryList();
							temp1.remove(currentEnquiry);
							temp2.remove(currentEnquiry);
							currentEnquiry.setStatus(EnquiryStatus.replied);
							currentEnquiry.setReply(enquiryReply);
							temp2.add(currentEnquiry);
							temp1.add(currentEnquiry);
							currentEnquiry.getCamp().setEnquiryList(temp1);
							currentEnquiry.getSender().setEnquiryList(temp2);
							System.out.println("Successfully reply.");
							return;
						} else {
							System.out.println("Invalid input. Please enter again.");
						}
					}
				}
			}
		}

	}



	public void viewSuggestion() {
		//no camp created
		if(this.getCreateCampList().isEmpty())
		{
			System.out.println("Sorry, you did not create any camp.");
		}
		//exist camp created
		int index=1;
		int choiceC;
		int choice;
		Camp currentCamp;
		SuggestionPrinter suggestionPrinter;
		while(true)
		{
			System.out.println("Please enter the index of camp you want to view suggestion: (0 Quit)");
			for(Camp camp:this.getCreateCampList())
			{
				System.out.println(index+") "+camp.getCampName());
				index++;
			}
			while (true)
			{
				choiceC=sc.nextInt();
				//quit check
				if(choiceC==0)return;
				//iput check
				if(choiceC<0 || choiceC>this.getCreateCampList().size())
				{
					System.out.println("Invalid input! Please enter again:");
					continue;
					//back to loop start
				}
				//get camp
				currentCamp=this.getCreateCampList().get(choiceC-1);
				if(currentCamp.getSuggestionList().isEmpty())
				{
					System.out.println("There is no suggestion in this camp");
				}
				else
				{
					for(Suggestion suggestion:currentCamp.getSuggestionList())
					{
						suggestionPrinter=new SuggestionPrinter(suggestion);
						suggestionPrinter.print();
					}
				}
				while (true)
				{
					//continue check
					System.out.println("Do you want to view other camp?");
					System.out.println("1) Yes");
					System.out.println("0) Quit");
					choice=sc.nextInt();
					//back to start
					if(choice==0 )return;
					//back to loop start
					if(choice==1) break;
					System.out.println("Invalid input! Please enter again.");
				}
				break;
			}

		}
	}


	public void approveSuggestion() {
		if(this.getCreateCampList().isEmpty())
		{
			System.out.println("Sorry, there is no camp created.");
			return;
		}
		int index=1;
		int campChoice;
		Camp camp;

		for(Camp Ccamp: this.getCreateCampList())
		{
			System.out.println(index+") "+Ccamp.getCampName());
			index++;
		}
		while (true) {
			System.out.println("Please select which camp suggestion you want to view: (0 Quit)");
			campChoice = sc.nextInt();
			if (campChoice == 0) return;
			else {
				camp = this.getCreateCampList().get(campChoice - 1);
				if (camp == null) {
					System.out.println("Invalid input! Please enter again.");
					continue;
				}
				break;
			}
		}

		ArrayList<Suggestion> suggestionList = camp.getSuggestionList();
		ArrayList<Suggestion> pendingSuggestionList = new ArrayList<Suggestion>();
		Suggestion currentSuggestion;
		int choice=0;
		int approve=0;
		int continueChoice=0;
		//check is there any suggestion.
		if(suggestionList.isEmpty())
		{
			System.out.println("There is no suggestion.");
			return;
		}
		//get all the pending suggestion
		for(Suggestion suggestion:suggestionList)
		{
			if(suggestion.getStatus()==SuggestionStatus.pending) pendingSuggestionList.add(suggestion);
		}
		//check is there any suggestion need to be processed
		if(pendingSuggestionList.isEmpty())
		{
			System.out.println("There is no more suggestion to be processed");
		}
		//count the number of suggestion need to be processed
		else {
			System.out.println("There are "+pendingSuggestionList.size()+" suggestions need to be processed.");
			// print out all the pending suggestions
			int i=1;
			for(Suggestion suggestion:pendingSuggestionList)
			{
				System.out.println(i+ ".");
				i++;
				SuggestionPrinter suggestionPrinter= new SuggestionPrinter(suggestion);
				suggestionPrinter.print();
				System.out.println();
			}
			//
			do{
				System.out.println("Please enter the index of suggestion you want to process: (0 Quit)");
				choice=sc.nextInt();
				//TODO: Error check
				currentSuggestion=pendingSuggestionList.get(choice-1);
				//Quit
				if(choice==0) return;
				//approve or reject
				else {
					System.out.println("You want to approve or reject it? (1 for approve, 0 for reject)");
					approve=sc.nextInt();
					if(approve==0)
					{
						currentSuggestion.setStatus(SuggestionStatus.rejected);
					}
					else if(approve==1)
					{
						currentSuggestion.setStatus(SuggestionStatus.appoved);
					}
					else System.out.println("Invalid input");//TODO: Reinput ?
					//prepare for change suggestion
					int id,location=0;
					ArrayList<Suggestion> temp;
					camp.getSuggestionList();
					id=currentSuggestion.getSuggestionId();
					temp=camp.getSuggestionList();
					//find the location of the changing suggestion inside the camp suggestion list;
					//Question: do we need to change in the csv file also?
					for(Suggestion suggestion:temp)
					{
						if(id==suggestion.getSuggestionId())
						{
							break;
						}
						location++;
					}
					//set updated suggestion in the temp array;
					temp.set(location,currentSuggestion);
					//set temp array as formal array;
					camp.setSuggestionList(temp);

				}
				while(true)
				{
					System.out.println("Do you want to process more suggestion? 1) Yes 0) Quit");
					continueChoice=sc.nextInt();
					if(continueChoice!=1 && continueChoice!=0) System.out.println("Invalid input. Please enter again.");
					else break;
				}

			}while(continueChoice==1);


		}

	}


	public void generateStudentReport() {
		CampReport campReport;
		if(this.getCreateCampList().isEmpty())
		{
			System.out.println("Sorry, there is no camp created.");
			return;
		}
		int index=1;
		int campChoice;
		Camp camp;

		for(Camp Ccamp: this.getCreateCampList())
		{
			System.out.println(index+") "+Ccamp.getCampName());
			index++;
		}
		while (true)
		{
			while (true) {
				System.out.println("Please select which camp report you want to generate : (0 Quit)");
				campChoice = sc.nextInt();
				if (campChoice == 0) return;
				else {
					camp = this.getCreateCampList().get(campChoice - 1);
					if (camp == null) {
						System.out.println("Invalid input! Please enter again.");
						continue;
					}
					break;
				}
			}
			campReport=new CampReport(camp);
			campReport.GenerateReport(camp);
			System.out.println("1) Quit");
			System.out.println("0) Continue");
			int c;
			c= sc.nextInt();
			if(c==1) return;
			//else continue
		}


	}


	public void generatePerformanceReport() {
		PerformanceReport campReport;
		if(this.getCreateCampList().isEmpty())
		{
			System.out.println("Sorry, there is no camp created.");
			return;
		}
		int index=1;
		int campChoice;
		Camp camp;

		for(Camp Ccamp: this.getCreateCampList())
		{
			System.out.println(index+") "+Ccamp.getCampName());
			index++;
		}
		while (true)
		{
			while (true) {
				System.out.println("Please select which camp report you want to generate : (0 Quit)");
				campChoice = sc.nextInt();
				if (campChoice == 0) return;
				else {
					camp = this.getCreateCampList().get(campChoice - 1);
					if (camp == null) {
						System.out.println("Invalid input! Please enter again.");
						continue;
					}
					break;
				}
			}
			campReport=new PerformanceReport(camp);
			campReport.GenerateReport(camp);
			System.out.println("1) Quit");
			System.out.println("0) Continue");
			int c;
			c= sc.nextInt();
			if(c==1) return;
			//else continue
		}

	}

	public void generateEnquiryReport()
	{
		EnquiryReport campReport;
		if(this.getCreateCampList().isEmpty())
		{
			System.out.println("Sorry, there is no camp created.");
			return;
		}
		int index=1;
		int campChoice;
		Camp camp;

		for(Camp Ccamp: this.getCreateCampList())
		{
			System.out.println(index+") "+Ccamp.getCampName());
			index++;
		}
		while (true)
		{
			while (true) {
				System.out.println("Please select which camp report you want to generate : (0 Quit)");
				campChoice = sc.nextInt();
				if (campChoice == 0) return;
				else {
					camp = this.getCreateCampList().get(campChoice - 1);
					if (camp == null) {
						System.out.println("Invalid input! Please enter again.");
						continue;
					}
					break;
				}
			}
			campReport=new EnquiryReport(camp);
			campReport.GenerateReport(camp);
			System.out.println("1) Quit");
			System.out.println("0) Continue");
			int c;
			c= sc.nextInt();
			if(c==1) return;
			//else continue
		}

	}



	public void start() {
		int choice;
		while (true)
		{
			System.out.println("Welcome "+this.getUserID()+"! What do you want to do today?");
			System.out.println("---Camp---");
			System.out.println("1) View Camp List");
			System.out.println("2) View Camp Created");
			System.out.println("3) Create Camp");
			System.out.println("4) Edit Camp");
			System.out.println("5) Delete Camp");
			System.out.println("---Suggestion---");
			System.out.println("6) View Suggestions");
			System.out.println("7) Process Suggestions");
			System.out.println("---Enquiry---");
			System.out.println("8) View Enquiries");
			System.out.println("9) Reply Enquiries");
			System.out.println("---Report---");
			System.out.println("10) Generate Camp Report");
			System.out.println("11) Generate Performance Report");
			System.out.println("12) Generate Enquiry Report");
			System.out.println("=======================================");
			System.out.println("0) QUIT");

			choice=sc.nextInt();
			switch (choice)
			{
				case 0: return;
				case 1: viewCampList();
				break;
				case 2: viewCampCreated();
				break;
				case 3: addCamp();
				break;
				case 4: editCamp();
				break;
				case 5: deleteCamp();
				break;
				case 6: viewSuggestion();
				break;
				case 7: approveSuggestion();
				break;
				case 8: viewEnquiry();
				break;
				case 9: replyEnquiry();
				break;
				case 10: generateStudentReport();
				break;
				case 11: generatePerformanceReport();
				break;
				case 12: generateEnquiryReport();
				break;
				default:System.out.println("Invalid input! Please enter again.");
			}
		}

	}

}