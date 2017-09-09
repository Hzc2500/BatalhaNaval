
package batalhanaval;

import java.util.Random;



public class Navios {
    int[] navioUm = new int[2]; //navio de um espaço
    int[] navioUm2 = new int[2];
    int[] navioDois = new int[4]; //navio de dois espaços
    int[] navioDois2 = new int[4];
    int[] navioTres = new int[6]; //navio de tres espaços
    
    void inicializarNavios()
    {
        Random gerador = new Random();     
        
        //navios de um espaço
        for (int i = 0; i < 2; i++) {
            if (i == 0)
            {
                //gerar linha
                navioUm[i] = gerador.nextInt(3);
                navioUm2[i] = gerador.nextInt(3);
            } else {
            navioUm[i] = gerador.nextInt(10);
            navioUm2[i] = gerador.nextInt(10);
            }
            if (navioUm[0] == navioUm2[0] && navioUm[1] == navioUm2[1]) i = -1;
        }
        
        //navios de dois espaços
        for (int i = 0; i < 2; i++) {
            if (i % 2 == 0){
                //gerar linha
                navioDois[i] = 6 + gerador.nextInt(4);
                navioDois2[i] = 6 + gerador.nextInt(4);
            } else {
                navioDois[i] = gerador.nextInt(9);
                navioDois2[i] = gerador.nextInt(9);
            }
        if (navioDois[0] == navioDois2[0]) i = -1;  
        }
        navioDois[2] = navioDois[0];
        navioDois[3] = navioDois[1] + 1;
        navioDois2[2] = navioDois2[0];
        navioDois2[3] = navioDois2[1] + 1;
        
        
        //navio de tres espaços
        for (int i = 0; i < 2; i++) {
            if (i % 2 == 0) navioTres[i] = 3 + gerador.nextInt(3);
            else navioTres[i] = gerador.nextInt(8);
        }        
        navioTres[2] = navioTres[0];
        navioTres[3] = navioTres[1]+1;
        navioTres[4] = navioTres[0];
        navioTres[5] = navioTres[1]+2;
    }

}
