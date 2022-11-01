public class BinarySearchTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos
    private int count; // contagem do número de nodos
    private Node root; // referência para o nodo raiz

    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        root = add(root, element, null);
        count++;

    }

    private Node add(Node n, Integer element, Node father) {
        if (n == null) { // insere
            Node aux = new Node(element);
            aux.father = father;
            return aux;
        }
        // senão insere na subavore da esquerda ou da direita
        if (n.element.compareTo(element) < 0) {
            // direita
            n.right = add(n.right, element, n);
        }

        else {
            // esquerda
            n.left = add(n.left, element, n);
        }
        return n;
    }

    public Integer getLeft(Integer element) {

        return null;
    }

    public Integer getRight(Integer element) {
        return null;
    }

    public Integer getParent(Integer element) {
        return null;
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); // Visita o nodo
            positionsPreAux(n.left, res); // Visita a subárvore da esquerda
            positionsPreAux(n.right, res); // Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); // Visita a subárvore da esquerda
            positionsPosAux(n.right, res); // Visita a subárvore da direita
            res.add(n.element); // Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); // Visita a subárvore da esquerda
            res.add(n.element); // Visita o nodo
            positionsCentralAux(n.right, res); // Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    public String strTraversalCentral() {
        return strTraversalCentral(root);
    }

    private String strTraversalCentral(Node n) {
        return null;
    }

    public boolean contains(Integer element) {
        return false;
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (element == null || target == null) {
            return null;
        }
        int c = target.element.compareTo(element);

        if (c == 0) {
            return target;
        } else if (c > 0) {
            return searchNodeRef(element, target.left);
        }

        else {
            return searchNodeRef(element, target.right);
        }

    }

    public boolean remove(Integer element) {
        // se árvore está vazia
        if (element == null || root == null) {
            return false;
        }

        Node aux = searchNodeRef(element, root);
        if (aux == null) { // se não encontrou element
            return false;
        }

        remove(aux); // chama o método que faz realmente a remoção
        count--; // atualiza o count
        return true;
    }

    /**
     * Método que faz a remoção. Recebe referẽncia para o nodo onde está o elemento
     * a ser
     * removido
     * 
     * @param n referencia do elemento
     */
    private void remove(Node n) {
        // guarda a referencia para o pai do elemento a ser removido
        Node father = n.father;
        if (n.left == null && n.right == null) { // remoção de nodo folha
            if (root == n) { // se remoção da raiz
                root = null;
                return;
            }
            if (father.left == n) {
                father.left = null;
            } else {
                father.right = null;
            }
        }

        else if (n.left == null && n.right != null) { // remoção de um nodo com filho à direita
            if (root == n) { // se remoção da raiz que tem um filho a direita
                root = root.right;
                root.father = null;
                return;
            }
            if (father.left == n) {
                father.left = n.right;
            } else {
                father.right = n.right;
                n.right.father = father;
            }
        }

        else if (n.left != null && n.right == null) { // remoção de nodo com filho à esquerda
            if (root == n) { // se remoção da raiz que tem um filho a esquerda
                root = root.left;
                root.father = null;
                return;
            }
            if (father.right == n) {
                father.right = n.left;
            } else {
                father.right = n.left;
                n.left.father = father;
            }
        }

        else { // remoção de um nodo com dois filhos
               // pega a referencia para o nodo que contem o menor elemento do lado direito
            Node menor = smallest(n.right);
            n.element = menor.element;
            remove(menor);
        }
    }

    public Integer getSmallest() {
        Node n = smallest(root);

        if (n == null) {
            return null;
        }

        return n.element;
    }

    private Node smallest(Node n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {
            n = n.left;
        }

        return n;
    }

    public Integer set(Integer old, Integer element) {
        return null;
    }

    public boolean isExternal(int element) {
        return false;
    }

    public boolean isInternal(int element) {
        return false;
    }

    public BinarySearchTreeOfInteger clone() {
        BinarySearchTreeOfInteger tree = new BinarySearchTreeOfInteger();
        clone(root, tree);
        return tree;
    }

    private void clone(Node n, BinarySearchTreeOfInteger tree) {
        if (n != null) {
            tree.add(n.element); // Visita o nodo
            clone(n.left, tree); // Visita a subárvore da esquerda
            clone(n.right, tree); // Visita a subárvore da direita
        }
    }

    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        // "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        // "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        // "[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        // node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }

}
