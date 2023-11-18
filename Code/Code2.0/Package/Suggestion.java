package Package;



public class Suggestion //extends Message
{

// attributes
	private String content;
	private CommitteeMember sender;
	private Camp camp;
	private SuggestionStatus status;
	private Staff dealer;


// constructor
	private Suggestion(String content,CommitteeMember sender,Camp camp)
	{
		this.content=content;
		this.sender=sender;
		this.camp=camp;
		this.dealer=null;
		this.status=SuggestionStatus.pending;
	}

//get and set methods
//content
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
//sender
	public CommitteeMember getSender() {
		return sender;
	}

	public void setSender(CommitteeMember sender) {
		this.sender = sender;
	}
//camp
	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}
//dealer
	public Staff getDealer() {
		return dealer;
	}

	public void setDealer(Staff dealer) {
		this.dealer = dealer;
	}
//status
	public SuggestionStatus getStatus() {
		return this.status;
	}
	/**
	 *
	 * @param status
	 */
	public void setStatus(SuggestionStatus status) {
		this.status=status;
	}

//methods
//print the conntent of the suggestion
	public void viewSuggestion()
	{
		System.out.println("Suggestion content: "+this.getContent());
		System.out.println("Suggestion sender: "+this.sender.getName());
		System.out.println("Suggestion relate camp: "+this.getCamp().getCampName());
		System.out.println("Suggestion status: "+this.getStatus());
		if(this.getStatus()!=SuggestionStatus.pending)
		{
			System.out.println("Suggestion dealer: "+this.getDealer().getName());
			System.out.println("Suggestion dealer's email: "+this.getDealer().getUserID()+"@e.ntu.edu.sg");
		}


	}

}