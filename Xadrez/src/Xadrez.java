import java.util.*;

public class Xadrez {

    enum Cor { BRANCO, PRETO }

    enum Tipo {
        PEAO('P'), TORRE('T'), CAVALO('C'), BISPO('B'), RAINHA('Q'), REI('K');
        final char simbolo;
        Tipo(char c) { simbolo = c; }
    }

    static class Posicao {
        int lin, col;
        Posicao(int l, int c) { lin = l; col = c; }
        static Posicao fromString(String s) {
            if (s.length() != 2) return null;
            int col = s.charAt(0) - 'a';
            int lin = 8 - (s.charAt(1) - '0');
            if (lin < 0 || lin > 7 || col < 0 || col > 7) return null;
            return new Posicao(lin, col);
        }
    }

    static class Peca {
        Tipo tipo;
        Cor cor;
        Peca(Tipo t, Cor c) { tipo = t; cor = c; }
        char simbolo() { return cor == Cor.BRANCO ? tipo.simbolo : Character.toLowerCase(tipo.simbolo); }
    }

    static class Tabuleiro {
        Peca[][] grid = new Peca[8][8];
        Cor vez = Cor.BRANCO;
        Posicao reiBranco, reiPreto;

        Tabuleiro() {
            // Peças pretas
            colocar(0, 0, new Peca(Tipo.TORRE, Cor.PRETO));
            colocar(0, 1, new Peca(Tipo.CAVALO, Cor.PRETO));
            colocar(0, 2, new Peca(Tipo.BISPO, Cor.PRETO));
            colocar(0, 3, new Peca(Tipo.RAINHA, Cor.PRETO));
            colocar(0, 4, new Peca(Tipo.REI, Cor.PRETO)); reiPreto = new Posicao(0, 4);
            colocar(0, 5, new Peca(Tipo.BISPO, Cor.PRETO));
            colocar(0, 6, new Peca(Tipo.CAVALO, Cor.PRETO));
            colocar(0, 7, new Peca(Tipo.TORRE, Cor.PRETO));
            for (int c = 0; c < 8; c++) colocar(1, c, new Peca(Tipo.PEAO, Cor.PRETO));

            // Peças brancas
            colocar(7, 0, new Peca(Tipo.TORRE, Cor.BRANCO));
            colocar(7, 1, new Peca(Tipo.CAVALO, Cor.BRANCO));
            colocar(7, 2, new Peca(Tipo.BISPO, Cor.BRANCO));
            colocar(7, 3, new Peca(Tipo.RAINHA, Cor.BRANCO));
            colocar(7, 4, new Peca(Tipo.REI, Cor.BRANCO)); reiBranco = new Posicao(7, 4);
            colocar(7, 5, new Peca(Tipo.BISPO, Cor.BRANCO));
            colocar(7, 6, new Peca(Tipo.CAVALO, Cor.BRANCO));
            colocar(7, 7, new Peca(Tipo.TORRE, Cor.BRANCO));
            for (int c = 0; c < 8; c++) colocar(6, c, new Peca(Tipo.PEAO, Cor.BRANCO));
        }

        void colocar(int l, int c, Peca p) { grid[l][c] = p; }

        Peca get(Posicao p) { return grid[p.lin][p.col]; }

        void mover(Posicao from, Posicao to) {
            Peca peca = get(from);
            Peca capturada = get(to);
            grid[to.lin][to.col] = peca;
            grid[from.lin][from.col] = null;

            // Atualiza posição do rei
            if (peca.tipo == Tipo.REI) {
                if (peca.cor == Cor.BRANCO) reiBranco = to;
                else reiPreto = to;
            }

            // Promoção de peão
            if (peca.tipo == Tipo.PEAO && (to.lin == 0 || to.lin == 7)) {
                grid[to.lin][to.col] = new Peca(Tipo.RAINHA, peca.cor);
            }
        }

        boolean dentro(Posicao p) { return p.lin >= 0 && p.lin < 8 && p.col >= 0 && p.col < 8; }

        boolean movimentoValido(Posicao from, Posicao to) {
            Peca p = get(from);
            if (p == null || p.cor != vez) return false;
            if (!dentro(to)) return false;
            Peca alvo = get(to);
            if (alvo != null && alvo.cor == p.cor) return false;

            // Verifica movimento da peça
            if (!movimentoDaPeca(p, from, to)) return false;

            // Verifica xeque
            Tabuleiro copia = copiar();
            copia.mover(from, to);
            copia.vez = p.cor == Cor.BRANCO ? Cor.PRETO : Cor.BRANCO;
            if (copia.emXeque(p.cor)) return false;

            return true;
        }

        boolean movimentoDaPeca(Peca peca, Posicao from, Posicao to) {
            int dl = to.lin - from.lin;
            int dc = to.col - from.col;
            switch (peca.tipo) {
                case PEAO:
                    int dir = peca.cor == Cor.BRANCO ? -1 : 1;
                    int linhaInicial = peca.cor == Cor.BRANCO ? 6 : 1;
                    if (dc == 0 && get(to) == null) {
                        if (dl == dir) return true;
                        if (from.lin == linhaInicial && dl == 2 * dir && get(new Posicao(from.lin + dir, from.col)) == null) return true;
                    }
                    if (Math.abs(dc) == 1 && dl == dir && get(to) != null && get(to).cor != peca.cor) return true;
                    return false;
                case TORRE:
                    return (dl == 0 || dc == 0) && caminhoLivre(from, to);
                case BISPO:
                    return Math.abs(dl) == Math.abs(dc) && caminhoLivre(from, to);
                case RAINHA:
                    return ((dl == 0 || dc == 0) || (Math.abs(dl) == Math.abs(dc))) && caminhoLivre(from, to);
                case CAVALO:
                    return (Math.abs(dl) == 2 && Math.abs(dc) == 1) || (Math.abs(dl) == 1 && Math.abs(dc) == 2);
                case REI:
                    return Math.abs(dl) <= 1 && Math.abs(dc) <= 1;
            }
            return false;
        }

        boolean caminhoLivre(Posicao from, Posicao to) {
            int stepL = Integer.compare(to.lin - from.lin, 0);
            int stepC = Integer.compare(to.col - from.col, 0);
            int l = from.lin + stepL;
            int c = from.col + stepC;
            while (l != to.lin || c != to.col) {
                if (grid[l][c] != null) return false;
                l += stepL;
                c += stepC;
            }
            return true;
        }

        boolean emXeque(Cor cor) {
            Posicao rei = cor == Cor.BRANCO ? reiBranco : reiPreto;
            Cor inimigo = cor == Cor.BRANCO ? Cor.PRETO : Cor.BRANCO;
            for (int l = 0; l < 8; l++) {
                for (int c = 0; c < 8; c++) {
                    Peca p = grid[l][c];
                    if (p != null && p.cor == inimigo) {
                        Posicao from = new Posicao(l, c);
                        if (movimentoDaPeca(p, from, rei) && caminhoLivre(from, rei)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean xequeMate(Cor cor) {
            if (!emXeque(cor)) return false;
            for (int l = 0; l < 8; l++) {
                for (int c = 0; c < 8; c++) {
                    Posicao from = new Posicao(l, c);
                    Peca p = get(from);
                    if (p != null && p.cor == cor) {
                        for (int ll = 0; ll < 8; ll++) {
                            for (int cc = 0; cc < 8; cc++) {
                                Posicao to = new Posicao(ll, cc);
                                if (movimentoValido(from, to)) return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        Tabuleiro copiar() {
            Tabuleiro t = new Tabuleiro();
            t.grid = new Peca[8][8];
            for (int l = 0; l < 8; l++) t.grid[l] = Arrays.copyOf(grid[l], 8);
            t.reiBranco = new Posicao(reiBranco.lin, reiBranco.col);
            t.reiPreto = new Posicao(reiPreto.lin, reiPreto.col);
            t.vez = vez;
            return t;
        }

        void imprimir() {
            System.out.println("  a b c d e f g h");
            for (int l = 0; l < 8; l++) {
                System.out.print((8 - l) + " ");
                for (int c = 0; c < 8; c++) {
                    Peca p = grid[l][c];
                    System.out.print((p == null ? '.' : p.simbolo()) + " ");
                }
                System.out.println(8 - l);
            }
            System.out.println("  a b c d e f g h");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tab = new Tabuleiro();
        while (true) {
            tab.imprimir();
            System.out.println("Vez das " + (tab.vez == Cor.BRANCO ? "brancas" : "pretas"));
            if (tab.emXeque(tab.vez)) System.out.println("XEQUE!");
            if (tab.xequeMate(tab.vez)) {
                System.out.println("XEQUE-MATE! " + (tab.vez == Cor.BRANCO ? "Pretas vencem!" : "Brancas vencem!"));
                break;
            }
            System.out.print("Movimento (ex: e2 e4): ");
            String linha = sc.nextLine().trim();
            if (linha.length() != 5 || linha.charAt(2) != ' ') {
                System.out.println("Formato inválido. Use: e2 e4");
                continue;
            }
            Posicao from = Posicao.fromString(linha.substring(0, 2));
            Posicao to = Posicao.fromString(linha.substring(3, 5));
            if (from == null || to == null) {
                System.out.println("Posição inválida.");
                continue;
            }
            if (!tab.movimentoValido(from, to)) {
                System.out.println("Movimento inválido.");
                continue;
            }
            tab.mover(from, to);
            tab.vez = tab.vez == Cor.BRANCO ? Cor.PRETO : Cor.BRANCO;
        }
        sc.close();
    }
}