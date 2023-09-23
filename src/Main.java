import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o tamanho:");
        int tam = scanner.nextInt();
        TabelaHash tabelaHash = new TabelaHash(tam);

        tabelaHash.preencherTabela(0.9); //Executa o preenchimento da tabela com números aleatórios

        int chave; // Variável chave para leitura das chaves digitadas

        do{
            System.out.println("Digite uma chave:");
            chave = scanner.nextInt();

            if (chave != -1){
                if (tabelaHash.busca(chave)) {
                    System.out.println("Chave encontrada na tabela.");
                    tabelaHash.mostrarElementos();
                } else {
                    System.out.println("Chave não encontrada na tabela. Inserindo...");
                    tabelaHash.insere(chave);
                    tabelaHash.mostrarElementos();
                }
            }
        }
        while (chave != -1);
        // Loop do...while:
        /*
        * busca as chaves digitadas enquanto diferente do código -1 (usado para finalizar a execução)
        * executa o método busca da TabelaHash usando a chave informada
        * se encontrada, exibirá a tabela e todos os elementos
        * se não encontrada, fará a inserção e mostrará os elementos
        *
        *  */

        scanner.close();
    }
}