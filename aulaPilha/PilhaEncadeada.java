
public class PilhaEncadeada {

    private class Node {
        public Integer element;
        public Node next; 
        public Node(Integer e) {
            element = e;
            next = null;
        }
    }
    private Node topo;
    private int count;
    
    public PilhaEncadeada() {
        
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
