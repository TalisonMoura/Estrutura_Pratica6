package br.com.praticaarvore;

import java.util.Scanner;

public class Questao4 {
    Arvore arv = new Arvore();
    Scanner ler = new Scanner(System.in);
    public void DeletarElemento() {
        arv.inserir(10);
        arv.inserir(5);
        arv.inserir(15);
        arv.inserir(3);
        arv.inserir(7);
        arv.inserir(12);

        System.out.println("Arvore original");
        arv.imprimir();

        System.out.print("Escolha um desses números para deletar: ");
        var list = arv.nums;
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.print("\nInsira um valor: ");
        boolean rightNumber = false;
        int val = 0;
        while (!rightNumber){
            var num = ler.nextInt();
            if(!list.contains(num)) {
                System.out.print("Insira um valor válido: ");
            }else{
                rightNumber = true;
                val = num;
            }
        }

        arv.delete(val);

        System.out.println(String.format("\nArvore com o elemento %d deletado", val));
        arv.imprimir();
    }
}
