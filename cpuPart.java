public class cpuPart{
    int cpuID;
    String cpuName;
    int cores;
    int threads;
    double ghzSpeed;
    double memSize;
    String memMeasure;
    public cpuPart(int newID, String newName, int newCore, int newThreads, 
    double newSpeed, double newMemSize, String newMemMeasure){
        cpuID = newID;
        cpuName = newName;
        cores = newCore;
        threads = newThreads;
        ghzSpeed = newSpeed;
        memSize = newMemSize;
        memMeasure = newMemMeasure;
        //AMD Ryzen 7
    }
    
    public int getID(){
        return cpuID;
    }
    public String getName(){
        return cpuName;
    }
    public int getCores(){
        return cores;
    }
    public int getThreads(){
        return threads;
    }
    public double ghzSpeed(){
        return ghzSpeed;
    }
    public String getFullMemory(){
        return ""+ memSize + memMeasure;
    }
}
