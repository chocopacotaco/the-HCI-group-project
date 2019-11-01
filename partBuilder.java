import java.util.*;
import java.lang.*;
import java.io.*;
public class partBuilder{
    fileReader getInfo;
    ArrayList<cpuPart> cpus = new ArrayList<cpuPart>();
    ArrayList<gpuPart> gpus = new ArrayList<gpuPart>();
    ArrayList<boardPart> boards = new ArrayList<boardPart>();
    ArrayList<memoryPart> memories = new ArrayList<memoryPart>();
    ArrayList<powerPart> powers = new ArrayList<powerPart>();
    ArrayList<drivePart> drives = new ArrayList<drivePart>();
    ArrayList<cpuPart> pcs = new ArrayList<cpuPart>();
    public partBuilder(fileReader newInfo){
        buildCPUs();
        buildGPUs();
        buildPCs();
    }
    
    public void buildPCs(){
        try{
            FileReader out = new FileReader("saves.csv");
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    int id = Integer.parseInt(record[0]);
                    String saveName = record[1];
                    int cpufinder = Integer.parseInt(record[2]);
                    cpuPart savedCpu = null;
                    for(int j = 0; j < cpus.size(); j++){
                        if(cpus.get(j).cpuID == cpufinder){
                            savedCpu= cpus.get(j);
                        }
                    }
                    int gpufinder = Integer.parseInt(record[3]);
                    gpuPart savedGpu = null;
                    for(int j = 0; j < gpus.size(); j++){
                        if(gpus.get(j).gpuID == gpufinder){
                            savedGpu= gpus.get(j);
                        }
                    }
                    int boardfinder = Integer.parseInt(record[4]);
                    boardPart savedBoard = null;
                    for(int j = 0; j < boards.size(); j++){
                        if(boards.get(j).boardID == boardfinder){
                            savedBoard= boards.get(j);
                        }
                    }
                    int memoriesfinder = Integer.parseInt(record[5]);
                    memoryPart savedMemories = null;
                    for(int j = 0; j < memories.size(); j++){
                        if(memories.get(j).memoryID == memoriesfinder){
                            savedMemories= memories.get(j);
                        }
                    }
                    int powersfinder = Integer.parseInt(record[6]);
                    powerPart savedPower = null;
                    for(int j = 0; j < powers.size(); j++){
                        if(powers.get(j).powerID == powersfinder){
                            savedPower = powers.get(j);
                        }
                    }
                    int drivefinder = Integer.parseInt(record[7]);
                    drivePart savedDrive = null;
                    for(int j = 0; j < powers.size(); j++){
                        if(drives.get(j).storageID == drivefinder){
                            savedDrive = drives.get(j);
                        }
                    }
                    currentPC savedPc = new currentPC(id,saveName,savedCpu,savedGpu,
                    savedBoard,savedMemories,savedPower,savedDrive);
                }
            }
        } catch(Exception e) {
        }
    }
    
    
    
    public void buildCPUs(){
        try{
            FileReader out = new FileReader("cpus.csv");
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    int id = Integer.parseInt(record[0]);
                    String name = record[1];
                    int cores = Integer.parseInt(record[2]);
                    int threads = Integer.parseInt(record[3]);
                    double ghzSpeed = Double.parseDouble(record[4]);
                    double memSize = Double.parseDouble(record[5]);
                    String memMeasure = record[6];
                    cpuPart newpart = new cpuPart(id, name, cores, threads,
                    ghzSpeed, memSize, memMeasure);
                    cpus.add(newpart);
                }
            }
            
        } catch(Exception e) {
        }
    }
    //Integer.parseInt(record[2]); Double.parseDouble(record[4]);
    public void buildGPUs(){ 
        try{
            FileReader out = new FileReader("cpus.csv");
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    int id = Integer.parseInt(record[0]);
                    String name = record[1];
                    String chipName = record[2];
                    String bus = record[3];
                    double memory = Double.parseDouble(record[4]);
                    int clockSpeed = Integer.parseInt(record[5]);
                    int memClock = Integer.parseInt(record[6]);
                    gpuPart newpart = new gpuPart(id, name, chipName, bus,
                    memory, clockSpeed, memClock);
                    gpus.add(newpart);
                }
            }
            
        } catch(Exception e) {
        }
    }
}
