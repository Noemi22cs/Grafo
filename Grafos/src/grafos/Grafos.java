package grafos;
import java.time.Clock;
import javax.swing.JOptionPane;
/**
 *
 * @author Noemi
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op=0, opc;       
        do {
            try {
               op = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Crear grafo "
                       + "\n2. Salir", "Opciones", JOptionPane.INFORMATION_MESSAGE));
                switch (op) {

                    case 1:
                       int vertices = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese  el número de vertices para el grafo:", "Crear grafo", JOptionPane.INFORMATION_MESSAGE));
                        long  matrizadya[][] = new long[vertices][vertices];
                        for (int i = 0; i < vertices; i++) {
                            for (int j = 0; j < vertices; j++) {
                                 matrizadya[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,
                                         "Introduzca el costo de la arista entre los vertices [" + (i + 1) + "] [" + (j + 1) + "]:", 
                                         "La distancia  de aristas", JOptionPane.INFORMATION_MESSAGE));
                            }
                        }

                        do {
                            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar matriz de adyacencia \n"
                                    + "2. Mostrar caminos más cortos \n"
                                    + "3. Buscar arista\n 4.salir", "Opciones", JOptionPane.INFORMATION_MESSAGE));
                            switch (opc) {
                                case 1:
                                    String cadena = "";
                                    long matrizAdyacencia[][] =  matrizadya;
                                    for (int i = 0; i < vertices; i++) {
                                        for (int j = 0; j < vertices; j++) {
                                            cadena = cadena +"[" + matrizAdyacencia[i][j] + "]";
                                        }
                                        cadena = cadena + "\n";
                                    }
                                    JOptionPane.showMessageDialog(null, "La matriz de adyacencia del grafo es: \n" + cadena);
                                    break;

                                case 2:
                                    Camino ruta = new Camino();
                                    JOptionPane.showMessageDialog(null, ruta.algoFloy(matrizadya));
                                    break;
                                case 3:
                                    int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la arista a buscar:", "Buscar arista", JOptionPane.INFORMATION_MESSAGE));
                                    for (int i = 0; i < vertices; i++) {
                                        for (int j = 0; j < vertices; j++) {
                                            if (buscar ==  matrizadya[i][j]) {
                                                JOptionPane.showMessageDialog(null, "La arista se encuentra entre los vertices " + (i + 1) + " y " + (j + 1));
                                            }
                                        }
                                    }
                                    break;
                            }
                        } while (opc != 4);
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inexistente");
                        break;
                }
            } catch (Exception w) {
                JOptionPane.showMessageDialog(null, "Error \nvuelva a intentarlo");
            }
        } while (op >= 2);
    }   
}
