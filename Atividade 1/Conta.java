package exception.creation;
import javax.swing.JOptionPane;

public class Conta {
    private double saldo;
    private String nome, cpf;
    private double limite = 200;

    public Conta(String nome, String cpf, double saldo) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSaldo(saldo);
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getCpf() { 
        return cpf; 
    }

    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    }

    public double getSaldo() { 
        return saldo; 
    }

    public void setSaldo(double saldo) {
        this.saldo = (saldo < 0) ? 0 : saldo;
    }

    public void deposita(double valor) {
        setSaldo(this.saldo + valor);
    }

    public void saca(double valor) throws SaldoInsuficienteException {
        double saldoComLimite = saldo + limite;
        if (valor <= saldoComLimite) {
            if (valor > saldo) {
                double limiteUtilizado = valor - saldo;
                JOptionPane.showMessageDialog(null, 
                    "Você está usando o limite. Valor do saque: " + valor + 
                    "\nLimite utilizado: " + limiteUtilizado);
            }
            setSaldo(saldo - valor);
        } else {
            throw new SaldoInsuficienteException("Seu saldo é: " + saldo + 
                "\nVocê tentou sacar: " + valor + 
                "\nSaldo + limite disponível: " + saldoComLimite);
        }
    }


    @Override
    public String toString() {
        return "Cliente: " + this.nome + 
               "\nCPF: " + this.cpf + 
               "\nSaldo: " + this.saldo;
    }
}
