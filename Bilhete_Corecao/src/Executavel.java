
public class Executavel 
{
	public static void main(String[] args) 
	{
		Tarefas tf = new Tarefas();
		tf.lerFicheiro();
		System.out.println(tf);
		tf.adaptQuantidadeBilhetesTipo();
		tf.adaptEscritaFichObj();
		tf.adaptLeituraFichObj();
		tf.adaptPesquisarBilheteCodigo();
		tf.adaptRemoverBilheteCodigo();
		tf.adaptAlterarMilhasCodigo();
		tf.adaptCalcularValTotalRecebido();
		tf.adaptVisualizarVooMaisLongo();
	}
}
