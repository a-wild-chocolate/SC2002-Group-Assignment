package Package;

public abstract class Message {

	private String content;
	private Account sender;
	private boolean status;

	public String getContent() {
		return this.content;
	}

	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public Account getSender() {
		return this.sender;
	}

	/**
	 * 
	 * @param sender
	 */
	public void setSender(Account sender) {
		this.sender = sender;
	}

	public boolean getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void sendMessage(Camp ca) {
		// TODO - implement Message.sendMessage
		throw new UnsupportedOperationException();
	}

	public void deleteMessage() {
		// TODO - implement Message.deleteMessage
		throw new UnsupportedOperationException();
	}

	public abstract void changeStatus();

}