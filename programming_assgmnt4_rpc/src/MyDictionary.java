import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyDictionary extends Remote {
    public String lookUpWord(String word) throws RemoteException;
//public int add(int x,int y)throws RemoteException;
}
