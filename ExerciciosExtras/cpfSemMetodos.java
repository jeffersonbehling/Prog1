import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jefferson Vantuir
 */
public class cpfSemMetodos {
    static String cpf;
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(178%11);
        System.out.print("Informe seu CPF: ");
        cpf = entrada.readLine();
        
        int contador = 0;
        int soma = 0;
        for (int i = 10; i >= 2; i--) {
            soma += (cpf.charAt(contador)-48)*i;
            contador++;
        }
        int resto = (soma%11);
        //ok
        if(resto < 2 && (cpf.charAt(9)-48) == 0){
            contador = 0;
            soma = 0;
            for (int i = 11; i >= 2; i--) {
                soma += (cpf.charAt(contador)-48)*i;
                contador++;
            }
            resto = (soma%11);
            if(resto < 2 && (cpf.charAt(10)-48) == 0){
                System.out.println("CPF Valido!!!");
            }
            else if(resto >= 2 && ((cpf.charAt(10)-48) == (11-resto))){
                System.out.println("CPF Valido!!!");
            }
        }
        else if (resto >= 2 && ((cpf.charAt(9)-48) == (11-resto))){
            contador = 0;
            soma = 0;
            for (int i = 11; i >= 2; i--) {
                soma += (cpf.charAt(contador)-48)*i;
                contador++;
            }
            resto = (soma%11);
            if(resto < 2 && (cpf.charAt(10)-48) == 0){
                System.out.println("CPF Valido!!!");
            }
            else if(resto >= 2 && ((cpf.charAt(10)-48) == (11-resto))){
                System.out.println("CPF Valido!!!");
            }
        }
        else{
            System.out.println("CPF Invalido!!!");
        }
    }
}
