import java.util.ArrayList;
import java.util.List;

public class CampList {

	private List<Camp> campList;

	public CampList() {
        this.campList = new ArrayList<>();
    }

	public List<Camp> getCampList() {
		return this.campList;
	}

	public void setCampList(List<Camp> campList) {
		this.campList = campList;
	}

	public void viewCampStudent(Camp camp) {
		List<Student> students = camp.getStudents(); 
	
		if (students != null) {
			for (Student student : students) {
				System.out.println(student.getName());
			}
		} else {
			System.out.println("No students in this camp.\n");
		}
	}

	public void viewAllCamp() {
		if (this.CampList != null) {
			for (Camp camp : campList) {
				System.out.println(camp.getCampName());
			}
		} else {
			System.out.println("No camps currently.\n");
		}
	}

	public void filter() {
		// TODO - implement CampList.filter
		throw new UnsupportedOperationException();
	}

	public void addCamp(Camp camp){
		this.campList.add(camp);
	}

	public void deleteCamp(Camp camp){
		this.campList.remove(camp);
	}

}
