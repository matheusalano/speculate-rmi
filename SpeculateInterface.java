import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SpeculateInterface extends Remote {

    public int registraJogador(String nome) throws RemoteException;
    public int encerraPartida(int idUsuario) throws RemoteException;
    public int temPartida(int idUsuario) throws RemoteException;
    public String obtemOponente(int idUsuario) throws RemoteException;
    public int ehMinhaVez(int idUsuario) throws RemoteException;
    public int obtemNumBolas(int idUsuario) throws RemoteException;
    public int obtemNumBolasOponente(int idUsuario) throws RemoteException;
    public String obtemTabuleiro(int idUsuario) throws RemoteException;
    public int defineJogadas(int idUsuario, int numLancamentos) throws RemoteException;
    public int jogaDado(int idUsuario) throws RemoteException;
}