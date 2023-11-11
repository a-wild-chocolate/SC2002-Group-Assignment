package Package;

import java.util.ArrayList;

public class NormalDisplay extends Displayer {

	/**
	 * 
	 * @param campList
	 */
	public void display(ArrayList<Camp> campList) {
		// TODO - implement NormalDisplay.display
		for(Camp camp:campList)
		{
			camp.printAllInformation();
		}
	}

}