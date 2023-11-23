package Package;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CommitteeMember extends Student {

//attributes
	private int point;
	private ArrayList<Suggestion> suggestionList;
	Scanner sc = new Scanner(System.in);

	public int getPoint() {
		return this.point;
	}

//constructor
	public CommitteeMember(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,faculty,password,securityQuestion,secureAnswer);
		suggestionList= new ArrayList<Suggestion>();
	}

//get and set

	/**
	 * 
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}









	public ArrayList<Suggestion> getSuggestionList() {
		return this.suggestionList;
	}

	/**
	 * 
	 * @param suggestionList
	 */
	public void setSuggestionList(ArrayList<Suggestion> suggestionList) {
		this.suggestionList = suggestionList;
	}

//methods
	public void viewCampManagedDetail() {
		if (this.getCommitteeStatus() != null) {
			ArrayList camp = new ArrayList<>();
			camp.add(this.getCommitteeStatus());
			Displayer displayer = new RestrictedDisplay();
			displayer.display(camp, this);
		} else {
			System.out.println("Sorry, you are not in any camp's committee");
		}
	}

	public void viewCampList() {
		Displayer campDisplayer= new RestrictedDisplay();
		System.out.println("----- Camp List -----");
		System.out.println("Current time: "+ LocalDate.now());
		campDisplayer.display(CampList.getCampList(),this);
		System.out.println();
		System.out.println("1) View in camp name alphabet order (Default)");
		System.out.println("2) Filter");
		System.out.println("0) Quit");
		int choice;
		choice=sc.nextInt();
		switch (choice)
		{
			case 2:
				campDisplayer.display(SearchApp.searchApp(CampList.getCampList()),this);
				break;
			case 1:
				campDisplayer.display(SortCampByName.sortCamp(CampList.getCampList()),this);
				break;

			case 0:
				break;
			default:System.out.println("Invalid Input!!!");
		}


	}

	public void replyEnquiry() {
		// TODO - implement CommitteeMember.replyEnquiry
		throw new UnsupportedOperationException();
	}

	public void viewEnquiry() {
		// TODO - implement CommitteeMember.viewEnquiry
		throw new UnsupportedOperationException();
	}

	public void viewSuggestion()
	{
		System.out.println("You submitted "+this.suggestionList.size()+" suggestions:");
		int i=1;
		for(Suggestion suggestion:this.getSuggestionList())
		{
			System.out.println(i++ +".");
			SuggestionPrinter suggestionPrinter= new SuggestionPrinter(suggestion);
			suggestionPrinter.print();
			System.out.println();
		}
	}

	public void submitSuggestion() {
		if(this.getCommitteeStatus()==null)
		{
			System.out.println("Sorry, you are not in any camp's committee");
			return;
		}
		String content;
		ArrayList suggestionList=this.getSuggestionList();
		System.out.println("Please enter the content you want to suggest: (empty space)");
		content=sc.nextLine();
		System.out.println("Thank you for your suggestion , the staff will deal with it soon.");
		Suggestion newSuggestion = new Suggestion(content,this,this.getCommitteeStatus(),SuggestionStatus.pending);
		suggestionList.add(newSuggestion);
		this.setSuggestionList(suggestionList);
		ArrayList campSuggestionList=this.getCommitteeStatus().getSuggestionList();
		campSuggestionList.add(newSuggestion);
		this.getCommitteeStatus().setSuggestionList(campSuggestionList);
	}

	public void editSuggestion() {
		//check his suggestion list
		if(this.suggestionList.isEmpty())
		{
			System.out.println("Sorry, you did not submit any suggestions.");
			return;
		}
		//check any suggestion can be edited
		ArrayList<Suggestion> avaliableSuggestions= new ArrayList<Suggestion>();
		for(Suggestion suggestion:this.suggestionList)
		{
			if(suggestion.getStatus()==SuggestionStatus.pending)
				avaliableSuggestions.add(suggestion);
		}
		if(avaliableSuggestions.isEmpty())
		{
			System.out.println("Sorry, there is no suggestion you can edit.");
			return;
		}
		System.out.println("Above is the availiable suggestion list:");
		int i=1;//number of suggestion
		for (Suggestion suggestion:avaliableSuggestions)
		{
			System.out.println(i+") :");
			SuggestionPrinter suggestionPrinter=new SuggestionPrinter(suggestion);
			suggestionPrinter.print();
			System.out.println();
		}
		int choice;
		//let user enter the suggestion he wants to choose
		while (true)
		{
			System.out.println("Which suggestion do you want to edit? Please enter the number (0:Quit)");
			choice=sc.nextInt();
			if(choice==0) return;
			if(choice>=avaliableSuggestions.size())
			{
				System.out.println("Invalid input please input again!");
				continue;
			}
			Suggestion editSuggestion;
			editSuggestion=avaliableSuggestions.get(choice-1);
			System.out.println("Please enter the update content: ");
			String newContent;
			newContent=sc.nextLine();
			editSuggestion.setContent(newContent);
			//set suggestion into committeeMember suggestion List
			int location=0;
			ArrayList<Suggestion> temp;
			for(Suggestion suggestion:this.suggestionList)
			{
				if(suggestion.getSuggestionId()==editSuggestion.getSuggestionId()) break;
				location++;
			}
			temp=this.suggestionList;
			temp.set(location,editSuggestion);
			this.setSuggestionList(temp);
			//set suggestion into Camp suggestion List
			location=0;
			for(Suggestion suggestion:editSuggestion.getCamp().getSuggestionList())
			{
				if(suggestion.getSuggestionId()==editSuggestion.getSuggestionId()) break;
				location++;
			}
			temp=editSuggestion.getCamp().getSuggestionList();
			temp.set(location,editSuggestion);
			editSuggestion.getCamp().setSuggestionList(temp);
			System.out.println("Successfully edit!");
			return;
		}
	}

	public void deleteSuggestion() {
		// TODO - implement CommitteeMember.deleteSuggestion
		throw new UnsupportedOperationException();
	}

	public void generateReport() {
		// TODO - implement CommitteeMember.generateReport
		throw new UnsupportedOperationException();
	}



	public void start() {
		// TODO - implement CommitteeMember.start
		throw new UnsupportedOperationException();
	}

}