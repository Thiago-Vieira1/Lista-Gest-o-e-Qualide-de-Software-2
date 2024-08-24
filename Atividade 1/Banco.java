package exception.creation;
import javax.swing.JOptionPane;

public class Banco {
    public static void main(String args[]) {
        // Obtem dados
        String nome = typeString("Digite o nome do cliente:");
        String cpf = typeString("Digite o CPF do cliente:");
        double saldo = 0.0;

        // Tratamento de erro da enunciado A
        while (true){
            try{
                saldo = typeDouble("Digite o saldo inicial do cliente:");
                break;
            }   catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + "\nSaldo inválido!!");
            }
        }

        Conta c = new Conta(nome, cpf, saldo); 
        
        double deposito = 0.0;
        while (true) {
            try {
                deposito = typeDouble("Digite o valor do depósito:");
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Por favor, digite um número válido.");
            }
        }
        c.deposita(deposito);
        
        double saque = 0;

        while (true) {
            try {
                saque = typeDouble("Digite o valor do saque:");
                c.saca(saque);
                break;
            } catch(SaldoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "\nOperação não realizada!");
            }
        }
        
        JOptionPane.showMessageDialog(null, c.toString());
    }

    private static double typeDouble(String txt) {
        String userInput = JOptionPane.showInputDialog(txt);
        double d = Double.parseDouble(userInput);
        return d;
    }

    private static String typeString(String txt) {
        return JOptionPane.showInputDialog(null, txt);
    }
}
