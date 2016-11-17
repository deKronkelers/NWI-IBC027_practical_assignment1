package model;

import java.util.Scanner;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class Main {
    public static void main(String[] args) {
        Mobile mobile = new Mobile(new Scanner(System.in).nextLine());
        ColorCountVisitor ccv = new ColorCountVisitor();
        mobile.accept(ccv);
        SwapCountVisitor scv = new SwapCountVisitor(ccv.getRed());
        try {
            mobile.accept(scv);
            System.out.print(scv.getSwaps());
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
