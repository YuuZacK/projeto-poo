package primeirob.primeiraatv.primeiroprojeto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrimeiroProjeto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir as colunas do CSV
        System.out.println("Digite o nome da coluna 1:");
        String coluna1 = scanner.nextLine();
        
        System.out.println("Digite o nome da coluna 2:");
        String coluna2 = scanner.nextLine();
        
        System.out.println("Digite o nome da coluna 3:");
        String coluna3 = scanner.nextLine();
        
        // Definir o número de linhas
        System.out.println("Quantas linhas você quer adicionar?");
        int linhas = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        // Matriz para armazenar os dados
        String[][] dados = new String[linhas][3];

        // Preencher as linhas com dados do usuário
        for (int i = 0; i < linhas; i++) {
            System.out.println("Linha " + (i + 1) + ":");
            System.out.println("Digite o valor para " + coluna1 + ":");
            dados[i][0] = scanner.nextLine();
            
            System.out.println("Digite o valor para " + coluna2 + ":");
            dados[i][1] = scanner.nextLine();
            
            System.out.println("Digite o valor para " + coluna3 + ":");
            dados[i][2] = scanner.nextLine();
        }

        // Criar o arquivo CSV
        String arquivoCSV = "planilha.csv";
        try (FileWriter escritor = new FileWriter(arquivoCSV)) {
            // Escrever as colunas
            escritor.append(coluna1);
            escritor.append(",");
            escritor.append(coluna2);
            escritor.append(",");
            escritor.append(coluna3);
            escritor.append("\n");

            // Escrever os dados
            for (int i = 0; i < linhas; i++) {
                escritor.append(dados[i][0]);
                escritor.append(",");
                escritor.append(dados[i][1]);
                escritor.append(",");
                escritor.append(dados[i][2]);
                escritor.append("\n");
            }

            System.out.println("Arquivo CSV criado com sucesso: " + arquivoCSV);

        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
