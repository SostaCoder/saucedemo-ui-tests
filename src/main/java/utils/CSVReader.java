package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<String[]> getTestData(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; // skip header
                }
                data.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
