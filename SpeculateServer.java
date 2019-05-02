import java.rmi.Naming;
import java.rmi.RemoteException;

public class SpeculateServer {

    public static void main(String[] args) {
        try { 
            java.rmi.registry.LocateRegistry.createRegistry(1099); 
            System.out.println("RMI registry ready.");
        } catch (RemoteException e) {
            System.out.println("RMI registry already running.");
        }

        try {
            int numDePartidas = 500;
            int bolasPorJogador = 15;
            Naming.rebind ("Speculate", new SpeculateImpl(numDePartidas, bolasPorJogador));
            System.out.println ("SpeculateServer is ready."); } catch (Exception e) {
            System.out.println ("SpeculateServer failed:");
            e.printStackTrace();
      }
    }
}