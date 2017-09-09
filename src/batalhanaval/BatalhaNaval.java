
package batalhanaval;

import java.util.Scanner;


public class BatalhaNaval {

    
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        Tabela batalhaNaval = new Tabela();
        Navios naviosCpu = new Navios();
        Navios naviosJogador = new Navios();
        naviosJogador.inicializarNavios();
        naviosCpu.inicializarNavios();
        batalhaNaval.inicializarTabelas();
        batalhaNaval.preencherNavios(naviosCpu, naviosJogador);
        String turno = "Jogador";
        int linha;
        int coluna;
        int acertos = 0;
        int acertosCpu = 0;
        
        while ("".equals(batalhaNaval.getVencedor())){
            if ("Jogador".equals(turno)) {   
                turno = "Cpu";
                batalhaNaval.imprimirTabela(turno);
                linha = sc.nextInt() - 1;
                coluna = sc.nextInt() - 1;
                while (linha<0 || linha>9 || coluna<0 || coluna>9){
                    System.out.println("Por favor digite valores de 1 à 10 (linha e coluna)");
                    linha = sc.nextInt() - 1;
                    coluna = sc.nextInt() - 1;
                }
                acertos = batalhaNaval.atacarNavio(linha, coluna, acertos);
            } else {
                turno = "Jogador";
                batalhaNaval.imprimirTabela(turno);
                acertosCpu = batalhaNaval.atacarNavioCpu(acertosCpu);
            }
            if (acertos == 9 || acertosCpu == 9)
            {
                batalhaNaval.setVencedor(acertos == 9 ? "Jogador" : "Cpu");
            }
        }
        System.out.println("O GRANDE VENCEDOR FOI " + batalhaNaval.getVencedor() + " PARABENS!!!");
    }
    
}
