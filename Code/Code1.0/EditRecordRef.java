import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditRecordRef {
    private static Scanner x;
    
    //入参要有表名，
    public static void main(String[] args){
        String inputFile = "records.txt";
        String outputFile = "records.txt";

        List<String[]> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String line;
            while ((line = reader.readLine())!= null) {
                String[] parts = line.split(",");
                data.add(parts);
                
            } 
        }catch (IOException e) {
                e.printStackTrace();
                return;
            }

        System.out.println("CSV data: ");
        for (int i=0; i<data.size(); i++){
            String[] row = data.get(i);
            System.out.print(i + ": ");
             for (int j=0; j<row.length; j++){
                System.out.print(j+"-"+row[j] + " ");
            }
            System.out.println();
        }

    System.out.print("Enter the name to edit: ");
    String nameToEdit = scanner.nextLine();

    boolean found = false;
    for(String[] row: data){
        if(row.length>0&&row[0].equals(nameToEdit)){
            found = true;
            System.out.print("Enter the new value for the row (comma-separated): ");
            String newValue = scanner.nextLine();
            String[] parts = newValue.split(",");
            System.arraycopy(parts, 0, nameToEdit, 0, parts.length);
        }
    }
    if (found){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] row : data) {
                String line = String.join(",", row);
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    System.out.println("CSV file modified successfully.");
    }else {
        System.out.println("Naame not found. No changes were made.");
    }
    }
}

