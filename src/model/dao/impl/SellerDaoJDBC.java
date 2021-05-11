package model.dao.impl;

import db.DB;
import db.DbException;
import model.Department;
import model.Seller;
import model.dao.SellerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller dp) {

    }

    @Override
    public void update(Seller dp) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                        "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE seller.Id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                int depId = rs.getInt("departmentId");
                String depName = rs.getString("depName");
                Department dep = new Department(depId, depName);

                int objId = rs.getInt("Id");
                double objBaseSalary = rs.getDouble("BaseSalary");
                String objName = rs.getString("Name");
                String objEmail = rs.getString("Email");
                Date objBirthDate = rs.getDate("BirthDate");

                Seller obj = new Seller(objId, objName, objEmail, objBirthDate, objBaseSalary, dep);

                return obj;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


    @Override
    public List<Seller> findAll() {
        return null;
    }
}

