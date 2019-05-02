import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class SpeculateImpl extends UnicastRemoteObject implements SpeculateInterface {

    private static final long serialVersionUID = 7896795898928282846L;
    private Speculate[] jogos;
    private Random gerador = new Random();
    private int bolasPorJogador;

    public SpeculateImpl(int numPartidas, int bolasPorJogador) throws RemoteException {
        this.bolasPorJogador = bolasPorJogador;
        jogos = new Speculate[numPartidas];

        for (int i = 0; i < 500; i++) {
            jogos[i] = new Speculate();
        }
    }

    public int registraJogador(String nome) throws RemoteException {
        int partida = this.temPartidaDisp(nome);
        if (partida == -1) { return -1; }
        if (partida == -2) { return -2; }

        String id = Integer.toString(gerador.nextInt(999) + 1000);
        id += String.format("%03d" , partida + 1);

        Jogador jog = new Jogador(Integer.parseInt(id), nome, bolasPorJogador);
        jogos[partida].adicionaJogador(jog);

        return jog.getIdentifier();
    }

    public int encerraPartida(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return idx;

        return jogos[idx].encerraPartida(idUsuario);
    }

    public int temPartida(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return idx;

        return jogos[idx].temPartida(idUsuario);
    }
    
    public String obtemOponente(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return "";

        return jogos[idx].obtemOponente(idUsuario);
    }

    public int ehMinhaVez(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return idx;

        return jogos[idx].ehMinhaVez(idUsuario);
    }

    public int obtemNumBolas(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return idx;

        return jogos[idx].obtemNumBolas(idUsuario);
    }

    public int obtemNumBolasOponente(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return idx;

        return jogos[idx].obtemNumBolasOponente(idUsuario);
    }

    public String obtemTabuleiro(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return "";

        return jogos[idx].obtemTabuleiro();
    }

    public int defineJogadas(int idUsuario, int numLancamentos) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return idx;

        return jogos[idx].defineJogadas(idUsuario, numLancamentos);
    }

    public int jogaDado(int idUsuario) throws RemoteException {
        int idx = getPartida(idUsuario);
        if (idx == -1) return idx;

        return jogos[idx].jogaDado(idUsuario);
    }

    // Helpers

    private int temPartidaDisp(String nome) {

        for (int i = 0; i < 500; i++) {
            if (jogos[i].temJogador(nome)) { return -1; }
        }

        for (int i = 0; i < 500; i++) {
            if (jogos[i].temVaga() == 1) { return i; }
        }

        for (int i = 0; i < 500; i++) {
            if (jogos[i].temVaga() == 2) { return i; }
        }
        
        return -2;
    }

    private int getPartida(int idUsuario) {
        String stringID = Integer.toString(idUsuario);
        if (stringID.length() <= 3) { return -1; }
        int idx = Integer.parseInt(stringID.substring(stringID.length() - 3)) - 1;

        if (jogos[idx].temJogador(idUsuario)) { return idx; }

        return -1;
    }
}