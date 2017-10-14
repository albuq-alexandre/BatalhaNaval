package com.aluno1631088056.iesb;


import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {
    public String tabuleiro[][] = new String[10][10]; //tabuleiro  10x10//
    public String tposicao[][] = new String[10][10]; //array para as posicoes dos barcos no tabuleiro//
    public String[] eixoY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; //label do eixo y//

    public Tabuleiro() {
        zeraPosicao();
        limpaTabuleiro();
    }

    public void zeraPosicao() { // limpa as posições do tabuleiro
        for (int l = 0; l < 10; l++) {//preenche as linhas com 0//
            for (int c = 0; c < 10; c++) {//preenche as colunas com 0//
                tposicao[l][c] = "~";
            }
        }
    }

    public void limpaTabuleiro() {
        for (int l = 0; l < 10; l++) {//preenche as linhas com elementos de 1 a 10//
            for (int c = 0; c < 10; c++) {//preenche as colunas com elementos de 1 a 10//
                tabuleiro[l][c] = " ";
            }
        }
    }


    public void imprimeTabuleiro() {
        System.out.println("Grelha de Ataque"); //numero da coluna
        System.out.println("    1   2   3   4   5   6   7   8   9   10"); //numero da coluna
        System.out.println("  _________________________________________");
        for (int l = 0; l < 10; l++) {//preenche as linhas com elementos de 0 a 7//
            System.out.print(eixoY[l] + " ");   //numero da linhas do lado do tabuleiro
            for (int c = 0; c < 10; c++) {//preenche as colunas com elementos de 0 a 7//
                System.out.print("| " + tabuleiro[l][c] + " ");
            }
            System.out.println("|");
            System.out.println("  _________________________________________");
        }
    }

    public void imprimeFrota() {
        System.out.println("Grelha de Defesa"); //numero da coluna
        System.out.println("    1   2   3   4   5   6   7   8   9   10"); //numero da coluna
        System.out.println("  _________________________________________");
        for (int l = 0; l < 10; l++) {//preenche as linhas com elementos de 0 a 7//
            System.out.print(eixoY[l] + " ");   //numero da linhas do lado do tabuleiro
            for (int c = 0; c < 10; c++) {//preenche as colunas com elementos de 0 a 7//
                System.out.print("| " + tposicao[l][c] + " ");
            }
            System.out.println("|");
            System.out.println(" __________________________________________");
        }
    }

    public ArrayList<Integer[]> posicaoParaNavio(int largura, int comprimento) throws IllegalArgumentException {

        /* retorna um array de coordenadas vazias para colocar o navio. */

        ArrayList<Integer[]> posicoes = new ArrayList<Integer[]>();
        Random aleatorio = new Random();
        Random posicao = new Random();
        int inversor = largura;

        boolean ocupado = true;

        // lança um erro se o método for chamado com dimensões negativas ou maiores que o tabuleiro
        if (largura < 0 || comprimento < 0) throw new IllegalArgumentException("Largura/Comprimento inválidos");
        if (largura > tabuleiro.length || comprimento > tabuleiro[0].length)
            throw new IllegalArgumentException("Largura/Comprimento inválidos");

        // inicializa as posicoes nas dimensões solicitadas

        if ((posicao.nextInt(50) % 2) > 0) {
            largura = comprimento;
            comprimento = inversor;
        }

        do {
            ocupado = false;
            posicoes.clear();
            // sorteia a primeira posição
            int li = aleatorio.nextInt(tabuleiro.length - largura);
            int ci = aleatorio.nextInt(tabuleiro[0].length - comprimento);

            for (int l = li; l < largura + li; l++) {
                for (int c = ci; c < comprimento + ci; c++) {
                    if (!tposicao[l][c].equals("~")) {
                        ocupado = true;
                        continue;
                    }

                    posicoes.add(new Integer[]{l, c});

                }
            }
        } while (ocupado);

        return posicoes;
    }

    public boolean posicionaNavio(Navio navio) {

        ArrayList<Integer[]> posicaoNavio = navio.getPosicao();

        posicaoNavio.forEach( c -> {
            tposicao[c[0]][c[1]] = navio.getSimbolo();
        });

        return true;

    }
}
