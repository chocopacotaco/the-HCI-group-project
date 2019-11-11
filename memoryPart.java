public class memoryPart{
    int memoryID;
    String memoryName;
    String socketType;
    int memorySize;
    String systemRAMType;
    int ramStickAmount;
    int power;
    double price;
    public memoryPart(int newID, String newName, String newSocket, int newSize,
    String newRamType, int newRamAmmount, int newPower, double newPrice){
        // initialise
        memoryID = newID;
        memoryName = newName;
        socketType = newSocket;
        memorySize = newSize;
        systemRAMType = newRamType;
        ramStickAmount = newRamAmmount;
        power = newPower;
        price = newPrice;
    }
    
}