package prog3;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Tabuleiro t1 = new Tabuleiro();
        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        
        Stack <Tabuleiro> ts = new Stack<>();
        Scanner e = new Scanner(System.in);
        Random gerador = new Random();
        
        int l, c;
        ts.push(new Tabuleiro());
        j1.setT(t1);
        System.out.println("Jogo da Velha");
        t1.iniciarTabuleiro();
        j1.setT(t1);
        j2.setT(t1);
        t1.desenhar();
        
        while (!t1.verificarGanhador() && !t1.empate()) {
            do {
                System.out.print("Digite a linha e coluna da jogada, separados por espaco: ");
                l = e.nextInt();
                c = e.nextInt();
            } while (!t1.verificarPosicao(l, c));
            j1.jogar(l, c, 'X');
          
            if (!t1.empate() && !t1.verificarGanhador()) {
                do {
                    l = gerador.nextInt(3);
                    c = gerador.nextInt(3);
                } while (!t1.verificarPosicao(l, c));
                j2.jogar(l, c, 'O');
            }
            
            Tabuleiro t = new Tabuleiro(t1);
            ts.push(t);
            t.desenhar();
            
            String v = "n";
            
            do {
                System.out.println("Voltar a jogar? (S/N)");
                v = e.next();
                if (v.equals("s") && ts.size() > 0) {
                    System.out.println("Voltando... ");
                    t1 = ts.pop();
                    if (!ts.isEmpty()) {
                        t1 = ts.pop();
                    }
                }
                Tabuleiro tp = new Tabuleiro(t1);
                ts.push(tp);
                j1.setT(t1);
                j2.setT(t1);
                t.desenhar();
            } while (v.equals("s"));
            
            /*e = new Scanner(System.in);
            System.out.println("Deseja refazer a joga? S/N");
            String r = e.nextLine();
            while(!"N".equals(r)){
                if (r.equals("s")) {
                    System.out.println("Voltando... ");
                    t1 = ts.pop();
                    if (!ts.isEmpty()) {
                        t1 = ts.pop();
                    }
                }
                Tabuleiro tp = new Tabuleiro(t1);
                ts.push(tp);
                j1.setT(t1);
                j2.setT(t1);
                t.desenhar();
            }
            
            /*
            t1.desenhar();
            s = new Scanner(System.in);
            System.out.println("Deseja refazer a jogada? S/N");
            String r = s.next();
            
            if ("S".equalsIgnoreCase(r)) {
                u = j.pop();
                t1.jogar(u.getLinha(), u.getColuna(), '-');
                t1.desenhar();
            }
            
            System.out.println("Deseja refazer mais? S/N");
            r = s.next();
            
            while ("S".equalsIgnoreCase(r)) {
                u = j.pop();
                t1.jogar(u.getLinha(), u.getColuna(), '-');
                t1.desenhar();
                System.out.println("Deseja refazer mais? S/N");
                r = s.next();
            }
            
            
            System.out.println("Deseja refazer a joga? S/N");
            String r = s.nextLine();
            while(!"N".equals(r)){
                 if (!j.isEmpty()) {
                    u = j.pop();
                t1.jogar( u.getLinha(), u.getColuna(), '-');
                u = j.pop();
                t1.jogar( u.getLinha(), u.getColuna(), '-');
                }
                
                t1.desenhar();
                s = new Scanner(System.in);
                System.out.println("Deseja refazer mais? S/N");
                r = s.nextLine();
                //t1.desenhar();
                
            }*/
        }

    }

}
