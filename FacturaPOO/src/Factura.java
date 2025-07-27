import java.io.*;
import java.text.DecimalFormat;

public class Factura 
{
  private int codigo, quantidadeLitros;
  private String nome, tipo, bairro;
  private float taxaLitro, valorTotal, imposto, valorFinal;
  private DecimalFormat mt;
  private Validacoes val;
  private Calculos cal;
    
  public Factura() //construtor leitura teclado
  {
	val = new Validacoes();
	cal = new Calculos();
    codigo = val.validarInt(1011,2011,"Introduza o codigo(1011-2011): ");
    nome = val.validarString("Introduza o nome:");
    tipo = val.validarString("Particular","Empresa","Introduza o tipo de cliente(Particular ou Empresa):");
    bairro = val.validarString("Central","Polana","Introduza o bairro(Central ou Polana):");
    quantidadeLitros = val.validarInt("Introduza a quantidade de litros(>=0)");
    taxaLitro = 2.3f;
    valorTotal = calcular();
    imposto = calcularImposto();
    valorFinal = calcularFinal();
    mt = new DecimalFormat("###,###.00 MTS");
  }
  
  public float calcularFinal()
  {
	return valorTotal + imposto;
  }
  
  public float calcularImposto()
  {
	final float P = 5/100f, E = 15/100f;
	
	if(tipo.equalsIgnoreCase("Particular"))
		return P * valorTotal;
	else
		return E * valorTotal;
  }
  
  public float calcular()
  {
	return quantidadeLitros * taxaLitro;
  }
  
	public int getCodigo() {
		return codigo;
	}
	
	public int getQuantidadeLitros() {
		return quantidadeLitros;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public float getImposto() {
		return imposto;
	}
	
	public float getValorFinal() {
		return valorFinal;
	}

	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", quantidadeLitros=" + quantidadeLitros + ", nome=" + nome + ", tipo="
				+ tipo + ", bairro=" + bairro + ", valorTotal=" + mt.format(valorTotal) + ", imposto=" + mt.format(imposto) + ", valorFinal="
				+ mt.format(valorFinal) + "]";
	}
}