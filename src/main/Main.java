package main;

import model.Department;
import model.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department dp = new Department(1, "Books");
        Seller sl = new Seller(1, "Amando", "amando@amando.amando", new Date(), 3000.0, dp);
        System.out.println(dp);
        System.out.println(sl);
    }
}
