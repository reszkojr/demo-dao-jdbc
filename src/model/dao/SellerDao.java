package model.dao;

import model.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller dp);
    void update(Seller dp);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
}
