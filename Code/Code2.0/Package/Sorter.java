package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {

	public static ArrayList<Student> sortByName(ArrayList<Student> studentList) {
		ArrayList<Student> newList=new ArrayList<>(studentList);
		Collections.sort(newList, Comparator.comparing(Student::getName));
		return newList;
	}

	public ArrayList<Student> sortByScore(ArrayList<Student> studentList) {
		ArrayList<Student> newList=new ArrayList<>(studentList);
		Collections.sort(newList, Comparator.comparing(Student::getPoint));
		return newList;
	}

}