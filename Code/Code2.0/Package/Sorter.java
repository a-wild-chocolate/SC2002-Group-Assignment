package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {

	//Sorter
	//For Performance&Camp report
	public static ArrayList<Student> sortByName(ArrayList<Student> studentList) {
		ArrayList<Student> newList=new ArrayList<>(studentList);
		Collections.sort(newList, Comparator.comparing(Student::getName));
		return newList;
	}

	public static ArrayList<Student> sortByScore(ArrayList<Student> studentList) {
		ArrayList<Student> newList=new ArrayList<>(studentList);
		Collections.sort(newList, Comparator.comparing(Student::getPoint));
		return newList;
	}

	//Searcher
	//For Camp Report staff can choose what kind of student they want to see.
	public static ArrayList<Student> sortByStudentType(Camp camp, StudentStatus userType) {
		ArrayList<Student> newList= new ArrayList<>();
		if(userType==StudentStatus.Attendee)
		{
			newList=new ArrayList<>(camp.getStudentList());
		}
		else if(userType==StudentStatus.CommitteeMember)
		{
			newList=new ArrayList<>(camp.getCommitteeMemberList());
		}
		newList=sortByName(newList);

		return newList;
	}

}