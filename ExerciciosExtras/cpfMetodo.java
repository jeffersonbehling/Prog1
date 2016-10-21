/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciciosExtras;

import static ExerciciosExtras.cpfSemMetodos.cpf;
import static ExerciciosExtras.validacaoCPF.cpf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jefferson Vantuir
 */
public class cpfMetodo {
    static String cpf;
       
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Informe seu CPF: ");
        cpf = entrada.readLine();
        
        int dig1 = Integer.valueOf(cpf.charAt(9)-48);
        int dig2 = Integer.valueOf(cpf.charAt(10)-48);
        
        int resto1 = calcularSomaCpf(10);
        int resto2 = calcularSomaCpf(11);
        
        boolean correto1 = verificaCpf(resto1, dig1);
        boolean correto2 = verificaCpf(resto2, dig2);
        
        if(correto1 && correto2){
            System.out.println("CPF VÁLIDO!!!");
        }
        else{
            System.out.println("CPF INVÁLIDO!!!");
        }
    }    
    public static int calcularSomaCpf(int valor) {
        int contador = 0;
        int soma = 0;
        for (int i = valor; i >= 2; i--) {
            soma += (cpf.charAt(contador)-48)*i;
            contador++;
        }
        int resto = (soma%11);
        return resto;
    }
    
    public static boolean verificaCpf(int resto, int digito){
        if((resto < 2) && (digito == 0)){
            return true;
        }else if ((resto >= 2) && ((11-resto) == digito)){
            return true;
        }
        return false;
    }
}