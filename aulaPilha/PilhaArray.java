public class PilhaArray {
    private static final int INITIAL_SIZE = 10;
    private Integer[] p;
    private int count;
    
    public PilhaArray() {
        this(INITIAL_SIZE);
    }
    
    public PilhaArray(int initialSize) {
        initialSize = INITIAL_SIZE;
        if (initialSize <= 0) {
            p = new Integer[initialSize];
        }
        count = 0;
    }
    
    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        if (count == p.length) {
            setCapacity(p.length * 2);
        }
        p[count] = element;
        count++;
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != p.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity]; 
            if (p.length < newCapacity) {
                min = p.length;
            }
            else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = p[i];
            }
            p = newData;
        }
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
        return count;
    }

    // retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return (count==0);
    }

    // esvazia a pilha
    public void clear() {
        p = new Integer[INITIAL_SIZE];
        count = 0;
    }    
    
    P
}
