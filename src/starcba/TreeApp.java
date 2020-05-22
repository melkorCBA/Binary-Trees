package starcba;

import java.util.Scanner;
import java.io.IOException;

public class TreeApp {

    public static void clearSccreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public static void promptEnterKey() {
        System.out.println("\n\nPress \"ENTER\" to continue...");
        try {
            System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {

        Tree newTree = new Tree();
        Scanner input = new Scanner(System.in);
        int menuIteam = 0;

        clearSccreen();
        do {
            promptEnterKey();
            clearSccreen();
            System.out.println("\nMain menu");
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Search");
            System.out.println("4.Display");
            System.out.println("5.Exit");

            System.out.println("\nPick a task");
            menuIteam = input.nextInt();
            switch (menuIteam) {

                case 1:
                    System.out.println("Enter the new value");
                    newTree.insert(input.nextInt());
                    break;
                case 2:
                    System.out.println("Enter the Key to delete");
                    newTree.delete(input.nextInt());
                    break;
                case 3:
                    System.out.println("Enter the Key to search");
                    newTree.find(input.nextInt());
                    break;
                case 4:
                    System.out.println("Current tree:");
                    newTree.inOrderTraverse(newTree.root);
                    break;

                default:
                    System.err.println("Invalid menu iteam !!");
            }

        } while (menuIteam != 0);

    }
}
