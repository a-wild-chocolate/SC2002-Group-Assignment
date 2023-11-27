package Package.Suggestion;
//This class shows Single Responsibility Principle
public class SuggestionPrinter {
    private Suggestion suggestion;
    public SuggestionPrinter(Suggestion suggestion)
    {
        this.suggestion=suggestion;
    }
    public void print()
    {
        System.out.println("Suggestion content: "+this.suggestion.getContent());
        System.out.println("Suggestion sender: "+this.suggestion.getSender().getName());
        System.out.println("Suggestion relate camp: "+this.suggestion.getCamp().getCampName());
        System.out.println("Suggestion status: "+this.suggestion.getStatus());
        if(this.suggestion.getStatus()!= SuggestionStatus.pending) {
            System.out.println("Suggestion dealer: " + this.suggestion.getDealer().getName());
            System.out.println("Suggestion dealer's email: " + this.suggestion.getDealer().getUserID() + "@e.ntu.edu.sg");
        }
    }

}
