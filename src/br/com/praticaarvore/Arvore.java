package br.com.praticaarvore;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Arvore {
    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
        NumerosInseridos(valor);
    }

    List<Integer> elementos = new ArrayList<>();
    public void NumerosInseridos(int value){
        elementos.add(value);
    }

    private No inserirRecursivo(No node, int valor) {
        if (node == null) {
            node = new No(valor);
            return node;
        }
        if (valor < node.valor) {
            node.esquerda = inserirRecursivo(node.esquerda, valor);
        } else if (valor > node.valor) {
            node.direita = inserirRecursivo(node.direita, valor);
        }

        return node;
    }

    public boolean pesquisar(int valor) {
        return pesquisarRecursivo(raiz, valor);
    }

    private boolean pesquisarRecursivo(No node, int valor) {
        if (node == null) {
            return false;
        }

        if (valor == node.valor) {
            return true;
        }

        if (valor < node.valor) {
            return pesquisarRecursivo(node.esquerda, valor);
        }

        return pesquisarRecursivo(node.direita, valor);
    }

    public void imprimir() {
        imprimirRecursivo(raiz, 0);
    }

    private void imprimirRecursivo(No node, int nivel) {
        if (node != null) {
            imprimirRecursivo(node.direita, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(node.valor);
            imprimirRecursivo(node.esquerda, nivel + 1);
        }
    }

    public void delete(int key) {
        raiz = deleteRec(raiz, key);
    }

    private No deleteRec(No node, int key) {
        if (node == null) {
            return node;
        }
        if (key < node.valor) {
            node.esquerda = deleteRec(node.esquerda, key);
        } else if (key > node.valor) {
            node.direita = deleteRec(node.direita, key);
        } else {
            if (node.esquerda == null) {
                return node.direita;
            } else if (node.direita == null) {
                return node.esquerda;
            }
            node.valor = minValue(node.direita);
            node.direita = deleteRec(node.direita, node.valor);
        }
        return node;
    }

    private int minValue(No node) {
        int minValue = node.valor;
        while (node.esquerda != null) {
            minValue = node.esquerda.valor;
            node = node.esquerda;
        }
        return minValue;
    }

    public void inOrder() {
        inOrderRec(raiz);
    }

    private void inOrderRec(No node) {
        if (node != null) {
            inOrderRec(node.esquerda);
            System.out.print(node.valor + " ");
            inOrderRec(node.direita);
        }
    }

    public void preOrder() {
        preOrderIterative(raiz);
    }

    private void preOrderIterative(No node) {
        if (node == null) {
            return;
        }

        Stack<No> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            No current = stack.pop();
            System.out.print(current.valor + " ");

            if (current.direita != null) {
                stack.push(current.direita);
            }
            if (current.esquerda != null) {
                stack.push(current.esquerda);
            }
        }
    }

    public void postOrder() {
        postOrderRec(raiz);
    }

    private void postOrderRec(No node) {
        if (node != null) {
            postOrderRec(node.esquerda);
            postOrderRec(node.direita);
            System.out.print(node.valor + " ");
        }
    }
}
