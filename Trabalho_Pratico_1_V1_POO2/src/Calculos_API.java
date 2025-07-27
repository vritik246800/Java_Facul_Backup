
public interface Calculos_API 
{
	public static final float TAX25=25/100f,IVA16=16/100f,IVA8=8/100f;
	public static final float DESCONTO5=5/100f,DESCONTO3=3/100f;
	
	public abstract float iva();
	public abstract float desconto();
}
