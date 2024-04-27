//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> records = new ArrayList<>();

        while (true) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            int yearOfBirth = SafeInput.getRangedInt(scanner, "Enter Year of Birth", 1900, 2023);

            String record = String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
            records.add(record);

            if (!SafeInput.getYNConfirm(scanner, "Add another person?")) {
                break;
            }
        }

        // Save records to a file
        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter file name to save records");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String record : records) {
                writer.println(record);
            }
            System.out.println("Records saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving records to file: " + e.getMessage());
        }
    }
}