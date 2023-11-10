package Package;
import java.util.ArrayList;

public class CampList {

	protected static ArrayList<Camp> campList;

	public static ArrayList<Camp> getCampList() {
	return campList;
	}

	/**
	 * 
	 * @param campList
	 */
	public void setCampList(ArrayList<Camp> campList) {

	}

	public void viewCampStudent() {
		// TODO - implement CampList.viewCampStudent
		throw new UnsupportedOperationException();
	}

	public void viewAllCamp() {
		// TODO - implement CampList.viewAllCamp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void addCamp(Camp camp) {
		// TODO - implement CampList.addCamp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param campName
	 */
	public static void deleteCamp(String campName) {
		// TODO - implement CampList.deleteCamp
		int position=0;
		for(Camp camp:campList)
		{

			if(camp.getCampName().equals(campName))
			{
				campList.remove(position);
				break;
			}
			position++;
		}
	}

	/**
	 * 
	 * @param newCamp
	 * @param oldCamp
	 */
	public void editCamp(Camp newCamp, int oldCamp) {
		// TODO - implement CampList.editCamp
		throw new UnsupportedOperationException();
	}

	public void search() {
		// TODO - implement CampList.search
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public Camp nameMatch(String name) {
		// TODO - implement CampList.nameMatch
		throw new UnsupportedOperationException();
	}

}