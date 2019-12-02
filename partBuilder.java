import java.util.*;
import java.lang.*;
import java.io.*;
public class partBuilder{
    //fileReader getInfo;
    ArrayList<cpuPart> cpus = new ArrayList<cpuPart>();
    ArrayList<gpuPart> gpus = new ArrayList<gpuPart>();
    ArrayList<boardPart> boards = new ArrayList<boardPart>();
    ArrayList<memoryPart> memories = new ArrayList<memoryPart>();
    ArrayList<powerPart> powers = new ArrayList<powerPart>();
    ArrayList<drivePart> drives = new ArrayList<drivePart>();
    ArrayList<currentPC> saves = new ArrayList<currentPC>();
    public partBuilder(){//fileReader newInfo
        buildCPUs();
        buildGPUs();
        buildBoards();
        buildMemory();
        buildPowers();
        buildDrives();
        buildPCs();
    } 
    
    public currentPC load(File file){
        currentPC savedPc;
        int id = 0;
        String saveName = null;
        int cpufinder = 0;
        cpuPart savedCpu = null;
        int gpufinder = 0;
        gpuPart savedGpu = null;
        int boardfinder = 0;
        boardPart savedBoard = null;
        int memoriesfinder = 0;
        memoryPart savedMemories = null;
        int powersfinder = 0;
        powerPart savedPower = null;
        int drivefinder = 0;
        drivePart savedDrive = null;
        try{
            FileReader out = new FileReader(file);
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    id = Integer.parseInt(record[0]);
                    saveName = record[1];
                    cpufinder = Integer.parseInt(record[2]);
                    savedCpu = null;
                    for(int j = 0; j < cpus.size(); j++){
                        if(cpus.get(j).cpuID == cpufinder){
                            savedCpu= cpus.get(j);
                        }
                    }
                    gpufinder = Integer.parseInt(record[3]);
                    savedGpu = null;
                    for(int j = 0; j < gpus.size(); j++){
                        if(gpus.get(j).gpuID == gpufinder){
                            savedGpu= gpus.get(j);
                        }
                    }
                    boardfinder = Integer.parseInt(record[4]);
                    savedBoard = null;
                    for(int j = 0; j < boards.size(); j++){
                        if(boards.get(j).boardID == boardfinder){
                            savedBoard= boards.get(j);
                        }
                    }
                    memoriesfinder = Integer.parseInt(record[5]);
                    savedMemories = null;
                    for(int j = 0; j < memories.size(); j++){
                        if(memories.get(j).memoryID == memoriesfinder){
                            savedMemories= memories.get(j);
                        }
                    }
                    powersfinder = Integer.parseInt(record[6]);
                    savedPower = null;
                    for(int j = 0; j < powers.size(); j++){
                        if(powers.get(j).powerID == powersfinder){
                            savedPower = powers.get(j);
                        }
                    }
                    drivefinder = Integer.parseInt(record[7]);
                    savedDrive = null;
                    for(int j = 0; j < powers.size(); j++){
                        if(drives.get(j).storageID == drivefinder){
                            savedDrive = drives.get(j);
                        }
                    }
                    //all parts created
                }
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
        savedPc = new currentPC(id,saveName,savedCpu,savedGpu,savedBoard,
        savedMemories,savedPower,savedDrive);
        saves.add(savedPc);
        return savedPc;
    }
    
    public void save(currentPC newSave, String newName, String path){
        boolean condition = true;
        if(newSave.saveID == 0){
            newSave.saveID = (saves.size() + 1);
            newSave.saveName = newName;
        }
        for(int i = 0; i < saves.size(); i++){
            currentPC comparison = saves.get(i);
            if(newName == comparison.saveName){
                newSave.saveID = comparison.saveID;
                comparison = newSave;
                condition = false;
            }
        }
        try{
            String saveLocation = newSave.saveName;
            saveLocation = saveLocation + ".csv";
            String absolutePath;
            File temp = new File(saveLocation);
            if(path != null) {
            	
            	saveLocation= path +"\\"+ saveLocation;
            	absolutePath = saveLocation;
        	    //System.out.println("File path : " + absolutePath);
            }else {
            	absolutePath = temp.getAbsolutePath();
        	    //System.out.println("File path : " + absolutePath);
            }
            
            //File file = new File(filePath);
            
            // for eclipse: "C:/Users/dh08020.AD/eclipse-workspace/test2/src/" + saveLocation + ".csv";  
            String filePath = saveLocation.substring(0,saveLocation.lastIndexOf(File.separator));
            
            File outFile = new File(absolutePath);
            
            outFile.createNewFile();
            FileWriter out = new FileWriter(outFile);//csv
            BufferedWriter out2 = new BufferedWriter(out);
            CSVWriter writer = new CSVWriter(out2);
            String[] header = {"SystemKey" , "DisplayName", "CpuID", "GpuID", 
            "BoardID", "MemoryID", "PowerID", "DriveID"};
            writer.writeNext(header);
            String[] line = new String[8];
            line[0] = Integer.toString(newSave.saveID);
            line[1] = newSave.saveName;
            if(newSave.currentCpu != null ){
            	line[2] = Integer.toString(newSave.currentCpu.cpuID);
            } else {line[2] = Integer.toString(0);}
            
            if(newSave.currentGpu != null ){
            	line[3] = Integer.toString(newSave.currentGpu.gpuID);
            } else {line[3] = Integer.toString(0);}
            
            if(newSave.currentBoard != null ){
            	line[4] = Integer.toString(newSave.currentBoard.boardID);
            } else {line[4] = Integer.toString(0);}
            
            if(newSave.currentMemory != null ){
            	line[5] = Integer.toString(newSave.currentMemory.memoryID);
            } else {line[5] = Integer.toString(0);}
            
            if(newSave.currentPower != null ){
            	line[6] = Integer.toString(newSave.currentPower.powerID);
            } else {line[6] = Integer.toString(0);}
            
            if(newSave.currentDrive != null ){
            	line[7] = Integer.toString(newSave.currentDrive.storageID);
            } else {line[7] = Integer.toString(0);}
            
            writer.writeNext(line);
            writer.close();
            newSave.saveID = 0;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void finish(){
        try{
            FileWriter out = new FileWriter("saves.csv");//csv
            //for eclipse: FileWriter out = new FileWriter("C:/Users/dh08020.AD/eclipse-workspace/test2/src/saves.csv");
            BufferedWriter out2 = new BufferedWriter(out);
            CSVWriter writer = new CSVWriter(out2);
            String[] header = {"SystemKey" , "DisplayName", "CpuID, GpuID", 
            "BoardID", "MemoryID", "PowerID", "DriveID"};
            writer.writeNext(header);
            for(int i = 0; i < saves.size(); i++){
                currentPC record = saves.get(i);
                String[] line = new String[8];
                line[0] = Integer.toString(record.saveID);
                line[1] = record.saveName;
                line[2] = Integer.toString(record.currentCpu.cpuID);
                line[3] = Integer.toString(record.currentGpu.gpuID);
                line[4] = Integer.toString(record.currentBoard.boardID);
                line[5] = Integer.toString(record.currentMemory.memoryID);
                line[8] = Integer.toString(record.currentPower.powerID);
                line[7] = Integer.toString(record.currentDrive.storageID);
                writer.writeNext(line);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void buildPCs(){
        try{
            File temp = new File("saves.csv");
        	
    	    String absolutePath = temp.getAbsolutePath();
    	    //System.out.println("File path : " + absolutePath);
    	    
    	    String filePath = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));
				
    	    //System.out.println("File path : " + filePath);
            
            File file = new File(absolutePath);
            FileReader out = new FileReader(file);
            //for eclipse: FileReader out = new FileReader("C:/Users/dh08020.AD/eclipse-workspace/test2/src/saves.csv");
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
                    saves.add(savedPc);
                }
            }
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void buildCPUs(){
        try{
            File temp = new File("cpus.csv");
        	
    	    String absolutePath = temp.getAbsolutePath();
    	    //System.out.println("File path : " + absolutePath);
            //File file = new File(filePath);
            FileReader out = new FileReader(temp);
            //for eclipse: FileReader out = new FileReader("C:/Users/dh08020.AD/eclipse-workspace/test2/src/cpus.csv");
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
                    int power = 8;//Integer.parseInt(record[7]);
                    double price = 10.3;//Double.parseDouble(record[8]);
                    cpuPart newpart = new cpuPart(id, name, cores, threads,
                    ghzSpeed, memSize, memMeasure, power, price);
                    cpus.add(newpart);
                }
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    //Integer.parseInt(record[2]); Double.parseDouble(record[4]);
    public void buildGPUs(){ 
        try{
            File temp = new File("gpus.csv");
        	
    	    String absolutePath = temp.getAbsolutePath();
    	   //System.out.println("File path : " + absolutePath);
            //File file = new File(filePath);
            FileReader out = new FileReader(absolutePath);
            //for eclipse: FileReader out = new FileReader("C:/Users/dh08020.AD/eclipse-workspace/test2/src/gpus.csv");
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
                    int power = Integer.parseInt(record[7]);
                    double price = Double.parseDouble(record[8]);
                    gpuPart newpart = new gpuPart(id, name, chipName, bus,
                    memory, clockSpeed, memClock, power, price);
                    gpus.add(newpart);
                }
            }
            
        } catch(Exception e) {
        }
    }
    //Integer.parseInt(record[2]); Double.parseDouble(record[4]);
    public void buildBoards(){ 
        try{
            File temp = new File("boards.csv");
        	
    	    String absolutePath = temp.getAbsolutePath();
    	    //System.out.println("File path : " + absolutePath);
            //File file = new File(filePath);
            FileReader out = new FileReader(absolutePath);
            //FileReader out = new FileReader("boards.csv");
            //for eclipse: FileReader out = new FileReader("C:/Users/dh08020.AD/eclipse-workspace/test2/src/boards.csv");
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    int id = Integer.parseInt(record[0]);
                    String name = record[1];
                    int sockNum = Integer.parseInt(record[2]);
                    String sockType = record[3];
                    String maxSup = record[4];
                    int gpuSocks = Integer.parseInt(record[5]);
                    int ramSocks = Integer.parseInt(record[6]);
                    String ramSockType = record[7];
                    int ramMax = Integer.parseInt(record[8]);
                    int peripAva = Integer.parseInt(record[9]);
                    int peripTotal = Integer.parseInt(record[10]);
                    int power = Integer.parseInt(record[11]);
                    double price = Double.parseDouble(record[12]);
                    boardPart newpart = new boardPart(id,name,sockNum,
                    sockType,maxSup,gpuSocks,ramSocks,ramSockType,ramMax,
                    peripAva,peripTotal, power, price);
                    boards.add(newpart);
                }
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    //Integer.parseInt(record[2]); Double.parseDouble(record[4]);
    public void buildMemory(){ 
        try{
            File temp = new File("memories.csv");
        	
    	    String absolutePath = temp.getAbsolutePath();
    	    //System.out.println("File path : " + absolutePath);
            //File file = new File(filePath);
            FileReader out = new FileReader(absolutePath);
            //FileReader out = new FileReader("memories.csv");
            //for eclipse: FileReader out = new FileReader("C:/Users/dh08020.AD/eclipse-workspace/test2/src/memories.csv");
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    int id = Integer.parseInt(record[0]);
                    String name = record[1];
                    String sockType = record[2];
                    int memSize = Integer.parseInt(record[3]);
                    String ramType = record[4];
                    int ramAmount = Integer.parseInt(record[5]);
                    int power = Integer.parseInt(record[6]);
                    double price = Double.parseDouble(record[7]);
                    memoryPart newpart = new memoryPart(id, name, sockType,
                    memSize,ramType, ramAmount, power, price);
                    memories.add(newpart);
                }
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    //Integer.parseInt(record[2]); Double.parseDouble(record[4]);
    public void buildPowers(){ 
        try{
            File temp = new File("powers.csv");
        	
    	    String absolutePath = temp.getAbsolutePath();
    	    //System.out.println("File path : " + absolutePath);
            //File file = new File(filePath);
            FileReader out = new FileReader(absolutePath);
            //FileReader out = new FileReader("powers.csv");
            //for eclipse: FileReader out = new FileReader("C:/Users/dh08020.AD/eclipse-workspace/test2/src/powers.csv");
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    int id = Integer.parseInt(record[0]);
                    String name = record[1];
                    int watts = Integer.parseInt(record[2]);
                    double price = Double.parseDouble(record[3]);
                    powerPart newpart = new powerPart(id, name, watts, price);
                    powers.add(newpart);
                }
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    //Integer.parseInt(record[2]); Double.parseDouble(record[4]);
    public void buildDrives(){ 
        try{
            File temp = new File("drives.csv");
        	
    	    String absolutePath = temp.getAbsolutePath();
    	    //System.out.println("File path : " + absolutePath);
            //File file = new File(filePath);
            FileReader out = new FileReader(absolutePath);
            //FileReader out = new FileReader("drives.csv");
            //for eclipse: FileReader out = new FileReader("C:/Users/dh08020.AD/eclipse-workspace/test2/src/drives.csv");
            BufferedReader out2 = new BufferedReader(out);
            CSVReader reader = new CSVReader(out2);
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if(i != 0){
                    int id = Integer.parseInt(record[0]);
                    String name = record[1];
                    String type = record[2];
                    int size = Integer.parseInt(record[3]);
                    String measure = record[4];
                    int rpm = Integer.parseInt(record[5]);
                    int ssdtr = Integer.parseInt(record[6]);
                    int power = Integer.parseInt(record[7]);
                    double price = Double.parseDouble(record[8]);
                    drivePart newpart = new drivePart(id, name, type, size,
                    measure, rpm, ssdtr, power, price);
                    drives.add(newpart);
                }
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    public memoryPart findMemory(int memoryfinder){
        memoryPart savedCpu = null;
        for(int j = 0; j < memories.size(); j++){
            if(memories.get(j).memoryID == memoryfinder){
                savedCpu= memories.get(j);
            }
        }
        return savedCpu;
    }
    
    public powerPart findPower(int powerfinder){
        powerPart savedCpu = null;
        for(int j = 0; j < powers.size(); j++){
            if(powers.get(j).powerID == powerfinder){
                savedCpu= powers.get(j);
            }
        }
        return savedCpu;
    }
    
    public drivePart findDrives(int drivefinder){
        drivePart savedCpu = null;
        for(int j = 0; j < drives.size(); j++){
            if(drives.get(j).storageID == drivefinder){
                savedCpu= drives.get(j);
            }
        }
        return savedCpu;
    }
    
    public boardPart findBoard(int boardfinder){
        boardPart savedCpu = null;
        for(int j = 0; j < boards.size(); j++){
            if(boards.get(j).boardID == boardfinder){
                savedCpu= boards.get(j);
            }
        }
        return savedCpu;
    }
    
    public gpuPart findGPU(int gpufinder){
        gpuPart savedGpu = null;
        for(int j = 0; j < gpus.size(); j++){
            if(gpus.get(j).gpuID == gpufinder){
                savedGpu= gpus.get(j);
            }
        }
        return savedGpu;
    }
    
    public cpuPart findCPU(int cpufinder){
        cpuPart savedCpu = null;
        for(int j = 0; j < cpus.size(); j++){
            if(cpus.get(j).cpuID == cpufinder){
                savedCpu= cpus.get(j);
            }
        }
        return savedCpu;
    }
}
/*

*/
