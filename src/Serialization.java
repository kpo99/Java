import java.io.*;

public class Serialization {

    static void Serealize(Storage_Stack object){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("storage.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in: storage.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    static Storage_Stack Deserealize(){
        Storage_Stack _return = null;

        try {
            FileInputStream fileIn = new FileInputStream("storage.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            _return = (Storage_Stack) in.readObject();
            in.close();
            fileIn.close();
            return _return;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Storage class not found");
            c.printStackTrace();
            return null;
        }
    }

}
