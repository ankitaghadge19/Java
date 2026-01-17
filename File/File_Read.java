package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class File_Read {
    private static final String Delimiter = ",";

    public static void main(String[] args) throws Exception {
        String filePath = "D:\\BankData.txt";
        Map<String, List<String>> columnData = new HashMap<>();

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String[] headers = null;

        if ((line = br.readLine()) != null) {
            headers = line.split(Delimiter);
            for (String header : headers) {
                columnData.put(header.toLowerCase(), new ArrayList<>());
            }
        }

        while ((line = br.readLine()) != null) {
            String[] values = line.split(Delimiter);
            for (int i = 0; i < headers.length; i++) {
                String key = headers[i].toLowerCase();
                columnData.get(key).add(values[i].toLowerCase());
            }
        }
        
        System.out.println(columnData.get("city"));
        br.close();
    }
}