
public class PilhaEncadeada {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
        
        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }        
    }

    
    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    
    /**
     * Construtor da lista.
     */
    public PilhaEncadeada
        () {
        head = null;
        tail = null;
        count = 0;
    }
    
    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        // new Node, incrementa count
    }

    // remove e retorna o elemento do topo da pilha 
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        
    }

    // retorna, mas não remove, o elemento do topo da pilha 
    //(erro se a pilha estiver vazia)
    public Integer top() {
        
    }

    // retorna o número de elementos da pilha
    public int size() {
        
    }

    // retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty() {
        
    }

    // esvazia a pilha
    public void clear() {
        
    }     
}
