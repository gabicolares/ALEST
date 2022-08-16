public class App {
    public static double potencia(double base, double expoente) {
        if (expoente == 0) {
            return 1;
        }
        double resultado = base;
        for (int i = (int) expoente; i > 1; i--) {
            resultado = resultado * base;
        }

        return resultado;
    }

    public static double potenciaRec(double base, double expoente) {
        if (expoente == 0) {
            return 1;
        } else {
            return base * potenciaRec(base, expoente - 1);
        }
    }

    public static void inverteArray(int vet[]) {
        inverteArray(vet, 0, vet.length-1);
    }

    private static void inverteArray(int vet[], int inicio, int fim) {
        if (inicio < fim) {
            int aux = vet[inicio];
            vet[inicio] = vet[fim];
            vet[fim] = aux;
            inverteArray(vet, inicio+1, fim-1);
        }
    }

    public static int somaArray(int vet[]) {
        return somaArrayRec(vet, 0);
    }

    private static int somaArrayRec(int vet[], int i) {
        return 0;
    }

    public static void main(String[] args) {
        int test[] = {1,2,3,4,5,6};
        inverteArray(test);
        System.out.println(test);
    }
}
