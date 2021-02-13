package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 05/07/2017.
 */
public class DerivViewDAO{

    public static ObservableList<DerivView> getEntryDerivViewList(int id) {
        ObservableList<DerivView> entryDerivViewList = FXCollections.observableArrayList();
        DerivView                 derivView          = null;
        String selectStmt = "SELECT * FROM derivview dv " + "WHERE dv.entryidfrom = " + id + " " + "AND dv.refgloss is not null;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            while (rs.next()) {
                derivView = new DerivView();
                derivView.setEntryidfrom(rs.getInt("entryidfrom"));
                derivView.setEntryidto(rs.getInt("entryidto"));
                derivView.setRefidfrom(rs.getInt("refidfrom"));
                derivView.setRefidto(rs.getInt("refidto"));
                derivView.setLanguageto(rs.getString("languageto"));
                derivView.setFormtxt(rs.getString("formtxt"));
                derivView.setSourcename(rs.getString("sourcename"));
                derivView.setSourceprefix(rs.getString("sourceprefix"));
                derivView.setSourcestring(rs.getString("sourcestring"));
                derivView.setSourcetypetxt(rs.getString("sourcetypetxt"));
                derivView.setEntrygloss(rs.getString("entrygloss"));
                derivView.setRefgloss(rs.getString("refgloss"));
                derivView.setOrdering(rs.getInt("lforder"));
                entryDerivViewList.add(derivView);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(
                    "Error fetching the Deriv view type linked to Entry / Lexicon " + "with id = " + id + ": " + e);
        }
        return entryDerivViewList;
    }
}
