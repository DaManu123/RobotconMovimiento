import java.util.Random;
import java.util.Scanner;
//Autor del codigo: Manuel Munguia Rubio :D
public class Main {
    public static void main(String[] args) {
        System.out.println("Practica robot lev" + "\n");

        Robot();
    }
    public static String[][] arreglo = new String[10][10];
    public static Random r = new Random();
    public static int re,c;
    public static Scanner scn = new Scanner(System.in);
    public static void Robot(){

        System.out.println("Bienvenido a mi robot que movimiento deseas hacer:");

        re = r.nextInt(10);
        c = r.nextInt(10);
        AsignarValores(arreglo);
        System.out.println("Posicones random Renglon: " + re + " Columna: " + c);
        boolean ciclo = true;
        int auxent = 0;
        do {

            System.out.println("w = arriba, a = izquierda, s = abajo, d = derecha");
            System.out.println("        t = salir, r = reiniciar" + "\n");
            String aux = arreglo[re][c];
            arreglo[re][c] = "R";

            auxent = 1 + Integer.parseInt(aux);

            ImprimirArreglo(arreglo);
            System.out.print("opcion: ");
            String op = scn.next();
            op = MovValido(op);
            arreglo[re][c] = ""+auxent;
            switch (op){
                case "a":
                    arreglo[re][c] = ""+auxent;
                    c--;
                    break;
                case "w":
                    arreglo[re][c] = ""+auxent;
                    re--;
                    break;
                case "d":
                    arreglo[re][c] = ""+auxent;
                    c++;
                    break;
                case "s":
                    arreglo[re][c] = ""+auxent;
                    re++;
                    break;
                case "r":
                    re = r.nextInt(10);
                    c = r.nextInt(10);
                    AsignarValores(arreglo);
                    break;
                case "t":
                    ciclo = false;
                    System.out.println("Gracias por probar mi robot!!!");
                    break;
                default:

                    arreglo[re][c] = aux;
                    System.out.println("No elegiste una opcion disponible");
                    break;
            }
        }while (ciclo);
    }
    public static void ImprimirArreglo(String[][] a)
    {

        for (int i = 0; i < a.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("\t");

                System.out.print(a[i][j]);
            }

            System.out.println();
        }
    }
    public static void AsignarValores (String[][] a){
        int cer = 0;
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[0].length; j++) {
                String conta = ""+cer;
                a[i][j] = conta;

            }

        }
    }
    public static String MovValido(String a){
        if (a.equals("a")){
            if (c == 0){
                System.out.println("El robot se encuentra en un extremo y no puede moverse dame otro movimiento");
                a = scn.next();
                a = MovValido(a);
                return a;
            }
        }
        if (a.equals("w")){
            if (re == 0){
                System.out.println("El robot se encuentra en un extremo y no puede moverse dame otro movimiento");
                a = scn.next();
                a = MovValido(a);
                return a;
            }
        }
        if (a.equals("d")){
            if (c == 9){
                System.out.println("El robot se encuentra en un extremo y no puede moverse dame otro movimiento");
                a = scn.next();
                a = MovValido(a);
                return a;
            }
        }
        if (a.equals("s")){
            if (re == 9){
                System.out.println("El robot se encuentra en un extremo y no puede moverse dame otro movimiento");
                a = scn.next();
                a = MovValido(a);
                return a;
            }
        }
        return a;
    }
}