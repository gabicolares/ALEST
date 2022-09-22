
import java.util.EmptyStackException;

public class Pilha {

    private LinkedListOfInteger p;
    
    public Pilha() {
        p = new LinkedListOfInteger();
    }
    
    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        p.add(0,element);
    }

    // remove e retorna o elemento do topo da pilha 
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        if (p.size() == 0) // se a pilha estiver vazia
            throw new EmptyStackException();
        return p.removeByIndex(0);
    }

    // retorna, mas não remove, o elemento do topo da pilha 
    //(erro se a pilha estiver vazia)
    public Integer top() {
        if (p.size() == 0) // se a pilha estiver vazia
            throw new EmptyStackException();
        return p.get(0);
    }

    // retorna o número de elementos da pilha
    public int size() {
        return p.size();
    }

    // retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return p.isEmpty();
    }

    // esvazia a pilha
    public void clear() {
        p.clear();
    }

}
