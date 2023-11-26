package Package;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class EnquiryReply {
    private int replyId;
    private String content;
    private static int replyNumber=0;
    private final String FILE_NAME = "enquiryReply";
    private Account replier;
    //for user
    public EnquiryReply(Account replier,String content)
    {
        this.content=content;
        this.replier=replier;
        replyNumber++;
        this.replyId=replyNumber;
    }
    // for csv
    public EnquiryReply(int replyId, CommitteeMember replier,String content)
    {
        this.replyId=replyId;
        this.replier=replier;
        this.content=content;
    }

    public int getReplyId() {return replyId;}
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Account getReplier() {
        return replier;
    }

    public void setReplier(Account replier) {
        this.replier = replier;
    }

    public void writeToEnquiryCSV()
    {
        String header = "EnquiryReply ID,Sender Name,Content\n";
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME,header);
        //String csvData = String.join(",", this.enquiryId, this.sender, this.camp, this.status, this.dealer.getName(), this.content);
        String csvData=toCsvString();
        try {
            csvModifier.checkCreateOrUpdate(Integer.toString(replyId), csvData);
        } catch (IOException e) {
            System.out.println("An I/O error occurred while creating the new account.");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("The cryptographic algorithm is not available in the current environment.");
            e.printStackTrace();
        }
    }

    public boolean deleteEnquiry(String onlyID) throws IOException {
        Path filePath = Paths.get(FILE_NAME);
        if (Files.notExists(filePath)) {
            // If the file does not exist, there is no account to delete
            return false;
        }

        // Read all lines except the one with the matching userID
        List<String> outLines = Files.lines(filePath)
                .filter(line -> !line.startsWith(onlyID + ","))
                .collect(Collectors.toList());

        // Check if the account was found and removed
        boolean accountRemoved = outLines.size() < Files.readAllLines(filePath).size();

        if (accountRemoved) {
            // Write the remaining lines back to the CSV file
            Files.write(filePath, outLines);
        }
        return accountRemoved;
    }

    public String toCsvString() {
        String senderStr = (replier == null) ? "" : replier.getName();
        String contentStr = (content == null) ? "" : content;
        //String replyStr = (reply == null) ? "" : reply.getContent();


        return String.join(",",
                Integer.toString(replyId),
                senderStr,
                contentStr);
    }


}
