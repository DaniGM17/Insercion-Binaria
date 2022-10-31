import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class InsercionBinaria {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[] leerArreglo(int n) throws IOException {
        int[] a = new int[n];
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.println("Escriba el valor [" + i + "]: ");
            entrada = bufer.readLine();
            a[i] = Integer.parseInt(entrada);
        }
        return a;
    }

    public static int[] insercionBinaria(int[] listaD) {
        for (int i = 1; i < listaD.length; i++) {
            int mantener = listaD[i];
            int insertar = posicion(listaD, 0, i-1, mantener);
            
            for(int j = i -1; j>=insertar; j--){
                listaD[j+1] = listaD[j];
            }
            listaD[insertar]=mantener;
        }
        return listaD;

    }
    
    public static int posicion(int[] lista, int inicio, int fin, int mantener){
        while(inicio<=fin){
            int m = inicio + (fin - inicio) / 2;
            if(mantener < lista[m]){
                fin = m - 1;
            }else{
                inicio = m + 1;
            }
        }
        return inicio;
    }

    public static void imprimirArreglo(int[] a) {
        System.out.println("-------------------------");
        System.out.println("Lista ordenada");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int[] array;
        int t;
        System.out.println("Programa que ordena la lista de números");
        System.out.println("Escribe la longitud de la lista a ingresar: ");
        entrada = bufer.readLine();
        t = Integer.parseInt(entrada);
        array = leerArreglo(t);
        array = insercionBinaria(array);
        imprimirArreglo(array);
    }

}
