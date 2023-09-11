public class Node {
    /*
     * Classe Node para armazenar as informações do nó
     *   Variável info = informação a ser inserida
     *   Variável próximo = representa o próximo info a seguir do primeiro (sempre inicailizado em nulo)
     */
    public int info;
    public Node proximo;

    public Node(int info){
        this.info = info;
        this.proximo = null;
    }
}
