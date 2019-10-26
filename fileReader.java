import java.util.*;
import java.lang.*;
import java.io.*;
public class fileReader{
    
    public fileReader(){
        // initialise instance variables
    }
    
    public void finishup(){
        try{
            FileWriter out = new FileWriter("output.csv");//csv
            BufferedWriter out2 = new BufferedWriter(out);
            CSVWriter writer = new CSVWriter(out2);
            String[] header = {"SystemKey" , "DisplayName", "CpuID, GpuID", 
                "BoardID", "MemoryID", "PowerID"};
            writer.writeNext(header);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
