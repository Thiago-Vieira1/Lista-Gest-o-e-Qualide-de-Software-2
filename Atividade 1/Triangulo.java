import java.util.Scanner;

// Exceção personalizada para triângulos inválidos
class TrianguloInvalidoError extends Exception {
    public TrianguloInvalidoError(String mensagem) {
        super(mensagem);
    }
}

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    // Construtor que valida os lados do triângulo
    public Triangulo(double ladoA, double ladoB, double ladoC) throws TrianguloInvalidoError {
        validarLados(ladoA, ladoB, ladoC);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    // Método para validar os lados do triângulo
    private void validarLados(double ladoA, double ladoB, double ladoC) throws TrianguloInvalidoError {
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            throw new TrianguloInvalidoError("Os lados do triângulo devem ser maiores que zero.");
        }
        if (!desigualdadeTriangular(ladoA, ladoB, ladoC)) {
            throw new TrianguloInvalidoError("A desigualdade triangular não é atendida.");
        }
    }

    // Verifica se os lados satisfazem a desigualdade triangular
    private boolean desigualdadeTriangular(double ladoA, double ladoB, double ladoC) {
        return (ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA);
    }

    // Método para determinar o tipo de triângulo
    public int determinarTipo() {
        if (ladoA == ladoB && ladoB == ladoC) {
            return 0; // Equilátero
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return 1; // Isósceles
        } else {
            return 2; // Escaleno
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Solicita ao usuário os valores dos lados do triângulo
            System.out.print("Insira o valor do lado A: ");
            double ladoA = scanner.nextDouble();

            System.out.print("Insira o valor do lado B: ");
            double ladoB = scanner.nextDouble();

            System.out.print("Insira o valor do lado C: ");
            double ladoC = scanner.nextDouble();

            // Cria o triângulo com os valores inseridos pelo usuário
            Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
            
            // Determina o tipo de triângulo e imprime o resultado
            int tipo = triangulo.determinarTipo();
            String tipoTriangulo = (tipo == 0) ? "Equilátero" : (tipo == 1) ? "Isósceles" : "Escaleno";
            System.out.println("O triângulo é: " + tipoTriangulo);

        } catch (TrianguloInvalidoError e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir números válidos.");
        } finally {
            scanner.close();
        }
    }
}
