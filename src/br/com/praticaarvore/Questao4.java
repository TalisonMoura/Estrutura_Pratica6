package br.com.praticaarvore;

public class Questao4 {
    Arvore arv = new Arvore();
    No root;
    public void DeletarElemento(int value) {
        arv.inserir(10);
        arv.inserir(5);
        arv.inserir(15);
        arv.inserir(3);
        arv.inserir(7);
        arv.inserir(12);

        System.out.println("Arvore original");
        arv.delete(value);

        System.out.println("Arvore com o elemento deletado");
        arv.imprimir();
    }
}
