// Interface base para listas
public interface Lista<T> 
{
    void createEmptyList();
    void add(T elem);                 // Adiciona no fim
    void add(int pos, T elem);        // Adiciona em posição específica
    T get(int pos);                   // Retorna elemento
    void remove(int pos);            // Remove elemento
    int size();                      // Retorna tamanho
    void listar();                   // Lista todos os elementos
}