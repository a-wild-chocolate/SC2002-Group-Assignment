package Package.Account;
import Package.CSVManager.CSVReadWriter;
import Package.Enum.AccountStatus;
import Package.Enum.Faculty;

import java.io.*;
//import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.*;

public class AccountInformation {
    private String userID;
    private String name;
    private AccountStatus accountStatus;
    private Faculty faculty;
    private String password;
    private String securityQuestion;
    private String secureAnswer;
    private final String FILE_NAME = "accounts";

    public AccountInformation(String userID, String name,AccountStatus accountStatus, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
            System.out.println("UserID: " + userID);
                System.out.println("write file path : "+System.getProperty("user.dir"));

        this.userID = userID;
            //System.out.println("this UserID: " + this.userID);

        this.name = name;
        this.accountStatus=accountStatus;
        this.faculty = faculty;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.secureAnswer = secureAnswer;
    }

    public AccountStatus getAccountStatus() {return accountStatus;}

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
        this.secureAnswer = secureAnswer;//.toUpperCase();
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
        String header = "userID,name,Account Status,faculty,password,securityQuestion,secureAnswer\n";
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME,header);
        return csvModifier.createNewRecord(this.userID, this.createCSVDataLine());
    }

    public String createCSVDataLine() throws IOException, NoSuchAlgorithmException {
        String facultyString = this.faculty.name(); // Assuming faculty is an enum and we want the name of the enum
        String passwordHash = hashPassword(this.password); // Hash the password before storing it
        System.out.println(this.secureAnswer);
        System.out.println(hashPassword(this.secureAnswer));
        String csvData = String.join(",", this.userID, this.name, this.accountStatus.toString(),facultyString, passwordHash, this.securityQuestion, hashPassword(this.secureAnswer));
        return csvData;
    }


    public void printAccountInformation() {
        System.out.println("UserID: " + this.userID);
        System.out.println("Name: " + this.name);
        System.out.println("Faculty: " + this.faculty.name());
        System.out.println("Security Question: " + this.securityQuestion);
        // Note: We do not print the password or secureAnswer for security reasons
    }


}

