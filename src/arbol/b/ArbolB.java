/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol.b;
import java.util.Scanner;
/**
 *
 * @author cachi
 */

public class ArbolB {

    public static void main(String[] args) {
        Scanner sc = 
                new Scanner(System.in);
        System.out.print
        ("INGRESE EL GRADO DE ARBOL QUE DESEA > 2: ");
        
        int t = 
                sc.nextInt();
        BTree tree = 
                new BTree(t);

        while (true) {
            System.out.println("\n1. INSERTE UNA CLAVE ");
            System.out.println("2. BUSCAR CLAVE");
            System.out.println("3. MOSTRAR ARBOL");
            System.out.println("4. SALIR");
            System.out.print("\nOPCIÓN: ");
            int op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print
                    ("QUE CLAVE DESEA INSERTAR: ");
                    int k = sc.nextInt();
                    tree.insert(k);
                }
                case 2 -> {
                    System.out.print
                    ("QUE CLAVE DESEA: ");
                    int k = sc.nextInt();
                    tree.search(k);
                }
                case 3 -> {
                    System.out.print
                    ("EL ARBOL CONTIENE LO SIGUIENTE: ");
                    tree.traverse();
                    System.out.println();
                }
                case 4 -> System.exit(0);
                default -> System.out.println
                       ("OPCIÓN INCORRECTA: ");
            }
        }
    }
}
