package Package.Camp;
import java.util.ArrayList;

public class CampList {

	protected static ArrayList<Camp> campList;

	public CampList()
	{
		campList=new ArrayList<>();
	}
	public static ArrayList<Camp> getCampList() {
	return campList;
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
		campList.add(camp);
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
		campList.set(oldCamp,newCamp);
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
		if (campList.isEmpty())
		{
			System.out.println("There is no camp");
			return null;
		}
		else {
			for(Camp camp:campList)
			{
				if(camp.getCampName().equals(name)) return camp;
			}
		}
		return null;
	}

}