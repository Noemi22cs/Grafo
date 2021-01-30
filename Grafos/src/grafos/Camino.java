package grafos;
/**
 *
 * @author Noemi
 */
public class Camino {
    public String algoFloy(long[][] mAdy) {
        int vertices = mAdy.length;
        long matrizadya[][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String caminosauxiliares[][] = new String[vertices][vertices];
        String caminorecorrido = "", cadena = "", caminit = "";
        int i, j, k;
        float temp1, temp2, temp3, temp4, minimo;

        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosauxiliares[i][j] = "";
            }
        }
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temp1 = matrizadya[i][j];
                    temp2 = matrizadya[i][k];
                    temp3 = matrizadya[k][j];
                    temp4 = temp2 + temp3;

                    minimo = Math.min(temp1, temp4);
                    if (temp1 != temp4) {
                        if (minimo == temp4) {
                            caminorecorrido = "";
                            caminosauxiliares[i][j] = k + "";
                            caminos[i][j] = caminoR(i, k, caminosauxiliares, caminorecorrido) + (k + 1);
                        }
                    }
                    matrizadya[i][j] = (long) minimo;
                }
            }
        }
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena = cadena + "[" + matrizadya[i][j] + "]";
            }
            cadena = cadena + "\n";
        }
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizadya[i][j] != 100000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminit += " de ( " + (i + 1) + "-->" + (j + 1) + " ) viajar hacia...(" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminit += "de (" + (i + 1) + "-->" + (j + 1) + ") viajar hacia... (" + (i + 1) + ", " + caminos[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }
        return "La matriz de caminos mas cortos entre los diferente vertices es: \n"+ cadena +
                "\n los caminos mas cortos entre los vertices son:\n "+ caminit ;
    }
    public String caminoR(int i, int k, String[][] caminosauxiliares, String caminorecorrido){
          if(caminosauxiliares[i][k].equals("")){
             return "";
          }else{
             caminorecorrido += caminoR(i, Integer.parseInt(caminosauxiliares[i][k].toString()),
                     caminosauxiliares, caminorecorrido) + Integer.parseInt(caminosauxiliares[i][k]) + ", ";
             return caminorecorrido;             
          }
    }
}
