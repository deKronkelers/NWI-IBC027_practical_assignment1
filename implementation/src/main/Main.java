package main;

import model.ColorCountVisitor;
import model.Mobile;
import model.SwapCountVisitor;

import java.util.Scanner;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class Main {
    public static void main(String[] args) {
        Mobile mobile = new Mobile(new Scanner(System.in).nextLine());
        System.out.print(mobile);
        SwapCountVisitor scv = new SwapCountVisitor();
        mobile.accept(scv);
    }
}
