import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyClient {
    public static void main(String agrs[]){
        String line;
        final int MAXCOUNT = 100;
        int counter = 0;
        try {

            MyDictionary stub = (MyDictionary) Naming.lookup("rmi://localhost:5000/dictionary");
            BufferedReader buffer = new BufferedReader(new FileReader("/Users/alsenydiallo/IdeaProjects/programming_assgmnt4_rpc/resources/words.txt"));
            while ((line = buffer.readLine()) != null && counter < MAXCOUNT) {
                String response = stub.lookUpWord(line);
                System.out.println("Client serching for word >> " + line);
                System.out.println(("Remote server response: "));
                System.out.println(line + " " + response);
                System.out.println(); // formatter
                counter +=1;
            }
            buffer.close();


        } catch (NotBoundException | IOException e) {
            System.out.println("Server exit with an exception !!");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

}
