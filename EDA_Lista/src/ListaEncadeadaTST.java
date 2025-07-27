import static javax.swing.UIManager.get;

    // @author fsaiete
 
public class ListaEncadeadaTST 
{
    public static void main(String []args)
    {   
        ListaEncadeada myLista=new ListaEncadeada();
        Lista lista=myLista; 
        
        Empregado emp1 = new Empregado(100,"Weng","Especialista em segurança de dados",115000);
        Empregado emp2 = new Empregado(101,"Paloma","Tecnica de contas",215000);
        Empregado emp3 = new Empregado(102,"Queen","gestora de projectos",225000);
        Empregado emp4 = new Empregado(103,"Vickie","Servente",11000);
        Empregado emp5 = new Empregado(104,"Massuque","Arquitecto",160000);
        Empregado emp6 = new Empregado(105,"Bambo","Motorista",8000);
        
        lista.createEmptyList();
        
        lista.add(emp1);
        lista.add(emp2);
        lista.add(emp3);
        
        lista.add(3,emp1);
        
        
        System.out.println();
         
        System.out.println("Elemento na posição 1: \n"+lista.get(1).toString());
        System.out.println("Elemento na posição 2: \n"+lista.get(2).toString());
        System.out.println("Elemento na posição 3: \n"+lista.get(3).toString());
        
            lista.add(2, emp4);
        
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
        
    }
    
}