package Package;
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
        this.inputSecureAnswer = inputSecureAnswer;
    }

    private String hashSecureAnswer(String secureAnswer) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(secureAnswer.toUpperCase().getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public boolean compareUserQuestion() throws IOException, NoSuchAlgorithmException {
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
        Map<String, String[]> users = csvModifier.readUsersFromCSV();
        if (users.containsKey(inputID)) {
            String storedSecureAnswerHash = users.get(inputID)[5]; // Assuming secureAnswer is the sixth element
            return storedSecureAnswerHash.equals(hashSecureAnswer(inputSecureAnswer));
        }
        return false;
    }

    public boolean resetPassword() throws IOException, NoSuchAlgorithmException {
        if (compareUserQuestion()) {
            String newPassword = getNewPasswordFromUserInput(); // This method needs to be implemented to get user input
            //String hashedNewPassword = hashSecureAnswer(newPassword);
            CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME);
            Map<String, String[]> users = csvModifier.readUsersFromCSV();
            //users.get(inputID)[3] = hashedNewPassword; // Assuming password is the fourth element
            String[] userDetails = users.get(inputID);
            AccountInformation modifyAccount = new AccountInformation(inputID, userDetails[1], Faculty.valueOf(userDetails[2]), userDetails[3], userDetails[4], userDetails[5]);
            modifyAccount.setPassword(newPassword);
            return true;
            
        }
        return false;
    }

    private String getNewPasswordFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your new password: ");
        String input = scanner.nextLine();
        return input;
    }

    // ... (rest of the code, including the Faculty enum and any other classes you need)
}
