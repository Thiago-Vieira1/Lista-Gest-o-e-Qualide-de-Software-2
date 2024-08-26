public class main {
    public static int fatorial(int numero) throws EntradaInvalida {
        if (numero > 20) {
            throw new EntradaInvalida("Número maior que 20 não é permitido.");
        }
        int fat = 1;
        for (int n = 1; n <= numero; n++) {
            fat *= n;
        }
        return fat;
    }

    public static void main(String[] args) {
        try {
            System.out.println(fatorial(23));
        } catch (EntradaInvalida e) {
            System.out.println(e.getMessage());
        }
    }
}