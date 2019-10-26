public class boardPart{
    int boardID;
    String boardName;
    int cpuSocket;
    String cpuSocketType;
    String cpuMaxSupport;
    int gpuSockets;
    int ramSockets;
    String ramSocketType;
    int ramMaxMemory;
    int peripheralSocketsAvaliable;
    int peripheralSocketsTotal;
    public boardPart(int newID, String newName, int newSocketNum, String newSocketType,
    String newMaxSup, int newGpuSocks, int newRamSocks, String newRamSockType,
    int newRamMax, int newPeripAva, int newPeripTotal){
        boardID = newID;
        boardName = newName;
        cpuSocket = newSocketNum;
        cpuSocketType = newSocketType;
        cpuMaxSupport = newMaxSup;
        gpuSockets = newGpuSocks;
        ramSockets =newRamSocks;
        ramSocketType = newRamSockType;
        ramMaxMemory = newRamMax;
        peripheralSocketsAvaliable = newPeripAva;
        peripheralSocketsTotal = newPeripTotal;
        
    }

}
