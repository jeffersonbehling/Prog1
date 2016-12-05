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

/**
 *
 * @author Jefferson Vantuir
 */
public class cacaPalavras_v2 {
    
  static String[][] matriz = new String[20][20];
    static String[][] matrizResposta = new String[20][20];
    
    public static void main(String[] args) throws IOException {
        geraMatrizResposta();
        
        lerArmazenarMatriz();
        
        File arquivo = new File("PalavrasParaCacarExtra.txt");
        if(arquivo.exists()){
            FileReader arq_PPC = new FileReader(arquivo);
            BufferedReader br_PPP = new BufferedReader(arq_PPC);
            while(br_PPP.ready()){
                String palavra = br_PPP.readLine();
                
                cacarPalavras(palavra);
                
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
    
    public static void cacarPalavras(String palavra){
        if(cacarPalavrasHorizontais(palavra)){
            System.out.println("Palavra "+ palavra + " está na HORIZONTAL");
        }else if(cacarPalavrasHorizontaisInverso(palavra)){
            System.out.println("Palavra "+ palavra + " está na HORIZONTAL INVERSO");
        }else if(cacarPalavrasVerticais(palavra)){
            System.out.println("Palavra "+ palavra + " está na VERTICAL");
        }else if(cacarPalavrasVerticaisInverso(palavra)){
            System.out.println("Palavra "+ palavra + " está na VERTICAL INVERSO");
        }else if(cacarPalavrasDiagonalPrincipal(palavra)){
            System.out.println("Palavra "+ palavra + " está na DIAGONAL PRINCIPAL");
        }else if(cacarPalavrasDiagonalPrincipalInverso(palavra)){
            System.out.println("Palavra "+ palavra + " está na DIAGONAL PRINCIPAL INVERSA");
        }else if(cacarPalavrasDiagonalSecundaria(palavra)){
            System.out.println("Palavra "+ palavra + " está na DIAGONAL SECUNDÁRIA");
        }else if(cacarPalavrasDiagonalSecundariaInverso(palavra)){
            System.out.println("Palavra "+ palavra + " está na DIAGONAL SECUNDÁRIA INVERSA");
        }else{
            System.out.println("Palavra "+ palavra + " não foi encontrada!");
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
        File arquivo = new File("CacaPalavrasExtra.txt");
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
                    int posPalavra = 0;
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
    
    public static boolean cacarPalavrasHorizontaisInverso(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxJ = j;
                
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && (j - (palavra.length() - 1) >= 0)){
                    int letrasIguais = 0;
                    int posPalavra = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            letrasIguais++;
                            j--;
                        }
                        else{
                            j = auxJ;
                            break;
                        }
                        if(letrasIguais == (palavra.length())){
                            int aux = 0;
                            for (int l = (auxJ); l > (auxJ-palavra.length()); l--) {
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
    
    public static boolean cacarPalavrasVerticaisInverso(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxI = i;
                
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && (i - (palavra.length() - 1) >= 0)){
                    int letrasIguais = 0;
                    int posPalavra = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            letrasIguais++;
                            i--;
                        }
                        else{
                            i = auxI;
                            break;
                        }
                        if(letrasIguais == (palavra.length())){
                            int aux = 0;
                            for (int l = auxI; l > (auxI - palavra.length()); l--) {
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
    
    public static boolean cacarPalavrasDiagonalPrincipal(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxI = i;
                int auxJ = j;
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && 
                        (j + (palavra.length() - 1) < 20) && (i + (palavra.length() - 1) < 20)){
                    int letrasIguais = 0;
                    int posPalavra = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            i++;
                            j++;
                            letrasIguais++;
                        }else{
                            i = auxI;
                            j = auxJ;
                            break;
                        }
                        
                        if(letrasIguais == (palavra.length())){
                            int aux = 0;
                            int auxiliar = auxJ;
                            for (int l = auxI; l < (palavra.length() + auxI); l++) {
                                matrizResposta[l][auxiliar] = String.valueOf(palavra.charAt(aux));
                                auxiliar++;
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
    
    public static boolean cacarPalavrasDiagonalPrincipalInverso(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxI = i;
                int auxJ = j;
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && 
                        (j - (palavra.length() - 1) >= 0) && (i - (palavra.length() - 1) >= 0)){
                    int letrasIguais = 0;
                    int posPalavra = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            i--;
                            j--;
                            letrasIguais++;
                        }else{
                            i = auxI;
                            j = auxJ;
                            break;
                        }
                        
                        if(letrasIguais == (palavra.length())){
                            int aux = 0;
                            int auxiliar = auxJ;
                            for (int l = auxI; l > (auxI - palavra.length()); l--) {
                                matrizResposta[l][auxiliar] = String.valueOf(palavra.charAt(aux));
                                auxiliar--;
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
    
    public static boolean cacarPalavrasDiagonalSecundaria(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxI = i;
                int auxJ = j;
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && 
                        (j + (palavra.length() - 1) < 20) && (i - (palavra.length() - 1) >= 0)){
                    int letrasIguais = 0;
                    int posPalavra = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            i--;
                            j++;
                            letrasIguais++;
                        }else{
                            i = auxI;
                            j = auxJ;
                            break;
                        }
                        
                        if(letrasIguais == (palavra.length())){
                            int aux = 0;
                            int auxiliar = auxJ;
                            for (int l = auxI; l > (auxI - palavra.length()); l--) {
                                matrizResposta[l][auxiliar] = String.valueOf(palavra.charAt(aux));
                                auxiliar++;
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
    
    public static boolean cacarPalavrasDiagonalSecundariaInverso(String palavra){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int auxI = i;
                int auxJ = j;
                if(matriz[i][j].equals(String.valueOf(palavra.charAt(0))) && 
                        (j - (palavra.length() - 1) >= 0) && (i + (palavra.length() - 1) < 20)){
                    int letrasIguais = 0;
                    int posPalavra = 0;
                    for (int k = 0; k < palavra.length(); k++) {
                        if(matriz[i][j].equals(String.valueOf(palavra.charAt(k)))){
                            i++;
                            j--;
                            letrasIguais++;
                        }else{
                            i = auxI;
                            j = auxJ;
                            break;
                        }
                        
                        if(letrasIguais == (palavra.length())){
                            int aux = 0;
                            int auxiliar = auxJ;
                            for (int l = auxI; l < (auxI + palavra.length()); l++) {
                                matrizResposta[l][auxiliar] = String.valueOf(palavra.charAt(aux));
                                auxiliar--;
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
