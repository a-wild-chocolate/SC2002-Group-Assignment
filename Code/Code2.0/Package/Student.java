package Package;

public class Student extends Account {

	private int point;
	private Camp committeeStatus;
	private ArrayList<LocalDate> daysOccupied;

	public Student() {
		// TODO - implement Student.Student
		throw new UnsupportedOperationException();
	}

	public int getPoint() {
		return this.point;
	}

	/**
	 * 
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	public Camp getCommitteeStatus() {
		return this.committeeStatus;
	}

	/**
	 * 
	 * @param committeeStatus
	 */
	public void setCommitteeStatus(Camp committeeStatus) {
		this.committeeStatus = committeeStatus;
	}

	public ArrayList<LocalDate> getDaysOccupied() {
		return this.daysOccupied;
	}

	/**
	 * 
	 * @param daysOccupied
	 */
	public void setDaysOccupied(ArrayList<LocalDate> daysOccupied) {
		this.daysOccupied = daysOccupied;
	}

	public void start() {
		// TODO - implement Student.start
		throw new UnsupportedOperationException();
	}

}