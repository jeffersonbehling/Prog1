package ExerciciosExtras;

import java.util.Scanner;

/**
 * @author Jefferson Vantuir
 */
public class NumerosAmigaveis {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe N1: ");
        int n1 = entrada.nextInt();
        System.out.print("\nInforme N2: ");
        int n2 = entrada.nextInt();
        
            verifNumAmigaveis(n1, n2);
    }
    
    public static void verifNumAmigaveis(int n1, int n2) {
        if(somaDivisores(n1) == n2 && somaDivisores(n2) == n1){
            System.out.println(n1 + " e "+ n2 + " SÃO NÚMEROS AMIGÁVEIS");
        }
        else {
            System.out.println(n1 + " e "+ n2 + " NÃO SÃO NÚMEROS AMIGÁVEIS");
        }
    }
    
    public static int somaDivisores(int numero){
        int soma = 0;
        
        for (int i = 1; i < numero; i++) {
            if(numero % i == 0){
                soma += i;
            }
        }
        return soma;
    }
}
