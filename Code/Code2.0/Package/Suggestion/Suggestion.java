package Package.Suggestion;

import Package.Camp.Camp;
import Package.Staff.Staff;
import Package.Student.CommitteeMember;

public class Suggestion //extends Message
{

// attributes
	private String content;
	private CommitteeMember sender;
	private Camp camp;
	private SuggestionStatus status;
	private Staff dealer;
	private static int suggestionNum=0;
	private final int suggestionId;



	//private final String FILE_NAME = "suggestions";


// constructor
	public Suggestion(String content,CommitteeMember sender,Camp camp,SuggestionStatus status)
	{
		this.content=content;
		this.sender=sender;
		this.camp=camp;
		this.dealer=null;
		this.status=status;
		this.suggestionId=suggestionNum;
		suggestionNum++;

	}
	public Suggestion(String content,CommitteeMember sender,Camp camp,SuggestionStatus status,int suggestionNum, Staff dealer)
	{
		this.content=content;
		this.sender=sender;
		this.camp=camp;
		this.dealer=dealer;
		this.status=status;
		this.suggestionId=suggestionNum;
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
//suggestionId
	public int getSuggestionId() {
		return suggestionId;
	}


//CSV method
	/*public void writeToSuggestionCSV()
	{
		String header = "Suggestion ID,Sender Name,Camp Name,Status,Dealer Name,Content\n";
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME,header);
		//String csvData = String.join(",", this.suggestionId, this.sender, this.camp, this.status, this.dealer.getName(), this.content);
        String csvData=toCsvString();		
		try {
		csvModifier.checkCreateOrUpdate(Integer.toString(suggestionId), csvData);
		} catch (IOException e) {
        System.out.println("An I/O error occurred while creating the new account.");
        e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("The cryptographic algorithm is not available in the current environment.");
			e.printStackTrace();
		}	
	}

	public boolean deleteAccount(String onlyID) throws IOException {
		Path filePath = Paths.get(FILE_NAME);
		if (Files.notExists(filePath)) {
			// If the file does not exist, there is no account to delete
			return false;
		}

		// Read all lines except the one with the matching userID
		List<String> outLines = Files.lines(filePath)
				.filter(line -> !line.startsWith(onlyID + ","))
				.collect(Collectors.toList());

		// Check if the account was found and removed
		boolean accountRemoved = outLines.size() < Files.readAllLines(filePath).size();
		
		if (accountRemoved) {
			// Write the remaining lines back to the CSV file
			Files.write(filePath, outLines);
		}
		return accountRemoved;
	}

	public String toCsvString() {
		String senderStr = (sender == null) ? "" : sender.toString();
		String campStr = (camp == null) ? "" : camp.toString();
		String statusStr = (status == null) ? "" : status.toString();
		String dealerName = (dealer == null) ? "" : dealer.getName();
		String contentStr = (content == null) ? "" : content;

		return String.join(",", 
			Integer.toString(suggestionId), 
			senderStr, 
			campStr, 
			statusStr, 
			dealerName, 
			contentStr);
	}*/
//methods
//print the content of the suggestion
	//move to new class SuggestionPrinter -single responsibility principle
	/*public void viewSuggestion()
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


	}*/

	

}