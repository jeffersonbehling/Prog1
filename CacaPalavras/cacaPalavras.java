/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacaPalavras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Jefferson Vantuir
 */
public class cacaPalavras {
      
  static String[][] matriz = new String[20][20];
  static String[][] matrizResposta = new String[20][20];
    
    public static void main(String[] args) throws IOException {
        geraMatrizResposta();
        
        lerArmazenarMatriz();
        
        File arquivo = new File("PalavrasParaCacar.txt");
        if(arquivo.exists()){
            FileReader arq_PPC = new FileReader(arquivo);
            BufferedReader br_PPP = new BufferedReader(arq_PPC);
            while(br_PPP.ready()){
                String palavra = br_PPP.readLine();
                System.out.println("Procurando palavra "+palavra);
                
                if(cacarPalavrasHorizontais(palavra)){
                    System.out.println("Palavra "+ palavra + " encontrada na HORIZONTAL");
                }else if(cacarPalavrasVerticais(palavra)){
                    System.out.println("Palavra "+ palavra + " encontrada na HORIZONTAL");
                }
                else{
                    System.out.println("Palavra "+ palavra + " não foi encontrada!");
                }
                salvarResolucaoTxt();
            }
            System.out.println("\n\n******************** TODAS AS PALAVRAS ENCONTRADAS ********************");
            
            for (int l = 0; l < 20; l++) {
                for (int m = 0; m < 20; m++) {
                    System.out.print(matrizResposta[l][m]);
                }
                System.out.println("");
            }
        }
    }
    
    public static void geraMatrizResposta(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                matrizResposta[i][j] = " ";
            }
        }
    }
     
    public static void lerArmazenarMatriz() throws FileNotFoundException, IOException{
        File arquivo = new File("CacaPalavras.txt");
        if(arquivo.exists()){
            FileReader arq_CP = new FileReader(arquivo);
            BufferedReader br_CP = new BufferedReader(arq_CP);
            int contLine = 0;
            while(br_CP.ready()){
                String linha = br_CP.readLine();
                int cont = 0;
                for (int i = 0; i < linha.length(); i++) {
                    if(i%2 == 0){
                        matriz[contLine][cont] = String.valueOf(linha.charAt(i));
                        cont++;
                    }
                }
                contLine++;
            }
        }
    }
    
    public static boolean cacarPalavrasHorizontais(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxJ = j;
                
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && (j + (palavra.length() - 1) < 20)){
                    int letrasIguais = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            letrasIguais++;
                            j++;
                        }
                        else{
                            j = auxJ;
                            break;
                        }
                        if(letrasIguais == (palavra.length())){
                            int aux = 0;
                            for (int l = auxJ; l < (auxJ + palavra.length()); l++) {
                                matrizResposta[i][l] = String.valueOf(palavra.charAt(aux));
                                aux++;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean cacarPalavrasVerticais(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxI = i;
                
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && (i + (palavra.length() - 1) < 20)){
                    int letrasIguais = 0;
                    int posPalavra = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            letrasIguais++;
                            i++;
                        }
                        else{
                            i = auxI;
                            break;
                        }
                        if(letrasIguais == (palavra.length())){
                            
                            
                            int aux = 0;
                            for (int l = auxI; l < (auxI + palavra.length()); l++) {
                                matrizResposta[l][j] = String.valueOf(palavra.charAt(aux));
                                aux++;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static void mostraMatriz(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }


    calculaDelta:
		li $t5, -4
		mul $t3,$t1,$t1 # b * b
		mul $t4,$t0,$t2 # a * c
		multu $t4, $t5
		add $t3, $t3,$t4
		syscall
    
    public static void salvarResolucaoTxt() throws IOException{
        File arquivo = new File("ResolucaoCacaPalavra.txt");
        
        if(arquivo.exists()){
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < 20; i++) {
                String linha = "";
                for (int j = 0; j < 20; j++) {
                    linha += matrizResposta[i][j] + " ";
                }
                bw.append(""+linha);
                bw.newLine();
            }
            bw.close();
            
        }else{
            arquivo.createNewFile();
        }
    }
}
