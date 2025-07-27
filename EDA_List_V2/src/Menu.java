import java.io.*;

public class Menu 
{
	public Menu()
	{
		
	}
	public void menu()throws IOException 
	{
		Agenda agenda = new Agenda();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcao;

        do {
        	System.out.println("  ┌──────────────────────────────┐");
        	System.out.println("  │            M E N U           │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ 1. Iniciar o programa        │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ 2. Nomes dos programadores   │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ 3. Sair do programa          │");
        	System.out.println("  ├──────────────────────────────┤");
        	System.out.println("  │ Opção(1-3) :                 │");
        	System.out.println("  └──────────────────────────────┘");

            opcao = Integer.parseInt(br.readLine());
            
            switch (opcao) 
            {
            	case 1:
            		
            		do
            		{
            			System.out.println("  ┌──────────────────────────────┐");
	                	System.out.println("  │       AGENDA DE CONTATOS     │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 1. Adicionar contato no fim  │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 2. Adicionar por posição     │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 3. Remover contato           │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 4. Consultar por posição     │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 5. Listar todos              │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 6. Total de contatos         │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 7. Inserir dias da semana    │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ 8. Voltar                    │");
	                	System.out.println("  ├──────────────────────────────┤");
	                	System.out.println("  │ Opção(1-7) :                 │");
	                	System.out.println("  └──────────────────────────────┘");
	                	opcao = Integer.parseInt(br.readLine());
	                	switch (opcao) 
	                	{
		                    case 1:
		                    	System.out.println("┌──────────────────┐");
		                        System.out.println("│ Introduz o nome: │");
		                        System.out.println("└──────────────────┘");
		                        
		                        String nome = br.readLine();
		                        
		                        System.out.println("┌────────────────────────────────┐");
		                        System.out.println("│ Introduz o numero de Telefone: │");
		                        System.out.println("└────────────────────────────────┘");
		                        
		                        String telefone = br.readLine();
		                        agenda.inserirContato(new Contato(nome, telefone));
		                        
		                        System.out.println("┌────────────────────────────────┐");
		                        System.out.println("│ Contato adicionado com sucesso!│");
		                        System.out.println("└────────────────────────────────┘");
		                        break;
		                    case 2:
		                    	System.out.println("┌─────────────────────┐");
		                        System.out.println("│ Introduz a Posição: │");
		                        System.out.println("└─────────────────────┘");
		                        
		                        int pos = Integer.parseInt(br.readLine());
		                        
		                        System.out.println("┌──────────────────┐");
		                        System.out.println("│ Introduz o nome: │");
		                        System.out.println("└──────────────────┘");
		                        
		                        nome = br.readLine();
		                        
		                        System.out.println("┌────────────────────────────────┐");
		                        System.out.println("│ Introduz o numero de Telefone: │");
		                        System.out.println("└────────────────────────────────┘");
		                        
		                        telefone = br.readLine();
		                        
		                        try 
		                        {
		                            agenda.inserirContato(pos, new Contato(nome, telefone));
		                            System.out.println("┌───────────────────────────────┐");
		                            System.out.println("│ Contato inserido com sucesso! │");
		                            System.out.println("└───────────────────────────────┘");
		                        } catch (RuntimeException e) {
		                            System.out.println("Erro: " + e.getMessage());
		                        }
		                        break;
		                    case 3:
		                    	System.out.println("┌───────────────────────────────┐");
		                        System.out.println("│ Posição do contato a remover: │");
		                        System.out.println("└───────────────────────────────┘");
		                        
		                        pos = Integer.parseInt(br.readLine());
		                        
		                        try 
		                        {
		                            agenda.removerContato(pos);
		                            
		                            System.out.println("┌───────────────────────────────┐");
		                            System.out.println("│ Contato removido com sucesso! │");
		                            System.out.println("└───────────────────────────────┘");
		                        } catch (RuntimeException e) 
		                        {
		                            System.out.println("Erro: " + e.getMessage());
		                        }
		                        break;
		                    case 4:
		                    	System.out.println("┌─────────────────────┐");
		                        System.out.println("│ Introduz a Posição: │");
		                        System.out.println("└─────────────────────┘");
		                        
		                        pos = Integer.parseInt(br.readLine());
		                        
		                        try 
		                        {
		                            agenda.verContato(pos);
		                        } catch (RuntimeException e)
		                        {
		                            System.out.println("Erro: " + e.getMessage());
		                        }
		                        break;
		                    case 5:
		                        agenda.listarContatos();
		                        break;
		                    case 6:
		                        System.out.println("Total de contatos: " + agenda.totalContatos());
		                        break;
		                    case 7:
		                    	
		                    	do
		                    	{
		                    		
		                    		System.out.println("  ┌──────────────────────────────┐");
		                        	System.out.println("  │            M E N U           │");
		                        	System.out.println("  ├──────────────────────────────┤");
		                        	System.out.println("  │ 1.Inserir dia da semana      │");
		                        	System.out.println("  ├──────────────────────────────┤");
		                        	System.out.println("  │ 2.Retornar para o menu       │");
		                        	System.out.println("  └──────────────────────────────┘");
		                        	
		                        	opcao = Integer.parseInt(br.readLine());
		                        	switch(opcao)
		                        	{
		                        		case 1:
		                        			System.out.println("┌───────────────────────────────────────────────────────┐");
		    		                    	System.out.println("│ Segunda, Terca, Quinta, Sexta, Sabado, Domingo, Marco │");
		    		                    	System.out.println("└───────────────────────────────────────────────────────┘");
		                        			//agenda.inserirContato(4,"Segunda");
		                        			break;
		                        		case 2:
		                        			break;
		                        	}
		                        	
		                    	}while(opcao!=2);
		                    	
		                    	
		                    	break;
		                    case 8:
		                    	System.out.println("┌─────────────────────────────────────────┐");
		                        System.out.println("│ Retorna por mais o uso do nosso servico │");
		                        System.out.println("└─────────────────────────────────────────┘");
		                        break;
		                    default:
		                    	System.out.println("┌────────────────────────────────────┐");
		                        System.out.println("│ Opção inválida!, tente novamente ! │");
		                        System.out.println("└────────────────────────────────────┘");
		                        break;
	                	}
            			
            		}while(opcao!=7);
            		
            		
            		break;
            	case 2:
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
            	case 3:
            		System.out.println("┌──────────────────────────────────────┐");
                    System.out.println("│ Obrigado por usar o nosso programa ! │");
                    System.out.println("└──────────────────────────────────────┘");
            		break;
            	default:
        			System.out.println("Opcao invalida !");
            }
            

        } while (opcao != 3);
	}
}
