import java.util.Random;

enum SpeculateStatus {
    AGUARDANDO_JOGADOR, VEZ_JOG01, VEZ_JOG02, ENCERRADA;
} 

public class Speculate {

    private Tabuleiro tabuleiro;
    private Jogador jogador01;
    private Jogador jogador02;
    private int dado;
    private SpeculateStatus status;
    private Random gerador = new Random(19700621);

    Speculate() {
        tabuleiro = new Tabuleiro();
        jogador01 = null;
        jogador02 = null;
        dado = gerador.nextInt(5) + 1;
        status = SpeculateStatus.AGUARDANDO_JOGADOR;
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
        return ((jogador01.getNome() == nome) || (jogador02.getNome() == nome));
    }

    public boolean temJogador(int id) {
        return ((jogador01.getIdentifier() == id) || (jogador02.getIdentifier() == id));
    }

    public void adicionaJogador(Jogador jog) {
        int temVaga = this.temVaga();
        if (temVaga == 2) {
            this.jogador01 = jog;
        } else if (temVaga == 1) {
            this.jogador02 = jog;
        }
    }

    public int encerraPartida(int idUsuario) {
        if (jogador01.getIdentifier() == idUsuario) {
            jogador01 = null;
            status = SpeculateStatus.ENCERRADA;
            return 0;
        } else if (jogador02.getIdentifier() == idUsuario) {
            jogador02 = null;
            status = SpeculateStatus.ENCERRADA;
            return 0;
        }
        return -1; 
    }
}