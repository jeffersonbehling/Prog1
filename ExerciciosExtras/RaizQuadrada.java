package ExerciciosExtras;

import java.util.Scanner;

/**
 * @author Jefferson Vantuir
 */
public class RaizQuadrada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Número: ");
        int numero = entrada.nextInt();
        
        raizQuadrada(numero);
    }
    
    public static void raizQuadrada(int num) {
        int sub = 1;
        int teste = num;
        int cont = 0;
        while(teste > 0){
            teste -= sub;
            cont++;
            sub += 2;
        }
        
        if( teste == 0){
            System.out.println("A raiz quadrada de "+ num + " é: "+ cont);
        }
        else{
            System.out.println("O número "+num+" não possui raiz exata");
        }
        
    }
}
