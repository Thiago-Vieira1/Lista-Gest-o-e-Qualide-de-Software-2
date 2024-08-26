public class Main {

    public static double divisao(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero não é permitida.");
        }
        return (double) a / b;
    }
    public static void main(String[] args) {
        try {
           
            double resultado1 = divisao(4, 2); 
            System.out.println("Resultado: " + resultado1);
            
            double resultado2 = divisao(4, 0); 
            System.out.println("Resultado: " + resultado2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); 
        }
    }
}

