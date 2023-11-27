package Package.Account;
import Package.CSVManager.CSVReadWriter;
import Package.Enum.AccountStatus;
import Package.Enum.Faculty;

import java.util.Scanner;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ResetAccount {

    private String inputID;
    private String inputSecureAnswer;
    private final String FILE_NAME = "accounts";

    public ResetAccount(String inputID, String inputSecureAnswer) {
        this.inputID = inputID;
        this.inputSecureAnswer = inputSecureAnswer;//.toUpperCase();
    }

    /*private String hashSecureAnswer(String secureAnswer) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(secureAnswer.toUpperCase().getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }*/

    private String hashSecureAnswer(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes());
        //System.out.println("Reset hash : "+password+" "+bytesToHex(encodedhash));

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

    public boolean compareUserQuestion() throws IOException, NoSuchAlgorithmException {
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
        Map<String, String[]> users = csvModifier.readUsersFromCSV();
        if (users.containsKey(inputID)) {
            String storedSecureAnswerHash = users.get(inputID)[6]; // Assuming secureAnswer is the seventh element
            //return storedSecureAnswerHash.equals(hashSecureAnswer(inputSecureAnswer));
            String hash1=hashSecureAnswer(storedSecureAnswerHash);
            String hash2=hashSecureAnswer(inputSecureAnswer);
            if(Objects.equals(storedSecureAnswerHash,hash2 ))
            {
                return true;
            }
            return Objects.equals(hash1,hash2 );}

        return false;
    }

    public AccountInformation resetPassword() throws IOException, NoSuchAlgorithmException {
        if (compareUserQuestion()) {
            String newPassword = getNewPasswordFromUserInput(); // This method needs to be implemented to get user input
            //String hashedNewPassword = hashSecureAnswer(newPassword);
            CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
            Map<String, String[]> users = csvModifier.readUsersFromCSV();
            //users.get(inputID)[3] = hashedNewPassword; // Assuming password is the fourth element
            String[] userDetails = users.get(inputID);
            AccountInformation modifyAccount = new AccountInformation(inputID, userDetails[1],  AccountStatus.valueOf(userDetails[2]), Faculty.valueOf(userDetails[3]),userDetails[4], userDetails[5], userDetails[6]);
            modifyAccount.setPassword(newPassword);
            return modifyAccount;
            
        }
        return null;
    }

    private String getNewPasswordFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your new password: ");
        String input = scanner.nextLine();
        return input;
    }

    // ... (rest of the code, including the Faculty enum and any other classes you need)
}
