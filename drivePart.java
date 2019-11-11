  
public class drivePart{
    // instance variables - replace the example below with your own
    int storageID;
    String storageName;
    String storageType;
    int storageSize;
    String sizeMeasure;
    int hardDriveRPM;
    int ssdDTR;
    int power;
    double price;
    public drivePart(int newID, String newName, String newStorType, int newStorSize,
    String newSizeMeasure, int newRPM, int newDTR, int newPower, double newPrice){
        // initialise instance variables
        storageID = newID;
        storageName = newName;
        storageType = newStorType;
        storageSize = newStorSize;
        sizeMeasure = newSizeMeasure;
        hardDriveRPM = newRPM;
        ssdDTR = newDTR;
        power = newPower;
        price = newPrice;
    }
}