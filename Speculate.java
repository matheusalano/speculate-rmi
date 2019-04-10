import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

enum SpeculateStatus {
    AGUARDANDO_JOGADOR, VEZ_JOG01, VEZ_JOG02, ENC_JOG01, ENC_JOG02, WO_JOG01, WO_JOG02, TEMPO_ESGOTADO;
} 

public class Speculate {

    private Tabuleiro tabuleiro;
    private Jogador jogador01;
    private Jogador jogador02;
    private int numLancamentos;
    private int dado;
    private SpeculateStatus status;
    private Random gerador = new Random(1279634689); //para entrega fazer a soma dos IDs dos jogadores
    private Timer timer;
    private TimerTask task;

    Speculate() {
        zerarPartida();
    }

    private void zerarPartida() {
        tabuleiro = new Tabuleiro();
        jogador01 = null;
        jogador02 = null;
        numLancamentos = -1;
        dado = gerador.nextInt(5) + 1;
        status = SpeculateStatus.AGUARDANDO_JOGADOR;
        if (task != null) {
            task.cancel();
            task = null;
        }
        timer = new Timer();
    }

    public int temVaga() {
        if (status != SpeculateStatus.AGUARDANDO_JOGADOR) { 
            return 0; 
        } else if (jogador01 == null) {
            return 2;
        }

        return 1;
    }

    public boolean temJogador(String nome) {
        if(jogador01 != null && jogador01.getNome().equals(nome)) { return true; }
        if(jogador02 != null && jogador02.getNome().equals(nome)) { return true; }
        
        return false;
    }

    public boolean temJogador(int id) {
        if(jogador01 != null && jogador01.getIdentifier() == id) { return true; }
        if(jogador02 != null && jogador02.getIdentifier() == id) { return true; }
        
        return false;
    }

    public void adicionaJogador(Jogador jog) {
        int temVaga = this.temVaga();
        if (temVaga == 2) {
            this.jogador01 = jog;
            esperaJogador();
        } else if (temVaga == 1) {
            this.jogador02 = jog;
            this.status = SpeculateStatus.VEZ_JOG01;
            task.cancel();
            task = null;
        }
    }

    public int encerraPartida(int idUsuario) {
        if (status == SpeculateStatus.AGUARDANDO_JOGADOR) { zerarPartida(); return 0; }

        if (jogador01.getIdentifier() == idUsuario) {
            status = SpeculateStatus.WO_JOG02;
            return 0;
        } else if (jogador02.getIdentifier() == idUsuario) {
            status = SpeculateStatus.WO_JOG01;
            return 0;
        }
        return -1; 
    }

    public int temPartida(int idUsuario) {
        switch (status) {
            case AGUARDANDO_JOGADOR:
                return 0;
            case TEMPO_ESGOTADO:
                return -2;
            case VEZ_JOG01:
                return (jogador01.getIdentifier() == idUsuario) ? 1 : 2;
            case VEZ_JOG02:
                return (jogador02.getIdentifier() == idUsuario) ? 1 : 2;
            default:
                return -1;
        }
    }

    public String obtemOponente(int idUsuario) {
        if (status == SpeculateStatus.AGUARDANDO_JOGADOR) { return ""; }

        return (jogador01.getIdentifier() == idUsuario) ? jogador02.getNome() : jogador01.getNome();
    }

    public int ehMinhaVez(int idUsuario) {
        switch (status) {
            case AGUARDANDO_JOGADOR:
                return -2;
            case VEZ_JOG01:
                return (jogador01.getIdentifier() == idUsuario) ? 1 : 0;
            case VEZ_JOG02:
                return (jogador02.getIdentifier() == idUsuario) ? 1 : 0;
            case ENC_JOG01:
                return (jogador01.getIdentifier() == idUsuario) ? 2 : 3;
            case ENC_JOG02:
                return (jogador02.getIdentifier() == idUsuario) ? 2 : 3;
            case WO_JOG01:
                return (jogador01.getIdentifier() == idUsuario) ? 5 : 6;
            case WO_JOG02:
                return (jogador02.getIdentifier() == idUsuario) ? 5 : 6;
            default:
                return -1;
        }
    }

    public int obtemNumBolas(int idUsuario) {
        if (status == SpeculateStatus.AGUARDANDO_JOGADOR) { return -2; }

        return (jogador01.getIdentifier() == idUsuario) ? jogador01.getBolas() : jogador02.getBolas();
    }

    public int obtemNumBolasOponente(int idUsuario) {
        if (status == SpeculateStatus.AGUARDANDO_JOGADOR) { return -2; }

        return (jogador01.getIdentifier() == idUsuario) ? jogador02.getBolas() : jogador01.getBolas();
    }

    public String obtemTabuleiro() {
        return tabuleiro.toString();
    }

    public int defineJogadas(int idUsuario, int numLancamentos) {
        if (status == SpeculateStatus.AGUARDANDO_JOGADOR) { return -2; }

        if (jogador01.getIdentifier() == idUsuario) {
            if (status != SpeculateStatus.VEZ_JOG01) { return -3; }
            if (this.numLancamentos != -1) { return -4; }
            if (numLancamentos < 1 || numLancamentos > jogador01.getBolas()) { return -5; }

            this.numLancamentos = numLancamentos;
            return 1;
        } else if (jogador02.getIdentifier() == idUsuario) {
            if (status != SpeculateStatus.VEZ_JOG02) { return -3; }
            if (this.numLancamentos != -1) { return -4; }
            if (numLancamentos < 1 || numLancamentos > jogador02.getBolas()) { return -5; }

            this.numLancamentos = numLancamentos;
            return 1;
        }

        return -1;
    }

    public int jogaDado(int idUsuario) {
        if (status == SpeculateStatus.AGUARDANDO_JOGADOR) { return -2; }

        if (jogador01.getIdentifier() == idUsuario) {
            if (status != SpeculateStatus.VEZ_JOG01) { return -3; }
            if (this.numLancamentos == -1) { return -4; }
            
            dado = gerador.nextInt(5) + 1;
            atualizaJogo(idUsuario);
            
            if (jogador01.getBolas() == 0) { status = SpeculateStatus.ENC_JOG01; }
            if (numLancamentos == 0) { numLancamentos = -1; status = SpeculateStatus.VEZ_JOG02; }
            return dado;
        } else if (jogador02.getIdentifier() == idUsuario) {
            if (status != SpeculateStatus.VEZ_JOG02) { return -3; }
            if (this.numLancamentos == -1) { return -4; }

            dado = gerador.nextInt(5) + 1;
            atualizaJogo(idUsuario);
            
            if (jogador02.getBolas() == 0) { status = SpeculateStatus.ENC_JOG02; }
            if (numLancamentos == 0) { numLancamentos = -1; status = SpeculateStatus.VEZ_JOG01; }
            return dado;
        }

        return -1;
    }

    private void atualizaJogo(int idUsuario) {
        Jogador jog = (jogador01.getIdentifier() == idUsuario) ? jogador01 : jogador02;

        if (dado == 6) {
            tabuleiro.incrementaBolasCentro();
            jog.decrementarBolas();
        } else {
            if (tabuleiro.getCasa(dado)) { jog.incrementarBolas(); } else { jog.decrementarBolas(); }
            tabuleiro.atualizaCasa(dado);
        }
        numLancamentos--;
    }

    private void esperaJogador() {
        task = new TimerTask() {
            @Override
            public void run() {
                status = SpeculateStatus.TEMPO_ESGOTADO;
                limpaPartida();
            }
        };

        timer.schedule(task, 120000);
    }

    private void limpaPartida() {
        task = new TimerTask() {
            @Override
            public void run() {
                zerarPartida();
            }
        };

        timer.schedule(task, 60000);
    }
}