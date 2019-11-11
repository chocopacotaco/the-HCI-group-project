public class gpuPart{
    int gpuID;
    String gpuName;
    String chipName;
    String bus;
    double memory;
    int gpuClockSpeed;
    int memoryClock;
    int power;
    double price;
    public gpuPart(int newGpuID, String newName,String newChip, String newBus,
    double newMemory,int newSpeed, int newClock, int newPower, double newPrice){
        gpuID = newGpuID;
        gpuName = newName;
        chipName = newChip;
        bus = newBus;
        memory = newMemory;
        gpuClockSpeed = newSpeed;
        memoryClock = newClock;
        power = newPower;
        price = newPrice;
    }
}