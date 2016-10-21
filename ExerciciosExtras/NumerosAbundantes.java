import java.util.Scanner;

/**
 * @author Jefferson Vantuir
 */
public class NumerosAbundantes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Número: ");
        int num = entrada.nextInt();
        
        if(verificaNumAbundante(num)){
            System.out.println("NÚMERO ABUNDANTE");
        }
        else {
           System.out.println("Não é NÚMERO ABUNDANTE");
        }
    }
    
    public static boolean verificaNumAbundante(int numero){
        int soma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0){
                soma += i;
            }
        }
        if(soma > numero){
            return true;
        }
        return false;
    }
}
