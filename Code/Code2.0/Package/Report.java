package Package;

public abstract class Report {

	private Camp camp;

	public Report(Camp camp)
	{
		this.camp=camp;
	}
	public Camp getCamp() {
		return this.camp;
	}

	/**
	 * 
	 * @param camp
	 */
	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	/**
	 * 
	 * @param camp
	 */
	public abstract void GenerateReport(Camp camp);

}