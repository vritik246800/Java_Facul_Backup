
public interface API 
{
	public static final float TAX25=25/100f,TAX15=15/100f,IMPOSTO=10/100f,IVA16=16/100f,IVA8=8/100f;
	public static final float DESCONTO5=5/100f,DESCONTO3=3/100f;
	public static final int TAXADOANEIRO10=10000,TAXINSPENSAO5=5000;
	public abstract float direitosAdoaneiro();
	public abstract float imposto();
	public abstract float iva();
	public abstract float desconto();
}
