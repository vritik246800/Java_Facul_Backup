public class Gato
{
    public static void main(String[] args) 
    {
        int altura = 10;
        int largura = 20;

        for (int i = 0; i < altura; i++) 
        {
            for (int j = 0; j < largura; j++) 
            {
                // Orelhas
                if ((i == 0 && (j == 2 || j == 17)) ||
                    (i == 1 && (j == 1 || j == 18))) 
                {
                    System.out.print("^");
                }
                // Cabeça contorno
                else if ((i == 2 && (j >= 4 && j <= 15)) ||
                         (i == 3 && (j == 3 || j == 16)) ||
                         (i == 6 && (j >= 4 && j <= 15))) 
                {
                    System.out.print("-");
                }
                // Olhos
                else if (i == 4 && (j == 6 || j == 13)) 
                {
                    System.out.print("o");
                }
                // Nariz
                else if (i == 5 && j == 9) 
                {
                    System.out.print("w");
                }
                // Bigodes
                else if (i == 5 && (j == 5 || j == 6 || j == 12 || j == 13)) 
                {
                    System.out.print("~");
                }
                // Corpo simples
                else if (i >= 7 && (j >= 7 && j <= 12)) 
                {
                    System.out.print("|");
                }
                // Espaço vazio
                else 
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
