public class ListaEncadeada {

    public Node Lista; //Atribui o nó a uma lista

    public ListaEncadeada(){
        Lista = null;
    }

    public boolean vazia(){
        if (Lista == null){
            //System.out.println("Vazia");
            return true;
        }else {
            //System.out.println("Ñvazia");
            return false;
        }
    }//verifica se a lista está vazia

    public void inserePrimeiro(int info){
        Node newNode = new Node(info);
        newNode.proximo = Lista;
        Lista = newNode;
    }//insere o elemento info como primeiro na Lista;


    public void insereDepois (Node node, int info){
        if(node != null){
            Node newNode = new Node(info);
            newNode.proximo = node.proximo;
            node.proximo = newNode;
        }
    }//insere o elemento info depois do nó node (informado por parâmetro)


    public void insereUltimo (int info){
        Node newNode = new Node(info);
        if (vazia()){             //--->Problema 1: se diferente de vazia (!vazia()) não há inserção - alterado para vazia()
            Lista = newNode;
            return;
        }
        Node atual = Lista;
        while (atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = newNode;

    }//insere o elemento info como último na Lista

    public void insereOrdenado(int info){
        Node newNode = new Node(info);
        if (vazia() || Lista.info >= info){
            newNode.proximo = Lista;
            Lista = newNode;
            return;
        }

        Node anterior = null;
        Node atual = Lista;

        while (atual != null && atual.info < info){
            anterior = atual;
            atual = atual.proximo;
        }

        anterior.proximo = newNode;
        newNode.proximo = atual;
    }//insere o elemento info de maneira ordenada na Lista

    public Node getNode(int info){
        Node atual = Lista;
        while (atual != null){
            if (atual.info == info){
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }//recupera o node que tem o valor info

    public void imprime(){
        Node atual = Lista;
        while (atual != null){
            System.out.println(atual.info + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }//imprime todos os elementos da Lista

    public Node removePrimeiro(){
        if (!vazia()){
            Node removido = Lista;
            Lista = Lista.proximo;
            removido.proximo = null;
            return removido;
        }
        return null;

    }//remove o primeiro elemento da Lista, e retorna o node removido

    public Node removeUltimo(){
        if (vazia() || Lista.proximo == null){
            return removePrimeiro();
        }
        Node atual = Lista;
        while (atual.proximo.proximo != null){
            atual = atual.proximo;
        }
        Node removido = atual.proximo;
        atual.proximo = null;
        return removido;
    }//remove o último elemento da Lista, e retorna o node removido

    public Node remove(Node no){
        if (no == Lista){
            return removePrimeiro();
        }
        Node atual = Lista;
        while (atual != null && atual.proximo != no){
            atual = atual.proximo;
        }
        if (atual != null){
            atual.proximo = no.proximo;
            no.proximo = null;
            return no;
        }
        return null;
    }//remove o node da Lista, e retorna o node removido

    public int primeiro(){
        if(!vazia()){
            return Lista.info;
        }else {
            System.out.println("Lista vazia");
            return -1;
        }
    }

    public boolean contem(int chave) {
        Node atual = Lista;
        while (atual != null) {
            if (atual.info == chave) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
    // Função contem recebendo o elemento chave como parametro
    /*
    *   -> atual recebe Lista parar buscar desde o primeiro nó
    *   -> Enquanto atual for diferente de nulo
    *       -> Se o info referente ao valor do nó atual for o mesmo valor do elemento chave
    *           -> retornará verdadeiro, ou seja, encontrou a chave na lista
    *       -> avança para o próximo nó da lista
    *   -> se cair fora do while (em que atual = nulo) retornará falso, ou seja, não localizou a chave na lista
    *
    * */

    public int tamanhoLista() {
        int tamanho = 0;
        Node atual = Lista;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }
    // Função tamanhoLista usada para calcular o número de elementos da lista (usado no método insere)
    /*
    *   -> variável tamanho para atribuição do número de elementos (inicializada em 0)
    *   -> atual recebe Lista parar buscar desde o primeiro nó (semelhante ao metodo anterior)
    *   -> Enquanto atual for diferente de nulo
    *       -> irá incrementar o valor de tamanho e avançar para o próximo nó da lista
    *   -> por fim retorna o valor de tamanho representando o número de elementos da lista
    *
    * */
}