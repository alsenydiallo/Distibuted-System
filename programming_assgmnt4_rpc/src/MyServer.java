import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MyServer {

    public static void main(String args[]) throws RemoteException, MalformedURLException {
        try {
            MyDictionary stub =  new MyDictionaryRemote();
            LocateRegistry.createRegistry(5000);
            Naming.rebind("rmi://localhost:5000/dictionary", stub);
            System.out.println("Remote server ready.");

        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        } catch (MalformedURLException e) {
            throw new MalformedURLException(e.getMessage());
        }

    }
}
