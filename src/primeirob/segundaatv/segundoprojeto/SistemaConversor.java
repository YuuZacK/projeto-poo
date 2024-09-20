package src.primeirob.segundaatv.segundoprojeto;

import java.util.Scanner;

public class SistemaConversor {
    
    private static final int[] VALORES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SIMBOLOS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número para converter para números romanos (1-3999): ");
        int numero = scanner.nextInt();
        
        if (numero < 1 || numero > 3999) {
            System.out.println("Número fora do intervalo permitido.");
        } else {
            String resultado = toRoman(numero);
            System.out.println("O número " + numero + " em números romanos é: " + resultado);
        }
        
        scanner.close();
    }


    private static String toRoman(int numero) {
        StringBuilder romano = new StringBuilder();
        
    
        for (int i = 0; i < VALORES.length; i++) {

            while (numero >= VALORES[i]) {
                romano.append(SIMBOLOS[i]);
                numero -= VALORES[i];
            }
        }
        
        return romano.toString();
    }
}

