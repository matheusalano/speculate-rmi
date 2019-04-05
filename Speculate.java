import java.util.Random;

public class Speculate {

    private Tabuleiro tabuleiro;
    private Jogador jogador01;
    private Jogador jogador02;
    private int dado;
    private Random gerador = new Random(19700621);

    Speculate() {
        tabuleiro = new Tabuleiro();
        jogador01 = null;
        jogador02 = null;
        dado = gerador.nextInt(5) + 1;
    }

    public int temVaga() {
        
        if (jogador01 == null) {
            return 2;
        }
        if (jogador02 == null) {
            return 1;
        }

        return 0;
    }

    public boolean temJogador(String nome) {
        return ((jogador01.getNome() == nome) || (jogador02.getNome() == nome));
    }

    public void adicionaJogador(Jogador jog) {
        int temVaga = this.temVaga();
        if (temVaga == 2) {
            this.jogador01 = jog;
        } else if (temVaga == 1) {
            this.jogador02 = jog;
        }
    }
}