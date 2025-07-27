import static javax.swing.UIManager.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    // @author fsaiete
 
public class ListaEncadeadaTST 
{
    public static void main(String []args)throws IOException 
    {   
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ListaEncadeada le=new ListaEncadeada();
        Lista lista=le;
        lista.createEmptyList();
        
        int opcao,op1;
        
        do
        {
        	System.out.println("  ┌──────────────────────────────┐");
        	System.out.println("  │            M E N U           │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ 1. Lista de dias             │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ 2. Lista de alunos           │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ 3. Nomes dos programadores   │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ 4. Sair do programa          │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ Opção(1-4) :                 │");
        	System.out.println("  └──────────────────────────────┘");
        	op1 = Integer.parseInt(br.readLine());
        	
        	switch(op1)
        	{
        		case 1:
        			do
        			{
	        			System.out.println("  ┌──────────────────────────────┐");
	                	System.out.println("  │         Lista de dias        │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 1. Adicionar 7 elementos     │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 2. Adicionar Novo elemento   │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 3. Remover o ultimo elemento │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 4. Voltar                    │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ Opção(1-4) :                 │");
	                	System.out.println("  └──────────────────────────────┘");
	                	opcao = Integer.parseInt(br.readLine());
	                	
	        			 switch (opcao) 
	        	         {
        	            	case 1:
		                		Dia_Mes m1=new Dia_Mes("Segunda",2);
		                        Dia_Mes m2=new Dia_Mes("Terca",3);
		                        Dia_Mes m3=new Dia_Mes("Quinta",5);
		                        Dia_Mes m4=new Dia_Mes("Sexta",6);
		                        Dia_Mes m5=new Dia_Mes("Sabado",7);
		                        Dia_Mes m6=new Dia_Mes("Domingo",1);
		                        Dia_Mes m7=new Dia_Mes("Marco",3);
		                        
		                        
		                        
		                        lista.add(m1);
		                        lista.add(m2);
		                        lista.add(m3);
		                        lista.add(m4);
		                        lista.add(m5);
		                        lista.add(m6);
		                        lista.add(m7);
		                        
		                        for(int i=1;i<=lista.size();i++)
		                        {
		                        	System.out.println("Elemento na posição "+i+" :"+lista.get(i).toString());
		                        }
		                		break;
		                	case 2:
		                		 	System.out.println("Para adicionar novo elemento que e Quarta feira: ");
		                	        Dia_Mes m8=new Dia_Mes("Quarta",4);
		                	        lista.add(m8);
		                	        for(int i=1;i<=lista.size();i++)
		                	        {
		                	        	System.out.println("Elemento na posição "+i+" :"+lista.get(i).toString());
		                	        }
		                		break;
		                	case 3:
		                			System.out.println("Para remover o ultimo elemento: ");
		                	        lista.remove(lista.size());
		                	        System.out.println("Removido com Sucesso ! ");
		                	        for(int i=1;i<=lista.size();i++)
		                	        {
		                	        	System.out.println("Elemento na posição "+i+" :"+lista.get(i).toString());
		                	        }
		                		break;
		                	case 4:
		                		break;
                		}
        			}while(opcao!=4);
        			 break;
        		case 2:
        			do
        			{
        				System.out.println("  ┌──────────────────────────────┐");
                    	System.out.println("  │         Lista de alunos      │");
                    	System.out.println("  ├──────────────────────────────┤");
                    	System.out.println("  │ 1. Adicionar 4 elementos     │");
                    	System.out.println("  ├──────────────────────────────┤");
                    	/*System.out.println("  │ 2. Adicionar Novo elemento   │");
                    	System.out.println("  ├──────────────────────────────┤");
                    	System.out.println("  │ 3. Remover o ultimo elemento │");
                    	System.out.println("  ├──────────────────────────────┤");*/
                    	System.out.println("  │ 2. Voltar                    │");
                    	System.out.println("  ├──────────────────────────────┤");
                    	System.out.println("  │ Opção(1-7) :                 │");
                    	System.out.println("  └──────────────────────────────┘");
                    	opcao = Integer.parseInt(br.readLine());
            			switch (opcao) 
        	            {
        	            	case 1:
        	            		Alunos a1=new Alunos("Paula",3);
        	            		Alunos a2=new Alunos("Paula",3);
        	            		Alunos a3=new Alunos("Paula",3);
        	            		Alunos a4=new Alunos("Paula",3);
        	            		
        	            		lista.add(a1);
        	            		lista.add(a2);
        	            		lista.add(a3);
        	            		lista.add(a4);
        	            		
        	            		for(int i=1;i<=lista.size();i++)
        	            		{
        	            			System.out.println("Elemento na posição "+i+" :"+lista.get(i).toString());
        	            		}
        	            		break;
        	            		/*case 2:
    		                		 	System.out.println("Para adicionar novo elemento que e Quarta feira: ");
    		                	        Dia_Mes m8=new Dia_Mes("Quarta",4);
    		                	        lista.add(m8);
    		                	        for(int i=1;i<=lista.size();i++)
    		                	        {
    		                	        	System.out.println("Elemento na posição "+i+" :"+lista.get(i).toString());
    		                	        }
    		                		break;
    		                	case 3:
    		                			System.out.println("Para remover o ultimo elemento: ");
    		                	        lista.remove(lista.size());
    		                	        System.out.println("Removido com Sucesso ! ");
    		                	        for(int i=1;i<=lista.size();i++)
    		                	        {
    		                	        	System.out.println("Elemento na posição "+i+" :"+lista.get(i).toString());
    		                	        }
    		                		break;
    		                	case 4:
    		                		break;*/
        	            }
        			}while(opcao!=2);
        			break;
        		case 3:
        			System.out.println("┌──────────────────────────────────────────────────────────────┐");
					System.out.println("│			Nomes dos Programadores		       │");
					System.out.println("├──────────────────────────────────────────────────────────────┤");
					System.out.println("│ Vritik Valabdas│ Vicente Macuacua│ Yasin Magno │ Aashir Omar │");
					System.out.println("├──────────────────────────────────────────────────────────────┤");
					System.out.println("│			Codico de Estudante	               │");
					System.out.println("├──────────────────────────────────────────────────────────────┤");
					System.out.println("│ 	20190025 │	 20240208  │ 20240260 	 │    20240143 │");
					System.out.println("└──────────────────────────────────────────────────────────────┘");
        			break;
        		case 4:
        			System.out.println("Obrigado por usar o programa !");
        			break;
        		default:
        			System.out.println("Opcao invalida !");
        	}
        	
        }while(op1!=4);
        
       
      /*      lista.add(2, emp4);
        w 
        System.out.println("Total de Elementos na Lista: "+lista.size());
        
        System.out.println("------- LISTA ACUALIZADA COM A INCLUSÃO DO 4º OBJECTO NA POSIÇÃO 2 DA LISTA -------");
        System.out.println("Elemento na posição 1: \n"+lista.get(1).toString());
        System.out.println("Elemento na posição 2: \n"+lista.get(2).toString());
        System.out.println("Elemento na posição 3: \n"+lista.get(3).toString());
        System.out.println("Elemento na posição 4: \n"+lista.get(4).toString());
        
            lista.add(emp5);
            lista.add(emp6);
            
        System.out.println("------- LISTA ACUALIZADA COM A INCLUSÃO DO 5º E 6º EMPREGADOS NO FIM DA LISTA -------");
        
        System.out.println("Elemento na posição 1: \n"+lista.get(1).toString());
        System.out.println("Elemento na posição 2: \n"+lista.get(2).toString());
        System.out.println("Elemento na posição 3: \n"+lista.get(3).toString());
        System.out.println("Elemento na posição 4: \n"+lista.get(4).toString());
        System.out.println("Elemento na posição 5: \n"+lista.get(5).toString());
        System.out.println("Elemento na posição 6: \n"+lista.get(6).toString());
        
        System.out.println("Total de Elementos na Lista: "+lista.size());
        
            lista.remove(5);
        
        System.out.println("------- LISTAGEM APÓS REMOÇÃO DO 5º EMPREGADO DA LISTA -------");
        
        System.out.println("Elemento na posição 1: \n"+lista.get(1).toString());
        System.out.println("Elemento na posição 2: \n"+lista.get(2).toString());
        System.out.println("Elemento na posição 3: \n"+lista.get(3).toString());
        System.out.println("Elemento na posição 4: \n"+lista.get(4).toString());
        System.out.println("Elemento na posição 5: \n"+lista.get(5).toString());
        

        System.out.println("Total de Elementos na Lista: "+lista.size());
        */
    }
    
}