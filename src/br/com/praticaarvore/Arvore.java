package br.com.praticaarvore;

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

    private int minValue(No root) {
        int minValue = root.valor;
        while (root.esquerda != null) {
            minValue = root.esquerda.valor;
            root = root.esquerda;
        }
        return minValue;
    }
}
