public class NoMenu {
    public static void main(String[] args) throws Exception {
        SBT sbt = new SBT();
        sbt.addData(10);
        sbt.addData(5);
        sbt.addData(15);
        sbt.addData(3);
        sbt.addData(7);
        sbt.inOrderPrint();
        sbt.postOrdenPrint();
        sbt.preOrdenPrint();
    }
    
} 
