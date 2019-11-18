public class main{
    public static void main(String[] args){
        partBuilder test = new partBuilder();
        //test.buildPCs();
        currentPC testpc = test.saves.get(0);
        System.out.println(test.saves.size());
        System.out.println(test.cpus.size());
        //test.save(testpc, "workDamnit");
    }
    
}
