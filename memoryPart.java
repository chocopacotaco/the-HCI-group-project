public class memoryPart{
    int memoryID;
    String memoryName;
    String socketType;
    int memorySize;
    String systemRAMType;
    int ramStickAmount;
    
    public memoryPart(int newID, String newName, String newSocket, int newSize,
    String newRamType, int newRamAmmount){
        // initialise
        memoryID = newID;
        memoryName = newName;
        socketType = newSocket;
        memorySize = newSize;
        systemRAMType = newRamType;
        ramStickAmount = newRamAmmount;
    }
    
}
