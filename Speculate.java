import java.util.Random;

public class Speculate {

    private Tabuleiro tabuleiro;
    private Jogador jogador01;
    private Jogador jogador02;
    private Int dado;
    private Random gerador = new Random(19700621);

    Speculate() {
        tabuleiro = new Tabuleiro();
        jogador01 = null;
        jogador02 = null;
        dado = gerador.nextInt(5) + 1;
    }

    public Int temVaga() {
        
        if (jogador01 == null) {
            return 2;
        }
        if (jogador02 == null) {
            return 1;
        }

        return 0;
    }
}