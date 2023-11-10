package Package;

public class Enquiry extends Message {

	private boolean status;
	private boolean headOrNot;

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

	public boolean getHeadOrNot() {
		return this.headOrNot;
	}

	/**
	 * 
	 * @param headOrNot
	 */
	public void setSeadOrNot(boolean headOrNot) {
		// TODO - implement Enquiry.setSeadOrNot
		throw new UnsupportedOperationException();
	}

	public void changeStauts() {
		// TODO - implement Enquiry.changeStauts
		throw new UnsupportedOperationException();
	}

}