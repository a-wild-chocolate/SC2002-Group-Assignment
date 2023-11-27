package Package.Account;
import Package.CSVManager.CSVReadWriter;
import Package.Enum.AccountStatus;
import Package.Enum.Faculty;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class LoginAccount {

    private String inputID;
    private String inputPassword;
    private final String FILE_NAME = "accounts";

    public LoginAccount(String inputID, String inputPassword) {
        this.inputID = inputID;
        this.inputPassword = inputPassword;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private boolean compareUserID() throws IOException, NoSuchAlgorithmException {
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
        Map<String, String[]> users = csvModifier.readUsersFromCSV();
        if (users.containsKey(inputID)) {
            String storedPasswordHash = users.get(inputID)[4]; // Assuming the password hash is the fourth element
            return storedPasswordHash.equals(hashPassword(inputPassword));
        }
        return false;
    }

    public AccountInformation loginAccount() throws IOException, NoSuchAlgorithmException {
        if (compareUserID()) {
            CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
            Map<String, String[]> users = csvModifier.readUsersFromCSV();
            String[] userDetails = users.get(inputID);
            return new AccountInformation(inputID, userDetails[1],  AccountStatus.valueOf(userDetails[2]), Faculty.valueOf(userDetails[3]),userDetails[4], userDetails[5], userDetails[6]);
        } else {
            return null; // If userID and password do not match, return null
        }
    }

}
