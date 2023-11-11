package Package;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Account {

	private int point;
	private Camp committeeStatus;
	private ArrayList<LocalDate> daysOccupied;

	public Student(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,faculty,password,securityQuestion,secureAnswer);
		this.point=0;
		this.daysOccupied=new ArrayList<LocalDate>();
		committeeStatus=null;

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