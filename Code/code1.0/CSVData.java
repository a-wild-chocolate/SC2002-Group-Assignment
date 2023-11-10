import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class CSVData {
    public static List<Camp> getCSVDataCamp(){
        List<Camp> campList = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("E:\\javacodes\\Assignment\\campData.csv"))) {
			// CSV文件的分隔符
			String DELIMITER = ",";
			// 按行读取
			String line;
            /*//testing
            System.out.println("222");*/
            br.readLine();
			while ((line = br.readLine()) != null) {
				// 分割
                /*//testing
                System.out.println("333");*/
                Camp camp = new Camp();
				String[] columns = line.split(DELIMITER);
				// 打印行
				//System.out.println("User["+ String.join(", ", columns) +"]");
				camp.setCampName(columns[0]);
                LocalDate beginDateTime = LocalDate.parse(columns[1], DateTimeFormatter.ofPattern("yyyyMMdd"));
                camp.setDate(beginDateTime);
                campList.add(camp);
                camp.getAllInformation();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
        /*//testing
        System.out.println("111");*/
		return campList;
	}

    public static void setCSVDataCamp(List<Camp> campList){
         //第一步：设置输出的文件路径
        //如果该目录下不存在该文件，则文件会被创建到指定目录下。如果该目录有同名文件，那么该文件将被覆盖。
        File writeFile = new File("E:\\javacodes\\Assignment\\campData.csv");
 
        try{
            //第二步：通过BufferedReader类创建一个使用默认大小输出缓冲区的缓冲字符输出流
            BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));
            // Write header manually if needed
            writeText.write("CampName,Date");
            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
            //boolean firstLine = true;
            for(int i=1;i<=campList.size();i++){
                Camp camp = campList.get(i-1);
                writeText.newLine();    //换行
                /*if (!firstLine) {
                    writeText.newLine();    // 换行
                } else {
                    firstLine = false;
                }*/
                //调用write的方法将字符串写到流中
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
                String dateStr = camp.getDate().format(fmt);
                String output = camp.getCampName() + ',' + dateStr;
                writeText.write(output);
            }
 
            //使用缓冲区的刷新方法将数据刷到目的地中
            writeText.flush();
            //关闭缓冲区，缓冲区没有调用系统底层资源，真正调用底层资源的是FileWriter对象，缓冲区仅仅是一个提高效率的作用
            //因此，此处的close()方法关闭的是被缓存的流对象
            writeText.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
    }
    

    public static void main (String[] args){
        List<Camp> campList = getCSVDataCamp();
        System.out.println(campList.size());
        
        /*for(int i=1;i<=campList.size();i++){
            
            Camp camp = campList.get(i-1);
            camp.getAllInformation();
            camp.setCampName(camp.getCampName()+"bbb");
            camp.setDate(LocalDate.of(2002+i, 2+i, 01+i)); 
        }*/
        Camp camp = new Camp();
        camp.getAllInformation();
        camp.setCampName("bbb");
        camp.setDate(LocalDate.of(2002, 2, 01)); 
        campList.add(camp);
        setCSVDataCamp(campList);


    }
} 
