package Package;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.function.Function;


public class testMain {
    public static void main(String[] args) {
        // Define the file name
    //     AccountInformation aaa = new AccountInformation("111", "111", Faculty.ADM, "111", "111", "111");
	// 	AccountInformation bbb = new AccountInformation("222", "222", Faculty.CEE, "222", "222", "222");
    //     LoginAccount ccc = new LoginAccount("111", "111");
    //     ResetAccount ddd = new ResetAccount ("111", "111");
	// 	LoginAccount ggg = new LoginAccount("111", "222");

    //     try {
    //     boolean aNew = aaa.createNewAccount();
    //     if (!aNew){
	// 		System.out.println("set a fail");
	// 	}
    //     boolean bNew = bbb.createNewAccount();
    //     if (!bNew){
	// 		System.out.println("set b fail");
	// 	}
	// 	AccountInformation eee = ccc.loginAccount();
	// 	eee.printAccountInformation();
    //     boolean fff = ddd.resetPassword();
	// 		if (!fff) {
	// 			System.out.println("reset fail");
	// 		}
    //     AccountInformation hhh = ggg.loginAccount();
	// 	hhh.printAccountInformation();

    // } catch (IOException e) {
    //     System.out.println("An I/O error occurred while creating the new account.");
    //     e.printStackTrace();
    // } catch (NoSuchAlgorithmException e) {
    //     System.out.println("The cryptographic algorithm is not available in the current environment.");
    //     e.printStackTrace();
    
    // }
         /* ///////////////////////account test//////////////
        String FILE_NAME = "accounts";

        // Define the record parser function for AccountInformation
        Function<String[], AccountInformation> accountParser = userDetails -> {
            // Assuming AccountInformation has a constructor that matches the provided parameters
            return new AccountInformation(
                    userDetails[0], userDetails[1], Faculty.valueOf(userDetails[2]),
                    userDetails[3], userDetails[4], userDetails[5]
            );
        };

        // Create an instance of CSVRecords with the specified record parser
        CSVRecords<AccountInformation> csvRecords = new CSVRecords<>(accountParser);

        try {
            // Read records from the CSV file
            List<AccountInformation> accountList = csvRecords.readRecordFromCSV(FILE_NAME);
            
            //System.out.println("write file path : "+System.getProperty("user.dir"));

            // Perform any additional testing or processing with the obtained records
            // For now, let's just print the records
            System.out.println("Records from CSV file:");
            for (AccountInformation account : accountList) {
                account.printAccountInformation();
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }*/

        String FILE_NAME = "suggestions";
        
        // Define the record parser function for AccountInformation
        Suggestion a = new Suggestion("suggestion a", null, null, null);

        try {
            // Read records from the CSV file
            List<AccountInformation> accountList = csvRecords.readRecordFromCSV(FILE_NAME);
            
            //System.out.println("write file path : "+System.getProperty("user.dir"));

            // Perform any additional testing or processing with the obtained records
            // For now, let's just print the records
            System.out.println("Records from CSV file:");
            for (AccountInformation account : accountList) {
                account.printAccountInformation();
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }*/

    } 
}
