package main;

import model.Mobile;

import java.util.Scanner;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class Main {
    public static void main(String[] args) {
        System.out.print(
                new Mobile(new Scanner(System.in).nextLine())
        );
    }
}
