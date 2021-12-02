

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author agata
 */

/**Não consegui tratar a modo de entrada para o jogo definido 
        (linha,coluna,valor). Portando deve-se entrar com os valores separadamente*/
public class Sudoku {
    
    /* @function verificaMovimento Função que verifica se determinado valor não se repete em linha, coluna, ou quadrado 3x3
    @param linha Linha de verificação
    @param coluna Coluna de verificação
    @param valor Valor de verificação
    @tabuleiro[][] Tabuleiro para se fazer a verificação
    @return true = movimento válid/false = movimento invalido
    */
    public static boolean verificaMovimento(int linha, int coluna, int valor, int tabuleiro[][]) {
        int valorX = 0;
        int valorY = 0;

        for (int i = 0; i < 9; i++) {
            if (valor == tabuleiro[linha][i]) {
                return false;
            }

        }

        for (int i = 0; i < 9; i++) {
            if (valor == tabuleiro[i][coluna]) {
                return false;
            }
        }

        if (linha > 2) {
            if (linha > 5) {
                valorX = 6;
            } else {
                valorX = 3;
            }
        }
        if (coluna > 2) {
            if (coluna > 5) {
                valorY = 6;
            } else {
                valorY = 3;
            }
        }
        for (int i = valorX; i < 10 && i < valorX + 3; i++) {
            for (int j = valorY; j < 10 && j < valorY + 3; j++) {
                if (valor == tabuleiro[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    /* @function vdefinido Função que cria um tabuleiro baseado no que o usuario digitar
    @param tabuleiro[][] Tabuleiro de sudoku
    @param tabuleiroAuxiliar[][] Tabuleiro de Sudoku Auxiliar
    */
    public static void definido(int tabuleiro[][], int tabuleiroAuxiliar[][]) {
        Scanner ler = new Scanner(System.in);
        int linha, coluna, valor;
        System.out.println("Entre com linha, coluna e valor!");
        System.out.println("Linha:");
        linha = ler.nextInt() - 1;
        while (linha < 0 || linha >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            linha = ler.nextInt() - 1;
        }
        System.out.println("Coluna:");
        coluna = ler.nextInt() - 1;
        while (coluna < 0 || coluna >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            coluna = ler.nextInt() - 1;
        }
        System.out.println("Valor:");
        valor = ler.nextInt();
        while (valor < 0 || valor >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            valor = ler.nextInt() - 1;
        }
        if (linha != -1 && coluna != -1 && valor != -1) {
            while (verificaMovimento(linha, coluna, valor, tabuleiro) == false && linha != -1 && coluna != -1 && valor != -1) {
                System.out.println("Movimento invalido, digite novamente");
                System.out.println("Linha:");
                linha = ler.nextInt() - 1;
                while (linha < 0 || linha >= 9) {
                    System.out.println("Entrada inválida, digite novamente:");
                    linha = ler.nextInt() - 1;
                }
                System.out.println("Coluna:");
                coluna = ler.nextInt() - 1;
                while (coluna < 0 || coluna >= 9) {
                    System.out.println("Entrada inválida, digite novamente:");
                    coluna = ler.nextInt() - 1;
                }
                System.out.println("Valor:");
                valor = ler.nextInt();
                while (valor < 0 || valor >= 9) {
                    System.out.println("Entrada inválida, digite novamente:");
                    valor = ler.nextInt() - 1;
                }
            }
        }
        while (linha != -1 && coluna != -1 && valor != -1) {
            tabuleiro[linha][coluna] = valor;
            System.out.println("Linha:");
            linha = ler.nextInt() - 1;
            while (linha < 0 || linha >= 9) {
                System.out.println("Entrada inválida, digite novamente:");
                linha = ler.nextInt() - 1;
            }
            System.out.println("Coluna:");
            coluna = ler.nextInt() - 1;
            while (coluna < 0 || coluna >= 9) {
                System.out.println("Entrada inválida, digite novamente:");
                coluna = ler.nextInt() - 1;
            }
            System.out.println("Valor:");
            valor = ler.nextInt();
            while (valor < 0 || valor >= 9) {
                System.out.println("Entrada inválida, digite novamente:");
                valor = ler.nextInt() - 1;
            }
            if (linha != -1 && coluna != -1 && valor != -1) {
                while (verificaMovimento(linha, coluna, valor, tabuleiro) == false && linha != -1 && coluna != -1 && valor != -1) {
                    System.out.println("Movimento invalido, digite novamente");
                    System.out.println("Linha:");
                    linha = ler.nextInt() - 1;
                    while (linha < 0 || linha >= 9) {
                        System.out.println("Entrada inválida, digite novamente:");
                        linha = ler.nextInt() - 1;
                    }
                    System.out.println("Coluna:");
                    coluna = ler.nextInt() - 1;
                    while (coluna < 0 || coluna >= 9) {
                        System.out.println("Entrada inválida, digite novamente:");
                        coluna = ler.nextInt() - 1;
                    }
                    System.out.println("Valor:");
                    valor = ler.nextInt();
                    while (valor < 0 || valor >= 9) {
                        System.out.println("Entrada inválida, digite novamente:");
                        valor = ler.nextInt() - 1;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabuleiroAuxiliar[i][j] = tabuleiro[i][j];
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }

    }
    /* @function aleatorio Função que cria um tabuleiro e mostra certos valores
    @param qtdeSorteados Qtde de valores do tabuleiro que serão mostrados
    @param tabuleiro[][] Gabarito do sudoku
    @param aleatorio[][] Tabuleiro de sudoku
    @param auxiliar[][] Tabuleiro de Sudoku Auxiliar
    */
    public static void aleatorio(int qtdeSorteados, int tabuleiro[][], int aleatorio[][], int auxiliar[][]) {
        int linha, coluna;

        /*for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                System.out.print(auxiliar[i][j] + " ");
            } 
            System.out.println();
        }*/
        for (int i = 0; i < qtdeSorteados; i++) {
            linha = (int) (Math.random() * (9));
            coluna = (int) (Math.random() * (9));
            while (aleatorio[linha][coluna] != 0) {
                linha = (int) (Math.random() * (9));
                coluna = (int) (Math.random() * (9));
            }
            aleatorio[linha][coluna] = tabuleiro[linha][coluna];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                auxiliar[i][j] = aleatorio[i][j];
                System.out.print(aleatorio[i][j] + " ");
            }
            System.out.println();
        }
    }
    /* @function jogada Função que realiza um movimento no jogo
    @param tabuleiro[][] Tabuleiro de sudoku
    */
    public static void jogada(int tabuleiro[][]) {
        int linha, coluna, valor;
        Scanner ler = new Scanner(System.in);
        char dica;
        System.out.println("Deseja dica? S/N:");
        dica = ler.next().charAt(0);
        while (dica != 'S' && dica != 's' && dica != 'N' && dica != 'n') {
            System.out.println("Entrada inválida, digite novamente:");
            dica = ler.next().charAt(0);
        }
        if (dica == 'S' || dica == 's') {
            System.out.println("Linha da dica:");
            linha = ler.nextInt() - 1;
            while (linha < 0 || linha >= 9) {
                System.out.println("Entrada inválida, digite novamente:");
                linha = ler.nextInt() - 1;
            }
            System.out.println("Coluna da dica");
            coluna = ler.nextInt() - 1;
            while (coluna < 0 || coluna >= 9) {
                System.out.println("Entrada inválida, digite novamente:");
                coluna = ler.nextInt() - 1;
            }
            for (int i = 1; i <= 9; i++) {
                if (verificaMovimento(linha, coluna, i, tabuleiro)) {
                    System.out.println("O número " + i + " pode ser adicionado nessa posição");
                }
            }
        }
        System.out.println("Entre com a linha, coluna e valor!");
        System.out.println("Linha:");
        linha = ler.nextInt() - 1;
        while (linha < 0 || linha >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            linha = ler.nextInt() - 1;
        }
        System.out.println("Coluna:");
        coluna = ler.nextInt() - 1;
        while (coluna < 0 || coluna >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            coluna = ler.nextInt() - 1;
        }
        System.out.println("Valor:");
        valor = ler.nextInt();
        while (valor < 0 || valor >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            valor = ler.nextInt() - 1;
        }
        if (verificaMovimento(linha, coluna, valor, tabuleiro)) {
            tabuleiro[linha][coluna] = valor;
            System.out.println("Valor " + valor + " adicionado na linha " + (linha + 1) + " e coluna " + (coluna + 1));
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
    /* @function remover Função que remove jogada
    @param tabuleiro[][] Tabuleiro de sudoku
    @param auxiliar[][] Tabuleiro de Sudoku Auxiliar para verificar se posição era original ou não
    */
    public static void remover(int tabuleiro[][], int auxiliar[][]) {
        int linha, coluna;
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com linha e coluna para remoção!");
        System.out.println("Linha:");
        linha = ler.nextInt() - 1;
        while (linha < 0 || linha >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            linha = ler.nextInt() - 1;
        }
        System.out.println("Coluna:");
        coluna = ler.nextInt() - 1;
        while (coluna < 0 || coluna >= 9) {
            System.out.println("Entrada inválida, digite novamente:");
            coluna = ler.nextInt() - 1;
        }
        if (auxiliar[linha][coluna] != 0) {
            System.out.println("Posição não pode ser removida");
        } else {
            System.out.println("Valor " + tabuleiro[linha][coluna] + " removido da linha " + (linha + 1) + " e coluna " + (coluna + 1));
            tabuleiro[linha][coluna] = 0;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
    /* @function verifica Função que verifica se sudoku esta compleo e certo
    @param tabuleiro[][] Tabuleiro de sudoku
    */
    public static void verifica(int tabuleiro[][]) {
        Scanner ler = new Scanner(System.in);
        char novoJogo;
        int auxiliar[][] = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        boolean certo = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (verificaMovimento(i, j, tabuleiro[i][j], auxiliar) == false) {
                    certo = false;
                }
            }
        }
        if (certo == true) {
            System.out.println("PARABENS, O TABULEIRO ESTÁ CERTO!!!");
        } else {
            System.out.println("Uma pena, não foi dessa vez, tente novamente...");
        }
        System.out.println("Deseja jogar novamente? S/N: ");
        novoJogo = ler.next().charAt(0);
        while (novoJogo != 'S' && novoJogo != 's' && novoJogo != 'N' && novoJogo != 'n') {
            System.out.println("Entrada inválida, digite novamente:");
            novoJogo = ler.next().charAt(0);
        }
        if (novoJogo == 'S' || novoJogo == 's') {
            menu();
        } else {
            System.out.println("Até a próxima!!");
            return;
        }

    }
    /*@function menu Função que oferece as escolhas ao usuario e cahama as funções*/
    public static void menu() {
        Scanner ler = new Scanner(System.in);
        //gabarito para jogo aleatorio
        int tabuleiroPronto[][] = {
            {7, 1, 6, 4, 2, 3, 5, 8, 9},
            {8, 5, 4, 9, 1, 7, 6, 2, 3},
            {9, 2, 3, 8, 5, 6, 1, 4, 7},
            {5, 9, 8, 3, 6, 1, 4, 7, 2},
            {1, 6, 7, 2, 4, 8, 3, 9, 5},
            {3, 4, 2, 5, 7, 9, 8, 1, 6},
            {2, 8, 5, 6, 9, 4, 7, 3, 1},
            {6, 3, 1, 7, 8, 2, 9, 5, 4},
            {4, 7, 9, 1, 3, 5, 2, 6, 8}
        };
        //onde sera realizado o jogo aleatorio
        int tabAleatorio[][] = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int tabAleatorioAux[][] = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        //onde sera realizado o jogo definido
        int tabuleiroUsuario[][] = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int auxiliarDefinido[][] = new int[9][9];

        int qtdeSorteados;
        int opcao, opcao2;
        System.out.println("-----Seja bem-vindx!!-----");
        System.out.println("Por favor, escolha uma opção:");
        System.out.println("1 - Jogo Aleatório");
        System.out.println("2 - Definir");
        System.out.println("Opção:");
        opcao = ler.nextInt();
        while (opcao != 1 && opcao != 2) {
            System.out.println("Por favor, digite uma opção válida");
            System.out.println("Opção:");
            opcao = ler.nextInt();
        }
        if (opcao == 1) {
            System.out.println("----Sudoku aleatório----");
            System.out.println("Caro jogador, você deve escolher quantos números do nosso tabuleiro gostaria que fossem revelados para dar início ao jogo!!");
            System.out.println("Como nosso Sudoku é 9x9 você pode escolher um número entre 1 e 81!!");
            System.out.println("Quantos números deseja pro sorteio?:");
            qtdeSorteados = ler.nextInt();
            while (qtdeSorteados < 0 || qtdeSorteados > 81) {
                System.out.println("Entrada inválida, digite novamente");
                qtdeSorteados = ler.nextInt();
            }
            aleatorio(qtdeSorteados, tabuleiroPronto, tabAleatorio, tabAleatorioAux);
            System.out.println("-----Início do Jogo-----");
            System.out.println("Caro jogador, o que gostaria de fazer agora?");
            System.out.print("1 - Jogada\n");
            System.out.println("2 - Remover");
            System.out.println("3 - Verificar Tabuleiro");
            System.out.println("4 - Sair");
            System.out.println("Opção:");
            opcao2 = ler.nextInt();
            while (opcao2 != 1 && opcao2 != 2 && opcao2 != 3 && opcao2 != 4) {
                System.out.println("Entrada inválida, digite novamente");
                opcao2 = ler.nextInt();
            }
            while (opcao2 != 4) {
                if (opcao2 == 1) {
                    jogada(tabAleatorio);
                } else if (opcao2 == 2) {
                    remover(tabAleatorio, tabAleatorioAux);
                } else {
                    verifica(tabAleatorio);

                }
                System.out.println("Caro jogador, o que gostaria de fazer agora?");
                System.out.print("1 - Jogada\n");
                System.out.println("2 - Remover");
                System.out.println("3 - Verificar Tabuleiro");
                System.out.println("4 - Sair");
                System.out.println("Opção:");
                opcao2 = ler.nextInt();
                while (opcao2 != 1 && opcao2 != 2 && opcao2 != 3 && opcao2 != 4) {
                    System.out.println("Entrada inválida, digite novamente");
                    opcao2 = ler.nextInt();
                }
            }

        } else {
            System.out.println("----Sudoku definido----");
            System.out.println("Caro jogador, você deve criar um tabuleiro pré-definido para darmos inicio ao jogo!!");
            System.out.println("Como nosso Sudoku é 9x9 você pode escolher numeros de 0 a 9 para coluna, linha e valor da casa!!");
            System.out.println("Vamos começar, e lembre-se: quando acabar de inciar com os valores basta entrar com o valor -1 para linha, coluna e valor da casa!!");
            definido(tabuleiroUsuario, auxiliarDefinido);
            System.out.println("Caro jogador, o que gostaria de fazer agora?");
            System.out.print("1 - Jogada\n");
            System.out.println("2 - Remover");
            System.out.println("3 - Verificar Tabuleiro");
            System.out.println("4 - Sair");
            System.out.println("Opção:");
            opcao2 = ler.nextInt();
            while (opcao2 != 1 && opcao2 != 2 && opcao2 != 3 && opcao2 != 4) {
                System.out.println("Entrada inválida, digite novamente");
                opcao2 = ler.nextInt();
            }
            while (opcao2 != 4) {
                if (opcao2 == 1) {
                    jogada(tabuleiroUsuario);
                } else if (opcao2 == 2) {
                    remover(tabuleiroUsuario, auxiliarDefinido);
                } else {
                    verifica(tabuleiroUsuario);

                }
                System.out.println("Caro jogador, o que gostaria de fazer agora?");
                System.out.print("1 - Jogada\n");
                System.out.println("2 - Remover");
                System.out.println("3 - Verificar Tabuleiro");
                System.out.println("4 - Sair");
                System.out.println("Opção:");
                opcao2 = ler.nextInt();
                while (opcao2 != 1 && opcao2 != 2 && opcao2 != 3 && opcao2 != 4) {
                    System.out.println("Entrada inválida, digite novamente");
                    opcao2 = ler.nextInt();
                }
            }

        }
    }

    public static void main(String args[]) {

        menu();
    }
}
