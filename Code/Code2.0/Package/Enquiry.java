package Package;

public class Enquiry {

	private Camp camp;


	private String content;

	private EnquiryStatus status;
	private static int enquiryNumber = 0;

	private final int enquiryId;

	private EnquiryReply reply;
//for user
	public Enquiry(String content,Camp camp)
	{
		this.camp=camp;
		this.content=content;
		this.enquiryId=enquiryNumber;
		enquiryNumber++;
		this.reply=null;
		this.status=EnquiryStatus.pending;
	}
//for csv writer
	public Enquiry(int enquiryId, String content,Camp camp, EnquiryReply reply, EnquiryStatus status)
	{
		this.camp=camp;
		this.enquiryId=enquiryId;
		this.content=content;
		this.reply=reply;
		this.status=status;
	}
	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public int getEnquiryId() {
		return enquiryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public EnquiryReply getReply() {
		return reply;
	}

	public void setReply(EnquiryReply reply) {
		this.reply = reply;
	}

	public EnquiryStatus getStatus() {
		return this.status;
	}

	/**
	 * @param status
	 */
	public void setStatus(EnquiryStatus status) {
		this.status = status;
	}
}



