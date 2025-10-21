import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class XadrezGUI {

    enum Cor { BRANCO, PRETO }
    enum Tipo { 
        PEAO("🟤","⚪"), TORRE("🏰","🏛️"), CAVALO("🐴","🦄"), 
        BISPO("⛪","🔱"), RAINHA("👑","💎"), REI("♚","♔");
        final String preto, branco;
        Tipo(String p, String b){ preto=p; branco=b; }
    }
    
    static class Peca { 
        Tipo t; Cor c; boolean moveu=false;
        Peca(Tipo t, Cor c){ this.t=t; this.c=c; }
        String simbolo(){ return c==Cor.BRANCO ? t.branco : t.preto; }
    }
    
    static class Pos { 
        int l,c; 
        Pos(int l, int c){ this.l=l; this.c=c; }
        @Override public boolean equals(Object o){
            if(!(o instanceof Pos)) return false;
            Pos p=(Pos)o; return l==p.l && c==p.c;
        }
        @Override public int hashCode(){ return l*8+c; }
    }

    static class Movimento {
        Pos de, para;
        Peca capturada;
        boolean moveuAntes;
        Movimento(Pos de, Pos para, Peca cap, boolean ma){ 
            this.de=de; this.para=para; this.capturada=cap; this.moveuAntes=ma;
        }
    }

    static class Tabuleiro {
        Peca[][] g = new Peca[8][8];
        Cor vez = Cor.BRANCO;
        Pos reiB = new Pos(7,4), reiP = new Pos(0,4);
        Stack<Movimento> historico = new Stack<>();
        Pos enPassant = null;

        Tabuleiro(){ criar(); }

        void criar(){
            Cor[] cores = {Cor.PRETO, Cor.BRANCO};
            int[] lin = {0,7};
            for(int i=0;i<2;i++){
                g[lin[i]][0]=new Peca(Tipo.TORRE,  cores[i]);
                g[lin[i]][1]=new Peca(Tipo.CAVALO,cores[i]);
                g[lin[i]][2]=new Peca(Tipo.BISPO, cores[i]);
                g[lin[i]][3]=new Peca(Tipo.RAINHA,cores[i]);
                g[lin[i]][4]=new Peca(Tipo.REI,   cores[i]);
                g[lin[i]][5]=new Peca(Tipo.BISPO, cores[i]);
                g[lin[i]][6]=new Peca(Tipo.CAVALO,cores[i]);
                g[lin[i]][7]=new Peca(Tipo.TORRE, cores[i]);
                int peao = i==0?1:6;
                for(int c=0;c<8;c++) g[peao][c]=new Peca(Tipo.PEAO,cores[i]);
            }
        }
        
        Peca get(Pos p){ return g[p.l][p.c]; }
        void colocar(Pos p, Peca x){ g[p.l][p.c]=x; }
        boolean dentro(Pos p){ return p.l>=0&&p.l<8&&p.c>=0&&p.c<8; }

        List<Pos> movimentosValidos(Pos from){
            List<Pos> moves = new ArrayList<>();
            Peca pc = get(from);
            if(pc==null || pc.c!=vez) return moves;
            
            for(int l=0;l<8;l++) for(int c=0;c<8;c++){
                Pos to = new Pos(l,c);
                if(movimentoValido(from, to)) moves.add(to);
            }
            return moves;
        }

        boolean movimentoValido(Pos from, Pos to){
            Peca pc = get(from);
            if(pc==null || pc.c!=vez) return false;
            if(!dentro(to)) return false;
            Peca alvo = get(to);
            if(alvo!=null && alvo.c==pc.c) return false;
            if(!movimentoDaPeca(pc, from, to)) return false;
            
            Tabuleiro cp = copia();
            cp.executarMovimento(from, to);
            return !cp.emXeque(pc.c);
        }

        boolean movimentoDaPeca(Peca pc, Pos f, Pos t){
            int dl=t.l-f.l, dc=t.c-f.c;
            switch(pc.t){
                case PEAO:
                    int dir=pc.c==Cor.BRANCO?-1:1;
                    int ini=pc.c==Cor.BRANCO?6:1;
                    if(dc==0 && get(t)==null){
                        if(dl==dir) return true;
                        if(f.l==ini && dl==2*dir && get(new Pos(f.l+dir,f.c))==null) return true;
                    }
                    if(Math.abs(dc)==1 && dl==dir){
                        if(get(t)!=null && get(t).c!=pc.c) return true;
                        if(enPassant!=null && t.equals(enPassant)) return true;
                    }
                    return false;
                case TORRE: return (dl==0||dc==0) && caminhoLivre(f,t);
                case BISPO: return Math.abs(dl)==Math.abs(dc) && caminhoLivre(f,t);
                case RAINHA: return ((dl==0||dc==0)||Math.abs(dl)==Math.abs(dc)) && caminhoLivre(f,t);
                case CAVALO: return (Math.abs(dl)==2&&Math.abs(dc)==1)||(Math.abs(dl)==1&&Math.abs(dc)==2);
                case REI:
                    if(Math.abs(dl)<=1 && Math.abs(dc)<=1) return true;
                    // Roque
                    if(!pc.moveu && dl==0 && Math.abs(dc)==2){
                        int col = dc>0?7:0;
                        Peca torre = get(new Pos(f.l, col));
                        if(torre!=null && torre.t==Tipo.TORRE && !torre.moveu){
                            int step = dc>0?1:-1;
                            for(int i=1; i<=Math.abs(dc); i++){
                                Pos p = new Pos(f.l, f.c+i*step);
                                if(get(p)!=null) return false;
                                if(i<=2 && emXequePosicao(pc.c, p)) return false;
                            }
                            return true;
                        }
                    }
                    return false;
            }
            return false;
        }

        boolean caminhoLivre(Pos f, Pos t){
            int stepL=Integer.compare(t.l-f.l,0);
            int stepC=Integer.compare(t.c-f.c,0);
            int l=f.l+stepL, c=f.c+stepC;
            while(l!=t.l || c!=t.c){
                if(g[l][c]!=null) return false;
                l+=stepL; c+=stepC;
            }
            return true;
        }

        boolean emXeque(Cor cor){
            Pos rei = cor==Cor.BRANCO?reiB:reiP;
            return emXequePosicao(cor, rei);
        }

        boolean emXequePosicao(Cor cor, Pos pos){
            Cor adv = cor==Cor.BRANCO?Cor.PRETO:Cor.BRANCO;
            for(int l=0;l<8;l++) for(int c=0;c<8;c++){
                Pos f = new Pos(l,c);
                Peca pc = get(f);
                if(pc!=null && pc.c==adv){
                    if(pc.t==Tipo.PEAO){
                        int dir = pc.c==Cor.BRANCO?-1:1;
                        if(pos.l-f.l==dir && Math.abs(pos.c-f.c)==1) return true;
                    } else if(movimentoDaPeca(pc, f, pos)){
                        if(pc.t!=Tipo.REI || Math.abs(pos.c-f.c)<=1){
                            if(pc.t==Tipo.CAVALO || caminhoLivre(f, pos)) return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean xequeMate(Cor cor){
            if(!emXeque(cor)) return false;
            for(int l=0;l<8;l++) for(int c=0;c<8;c++){
                Pos f = new Pos(l,c);
                if(get(f)!=null && get(f).c==cor){
                    if(!movimentosValidos(f).isEmpty()) return false;
                }
            }
            return true;
        }

        void executarMovimento(Pos f, Pos t){
            Peca pc = get(f);
            Peca capturada = get(t);
            boolean moveuAntes = pc.moveu;
            
            historico.push(new Movimento(new Pos(f.l,f.c), new Pos(t.l,t.c), capturada, moveuAntes));
            
            // En passant
            Pos epAnterior = enPassant;
            enPassant = null;
            if(pc.t==Tipo.PEAO && Math.abs(t.l-f.l)==2){
                enPassant = new Pos((f.l+t.l)/2, f.c);
            }
            if(pc.t==Tipo.PEAO && epAnterior!=null && t.equals(epAnterior)){
                int dir = pc.c==Cor.BRANCO?1:-1;
                colocar(new Pos(t.l+dir, t.c), null);
            }

            // Roque
            if(pc.t==Tipo.REI && Math.abs(t.c-f.c)==2){
                int torreCol = t.c>f.c?7:0;
                int novaTorreCol = t.c>f.c?t.c-1:t.c+1;
                Peca torre = get(new Pos(f.l, torreCol));
                colocar(new Pos(f.l, novaTorreCol), torre);
                colocar(new Pos(f.l, torreCol), null);
                torre.moveu = true;
            }

            colocar(t, pc);
            colocar(f, null);
            pc.moveu = true;

            if(pc.t==Tipo.REI){
                if(pc.c==Cor.BRANCO) reiB=t;
                else reiP=t;
            }
        }

        void mover(Pos f, Pos t, JFrame frame){
            Peca pc = get(f);
            executarMovimento(f, t);
            
            if(pc.t==Tipo.PEAO && (t.l==0 || t.l==7)){
                Object[] op = {"Rainha","Torre","Bispo","Cavalo"};
                String esc = (String)JOptionPane.showInputDialog(frame,"Promoção:","Escolha",
                    JOptionPane.PLAIN_MESSAGE, null, op, op[0]);
                Tipo novo = switch(esc){
                    case "Torre" -> Tipo.TORRE;
                    case "Bispo" -> Tipo.BISPO;
                    case "Cavalo" -> Tipo.CAVALO;
                    default -> Tipo.RAINHA;
                };
                colocar(t, new Peca(novo, pc.c));
            }
        }

        void desfazer(){
            if(historico.isEmpty()) return;
            Movimento m = historico.pop();
            Peca pc = get(m.para);
            pc.moveu = m.moveuAntes;
            colocar(m.de, pc);
            colocar(m.para, m.capturada);
            
            if(pc.t==Tipo.REI){
                if(pc.c==Cor.BRANCO) reiB=m.de;
                else reiP=m.de;
            }
            
            enPassant = null;
        }

        Tabuleiro copia(){
            Tabuleiro b = new Tabuleiro();
            for(int l=0;l<8;l++){
                for(int c=0;c<8;c++){
                    Peca p = g[l][c];
                    if(p!=null){
                        Peca nova = new Peca(p.t, p.c);
                        nova.moveu = p.moveu;
                        b.g[l][c] = nova;
                    }
                }
            }
            b.reiB = new Pos(reiB.l, reiB.c);
            b.reiP = new Pos(reiP.l, reiP.c);
            b.vez = vez;
            b.enPassant = enPassant!=null ? new Pos(enPassant.l, enPassant.c) : null;
            return b;
        }
    }

    static class GUI extends JFrame {
        Tabuleiro tab = new Tabuleiro();
        JButton[][] botoes = new JButton[8][8];
        Pos selecionado = null;
        List<Pos> movsPossiveis = new ArrayList<>();
        JLabel statusBar = new JLabel("Vez das Brancas", JLabel.CENTER);

        GUI(){
            super("Xadrez");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
            
            JPanel board = new JPanel(new GridLayout(8,8));
            for(int l=0;l<8;l++){
                for(int c=0;c<8;c++){
                    botoes[l][c] = new JButton();
                    Color fundo = (l+c)%2==0 ? new Color(240,217,181) : new Color(181,136,99);
                    botoes[l][c].setBackground(fundo);
                    botoes[l][c].setFont(new Font("Segoe UI Symbol", Font.PLAIN, 48));
                    botoes[l][c].setFocusPainted(false);
                    botoes[l][c].setBorderPainted(false);
                    int ll=l, cc=c;
                    botoes[l][c].addActionListener(e->clique(ll,cc));
                    board.add(botoes[l][c]);
                }
            }
            
            JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JButton btnDesfazer = new JButton("↶ Desfazer");
            JButton btnReiniciar = new JButton("↻ Reiniciar");
            btnDesfazer.addActionListener(e->desfazer());
            btnReiniciar.addActionListener(e->reiniciar());
            toolbar.add(btnDesfazer);
            toolbar.add(btnReiniciar);
            
            statusBar.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
            
            add(board, BorderLayout.CENTER);
            add(toolbar, BorderLayout.NORTH);
            add(statusBar, BorderLayout.SOUTH);
            
            atualizar();
            setSize(600, 650);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        void atualizar(){
            for(int l=0;l<8;l++){
                for(int c=0;c<8;c++){
                    Peca p = tab.get(new Pos(l,c));
                    botoes[l][c].setText(p==null ? "" : p.simbolo());
                    Color fundo = (l+c)%2==0 ? new Color(240,217,181) : new Color(181,136,99);
                    botoes[l][c].setBackground(fundo);
                }
            }
            
            if(selecionado!=null){
                botoes[selecionado.l][selecionado.c].setBackground(new Color(186,202,68));
                for(Pos m : movsPossiveis){
                    botoes[m.l][m.c].setBackground(new Color(246,246,105));
                }
            }
            
            String status = tab.vez==Cor.BRANCO ? "Vez das Brancas" : "Vez das Pretas";
            if(tab.emXeque(tab.vez)) status += " - XEQUE!";
            statusBar.setText(status);
        }

        void clique(int l, int c){
            Pos p = new Pos(l,c);
            
            if(selecionado==null){
                if(tab.get(p)!=null && tab.get(p).c==tab.vez){
                    selecionado = p;
                    movsPossiveis = tab.movimentosValidos(p);
                    atualizar();
                }
            } else {
                if(tab.movimentoValido(selecionado, p)){
                    tab.mover(selecionado, p, this);
                    tab.vez = tab.vez==Cor.BRANCO ? Cor.PRETO : Cor.BRANCO;
                    
                    if(tab.xequeMate(tab.vez)){
                        String vencedor = tab.vez==Cor.BRANCO ? "Pretas" : "Brancas";
                        JOptionPane.showMessageDialog(this, "Xeque-mate! " + vencedor + " vencem!");
                        reiniciar();
                    }
                }
                selecionado = null;
                movsPossiveis.clear();
                atualizar();
            }
        }

        void desfazer(){
            if(!tab.historico.isEmpty()){
                tab.desfazer();
                tab.vez = tab.vez==Cor.BRANCO ? Cor.PRETO : Cor.BRANCO;
                selecionado = null;
                movsPossiveis.clear();
                atualizar();
            }
        }

        void reiniciar(){
            tab = new Tabuleiro();
            selecionado = null;
            movsPossiveis.clear();
            atualizar();
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(GUI::new);
    }
}