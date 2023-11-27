package Package;

public class EnquiryPrinter {
    private Enquiry enquiry;
    public EnquiryPrinter(Enquiry enquiry)
    {
        this.enquiry=enquiry;
    }


    public void printEnquiryWithReply()
    {
        System.out.println("Enquiry Id: "+this.enquiry.getEnquiryId());
        System.out.println("Enquiry Content: "+this.enquiry.getContent());
        System.out.println("Enquiry Status: "+this.enquiry.getStatus().toString());
        System.out.println("Enquiry Sender: "+this.enquiry.getSender().getName());
        System.out.println("Enquiry Sender Email: "+this.enquiry.getSender().getUserID()+"@e.nut.edu.sg");
        if(this.enquiry.getStatus()==EnquiryStatus.replied)
        {
            System.out.println("Reply Id: "+this.enquiry.getReply().getReplyId());
            System.out.println("Replier: "+ this.enquiry.getReply().getReplier().getName());
            System.out.println("Replier Email: "+this.enquiry.getReply().getReplier().getUserID()+"@e.nut.edu.sg");
            System.out.println("Reply: "+this.enquiry.getReply().getContent());
        }
    }
    public void printEnquiryWithoutReply()
    {
        System.out.println("Enquiry Id: "+this.enquiry.getEnquiryId());
        System.out.println("Enquiry Content: "+this.enquiry.getContent());
        System.out.println("Enquiry Status: "+this.enquiry.getStatus().toString());
    }

}
