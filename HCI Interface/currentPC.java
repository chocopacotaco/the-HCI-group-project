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
}
