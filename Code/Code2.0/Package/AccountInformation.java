/*package Package;
import java.util.ArrayList;
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
}
