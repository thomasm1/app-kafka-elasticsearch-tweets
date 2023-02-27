package app.mapl.dao;

import app.mapl.models.OfferLogic;
import app.mapl.util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferLogicDAOImpl implements OfferLogicDAO {

    public static Connection conn = JDBCConnection.getConnection();

    public boolean addOfferLogic(OfferLogic el) {
        String sql = "CALL add_new_market(?,?,?, ?,?,?, ?,?,?)";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, Integer.toString(el.getOfferid()));
            cs.setString(2, Integer.toString(el.getCoinid()));
            cs.setString(3, el.getUserName());
            cs.setString(4, Double.toString(el.getPricetotal()));
            cs.setString(5, Double.toString(el.getOfferamt()));
            cs.setString(6, Double.toString(el.getBalance()));
            cs.setString(7, Integer.toString(el.getOffermos()));
            cs.setString(8, Integer.toString(el.getMonthsRemaining()));
            cs.setString(9, Double.toString(el.getMonthlyPayments()));
            cs.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Large Number Warning-Use higher precision");
            e.printStackTrace();
        }
        return false;
    }
    public OfferLogic getOfferLogic(int id) {
        try {
            String sql = "SELECT * FROM market WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(id));
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
//                				return new OfferLogic(rs.getInt("ID"), rs.getString("userNAME"), rs.getString("---"));
            }

        } catch (Exception e) {
            System.out.println("(id): check SQL");
            e.printStackTrace();
        }
        return null;
    }

    public OfferLogic getOfferLogic(String username) {

        try {
            String sql = "SELECT * FROM market WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                return new OfferLogic(rs.getInt("ID"), rs.getInt("OFFERID"), rs.getInt("COINID"), rs.getString("USERNAME"),  rs.getDouble("PRICETOTAL"), rs.getDouble("OFFERAMT"), rs.getDouble("BALANCE"), rs.getInt("OFFERMOS"), rs.getInt("monthsRemaining"), rs.getDouble("MONTHLYPAYMENTS"));
            }

        } catch (SQLException e) {
            System.out.println("GetElectrolot(username): check SQL");
            e.printStackTrace();
        }
        return null;
    }

    public List<OfferLogic> getAllOfferLogic(String username) {
        //		String sql2 = "SELECT o.username,  o.coinid,  o.offerstatus,  o.offermos, c.coinid, c.cointoken, c.coinsymbol, c.pricetotal FROM offers o JOIN cointable c ON c.coinid = o.coinid WHERE o.offerstatus = 'APPROVED' AND o.username = ?";
        String sql2 = "SELECT * FROM market WHERE username = ?";
        List<OfferLogic> offerLogics = new ArrayList<OfferLogic>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                offerLogics.add(new OfferLogic(rs.getInt("ID"),  rs.getInt("OFFERID"), rs.getInt("COINID"),
                        rs.getString("USERNAME"),  rs.getDouble("PRICETOTAL"), rs.getDouble("OFFERAMT"),
                        rs.getDouble("BALANCE"), rs.getInt("OFFERMO" +
                        "S"), rs.getInt("MonthsRemaining"),
                        rs.getDouble("MonthlyPayments")));
            }
            return offerLogics;
        } catch (SQLException e) {
            System.out.println("Double Check Updated DB's Electrolot customer's list");
            e.printStackTrace();
        }
        return null;
    }
    public List<OfferLogic> getAllOfferLogic() {
        String sql = "SELECT * FROM market";
        List<OfferLogic> offerLogic = new ArrayList<OfferLogic>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                offerLogic.add(new OfferLogic(rs.getInt("ID"),  rs.getInt("OFFERID"), rs.getInt("CARID"),
                        rs.getString("USERNAME"),  rs.getDouble("PRICETOTAL"), rs.getDouble("OFFERAMT"), rs.getDouble("BALANCE"), rs.getInt("OFFERMOS"), rs.getInt("MonthsRemaining"), rs.getDouble("MonthlyPayments")));
            }
            return offerLogic;
        } catch (SQLException e) {
            System.out.println("Double Check Updated DB's (GETALL) customer's list");
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateOfferLogic(OfferLogic change) {
        String sql = "UPDATE market SET username = ?, coinid = ? WHERE offerid = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, change.getUserName());
            ps.setString(2, Integer.toString(change.getCoinid()));
            ps.setString(3, Integer.toString(change.getOfferid()));

            ps.executeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println("Double Check Updated DB's Electrolot update customer's list");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOfferLogic(int id) {
        String sql = "DELETE market WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(id));
            ps.executeQuery();

            return true;
        } catch (SQLException e) {
            System.out.println("exception " + e);
            System.out.println("Double Check Deletions on DB's customer's list");
            e.printStackTrace();
        }
        return false;
    }


}