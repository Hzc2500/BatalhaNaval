
package batalhanaval;

import java.util.Random;


public class Tabela {
    private String vencedor = "";
    public String Jogador[][] = new String[10][10];
    public String Cpu[][] = new String [10][10];
    private int[] tirosCpu = new int[200];
    private int qtdTirosCpu = 0;
    private int linhaCerta;
    private int colunaCerta;
    private int contador = 0;
    private int contador2 = 0;
    private int contador3 = 0;
    Random gerador = new Random(); 
    
    
    void imprimirTabela(String turno)
    {
        System.out.println("     1   2   3   4   5   6   7   8   9   10");
        System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
        for (int i = 0; i < 10; i++) {
            System.out.print(i == 9 ? i+1 : i+1 + " ");
            for (int j = 0; j < 10; j++) {
                if  ("Jogador".equals(turno)) {
                    System.out.print("O".equals(Jogador[i][j]) ? " | ~" : " | "+ Jogador[i][j]);
                }
                else {
                    System.out.print("O".equals(Cpu[i][j]) ? " | ~" : " | "+ Cpu[i][j]);
                }
            }
        System.out.println(" |");
        System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
        }
    if ("Cpu".equals(turno)){
        System.out.println("\n Jogador - escolha a linha e coluna que deseja atacar");
    } else System.out.println("\n Cpu - escolha a linha e coluna que deseja atacar");
    }


    void inicializarTabelas()
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Jogador[i][j] = "~";
                Cpu[i][j] = "~";
            }
        }
    }
    
    int atacarNavio(int linha, int coluna, int acertos)
    {
        if ("O".equals(Cpu[linha][coluna]))
        {
            System.out.println("Você acertou um navio!!!");
            Cpu[linha][coluna] = "X";
            return acertos+1;
        } else System.out.println("Jogador errou!!!");
    return acertos;
    }
    
    void preencherNavios(Navios naviosCpu, Navios naviosJogador)
    {
        //Prencher navios de 1 espaço primeiro
        Cpu[naviosCpu.navioUm[0]][naviosCpu.navioUm[1]] = "O";
        Cpu[naviosCpu.navioUm2[0]][naviosCpu.navioUm2[1]] = "O";
        Jogador[naviosJogador.navioUm[0]][naviosJogador.navioUm[1]] = "O";
        Jogador[naviosJogador.navioUm2[0]][naviosJogador.navioUm2[1]] = "O";
        
        //Preencher navios de 2 espaços
        for (int i = 0; i < 4; i=i+2) {
            Cpu[naviosCpu.navioDois[i]][naviosCpu.navioDois[i+1]] = "O";
            Cpu[naviosCpu.navioDois2[i]][naviosCpu.navioDois2[i+1]] = "O";
            Jogador[naviosJogador.navioDois[i]][naviosJogador.navioDois[i+1]] = "O";
            Jogador[naviosJogador.navioDois2[i]][naviosJogador.navioDois2[i+1]] = "O";
        }
        
        //Preenchar navios de 3 espaços
        for (int i = 0; i < 6; i=i+2) {
            Cpu[naviosCpu.navioTres[i]][naviosCpu.navioTres[i+1]] = "O";
            Jogador[naviosJogador.navioTres[i]][naviosJogador.navioTres[i+1]] = "O";           
        }

    }
    
   
    public String getVencedor() {
    return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    int atacarNavioCpu(int acertosCpu) {
         
    int linha;
    int coluna;
    
        if(acertosCpu < 2) {
            linha = gerador.nextInt(3);
            coluna = gerador.nextInt(10);
            tirosCpu[qtdTirosCpu] = linha;
            tirosCpu[qtdTirosCpu+1] = coluna;
            qtdTirosCpu = qtdTirosCpu+2;

        } else if (acertosCpu >= 2 && acertosCpu < 5)
        {
            linha = 3 + gerador.nextInt(3);
            coluna = gerador.nextInt(8);
            if (acertosCpu > 2) {
                    if (contador == 0) {
                        linhaCerta =  tirosCpu[qtdTirosCpu-2];
                        colunaCerta = tirosCpu[qtdTirosCpu-1];
                    }
                linha = linhaCerta;
                switch (contador)
                {
                    case 0:
                        coluna = colunaCerta+1;
                        break;
                    case 1:
                        coluna = colunaCerta+2;
                        break;
                    case 2:
                        coluna = colunaCerta-1;
                        break;
                    case 3:
                        coluna = colunaCerta-2;
                        break;
                }
                contador++;
            }
            tirosCpu[qtdTirosCpu] = linha;
            tirosCpu[qtdTirosCpu+1] = coluna;
            qtdTirosCpu = qtdTirosCpu+2; 
        }
        else {
            linha = 6 + gerador.nextInt(4);
            coluna = gerador.nextInt(9);
            if (acertosCpu == 6) {
                    if (contador2 == 0) {
                        linhaCerta =  tirosCpu[qtdTirosCpu-2];
                        colunaCerta = tirosCpu[qtdTirosCpu-1];
                    }
                linha = linhaCerta;
                switch (contador2)
                {
                    case 0:
                        coluna = colunaCerta+1;
                        break;
                    case 1:
                        coluna = colunaCerta-1;
                        break;
                }
                contador2++;
            }
            if (acertosCpu == 8) {
                    if (contador3 == 0) {
                        linhaCerta =  tirosCpu[qtdTirosCpu-2];
                        colunaCerta = tirosCpu[qtdTirosCpu-1];
                    }
                linha = linhaCerta;
                switch (contador3)
                {
                    case 0:
                        coluna = colunaCerta+1;
                        break;
                    case 1:
                        coluna = colunaCerta-1;
                        break;
                }
                contador3++;
            }   
            tirosCpu[qtdTirosCpu] = linha;
            tirosCpu[qtdTirosCpu+1] = coluna;
            qtdTirosCpu = qtdTirosCpu+2; 
        }
        
        for (int i = 0; i < qtdTirosCpu; i=i+2) {
            for (int j = 0; j < qtdTirosCpu; j=j+2) {
                if (i==j) continue;
                if (tirosCpu[i] == tirosCpu[j] && tirosCpu[i+1] == tirosCpu[j+1])
                {   
                    if(acertosCpu < 2) {
                        linha = gerador.nextInt(3);
                        coluna = gerador.nextInt(10);
                    }
                    else if(acertosCpu >=2 && acertosCpu<5) {
                        linha = 3 + gerador.nextInt(3);
                        coluna = gerador.nextInt(7);
                    }
                    else {
                        linha = 6 + gerador.nextInt(4);
                        coluna = gerador.nextInt(9);
                    }
                    tirosCpu[qtdTirosCpu-2] = linha;
                    tirosCpu[qtdTirosCpu-1] = coluna;
                    //j = j-2;
                    i = 0;
                    break;
                }
            }
        }
            
        try {
            System.out.print("Realizando disparo .");
            Thread.sleep(1500);   
            System.out.print(".");
            Thread.sleep(1500);   
            System.out.println(".");
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        if ("O".equals(Jogador[linha][coluna]))
        {
            System.out.println("Cpu acertou um navio!!!");
            Jogador[linha][coluna] = "X";
            return acertosCpu+1;
        } else System.out.println("Cpu errou!!!");
        
    return acertosCpu;   
    }          
    
}

