package Package;

import java.util.ArrayList;

public class CommitteeMember extends Student {

	private int point;
	private ArrayList<Suggestion> suggestionList;

	public int getPoint() {
		return this.point;
	}

	/**
	 * 
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	public void viewCampManagedDetail() {
		// TODO - implement CommitteeMember.viewCampManagedDetail
		throw new UnsupportedOperationException();
	}

	public void submitSuggestion() {
		// TODO - implement CommitteeMember.submitSuggestion
		throw new UnsupportedOperationException();
	}

	public void editSuggestion() {
		// TODO - implement CommitteeMember.editSuggestion
		throw new UnsupportedOperationException();
	}

	public void deleteSuggestion() {
		// TODO - implement CommitteeMember.deleteSuggestion
		throw new UnsupportedOperationException();
	}

	public void viewSuggestion()
	{
		System.out.println("You submitted "+this.suggestionList.size()+" suggestions:");
		for
	}

	public void replyEnquiry() {
		// TODO - implement CommitteeMember.replyEnquiry
		throw new UnsupportedOperationException();
	}

	public void viewEnquiry() {
		// TODO - implement CommitteeMember.viewEnquiry
		throw new UnsupportedOperationException();
	}

	public void generateReport() {
		// TODO - implement CommitteeMember.generateReport
		throw new UnsupportedOperationException();
	}

	public CommitteeMember(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,faculty,password,securityQuestion,secureAnswer);
		suggestionList= new ArrayList<Suggestion>();
	}

	public void start() {
		// TODO - implement CommitteeMember.start
		throw new UnsupportedOperationException();
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

}