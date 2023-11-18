package Package;

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
			suggestion.viewSuggestion();
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
		// TODO - implement CommitteeMember.editSuggestion
		throw new UnsupportedOperationException();
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