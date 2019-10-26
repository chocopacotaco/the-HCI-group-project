public class currentPC{
    cpuPart currentCpu;
    gpuPart currentGpu;
    boardPart currentBoard;
    memoryPart currentMemory;
    powerPart currentPower;
    drivePart currentDrive;
    public currentPC(cpuPart newCpu, gpuPart newGpu, boardPart newBoard, 
    memoryPart newMemory, powerPart newPower, drivePart newDrive){
        currentCpu = newCpu;
        currentGpu = newGpu;
        currentBoard = newBoard;
        currentMemory = newMemory;
        currentPower = newPower;
        currentDrive = newDrive;
    }
    
    public cpuPart getCpu(){
        return currentCpu;
    }
}
