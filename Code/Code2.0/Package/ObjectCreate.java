package Package;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class ObjectCreate {
    /*public static Student studentObject(String onlyId)throws IOException, NoSuchAlgorithmException{
        CSVReadWriter accountReader =  new CSVReadWriter("accounts");
        Map<String, String[]> accountsString = accountReader.readUsersFromCSV();
        String[] accountDetail = accountsString.get(onlyId);
        CSVReadWriter studentReader =  new CSVReadWriter("studentList");
        Map<String, String[]> studentString = accountReader.readUsersFromCSV();
        String[] studentDetail = accountsString.get(onlyId);

        return new Student(onlyId,);
    }*/

    public static Staff staffObject(String onlyId) throws IOException, NoSuchAlgorithmException {
        CSVReadWriter accountReader = new CSVReadWriter("accounts");
        Map<String, String[]> accountString = accountReader.readUsersFromCSV();
        String[] accountDetail = accountString.get(onlyId);
        ArrayList<Camp> createCampList = new ArrayList<>();
        for (Camp camp : CampList.campList) {
            if (camp.getStaffInCharge() != null && camp.getStaffInCharge().getUserID().equals(onlyId)) {
                createCampList.add(camp);
            }
        }
        return new Staff(onlyId, accountDetail[1], AccountStatus.valueOf(accountDetail[2]), Faculty.valueOf(accountDetail[3]), accountDetail[4], accountDetail[5], accountDetail[6], createCampList);
    }
}
/*
    public static Attendee attendeeObject(String onlyId) throws IOException, NoSuchAlgorithmException{
        CSVReadWriter accountReader =  new CSVReadWriter("accounts");
        Map<String, String[]> accountString = accountReader.readUsersFromCSV();
        String[] accountDetail = accountString.get(onlyId);
        ArrayList<Camp> createCampList = new ArrayList<>();
        for(Camp camp: CampList.campList){
            if (camp.getStaffInCharge() != null && camp.getStaffInCharge().getUserID().equals(onlyId)) {
                createCampList.add(camp);
            }
        }

        return new Staff(onlyId,accountDetail[1],AccountStatus.valueOf(accountDetail[2]),Faculty.valueOf(accountDetail[3]),accountDetail[4],accountDetail[5],accountDetail[6],createCampList);
    }

    public Attendee readAttendeeById(String onlyId) throws IOException {
        String FILE_NAME = "attendeeList.csv"; // 文件名可以根据需要调整

        Path filePath = Paths.get(FILE_NAME);
        if (Files.notExists(filePath)) {
            return null; // 文件不存在
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(onlyId)) {
                    // 解析其他字段并创建Attendee对象
                    String userID = values[0];
                    String name = values[1];
                    AccountStatus accountStatus = AccountStatus.valueOf(values[2]);
                    Faculty faculty = Faculty.valueOf(values[3]);
                    String password = values[4]; // 假设密码和安全问题答案也在CSV中
                    String securityQuestion = values[5];
                    String secureAnswer = values[6];
                    ArrayList<Camp> attendeeStatus = parseCamps(values[7]); // 解析参与的活动
                    ArrayList<Camp> withdrawStatus = parseCamps(values[8]); // 解析撤回的活动
                    ArrayList<Enquiry> enquiryList = parseEnquiries(values[9]); // 解析查询列表

                    return new Attendee(userID, name, accountStatus, faculty, password, securityQuestion, secureAnswer, attendeeStatus, withdrawStatus, enquiryList);
                }
            }
        }

        return null; // 未找到ID对应的记录
    }

    public Optional<Enquiry> readEnquiryById(int enquiryId) {
        String FILE_NAME = "enquiry.csv"; // CSV文件名
        Path path = Paths.get(FILE_NAME);
        if (Files.notExists(path)) {
            return Optional.empty(); // 文件不存在
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                if (id == enquiryId) {
                    // 此处假设values数组按照CSV文件顺序：Enquiry ID, Content, Camp Name, Reply ID, Status, Sender ID
                    String content = values[1];
                    Camp camp = new Camp(values[2]); // 需要Camp的构造方法或其他逻辑来创建
                    EnquiryReply reply = new EnquiryReply(Integer.parseInt(values[3])); // 同样需要适当的构造方法或逻辑
                    EnquiryStatus status = EnquiryStatus.valueOf(values[4]);
                    Attendee sender = readAttendeeById(values[5]); // 这需要一个方法来根据ID读取Attendee

                    return Optional.of(new Enquiry(enquiryId, content, camp, reply, status, sender));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty(); // 未找到对应ID的查询
    }
    // 方法：根据ID读取Staff对象
    public Staff readStaffById(String onlyId) throws IOException {
        String FILE_NAME = "staffList.csv"; // Staff CSV文件名
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (String line : lines) {
            String[] values = line.split(",");
            if (values[0].equals(onlyId)) {
                String userID = values[0];
                String name = values[1];
                AccountStatus accountStatus = AccountStatus.valueOf(values[2]);
                Faculty faculty = Faculty.valueOf(values[3]);
                String password = values[4];
                String securityQuestion = values[5];
                String secureAnswer = values[6];
                List<Camp> campList = Arrays.stream(values[7].split(";")) // ";" is a placeholder for the actual delimiter
                        .map(Camp::new) // Assuming Camp constructor takes a String
                        .collect(Collectors.toList());
                return new Staff(userID, name, accountStatus, faculty, password, securityQuestion, secureAnswer, campList);
            }
        }
        return null;
    }

    // 方法：根据ID读取Student对象
    public Student readStudentById(String onlyId) throws IOException {
        String FILE_NAME = "studentList.csv"; // Student CSV文件名
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (String line : lines) {
            String[] values = line.split(",");
            if (values[0].equals(onlyId)) {
                String userID = values[0];
                String name = values[1];
                AccountStatus accountStatus = AccountStatus.valueOf(values[2]);
                Faculty faculty = Faculty.valueOf(values[3]);
                String password = values[4];
                String securityQuestion = values[5];
                String secureAnswer = values[6];
                int point = Integer.parseInt(values[7]);
                return new Student(userID, name, accountStatus, faculty, password, securityQuestion, secureAnswer, point);
            }
        }
        return null;
    }

    // 方法：根据ID读取CommitteeMember对象
    public CommitteeMember readCommitteeMemberById(String onlyId) throws IOException {
        String FILE_NAME = "committeeMemberList.csv"; // CommitteeMember CSV文件名
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (String line : lines) {
            String[] values = line.split(",");
            if (values[0].equals(onlyId)) {
                String userID = values[0];
                String name = values[1];
                AccountStatus accountStatus = AccountStatus.valueOf(values[2]);
                Faculty faculty = Faculty.valueOf(values[3]);
                String password = values[4];
                String securityQuestion = values[5];
                String secureAnswer = values[6];
                List<Suggestion> suggestionList = Arrays.stream(values[7].split(";")) // ";" is a placeholder for the actual delimiter
                        .map(Suggestion::new) // Assuming Suggestion constructor takes a String
                        .collect(Collectors.toList());
                return new CommitteeMember(userID, name, accountStatus, faculty, password, securityQuestion, secureAnswer, suggestionList);
            }
        }
        return null;
    }
    public Suggestion readSuggestionById(int suggestionId) throws IOException {
        String FILE_NAME = "suggestions.csv"; // Suggestions CSV文件名
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (String line : lines) {
            String[] values = line.split(","); // Assuming the CSV uses commas to separate values
            int id = Integer.parseInt(values[0]);
            if (id == suggestionId) {
                String content = values[1];
                CommitteeMember sender = readCommitteeMemberById(values[2]); // This will be another method to read CommitteeMember by ID
                Camp camp = new Camp(values[3]); // This assumes a Camp constructor that takes a String or similar identifier
                SuggestionStatus status = SuggestionStatus.valueOf(values[4]);
                int suggestionNum = Integer.parseInt(values[0]);
                Staff dealer = readStaffById(values[5]); // This will be another method to read Staff by ID

                return new Suggestion(content, sender, camp, status, suggestionNum, dealer);
            }
        }
        return null;
    }

    // 根据campName读取Camp对象
    public Camp readCampByName(String campName) throws IOException {
        String FILE_NAME = "campList.csv"; // Camp CSV文件名
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (String line : lines) {
            String[] values = line.split(","); // 假设CSV使用逗号分隔值
            if (values[0].equals(campName)) {
                // 假设CSV列顺序：campName, date, registrationDate, userGroup, location, totalSlot, committeeSlot, description, staffInChargeId, visibility, studentList, committeeMemberList
                LocalDate date = LocalDate.parse(values[1]);
                LocalDate registrationDate = LocalDate.parse(values[2]);
                ArrayList<Faculty> userGroup = parseUserGroup(values[3]);
                String location = values[4];
                int totalSlot = Integer.parseInt(values[5]);
                int committeeSlot = Integer.parseInt(values[6]);
                String description = values[7];
                Staff staffInCharge = readStaffById(values[8]); // 这将是另一个方法来按ID读取Staff
                Boolean visibility = Boolean.parseBoolean(values[9]);
                ArrayList<Enquiry> enquiryList = new ArrayList<>(); // 假设有方法解析Enquiry列表
                ArrayList<Suggestion> suggestionList = new ArrayList<>(); // 假设有方法解析Suggestion列表
                ArrayList<Student> studentList = parseStudentList(values[10]);
                ArrayList<Student> committeeMemberList = parseStudentList(values[11]);

                return new Camp(campName, date, registrationDate, userGroup, location, totalSlot, committeeSlot, description, staffInCharge, enquiryList, suggestionList, visibility, studentList, committeeMemberList);
            }
        }
        return null;
    }

    // 辅助方法，用于解析CSV字符串中的Camp信息
    private ArrayList<Camp> parseCamps(String data) throws IOException{
        // 解析逻辑，根据您的CSV格式来实现
        // 假设活动名称之间用分号分隔
        ArrayList<Camp> camps = new ArrayList<>();
        String[] campNames = data.split(";");
        for (String name : campNames) {
            // 创建Camp对象并添加到列表
            camps.add(new Camp(name)); // 假设Camp有一个接受name的构造函数
        }
        return camps;
    }

    // 辅助方法，用于解析CSV字符串中的Enquiry信息
    private ArrayList<Enquiry> parseEnquiries(String data) {
        // 解析逻辑，根据您的CSV格式来实现
        // 假设查询ID之间用分号分隔
        ArrayList<Enquiry> enquiries = new ArrayList<>();
        String[] enquiryIds = data.split(";");
        for (String id : enquiryIds) {
            // 创建Enquiry对象并添加到列表
            enquiries.add(new Enquiry(Integer.parseInt(id))); // 假设Enquiry有一个接受id的构造函数
        }
        return enquiries;
    }

}*/
