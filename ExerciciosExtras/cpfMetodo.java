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
        
        int dig1 = Integer.valueOf(""+cpf.charAt(9));
        int dig2 = Integer.valueOf(""+cpf.charAt(10));
                
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
            soma += (Integer.valueOf(""+cpf.charAt(contador)))*i;
            contador++;
        }
        int resto = (soma%11);
        return resto;
    }
    
    public static boolean verificaCpf(int resto, int digito){
        if(cpfInalidosConhecidos()){
            return false;
        }else{
            if((resto < 2) && (digito == 0) || (resto >= 2) && ((11-resto) == digito)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean cpfInalidosConhecidos() {
        String[] cpfInvalido = {"00000000000", "11111111111", 
                                "22222222222", "33333333333",
                                "44444444444", "55555555555",
                                "66666666666", "77777777777",
                                "88888888888", "99999999999"};
        
        int qtdCpfInv = (cpfInvalido.length - 1);
        while (qtdCpfInv >= 0){
            if(cpf.equals(cpfInvalido[qtdCpfInv])){
                return true;
            }
            qtdCpfInv--;
        }
        return false;
    }
}