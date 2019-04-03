import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SpeculateInterface extends Remote {

    public Int registraJogador(String nome) throws RemoteException;
    public Int encerraPartida(Int idUsuario) throws RemoteException;
    public Int temPartida(Int idUsuario) throws RemoteException;
    public String obtemOponente(Int idUsuario) throws RemoteException;
    public Int ehMinhaVez(Int idUsuario) throws RemoteException;
    public Int obtemNumBolas(Int idUsuario) throws RemoteException;
    public Int obtemNumBolasOponente(Int idUsuario) throws RemoteException;
    public String obtemTabuleiro(Int idUsuario) throws RemoteException;
    public Int defineJogadas(Int idUsuario, Int numLancamentos) throws RemoteException;
    public Int jogaDado(Int idUsuario) throws RemoteException;
}