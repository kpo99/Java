public class Main {
    public static void main(String[] args){
        DiagramCalculation CalcModule = new DiagramCalculation();

        Storage_Stack storage = Serialization.Deserealize();
        storage.printArray();

        char[][][] temp = CalcModule.Calculate(
                new char[] { '0', '0', '0', '1', '*', '*', '0', '*', '*', '*' },
                new char[] { '0', '0', '0', '0', '1', '1', '1','0','1','1' },
                new char[] { '0', '0', '0', '1', '1', '1', '1','1','1','0' },
                new char[] { '0', '0', '1', '1', '1', '1', '0','0','0','0' },
                new char[] { '0', '1', '1', '1', '1', '0', '0','0','0','0' },
                new char[] { '*', '*', '*', '*', '*', '*', '0','*','1','*'});

        //storage.addElement(new StorageItem(temp,"Second element"));


        Serialization.Serealize(storage);

    }
}
