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
            int numDePartidas = Integer.parseInt(args[0]);
            int bolasPorJogador = Integer.parseInt(args[1]);
            System.out.println("Número de partidas: " + numDePartidas + "; Número de bolas por jogador: " + bolasPorJogador);
            Naming.rebind ("Speculate", new SpeculateImpl(numDePartidas, bolasPorJogador));
            System.out.println ("SpeculateServer is ready."); } catch (Exception e) {
            System.out.println ("SpeculateServer failed:");
            e.printStackTrace();
      }
    }
}