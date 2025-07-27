import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class TodaFatura
{
    public TodaFatura()
    {

    }
    public void corpo()
    {
        int q2,q5,q10,v2,v5,v10,soma=0,numeroC,cartao=0;
        final int V2=200,V5=500,V10=1000;
        String linha,nome,data;
        StringTokenizer seccao;

        try
        {
            q2=validarQ("Introduz quatidade de notas de 200(>0): ");
            q5=validarQ("Introduz quatidade de notas de 500(>0): ");
            q10=validarQ("Introduz quatidade de notas de 1000(>0): ");
            v2=valor(q2,V2);
            v5=valor(q5,V5);
            v10=valor(q10,V10);
            soma=soma(v2,v5,v10);
            cartao=validarC("Introduz o valor de cartao(>=0): ");
            FileReader fr=new FileReader("Dados.txt");
            BufferedReader br=new BufferedReader(fr);
            linha=br.readLine();
            while(linha!=null)
            {
                seccao=new StringTokenizer(linha,";");
                nome=seccao.nextToken();
                numeroC=Integer.parseInt(seccao.nextToken());
                data=seccao.nextToken();
                linha=br.readLine();
                Fatura f=new Fatura(nome, numeroC, data);
                System.out.println(f);
            }
            br.close();
        }
        catch(FileNotFoundException z)
        {
            System.out.println("O File de Dados nao Encontrado!!");
        }
        catch(NumberFormatException x)
        {
            System.out.println(x.getMessage());
        }
        catch(IOException y)
        {
            System.out.println(y.getMessage());
        }
        fileValor("Feixo_de_caixa.txt",soma,cartao); // dadods
        
    }
    public int validarC(String mns)
    {
        int c=0;
        do
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            try
            {
                System.out.println(mns);
                c=Integer.parseInt(br.readLine());
                if(c<0)
                    System.out.println("O valor de cartao valido!!");
            }
            catch(IOException z)
            {
                System.out.println(z.getMessage());
            }
        }while(c<0);
        return c;
    }
    public void fileValor(String a,int s,int c)
    {
        DecimalFormat m=new DecimalFormat("###,###.00 Mts");
        try
        {
            FileReader fr=new FileReader("Dados.txt");
            BufferedReader br=new BufferedReader(fr);
            FileWriter fw=new FileWriter(a);
            BufferedWriter bw=new BufferedWriter(fw);
            String linha;
            
            linha=br.readLine();
            while(linha!=null)
            {
            	bw.write(linha);
            	bw.newLine();
            	
            	linha=br.readLine();
            }
            bw.write("==============================");
            bw.newLine();
            bw.write("Numerario: "+m.format(s));
            bw.newLine();
            bw.write("Cartao: "+m.format(c));
            br.close();
            bw.close();
            
            /*bw.write(br.readLine());
            bw.newLine();
            bw.write(br.readLine());
            bw.newLine();
            bw.write(br.readLine());
            bw.newLine();
            bw.write("Numerario: "+m.format(s));
            bw.newLine();
            bw.write("Cartao: "+m.format(c));
            bw.close();
            br.close();*/
        }
        catch(NumberFormatException z)
        {
            System.out.println(z.getMessage());
        }
        catch(IOException x)
        {
            System.out.println(x.getMessage());
        }
        System.out.println("Fatura de Feixo criado com sucesso!!");
    }
    public int soma(int a,int b,int c)
    {
        return a+b+c;
    }
    public int valor(int q,final int V)
    {
        return q*V;
    }
    public int validarQ(String msg)
    {
        int q=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try
        {
            do
            {
                System.out.println(msg);
                q=Integer.parseInt(br.readLine());
                if(q<0)
                    System.out.println("Quantidade de notas Invalidas!!");
            }while(q<0);
        }
        catch(IOException x)
        {
            System.out.println(x.getMessage());
        }
        return q;
    }
}