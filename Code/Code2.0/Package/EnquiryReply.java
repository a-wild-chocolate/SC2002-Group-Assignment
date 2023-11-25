package Package;

public class EnquiryReply {
    private int replyId;



    private String content;


    private CommitteeMember replier;
    public EnquiryReply(CommitteeMember replier,String content)
    {
        this.content=content;
        this.replier=replier;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommitteeMember getReplier() {
        return replier;
    }

    public void setReplier(CommitteeMember replier) {
        this.replier = replier;
    }


}
