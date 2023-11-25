package Package;

public class EnquiryReply {
    private int replyId;
    private String content;
    private static int replyNumber=0;

    private CommitteeMember replier;
    //for user
    public EnquiryReply(CommitteeMember replier,String content)
    {
        this.content=content;
        this.replier=replier;
        replyNumber++;
        this.replyId=replyNumber;
    }
    // for csv
    public EnquiryReply(int replyId, CommitteeMember replier,String content)
    {
        this.replyId=replyId;
        this.replier=replier;
        this.content=content;
    }

    public int getReplyId() {return replyId;}
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
