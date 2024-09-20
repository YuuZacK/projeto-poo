package src.primeirob.segundaatv.segundoprojeto;

import java.util.Scanner;

public class ConversorMoedas {

    private static final String[] MOEDAS = {"USD", "EUR", "JPY", "GBP", "BRL"};
    private static final double[] TAXAS = {1.0, 0.85, 110.0, 0.75, 5.4}; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a moeda de origem (por exemplo, USD, EUR): ");
        String moedaOrigem = scanner.next().toUpperCase();

        System.out.print("Digite a moeda de destino (por exemplo, USD, EUR): ");
        String moedaDestino = scanner.next().toUpperCase();

        System.out.print("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();

        try {
            double valorConvertido = convert(valor, moedaOrigem, moedaDestino);
            System.out.printf("%.2f %s em %s: %.2f%n", valor, moedaOrigem, moedaDestino, valorConvertido);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static double convert(double amount, String fromCurrency, String toCurrency) {
        int fromIndex = findCurrencyIndex(fromCurrency);
        int toIndex = findCurrencyIndex(toCurrency);

        if (fromIndex == -1 || toIndex == -1) {
            throw new IllegalArgumentException("Código de moeda inválido. Por favor, use um código de moeda suportado.");
        }

        double valorEmUSD = amount / TAXAS[fromIndex];
        double valorConvertido = valorEmUSD * TAXAS[toIndex];
        return valorConvertido;
    }

    private static int findCurrencyIndex(String currency) {
        for (int i = 0; i < MOEDAS.length; i++) {
            if (MOEDAS[i].equals(currency)) {
                return i;
            }
        }
        return -1;
    }
}
