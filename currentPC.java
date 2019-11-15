public class currentPC{
    int saveID;
    String saveName;
    cpuPart currentCpu;
    gpuPart currentGpu;
    boardPart currentBoard;
    memoryPart currentMemory;
    powerPart currentPower;
    drivePart currentDrive;
    public currentPC(int saveCheck, String newName, cpuPart newCpu, gpuPart newGpu,
    boardPart newBoard,memoryPart newMemory, powerPart newPower, drivePart newDrive){ 
        saveID = saveCheck;
        saveName = newName;
        currentCpu = newCpu;
        currentGpu = newGpu;
        currentBoard = newBoard;
        currentMemory = newMemory;
        currentPower = newPower;
        currentDrive = newDrive;
    }
    
    public currentPC(){
        saveID = 0;// zero indicates a new file
        saveName = "untitled";
        currentCpu = null;
        currentGpu = null;
        currentBoard = null;
        currentMemory = null;
        currentPower = null;
        currentDrive = null;
    }
    
    public cpuPart getCpu(){
        return currentCpu;
    }
    
    public double cost(){
        double totalCost = 0.00;
        totalCost = totalCost + currentCpu.price;
        totalCost = totalCost + currentGpu.price;
        totalCost = totalCost + currentBoard.price;
        totalCost = totalCost + currentMemory.price;
        totalCost = totalCost + currentPower.price;
        totalCost = totalCost + currentDrive.price;
        return totalCost;
    }
    
    public int powerCheck(){
        int totalPower;
        totalPower = currentPower.maxWattage;
        totalPower = totalPower - currentCpu.power;
        totalPower = totalPower - currentGpu.power;
        totalPower = totalPower - currentBoard.power;
        totalPower = totalPower - currentMemory.power;
        totalPower = totalPower - currentDrive.power;
        return totalPower;
    }
    
    public boolean powerAccept(){
        int totalPower = powerCheck();
        boolean checker;
        if(totalPower < 0){
            checker = false;
        } else {
            checker = true;
        }
        return checker;
    }
}
