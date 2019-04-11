import java.rmi.Naming;
import java.util.Scanner;

public class SpeculateClient {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner (System.in);  
            SpeculateInterface speculate = (SpeculateInterface) Naming.lookup ("//localhost/Speculate"); 
           
            System.out.println ("Bem-vindo(a) ao Speculate!\n\n");  

            //Registro do usuário
            int id;
            while (true) {
                System.out.println ("Para começar, informe um usuário: \n");  
                String username = scan.nextLine(); 
            
                id = speculate.registraJogador(username);

                if (id == -1) {
                    System.out.println ("Usuário já está cadastrado. Tente novamente...\n\n");  
                    Thread.sleep(1000);
                } else if (id == -2) {
                    System.out.println ("Não há partidas no momento. Tente novamente mais tarde...\n\n");  
                    System.exit(0);
                } else {
                    System.out.println ("Obrigado!\n");  
                    break;
                }
            }
            
            //Aguardo do segundo jogador
            System.out.println ("Procurando outro jogador.\n");  
            System.out.print ("Aguarde...");  

            while (true) {
                int temPartida = speculate.temPartida(id);

                if (temPartida == -2) {
                    System.out.println ("Não encontramos outro jogador. Tente novamente mais tarde...\n\n");  
                    System.exit(0);
                } else if (temPartida == -1) {
                    System.out.println ("Ocorreu um erro inesperado...\n\n");  
                    System.exit(1);
                } else if (temPartida == 0) {
                    System.out.print(".");
                    Thread.sleep(2000);
                } else if (temPartida == 1) {
                    System.out.println ("Encontramos outro jogador e você inicia jogando.");  
                    System.out.println ("Jogador " + speculate.obtemOponente(id) + "está aguardando sua jogada.\n\n");  
                    break;
                } else if (temPartida == 2) {
                    System.out.println ("Encontramos outro jogador e ele inicia jogando.");  
                    System.out.println ("Aguarde enquanto " + speculate.obtemOponente(id) + "realiza sua jogada.\n\n");  
                    break;
                }
            }
            
            while (true) {
                int temPartida = speculate.ehMinhaVez(id);
                
                if (temPartida == -2) {
                    System.out.println ("Não encontramos outro jogador. Tente novamente mais tarde...\n\n");  
                    System.exit(0);
                } else if (temPartida == -1) {
                    System.out.println ("Ocorreu um erro inesperado...\n\n");  
                    System.exit(1);
                } else if (temPartida == 0) {
                    System.out.print(".");
                    Thread.sleep(2000);
                } else if (temPartida == 2) {
                    System.out.println("Você é o vencedor. Parabéns!\n");
                    break;
                } else if (temPartida == 3) {
                    System.out.println("Você perdeu.\n");
                    break;
                } else if (temPartida == 5) {
                    System.out.println("Você venceu por WO. Parabéns!\n");
                    break;
                } else if (temPartida == 6) {
                    System.out.println("Você perdeu por WO.\n");
                    break;
                } else if (temPartida == 1) {
                    //tratar jogadas.
                }

            }

            scan.close();

        } catch (Exception e) {
            System.out.println ("HelloClient failed:"); 
            e.printStackTrace();
        }
    }
}