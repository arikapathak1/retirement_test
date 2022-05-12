package data_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvFileManager {
    public static List<List<String>> getData() throws FileNotFoundException {
        File file = new File("src/test/resources/testdata/testdata.csv");
        if(file.exists()){
            Scanner sc = new Scanner(file);
            sc.nextLine();
            List<List<String>> arr = new ArrayList<>();
            while(sc.hasNext()){
                arr.add(Arrays.asList(sc.nextLine().split(",")));
            }
            return arr;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        try{
            System.out.println(getData());
        }catch (Exception e){
            System.out.println("no data");
        }
    }
}
