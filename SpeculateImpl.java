import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SpeculateImpl extends UnicastRemoteObject implements SpeculateInterface {

    private static final long serialVersionUID = 1L;
    private Speculate[] jogos;

    SpeculateImpl(Int numPartidas) {
        jogos = Speculate[numPartidas];
    }

    public Int registraJogador(String nome) throws RemoteException {

    }

    public Int encerraPartida(Int idUsuario) throws RemoteException {

    }

    public Int temPartida(Int idUsuario) throws RemoteException {

    }
    
    public String obtemOponente(Int idUsuario) throws RemoteException {

    }

    public Int ehMinhaVez(Int idUsuario) throws RemoteException {

    }

    public Int obtemNumBolas(Int idUsuario) throws RemoteException {

    }

    public Int obtemNumBolasOponente(Int idUsuario) throws RemoteException {

    }

    public String obtemTabuleiro(Int idUsuario) throws RemoteException {

    }

    public Int defineJogadas(Int idUsuario, Int numLancamentos) throws RemoteException {

    }

    public Int jogaDado(Int idUsuario) throws RemoteException {

    }
}