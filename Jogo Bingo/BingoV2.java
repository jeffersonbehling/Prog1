/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Jefferson Vantuir
 */
public class BingoV2 {
    static int[][] jogador1 = new int[5][5];
    static int[][] jogador2 = new int[5][5];
    static String COR = "\u001B[";
    
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
        menu();
        gerarCartelas(jogador1);
        gerarCartelas(jogador2);
        mostrarCartelas();
        verificaAcertos();
    }
    
    public static void gerarCartelas(int cartela[][]) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numeroSorteado = (int) (Math.random() * 99)+1;
                if(i == 2 && j == 2){
                    cartela[2][2] = 0;
                }
                else{
                    // VERIFICA SE Nº JÁ EXISTE
                    boolean achou = false;
                    for (int k = 0; k < 5; k++) {
                        for (int l = 0; l < 5; l++) {
                            if(numeroSorteado == cartela[k][l]) {
                                achou = true;
                            }
                        }
                    }
                    // CASO NAO EXISTE, ARMAZENA NA CARTELA
                    if(achou == false){
                        cartela[i][j] = numeroSorteado;
                    }
                    // SENÃO, SORTEIA NOVAMENTE
                    else{
                        j--;
                    }
                }
            }
        }
        // FAZ A VERIFICAÇÃO DA IGUALDADE DAS CARTELAS
        if(verfCartelasIguais()){
            gerarCartelas(jogador1);
            gerarCartelas(jogador2);
        }
        // ORDENA A RESPECTIVA CARTELA
        ordenarCartelas(cartela);
    }
        
    public static void mostrarCartelas(){
        System.out.print (COR + "31" + "m");
        System.out.println("  \t\t\t\t\tJogador 1 \t\t\t\t\t\t Jogador 2\n");
        // MOSTRA AMBAS CARTELAS, VERIFICANDO SE O VALOR É "0", SE FOR, IMPRIME COM COR VERDE O "0" (usando tabela ANSI)
        for (int i = 0; i < 5; i++) {
            System.out.print("  \t\t\t\t\t");
            if(jogador1[i][0] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador1[i][0] + " ]\t");
            }
            else{
                if(jogador1[i][0] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador1[i][0] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador1[i][0] + " ]\t");
                }
            }
            if(jogador1[i][1] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador1[i][1] + " ]\t");
            }
            else{
                if(jogador1[i][1] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador1[i][1] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador1[i][1] + " ]\t");
                }
            }
            if(jogador1[i][2] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador1[i][2] + " ]\t");
            }
            else{
                if(jogador1[i][2] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador1[i][2] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador1[i][2] + " ]\t");
                }
            }
            if(jogador1[i][3] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador1[i][3] + " ]\t");
            }
            else{
                if(jogador1[i][3] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador1[i][3] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador1[i][3] + " ]\t");
                }
            }
            if(jogador1[i][4] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador1[i][4] + " ]\t");
            }
            else{
                if(jogador1[i][4] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador1[i][4] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador1[i][4] + " ]\t");
                }
            }
            
            System.out.print("\t\t");

            // JOGADOR 2
            if(jogador2[i][0] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador2[i][0] + " ]\t");
            }
            else{
               if(jogador2[i][0] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador2[i][0] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador2[i][0] + " ]\t");
                }
            }
            if(jogador2[i][1] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador2[i][1] + " ]\t");
            }
            else{
                if(jogador2[i][1] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador2[i][1] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador2[i][1] + " ]\t");
                }
            }
            if(jogador2[i][2] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador2[i][2] + " ]\t");
            }
            else{
                if(jogador2[i][2] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador2[i][2] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador2[i][2] + " ]\t");
                }
            }
            if(jogador2[i][3] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador2[i][3] + " ]\t");
            }
            else{
                if(jogador2[i][3] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador2[i][3] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador2[i][3] + " ]\t");
                }
            }
            if(jogador2[i][4] == 0){
                System.out.print(COR + "32" + "m");
                System.out.print("[ 0"+jogador2[i][4] + " ]\t");
            }
            else{
                if(jogador2[i][4] < 10){
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ 0"+jogador2[i][4] + " ]\t");
                }else{
                    System.out.print(COR + "39" + "m");
                    System.out.print("[ "+jogador2[i][4] + " ]\t");
                }
            }
            System.out.println("");
        }
    }
    
    public static void ordenarCartelas(int[][] cartela){
        // ORDENA A RESPECTIVA CARTELA USANDO MÉTODO BUBBLE SORT
       int interacoes = 0;
       while (interacoes < (cartela.length * cartela.length)){
            for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                   int comp = 1;
                   
                   if(i == 2 && j == 1){
                       comp = 2;
                   }
                   
                    if (i == (cartela.length -1) && (j == (cartela.length - 1))){
                       break;
                    }
                    else{
                        if (j == (cartela.length - 1)){
                            if(cartela[i][j] > cartela[i+1][0]){
                                int aux = cartela[i][j];
                                cartela[i][j] = cartela[i+1][0];
                                cartela[i+1][0] = aux;
                            }
                        }
                        else{
                            if(cartela[i][j] > cartela[i][j+comp]){
                                int aux = cartela[i][j];
                                cartela[i][j] = cartela[i][j+comp];
                                cartela[i][j+comp] = aux;
                            }
                        } 
                    }
                }
           }
           interacoes++;
        }
    }
    
    public static boolean verfCartelasIguais() {
        for (int i = 0; i < 5; i++) {
            if(jogador1[i][0] == jogador2[i][0] && jogador1[i][1] == jogador2[i][1] &&
                jogador1[i][2] == jogador2[i][2] && jogador1[i][3] == jogador2[i][3] &&
                jogador1[i][4] == jogador2[i][4]){
                System.out.println("Iguais");
                return true;
            }
        }
           return false;  
    }
    
    public static int sorteio() throws IOException{
        // FAZ O SORTEIO DO NUMERO
        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
        int numSorteado = (int) (Math.random() * 99);
       // System.out.println("\n\t\t\t\t\t\tTecle ENTER para sortear ou digite EXIT para sair");
       //String opcao = entrada.readLine();
        
        //opcao = opcao.toLowerCase();
        //if(opcao.equals("exit")){
          //  System.out.println("\nEncerrando...\n");
            //System.exit(0);
        //}
        return (numSorteado+1);
    }
    
    public static void menu() {
        System.out.println("\t\t\t\t\t\t\t\t+===============================================+");
        System.out.println("\t\t\t\t\t\t\t\t|                                               |");
        System.out.println("\t\t\t\t\t\t\t\t|                Jogo de Bingo                  |");
        System.out.println("\t\t\t\t\t\t\t\t|                                               |");
        System.out.println("\t\t\t\t\t\t\t\t+===============================================+");
        System.out.println("\t\t\t\t\t\t\t\t|... Criado por ................................|");
        System.out.println("\t\t\t\t\t\t\t\t|.............. Jefferson Vantuir ..............|");
        System.out.println("\t\t\t\t\t\t\t\t|................................. ADS 12 ......|");
        System.out.println("\t\t\t\t\t\t\t\t|.................... v 1.0 ....................|");
        System.out.println("\t\t\t\t\t\t\t\t+===============================================+");
        System.out.println("");
    }
    
    public static void verificaAcertos() throws IOException{
         // ENQUANTO NAO HOUVER GANHADOR, ELE FICA SORTEANDO E SUBSTITUINDO O NUMERO NA CARTELA POR "0"
        while(verificaGanhador() == 0){
            int sorteado = sorteio();
            
            System.out.println("\n\n");
            System.out.print(COR + "32" + "m");
            System.out.println("\t\t\t\t\t\t\t\t*********** Numero sorteado: "+sorteado+" ***********");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(jogador1[i][j] == sorteado){
                        jogador1[i][j] = 0;
                    }
                    if(jogador2[i][j] == sorteado){
                        jogador2[i][j] = 0;
                    }
                }
            }
            mostrarCartelas();
        }
    }
    
    public static int verificaGanhador(){
        int acertosJog1 = 0;
        int acertosJog2 = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(jogador1[i][j] == 0){
                    acertosJog1++;
                }
                if(jogador2[i][j] == 0){
                    acertosJog2++;
                }
            }
        }
        if(acertosJog1 == 25 && acertosJog2 == 25){
            System.out.println("\n\n");
            // COR AMARELA
            System.out.print("\t\t\t\t");
            System.out.print (COR + "43m" + COR + "39m");
            System.out.println("\t\t\t\t  ********** OUVE EMPATE ENTRE OS JOGADORES **********\t\t\t\t\t\t");
            return 1;
        }
        if(acertosJog1 == 25){
            System.out.println("\n\n");
            System.out.print("\t\t\t\t\t");
            System.out.print (COR + "42" + "m" + COR + "39m");
            System.out.println("\t\t\t    ********** JOGADOR 1 GANHOU **********\t\t\t\t");
            return 1;
        }
        else if (acertosJog2 == 25){
            System.out.println("\n\n");
            System.out.print("\t\t\t\t\t");
            System.out.print (COR + "42" + "m" + COR + "39m");
            System.out.println("\t\t\t    ********** JOGADOR 2 GANHOU **********\t\t\t\t");
            return 1;
        }
        return 0;
    }
}