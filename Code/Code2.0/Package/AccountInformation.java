//newnew accountinformation 3.0/////////////////////////////////////////////////
package Package;
import java.io.*;
//import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.*;

public class AccountInformation {
    private String userID;
    private String name;
    private Faculty faculty;
    private String password;
    private String securityQuestion;
    private String secureAnswer;
    private final String FILE_NAME = "accounts";

    public AccountInformation(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
            System.out.println("UserID: " + userID);

        this.userID = userID;
            System.out.println("this UserID: " + this.userID);

        this.name = name;
        this.faculty = faculty;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.secureAnswer = secureAnswer;
    }


    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) throws IOException, NoSuchAlgorithmException{
        this.faculty = faculty;
        //updateAccountInCSV();
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
        csvModifier.updateInformationInCSV(this.userID,this.createCSVDataLine());
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) throws IOException, NoSuchAlgorithmException{
        this.securityQuestion = securityQuestion;
        //updateAccountInCSV();
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
        csvModifier.updateInformationInCSV(this.userID,this.createCSVDataLine());
    }

    public void setPassword(String password) throws NoSuchAlgorithmException, IOException {
        this.password = password;
        //updateAccountInCSV();
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
        csvModifier.updateInformationInCSV(this.userID,this.createCSVDataLine());
    }

    public void setSecureAnswer(String secureAnswer) throws NoSuchAlgorithmException, IOException {
        this.secureAnswer = secureAnswer.toUpperCase();
        //updateAccountInCSV();
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
        System.out.println(this.secureAnswer);
        csvModifier.updateInformationInCSV(this.userID,this.createCSVDataLine());
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes());
        return bytesToHex(encodedhash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public boolean createNewAccount() throws IOException, NoSuchAlgorithmException {
        String header = "userID,name,faculty,password,securityQuestion,secureAnswer\n";
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME,header);
        return csvModifier.createNewAccount(this.userID, this.createCSVDataLine());
    }

    public String createCSVDataLine() throws IOException, NoSuchAlgorithmException {
        String facultyString = this.faculty.name(); // Assuming faculty is an enum and we want the name of the enum
        String passwordHash = hashPassword(this.password); // Hash the password before storing it
        String csvData = String.join(",", this.userID, this.name, facultyString, passwordHash, this.securityQuestion, hashPassword(this.secureAnswer));
        return csvData;
    }


    public void printAccountInformation() {
        System.out.println("UserID: " + this.userID);
        System.out.println("Name: " + this.name);
        System.out.println("Faculty: " + this.faculty.name());
        System.out.println("Security Question: " + this.securityQuestion);
        // Note: We do not print the password or secureAnswer for security reasons
    }
/////////////////////////////////////////////////////////////////
    /*// Main method for testing purposes
    public static void main(String[] args) {
        AccountInformation aaa = new AccountInformation("111", "111", Faculty.ADM, "111", "111", "111");
		AccountInformation bbb = new AccountInformation("222", "222", Faculty.CEE, "222", "222", "222");
        LoginAccount ccc = new LoginAccount("111", "111");
        ResetAccount ddd = new ResetAccount ("111", "111");
		LoginAccount ggg = new LoginAccount("111", "222");

        try {
        boolean aNew = aaa.createNewAccount();
        if (!aNew){
			System.out.println("set a fail");
		}
        boolean bNew = bbb.createNewAccount();
        if (!bNew){
			System.out.println("set b fail");
		}
		AccountInformation eee = ccc.loginAccount();
		eee.printAccountInformation();
        boolean fff = ddd.resetPassword();
			if (!fff) {
				System.out.println("reset fail");
			}
        AccountInformation hhh = ggg.loginAccount();
		hhh.printAccountInformation();

    } catch (IOException e) {
        System.out.println("An I/O error occurred while creating the new account.");
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        System.out.println("The cryptographic algorithm is not available in the current environment.");
        e.printStackTrace();
    }
    }*/
}

////////////////////////////////////////////////account information 1.0///////////////////////////////////////
/*import java.util.ArrayList;
import java.util.List;

public class AccountInformation extends AccountManager {

	private String userID;
	private String name;
	private Faculty faculty;
	private String password = "password";

	public AccountInformation(String userID, String name,  String faculty) {
		this.userID=userID;
		this.name=name;
		this.faculty=Converter.sringToFaculty(faculty);
	}

	public String getUserID() {
		return this.userID;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param Password
	 *//*
	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getName() {
		return this.name;
	}

	
	public void setFaculty(Faculty faculty) {
	this.faculty=faculty;
	}

	public Faculty getFaculty() {return this.faculty;}


}*/
	/////////////////////////////////////////////////////////////acount information 2.0/////////////////////////////////////////////////////////
/*
package Package;
import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AccountInformation {
    private String userID;
    private String name;
    private Faculty faculty;
    private String password;
    private String securityQuestion;
    private String secureAnswer;
    private static final String CSV_FILE = "./accounts.csv";

    public AccountInformation(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
        this.userID = userID;
        this.name = name;
        this.faculty = faculty;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.secureAnswer = secureAnswer;
    }


    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) throws IOException {
        this.faculty = faculty;
        updateAccountInCSV();
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) throws IOException {
        this.securityQuestion = securityQuestion;
        updateAccountInCSV();
    }

    public void setPassword(String password) throws NoSuchAlgorithmException, IOException {
        this.password = hashPassword(password);
        updateAccountInCSV();
    }

    public void setSecureAnswer(String secureAnswer) throws NoSuchAlgorithmException, IOException {
        this.secureAnswer = hashPassword(secureAnswer.toUpperCase());
        updateAccountInCSV();
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes());
        return bytesToHex(encodedhash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private void updateAccountInCSV() throws IOException {
        // Read all accounts into a list
        List<String> accountLines = Files.readAllLines(Paths.get(CSV_FILE));
        int indexToUpdate = -1;
        for (int i = 0; i < accountLines.size(); i++) {
            String[] values = accountLines.get(i).split(",");
            if (values[0].equals(userID)) {
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -1) {
            // Update the specific line with new account information
            String newLine = String.join(",", userID, name, faculty.name(), password, securityQuestion, secureAnswer);
            accountLines.set(indexToUpdate, newLine);

            // Write all accounts back to the CSV file
            Files.write(Paths.get(CSV_FILE), accountLines);
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        // Example usage of AccountInformation class
    }
}*/
