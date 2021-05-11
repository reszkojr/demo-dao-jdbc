package main;

import model.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);
    }
}
