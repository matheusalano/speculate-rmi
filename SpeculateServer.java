import java.rmi.Naming;
import java.rmi.RemoteException;

public class SpeculateServer {

    public static void main(String[] args) {
        
        try {
            SpeculateImpl spec = new SpeculateImpl(500);
            System.out.println ("HelloServer is ready.");
        } catch (Exception e) {
            System.out.println ("HelloServer failed:");
            e.printStackTrace();
        }
        
    }
}