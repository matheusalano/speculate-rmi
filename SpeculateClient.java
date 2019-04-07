import java.rmi.Naming;

public class SpeculateClient {

    public static void main(String[] args) {
        try {
            SpeculateInterface speculate = (SpeculateInterface) Naming.lookup ("//localhost/Speculate"); 
            System.out.println ("encerraPartida01: " + speculate.encerraPartida(3113001));
            int id = speculate.registraJogador("matheusalano"); System.out.println ("registraJogador01: " + id);
            System.out.println ("registraJogador01: " + speculate.registraJogador("matheusalano"));
            System.out.println ("encerraPartida01: " + speculate.encerraPartida(id));
            id = speculate.registraJogador("matheusalano"); System.out.println ("registraJogador01: " + id);
            System.out.println ("temPartida01: " + speculate.temPartida(id));
            System.out.println ("obtemOponente01: " + speculate.obtemOponente(id));
            System.out.println ("ehMinhaVez01: " + speculate.ehMinhaVez(id));
            System.out.println ("obtemNumBolas01: " + speculate.obtemNumBolas(id));
            System.out.println ("obtemNumBolasOponente01: " + speculate.obtemNumBolasOponente(id));
            System.out.println ("obtemTabuleiro01: " + speculate.obtemTabuleiro(id));
            System.out.println ("defineJogadas01: " + speculate.defineJogadas(id, 10));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));

            int id2 = speculate.registraJogador("domisobrosa"); System.out.println ("registraJogador02: " + id);

            System.out.println ("defineJogadas01: " + speculate.defineJogadas(id, 15));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
            System.out.println ("jogaDado01: " + speculate.jogaDado(id));
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