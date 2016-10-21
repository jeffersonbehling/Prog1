/**
 * @author Jefferson Vantuir
 */
public class Fibonacci {
    public static void main(String[] args) {
        fibonacci(20);
    }
    public static void fibonacci(int quantNumeros) {
        int ant = 0;
        int atual = 1;
        for (int i = 0; i < quantNumeros; i++) {
            System.out.print(atual + " ");
            int aux = atual;
            atual += ant;
            ant = aux;
        }
    }
}
