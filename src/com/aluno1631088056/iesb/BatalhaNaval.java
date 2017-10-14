package com.aluno1631088056.iesb;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) {

        List<Navio> frota;
        frota = new ArrayList<Navio>();

        Tabuleiro t1 = new Tabuleiro();

        //Criar o Porta Aviões e outros navios

        Navio portaAvioes = new Navio(3, 3, "P", t1.posicaoParaNavio(3, 3));
        t1.posicionaNavio(portaAvioes);
        frota.add(portaAvioes);

        Navio n4canos = new Navio(1, 4, "N", t1.posicaoParaNavio(1, 4));
        t1.posicionaNavio(n4canos);
        frota.add(n4canos);

        Navio n3canos1 = new Navio(1, 3, "N", t1.posicaoParaNavio(1, 3));
        t1.posicionaNavio(n3canos1);
        Navio n3canos2 = new Navio(1, 3, "N", t1.posicaoParaNavio(1, 3));
        t1.posicionaNavio(n3canos2);
        frota.add(n3canos1);
        frota.add(n3canos2);

        Navio n2canos1 = new Navio(1, 2, "N", t1.posicaoParaNavio(1, 2));
        t1.posicionaNavio(n2canos1);
        Navio n2canos2 = new Navio(1, 2, "N", t1.posicaoParaNavio(1, 2));
        t1.posicionaNavio(n2canos2);
        Navio n2canos3 = new Navio(1, 2, "N", t1.posicaoParaNavio(1, 2));
        t1.posicionaNavio(n2canos3);
        frota.add(n2canos1);
        frota.add(n2canos2);
        frota.add(n2canos3);

        Navio n1canos1 = new Navio(1, 1, "N", t1.posicaoParaNavio(1, 1));
        t1.posicionaNavio(n1canos1);
        Navio n1canos2 = new Navio(1, 1, "N", t1.posicaoParaNavio(1, 1));
        t1.posicionaNavio(n1canos2);
        Navio n1canos3 = new Navio(1, 1, "N", t1.posicaoParaNavio(1, 1));
        t1.posicionaNavio(n1canos3);
        Navio n1canos4 = new Navio(1, 1, "N", t1.posicaoParaNavio(1, 1));
        t1.posicionaNavio(n1canos4);
        frota.add(n1canos1);
        frota.add(n1canos2);
        frota.add(n1canos3);
        frota.add(n1canos4);


        // Define os 3 tiros e inicia os seus resultados
        String[] tiros = new String[3];
        String[] eixoY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int acertos = 0;

        //Inicia o jogo


        System.out.println("");
        System.out.println("");
        System.out.println("Recebendo Mensagem...");
        System.out.println("");
        outcomeMessage("Bem Vindo Contra-Almirante! Nesta Batalha Naval temos um Grande Desafio a você:");
        System.out.println("");
        outcomeMessage("Precisamos que acerte pelo menos 1 dos últimos três tiros que temos em nosso arsenal");
        System.out.println("");
        outcomeMessage("Acerte 3 tiros para ser Promovido.");
        System.out.println(" ");
        outcomeMessage("Veja em nosso radar sua Grelha de Ataque:");
        System.out.println(" ");
        System.out.println(" ");

        t1.imprimeTabuleiro();
        System.out.println("");


        for (int i = 0; i < 3; i++) {

            System.out.println("");
            System.out.println("Tiro " + (i + 1) + " ==>");
            System.out.println("");

            int[] coord = lerCoordenada();

            if (coord[0] == 99) {
                t1.imprimeFrota();
                System.out.println("");
                System.out.println("");
                coord = lerCoordenada();
            }

            int lin = coord[0];
            int col = coord[1];

            if (t1.tposicao[lin][col] != "~") {
                tiros[i] = "Acertou um navio bandeira " + t1.tposicao[lin][col] + " na posição " + eixoY[lin] + (col + 1) + "!";
                t1.tabuleiro[lin][col] = "♨︎";
                acertos++;
            } else if (t1.tposicao[lin][col] == "~") {
                tiros[i] = "Acertou a água na posição " + eixoY[lin] + (col + 1) + " -> Tiro Perdido!";
                t1.tabuleiro[lin][col] = "⦿";
            } else if (t1.tposicao[lin][col] == "♨︎") {
                tiros[i] = "Acertou um Tiro anterior " + eixoY[lin] + (col + 1) + " -> Tiro Perdido!";
            } else if (t1.tposicao[lin][col] == "⦿") {
                tiros[i] = "Acertou a água *NOVAMENTE* na posição " + eixoY[lin] + (col + 1) + " -> Tiro Perdido!";
            } else {
                tiros[i] = "Munição Falhou - Não foi possível identificar a posição -> Tiro Perdido!";
            }

        }

        t1.imprimeFrota();
        System.out.println("");

        t1.imprimeTabuleiro();
        System.out.println("");
        System.out.println("");

        for (String tiro : tiros) {
            outcomeMessage(tiro);
            System.out.println("");
        }

        System.out.println("");
        System.out.println("");
        switch (acertos) {
            case 0: {
                outcomeMessage("Contra-Almirante, não conquistou acertos e foi rebaixado a Segunto-Tenente!");
                System.out.println("");
                outcomeMessage("Você pode melhorar! Tente novamente em um novo jogo... até a próxima!");
                System.out.println("");
                break;
            }
            case 1: {
                outcomeMessage("Contra-Almirante, você conquistou apenas 1 acerto e foi rebaixado a Capitão-Tenente!");
                System.out.println("");
                outcomeMessage("Você pode melhorar! Tente novamente em um novo jogo... até a próxima!");
                System.out.println("");
                break;
            }
            case 2: {
                outcomeMessage("Contra-Almirante, você conquistou 2 acertos e foi rebaixado a Capitão-de-Mar-e-Guerra!");
                System.out.println("");
                outcomeMessage("Você pode melhorar! Tente novamente em um novo jogo... até a próxima!");
                System.out.println("");
                break;

            }

            case 3: {
                outcomeMessage("Contra-Almirante, você conquistou a Glória! Vencemos!!!");
                System.out.println("");
                outcomeMessage("Você se tornou nosso Herói de Guerra e foi PROMOVIDO a Almirante!");
                System.out.println("");
                outcomeMessage("Com a paz reestabelecida, vc comandará nossa Marinha como Almirante-de-Esquadra, Parabéns!!!!");
                break;
             }
             default: break;
        }

        System.out.println("");
        outcomeMessage("Fim do Jogo!...");
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }


    public static int[] lerCoordenada() {
        Scanner entrada = new Scanner(System.in);
        String Coord = "", Linha = "";
        String eixo = "ABCDEFGHIJ";
        int[] result = {0, 0};
        int lin = 0, col = 0;
        try {
            System.out.println("Informe a linha(A-J) e a coluna (1-10) ex: E10");
            Coord = entrada.nextLine();
            Coord = Coord.toUpperCase();
            Linha = Coord.substring(0, 1);
            //Linha = Coord.substring(1,1);


            if (Linha == "") return (lerCoordenada());

            if (Coord.equals("CHEATCODE")) {

                result = new int[]{99, 99};
                return result;
            }

            lin = eixo.indexOf(Linha);

            if (lin >= 0 && lin <= 9) {
                result[0] = lin;
            } else {
                System.out.println("Linha inválida!!!");
                return (lerCoordenada());
            }

            col = Integer.parseInt(Coord.substring(1));

            if (col >= 1 && col <= 10) {
                result[1] = col - 1;
            } else {
                System.out.println("Coluna inválida!!!");
                return (lerCoordenada());
            }


        } catch (Exception e) {
            System.out.println("Coordenada inválida!!!");
            return (lerCoordenada());
        }

        return result;

    }

    public static void outcomeMessage(String message) {
        int i = 0;
        while ((i < message.length())) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(50);
                i++;
            } catch (Exception e) {
                System.out.println("Mensagem interrompida..." + e.getLocalizedMessage());
                break;
            }


        }
    }




}


