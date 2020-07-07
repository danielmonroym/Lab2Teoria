/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2teoria;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Lab2Teoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Lab1Teoria automata = new Lab1Teoria();
        boolean condicion = false;
        String noterminal, terminal, noterminal2;
        String[] vectornoterminales = new String[50];
        String[] vectorterminales = new String[50];
        int contadort = 0, contadornt = 0;

        System.out.println("Ingrese la gramatica deseada");
        while (condicion == false) {

            System.out.println("Ingrese el  no terminal");
            noterminal = sc.nextLine();
            while (noterminal.contains("<") == false || noterminal.contains(">") == false) {
                System.out.println("Recuerde que los no terminales van entre <>");
                noterminal = sc.nextLine();
            }

            vectornoterminales[contadornt] = noterminal;
            contadornt = contadornt + 1;
            System.out.println("Ingrese el  terminal(solo una caracter), si quiere usar lambda escriba lambda");
            terminal = sc.nextLine();
            while (terminal.length() != 1 && terminal.equals("lambda") == false) {
                System.out.println("error, recuerda que solo se recibe lambda o un caracter");
                terminal = sc.nextLine();
            }

            if (terminal.contains("lambda")) {

                condicion = true;
                System.out.println( noterminal +"---------->" + terminal);
            } else {
                vectorterminales[contadort] = terminal;
                contadort = contadort + 1;
                System.out.println("Ingrese el  no terminal al que se dirige  con  " + terminal);
                noterminal2 = sc.nextLine();
                while (noterminal2.contains("<") == false || noterminal2.contains(">") == false) {
                    System.out.println("Recuerde que los no terminales van entre <>");
                    noterminal2 = sc.nextLine();
                }
              System.out.println( noterminal +"---------->" + terminal+noterminal2);
            }

        }
                System.out.println(" //////////////////////");
        if (contadornt <= 5 && contadort <= 3) {
            System.out.println(" Su gramática es de la forma lineal por derecha.");
            System.out.println(" //////////////////////");
            System.out.println(" Producciones de la gramatica ingresada:");
            System.out.println(" No terminales");
            for (int i = 0; i < vectornoterminales.length; i++) {
                if (vectornoterminales[i] != null) {
                    System.out.println(vectornoterminales[i]);
                }
            }
            System.out.println(" Terminales");
            for (int i = 0; i < vectorterminales.length; i++) {
                if (vectorterminales[i] != null) {
                    System.out.println(vectorterminales[i]);
                }
            }
        } else {
            System.out.println(" Su gramática no es de la forma lineal por derecha.");

        }

    }
}
