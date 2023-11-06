class NoArvore {
    int valor;
    NoArvore esquerdo;
    NoArvore direito;

    NoArvore() {}

    NoArvore(int valor) {
        this.valor = valor;
    }

    NoArvore(int valor, NoArvore esquerdo, NoArvore direito) {
        this.valor = valor;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }
}

public class SomaIntervaloArvore {
    public int somaIntervaloArvore(NoArvore raiz, int inicio, int fim) {
        if (raiz == null) return 0;

        if (raiz.valor > fim) return somaIntervaloArvore(raiz.esquerdo, inicio, fim);

        if (raiz.valor < inicio) return somaIntervaloArvore(raiz.direito, inicio, fim);

        return raiz.valor + somaIntervaloArvore(raiz.esquerdo, inicio, fim) + somaIntervaloArvore(raiz.direito, inicio, fim);
    }

    public static void main(String[] args) {
        NoArvore raiz = new NoArvore(10);
        raiz.esquerdo = new NoArvore(5);
        raiz.esquerdo.esquerdo = new NoArvore(3);
        raiz.esquerdo.direito = new NoArvore(7);
        raiz.direito = new NoArvore(15);
        raiz.direito.direito = new NoArvore(18);

        SomaIntervaloArvore solucao = new SomaIntervaloArvore();
        int soma = solucao.somaIntervaloArvore(raiz, 7, 15);
        System.out.println(soma); // Saída esperada: 32
    }
}
