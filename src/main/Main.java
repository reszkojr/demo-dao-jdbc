package main;

import model.Department;
import model.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        List<Seller> list;

        System.out.println("--- Test 1: seller findById ---");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("--- Test 2: seller findByDepartment ---");
        Department department = new Department(2, null);
        list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: seller findAll =====");

        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());

    }
}

