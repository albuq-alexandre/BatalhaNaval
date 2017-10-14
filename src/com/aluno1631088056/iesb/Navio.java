package com.aluno1631088056.iesb;

import java.util.ArrayList;
import java.util.Random;

public class Navio {

    private int largura;
    private int comprimento;
    private String simbolo;
    private ArrayList<Integer[]> posicao;
    private ArrayList<Integer[]> avaria; // posição do navio que levou tiro
    private Random pos = new Random();

    public Navio(int largura, int comprimento, String simbolo, ArrayList<Integer[]> posicao) {


            this.largura = largura;
            this.comprimento = comprimento;
            this.simbolo = simbolo;


        if (simbolo == "P") switch (pos.nextInt(4)) {

            case 3: {
                posicao.remove(8);
                posicao.remove(6);
                posicao.remove(5);
                posicao.remove(3);
                break;
            }
            case 2: {
                posicao.remove(5);
                posicao.remove(3);
                posicao.remove(2);
                posicao.remove(0);
                break;
            }
            case 1: {
                posicao.remove(8);
                posicao.remove(7);
                posicao.remove(2);
                posicao.remove(1);
                break;
            }
            case 0: {
                posicao.remove(7);
                posicao.remove(6);
                posicao.remove(1);
                posicao.remove(0);
            }
        }

        this.posicao = posicao;
    }

    public ArrayList<Integer[]> getAvaria() {
        return avaria;
    }

    public void setAvaria(ArrayList<Integer[]> avaria) {
        this.avaria = avaria;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setPosicao(ArrayList<Integer[]> posicao) {
        this.posicao = posicao;
    }

    public int getLargura() {
        return largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public ArrayList<Integer[]> getPosicao() {
        return posicao;
    }







}
