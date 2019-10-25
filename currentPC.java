public class currentPC{
    cpuPart currentCpu;
    gpuPart currentGpu;
    //currentBoard
    //currentMemory
    //currentPower
    public currentPC(cpuPart newCpu, gpuPart newGpu){
        currentCpu = newCpu;
        currentGpu = newGpu;
    }
    
    public cpuPart getCpu(){
        return currentCpu;
    }
}
