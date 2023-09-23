import java.util.Random;

public class TabelaHash {
    public int colisao; //Declaração de variável para contagem de colisões
    public ListaEncadeada[] tabela; //Atribuindo um vetor de objetos da classe ListaEncadeada

    public TabelaHash(int tamanho){
        this.colisao = 0; //Numero de colisoes (inicializado em 0)
        this.tabela = new ListaEncadeada[tamanho]; //Instanciando o vetor tabela com o tamanho informado como parametro

        for (int i = 0; i < tamanho; i++){
            tabela[i] = new ListaEncadeada();
        }
    }
    //Método construtor da classe TabelaHash:
    /*
    *   -> Inicializa o número de colisões em 0
    *   -> Instancia o atributo tabela recebendo o tamanho da mesma como parâmetro
    *
    * */

    public int hash(int chave){
        int tamanho = tabela.length;
        return chave % tamanho;
    }
    //Função hash retornando o resultado do cálculo chave % tamanho (sendo este o tamanho da tabela)

    public void insere(int chave){
        int tamanho = tabela.length;
        int indice = hash(chave % tamanho);

        if(tabela[indice].tamanhoLista() < 1){
            tabela[indice].inserePrimeiro(chave);
        }else{
            tabela[indice].insereOrdenado(chave);
            colisao++;
        }
    }
    // Função insere que recebe a chave como parâmetro e armazena o hash na variável indice
    /*
    *   -> Se o conteúdo do índice for menor que 1:
    *       -> executa o inserePrimeiro da ListaEncadeada, inserindo a chave no índice correspondente
    *   -> Se não:
    *       -> executa o insereOrdenado da ListaEncadeada, inserindo a chave de forma ordenada no índice;
    *       -> e incrementa o contador colisão
    * */

    public void mostrarElementos(){
        for (int i = 0; i < tabela.length; i++){
            System.out.println("Índice: " + i + "  ");
            ListaEncadeada listaEncadeada = tabela[i];
            Node atual = listaEncadeada.Lista;

            while (atual != null){
                System.out.println(atual.info + "   ");
                atual = atual.proximo;
            }
            if (listaEncadeada.Lista == null){
                System.out.println("-1");
            }

            System.out.println();
        }
    }
    //Função mostrarElementos cujo exibe o conteúdo da tabela
    /*
    *   -> recebe os índices da tabela com base no tamanho
    *   -> listaEncadeada recebe o elemento da tabela no índice i, instanciando da classe ListaEncadeada
    *   -> atual recebe a referência para o nó inicial
    *   -> Enquanto atual for diferente de nulo
    *       -> deverá imprimir o(s) info(s) associados àquele nó
    *   -> Se a referência para a Lista for nula (sem elementos naquele índice)
    *       -> deverá imprimir -1
    *
    * */

    public boolean busca (int chave){
        int indice = hash (chave);
        return tabela[indice].contem(chave);
    }
    //Função busca para procurar um elemento chave na lista encadeada e retornar o próprio elemento (se encontrado)
    /*
    *   -> funciona em conjunto com a função contem (criada na classe ListaEncadeada);
    *   -> cujo verifica se um elemento chave está presente na lista e retorna verdadeiro ou falso
    *
    * */

    public void preencherTabela(double percentual){
        int tamanho = tabela.length;
        int qtdElementos = (int) (tamanho * percentual);

        Random random = new Random();

        for (int i = 0; i < qtdElementos; i++){
            int chave = random.nextInt(1000000);
            insere(chave);
        }
    }
    //Função preencherTabela recebendo o percentual de elementos a serem inseridos
    /*
    *   recebe o tamanho da tabela
    *   calcula a qtd de elementos que serão inseridos, multiplicando o tamanho pelo percentual
    *   random para receber números aleatórios
    *   Loop for executa até que o número qtdElementos seja inserido na tabela
    *   chave recebe um número aleatório de 0 a 999999
    *   chama a função insere para inserir a chave na tabela, gerada aleatoriamente
    *
    * */
}
