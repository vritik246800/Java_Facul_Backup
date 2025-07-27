import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class AbrirFinder {

    public AbrirFinder() 
    {
    	
    }

    public void abrirDocumentos() 
    {
        try 
        {
            String os = System.getProperty("os.name").toLowerCase();
            File pastaDocumentos;

            if (os.contains("win")) 
            {
                // Windows
                String userProfile = System.getenv("USERPROFILE");
                pastaDocumentos = new File(userProfile + "\\Documents");
            }
            else if (os.contains("mac")) 
            {
                // macOS
                String home = System.getProperty("user.home");
                pastaDocumentos = new File(home + "/Music");
            }
            else if (os.contains("nux") || os.contains("nix"))
            {
                // Linux
                String home = System.getProperty("user.home");
                pastaDocumentos = new File(home + "/Documentos"); // nome comum em português
                if (!pastaDocumentos.exists()) 
                {
                    pastaDocumentos = new File(home + "/Documents"); // fallback em inglês
                }
            }
            else 
            {
                System.out.println("Sistema operacional não suportado.");
                return;
            }

            if (pastaDocumentos.exists() && Desktop.isDesktopSupported()) 
            {
                Desktop.getDesktop().open(pastaDocumentos);
            } else 
            {
                System.out.println("Pasta não encontrada ou Desktop não suportado.");
            }

        } catch (IOException e) 
        {
        	JOptionPane.showMessageDialog(null, "Erro ao abrir a pasta:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
