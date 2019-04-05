import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class SpeculateImpl extends UnicastRemoteObject implements SpeculateInterface {

    private static final long serialVersionUID = 1L;
    private Speculate[] jogos;
    private Random gerador = new Random();

    public SpeculateImpl(int numPartidas) throws RemoteException {
        jogos = new Speculate[numPartidas];
    }

    public int registraJogador(String nome) throws RemoteException {
        int partida = this.temPartidaDisp(nome);
        if (partida == -1) { return -1; }
        if (partida == -2) { return -2; }

        String id = Integer.toString(gerador.nextInt(999) + 1000);
        id += String.format("%03d" , partida);

        Jogador jog = new Jogador(Integer.parseInt(id), nome);
        jogos[partida].adicionaJogador(jog);

        return jog.getIdentifier();
    }

    public int encerraPartida(int idUsuario) throws RemoteException {
        return 0;
    }

    public int temPartida(int idUsuario) throws RemoteException {
        return 0;
    }
    
    public String obtemOponente(int idUsuario) throws RemoteException {
        return "";
    }

    public int ehMinhaVez(int idUsuario) throws RemoteException {
        return 0;
    }

    public int obtemNumBolas(int idUsuario) throws RemoteException {
        return 0;
    }

    public int obtemNumBolasOponente(int idUsuario) throws RemoteException {
        return 0;
    }

    public String obtemTabuleiro(int idUsuario) throws RemoteException {
        return "";
    }

    public int defineJogadas(int idUsuario, int numLancamentos) throws RemoteException {
        return 0;
    }

    public int jogaDado(int idUsuario) throws RemoteException {
        return 0;
    }

    // Helpers

    private int temPartidaDisp(String nome) {

        for (int i = 0; i < 500; i++) {
            if (jogos[i].temJogador(nome)) { return -1; }
            if (jogos[i].temVaga() == 1) { return i; }
        }
        for (int i = 0; i < 500; i++) {
            if (jogos[i].temVaga() == 2) { return i; }
        }

        return -2;
    }
}