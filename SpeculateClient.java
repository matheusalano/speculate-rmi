import java.rmi.Naming;

public class SpeculateClient {

    public static void main(String[] args) {
        try {
            SpeculateInterface speculate = (SpeculateInterface) Naming.lookup ("//localhost/Speculate"); 
            int id = speculate.registraJogador("matheusalano"); System.out.println ("registraJogador01: " + id);
            System.out.println ("temPartida01: " + speculate.temPartida(id));

            int id2 = speculate.registraJogador("domisobrosa"); System.out.println ("registraJogador02: " + id2);
            System.out.println ("temPartida01: " + speculate.temPartida(id));

            //JOGADOR 1
            System.out.println ("defineJogadas01: " + speculate.defineJogadas(id, 5));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));

            System.out.println ("obtemTabuleiro01: " + speculate.obtemTabuleiro(id));
            System.out.println ("obtemNumBolas01: " + speculate.obtemNumBolas(id));
            System.out.println ("ehMinhaVez01: " + speculate.ehMinhaVez(id));

            //JOGADOR 2
            System.out.println ("defineJogadas02: " + speculate.defineJogadas(id2, 5));
            System.out.println ("jogaDado02: " + speculate.jogaDado(id2));
            System.out.println ("jogaDado02: " + speculate.jogaDado(id2));
            System.out.println ("jogaDado02: " + speculate.jogaDado(id2));
            System.out.println ("jogaDado02: " + speculate.jogaDado(id2));
            System.out.println ("jogaDado02: " + speculate.jogaDado(id2));

            System.out.println ("obtemTabuleiro02: " + speculate.obtemTabuleiro(id2));
            System.out.println ("obtemNumBolas02: " + speculate.obtemNumBolas(id2));
            System.out.println ("ehMinhaVez02: " + speculate.ehMinhaVez(id2));

            //JOGADOR 1
            System.out.println ("defineJogadas01: " + speculate.defineJogadas(id, 2));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));

            System.out.println ("obtemTabuleiro01: " + speculate.obtemTabuleiro(id));
            System.out.println ("obtemNumBolas01: " + speculate.obtemNumBolas(id));
            System.out.println ("ehMinhaVez01: " + speculate.ehMinhaVez(id));

            //JOGADOR 2
            System.out.println ("defineJogadas02: " + speculate.defineJogadas(id2, 2));
            System.out.println ("jogaDado02: " + speculate.jogaDado(id2));
            System.out.println ("jogaDado02: " + speculate.jogaDado(id2));

            System.out.println ("obtemTabuleiro02: " + speculate.obtemTabuleiro(id2));
            System.out.println ("obtemNumBolas02: " + speculate.obtemNumBolas(id2));
            System.out.println ("ehMinhaVez02: " + speculate.ehMinhaVez(id2));

            //JOGADOR 1
            System.out.println ("defineJogadas01: " + speculate.defineJogadas(id, 2));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));

            System.out.println ("obtemTabuleiro01: " + speculate.obtemTabuleiro(id));
            System.out.println ("obtemNumBolas01: " + speculate.obtemNumBolas(id));
            System.out.println ("ehMinhaVez01: " + speculate.ehMinhaVez(id));
        } catch (Exception e) {
            System.out.println ("HelloClient failed:"); 
            e.printStackTrace();
        }
    }
}