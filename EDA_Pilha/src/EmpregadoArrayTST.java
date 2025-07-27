public class EmpregadoArrayTST 
{
    public static void main(String []args)
    {   
        
        ImplementaPilha p=new ImplementaPilha(5);
        Pilha pilha=p;
        
        Empregado emp0 = new Empregado(100,"Weng","Especialista em segurança de dados",115000);
        Empregado emp1 = new Empregado(101,"Paloma","Tecnica de contas",215000);
        Empregado emp2 = new Empregado(102,"Queen","gestora de projectos",225000);
        Empregado emp3 = new Empregado(103,"Vickie","Servente",11000);
        Empregado emp4 = new Empregado(104,"Massuque","Arquitecto",160000);
        Empregado emp5 = new Empregado(105,"Bambo","Motorista",8000);
        
        pilha.push(emp0);
        pilha.push(emp1);
        pilha.push(emp2);
        pilha.push(emp3);
        pilha.push(emp4);
        
        System.out.println("Total de Empregados na pilha: "+pilha.size());
        
        System.out.println("Empregado no topo da pilha: \n"+pilha.top().toString());
        System.out.println(" Empregado a ser removido no topo da pilha: \n"+pilha.pop().toString());
 
        System.out.println("Novo Empregado na posição topo da pilha: \n"+pilha.top().toString());
        System.out.println("Total de Empregados após remoção do primeiro: "+pilha.size());

        pilha.pop();
        pilha.pop();
        pilha.pop();
        
        System.out.println("Total de Empregados após remoção de mais três: "+pilha.size());
        System.out.println("Último Empregado removido da pilha: \n"+pilha.pop().toString());
        System.out.println("Total de Empregados após remoção do último: "+pilha.size());
        
     }
}