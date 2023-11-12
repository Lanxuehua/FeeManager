/***
 * Class Main
 * Collect previous processed fee information, including transaction date, processsing date
 * @author: Xuehua Lan
 * @version JavaSE-17
 */

import java.io.*;
import java.io.BufferedReader;
import java.io.Bufferedwriter;
import java.io.FileReader;
import java.io.Filewriter;
import java.util.List;
import java.util.ArrayList;
import java.nio.fi1e.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat
import java.uti1.Date;
import java.io. IOException;

public class Main {
    public static void main(string[] args) {
        string seanchDirectory = "C:/make_up_folder";
        String searchTerm = "fee";
        String outputCsvPath = "C:/Users/Downloads/processedfee.csv";

        List<File> csvFileLocations = new ArrayList<>();
        
        searchcSVFiles(new File(searchDirectory), searchTerm，foundcsVFiles);

        /*
        for (File csvFile : csvFileLocations) {
            System.out.println(csvFile.getAbsolutePath());
        }
        */

        try {
            Bufferedwriter outputwriter = new Bufferedwriter(new Filewriter(outputcSVPath));
            for (String csvFileLocation : csvFileLocations) {
                BufferedReader csvReader = new BufferedReader(new FileReader(csvFileLocation));
                String csvLine;

                while ((csvLine = cSvReader.readLine()) != nul1) {
                    outputwriter.write(csvLine);
                    outputWriter.write(csvFileLocation);
                    outputwriter.newLine();
                }
                csVReader.close();
            }
            outputwriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
        
    private static void searchcSVFiles(File directory, String searchTerm,List<File> foundCSVFiles) {
        File[] files = directory.listFiles();

        if(files != nul1){
            for (File file : files){
                if(file.isDirectory()){
                    searchcSVFiles(file, searchTerm, csvFileLocations);
                } else if (file.isFile() && file.getName().toLowerCase().endswith(".csv")) {
                    if (file.getAbsolutePath().toLowercase().contains(searchTerm.toLowerCase())) {

                        foundCSVFiles.add(file);

                        Path filePath = Paths.get(file.getAbsolutePath();
                        
                        BasicFileAttributes attr;

                        try {
                            attr = java.nio.file.Files.readAttributes(filePath, BasicFileAttributes.class);

                            FileTime savingTime = attr.lastModifiedTime();
                            Date date = new Date(savingTime.toMillis());
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                            String formattedDate =dateFormat.format(date);

                        } catch (FileNotFoundException e){
                            e.printStackTrace();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
