
public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        
        System.out.println(lista);
       
        System.out.println("Elemento armazenado na "
                + "segunda posicao da lista: " +lista.get(1));

        System.out.println("Elemento armazenado na "
                + "ultima posicao da lista: " +lista.get(lista.size()-1));
        
        System.out.println("Removeu o primeiro? " + lista.remove(2));
        System.out.println("Removeu o do meio? " + lista.remove(8));
        System.out.println("Removeu o final? " + lista.remove(12));
        System.out.println(lista);

        lista.add(0,1);
        lista.add(lista.size(), 16);
        lista.add(2,55);

        System.out.println(lista);
        
    }
}
