
package prog3;
import java.util.Random;
import java.util.Scanner;

public class Correções {
	
	 public static char matriz[][] = new char[3][3];
	 
		public static void main(String[] args) {
			System.out.println("Jogo da Velha");	
			Scanner s = new Scanner(System.in);
	        Random gerador = new Random();
	        iniciarTabuleiro();
	        int linha, coluna;
	        desenhar();                      
			while(!verificarGanhador() && !empate()) {		
				do {
					System.out.print("Digite a linha e coluna da jogada, separados por espaco: ");
					linha = s.nextInt();	
					coluna = s.nextInt();				
				}while(!verificarPosicao(linha, coluna));
				jogar(linha, coluna, 'X');
				
				if(!empate() && !verificarGanhador()){
					do {
						linha = gerador.nextInt(3);
						coluna = gerador.nextInt(3);				
					}while(!verificarPosicao(linha, coluna));				
					jogar(linha, coluna, 'O');
				}									
				desenhar();											
			}

		}
	 
     public static void iniciarTabuleiro() {
	     for (int i = 0; i <= 2; i++) {
	         for (int j = 0; j <= 2; j++) {             
	             matriz[i][j] = '-';
	         }
	     }
     }
               
	public static void desenhar() {
		System.out.println("TABULEIRO");
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }	
	}
	
	public static boolean verificarPosicao(int l, int c) {
		if(matriz[l][c] == '-') {
			return true;
		}
		return false;
	}
	
	public static boolean empate() {
		int cont = 0;
		for (int i = 0; i <= 2; i++) {
	        for (int j = 0; j <= 2; j++) {             
	            if(matriz[i][j] != '-'){
					cont++;
				}
	         }
	    }
		if(cont == 9 && !verificarGanhador()) {
			System.out.println("Empate!");
			return true;
		}
		return false;
	}
	
	public static void jogar(int l, int c, char x) {
		matriz[l][c] = x;
	}
	 
	
	public static boolean verificarGanhador() {
		if((matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] != '-') || 
				(matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] != '-')){
			System.out.println("Venceu o jogador: " + matriz[1][1]);			
			return true;
		}
		for(int i = 0; i < 3; i++){
			if(matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] != '-'){
				System.out.println("Venceu o jogador: " + matriz[i][1]);				
				return true;
			}
			if(matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[0][i] != '-'){
				System.out.println("Venceu o jogador: " + matriz[1][i]);				
				return true;
		    }
		}
		return false;
	}

}


