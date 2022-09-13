
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;    
    // Contador do numero de elementos da lista.
    private int count;

     private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // primeiro cria o nodo
        Node n = new Node(element);
        // conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // atualiza count
        count++;     
    }
    
    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        // primeiro verifica se o indice é válido 
        if (index < 0 || index > count )
        	throw new IndexOutOfBoundsException();
        
            if (index == count) {
                add(element); // insere no final
            }

            else {
                // primeiro cria o nodo
                Node n = new Node(element);
                // caminha ate a posição index
                Node aux = getNodeIndex(index);
                // conecta o novo nodo na lista
                n.next = aux;
                n.prev = aux.prev;
                // atualiza as referencias para apontar para o novo nodo
                aux.prev.next = n;
                aux.prev = n;
                // autaliza o count
                count++;
            }

    }
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                aux.next.prev = aux.prev;
                aux.prev.next = aux.next;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // verifica se o index é válido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }        
        
        Node aux = getNodeIndex(index);
        aux.next.prev = aux.prev;
        aux.prev.next = aux.next;
        count--;

        return aux.element;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        // primeiro verifica se index é válido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }

        Node aux = getNodeIndex(index);
        
        return aux.element;
    }

    private Node getNodeIndex(int index) {
        Node aux = null;
        // caminha do inicio para o meio
        if (index < count/2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        }
        // caminha do fim para o meio
        else {
            aux = trailer.prev;
            for (int i = count-1; i > index; i--) {
                aux = aux.prev;
            }
        }

        return aux;
    }
    
   /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) {
        // primeiro verifica se index é válido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        
        Node aux = getNodeIndex(index);
        Integer elem = aux.element;
        aux.element = element;

        return elem;
    }    
   
    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        Integer[] lista = new Integer[toIndex-fromIndex];
        
        for (int i = fromIndex; i < toIndex; i++) {
            int aux = lista.get(i);
            lista.add(aux);
        }
        
        return lista;
    }  
    
    
    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    
    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }
        
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
    
    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * @return elemento da posicao corrente
     */
    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }      
}
