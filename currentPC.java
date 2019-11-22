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
        
        if(currentCpu != null) {
        	totalCost = totalCost + currentCpu.price;
        }
        if(currentGpu != null) {
        	totalCost = totalCost + currentGpu.price;
        }
        if(currentBoard != null) {
        	totalCost = totalCost + currentBoard.price;
        }
        if(currentMemory != null) {
        	totalCost = totalCost + currentMemory.price;
        }
        if(currentPower != null) {
        	totalCost = totalCost + currentPower.price;
        }
        if(currentDrive != null) {
        	totalCost = totalCost + currentDrive.price;
        }
        
        
        return totalCost;
    }
    
    public int powerCheck(){
        int totalPower = 0;
        if(currentPower != null) {
        	totalPower = currentPower.maxWattage;
        }
        if(currentCpu != null) {
        	totalPower = totalPower - currentCpu.power;
        }
        if(currentGpu != null) {
        	totalPower = totalPower - currentGpu.power;
        }
        if(currentBoard != null) {
        	totalPower = totalPower - currentBoard.power;
        }
        if(currentMemory != null) {
        	totalPower = totalPower - currentMemory.power;
        }
        if(currentDrive != null) {
        	totalPower = totalPower - currentDrive.power;
        }
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
