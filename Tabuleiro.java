
public class Tabuleiro {

    private boolean[] casas;
    private Int bolasCentro;

    Tabuleiro() {
        casas = new boolean[] {true, false, true, false, true};
        bolasCentro = 0;
    }

    public boolean getCasa(Int posicao) {
        return casas[posicao - 1];
    }

    public boolean atualizaCasa(Int posicao) {
        casas[posicao - 1] = !casas[posicao - 1];
        return casas[posicao - 1];
    }

    public void incrementaBolasCentro() {
        bolasCentro++;
    }

    public String toString() {
        String tab = "";

        if (casas[0]) { tab += "*"; } else { tab += "1"; } 
        if (casas[1]) { tab += "*"; } else { tab += "2"; } 
        if (casas[2]) { tab += "*"; } else { tab += "3"; } 
        if (casas[3]) { tab += "*"; } else { tab += "4"; } 
        if (casas[4]) { tab += "*"; } else { tab += "5"; } 
        tab += "6";

        return tab;
    }
}