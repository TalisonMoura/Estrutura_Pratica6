package br.com.praticaarvore;

public class Questao5 {
    Arvore arv = new Arvore();
    public void ImprimirInPrePos(){
        arv.inserir(50);
        arv.inserir(30);
        arv.inserir(20);
        arv.inserir(40);
        arv.inserir(70);
        arv.inserir(60);
        arv.inserir(80);

        System.out.println("Árvore In-Ordem:");
        arv.inOrder();

        System.out.println("\nÁrvore Pré-Ordem:");
        arv.preOrder();

        System.out.println("\nÁrvore Pós-Ordem");
        arv.postOrder();
    }
}
