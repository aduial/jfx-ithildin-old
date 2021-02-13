package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 07/07/2017.
 */
public class RefcognateDAO{

    public static ObservableList<RefcognateView> getRefcognateList(int entryIdFrom) {
        ObservableList<RefcognateView> refcognateList = FXCollections.observableArrayList();
        String                         selectStmt     = "SELECT * from refcognateview where entryidfrom = " + entryIdFrom + ";";
        RefcognateView                 refcognateView;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            while (rs.next()) {
                refcognateView = new RefcognateView();
                refcognateView.setEntryidfrom(rs.getInt("entryidfrom"));
                refcognateView.setLang(rs.getString("lang"));
                refcognateView.setForm(rs.getString("form"));
                refcognateView.setGloss(rs.getString("gloss"));
                refcognateView.setSources(rs.getString("sources"));
                refcognateList.add(refcognateView);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(
                    "Error fetching the Refcognate rows for Entry / Lexicon " + "with id = " + entryIdFrom + ": " + e);
        }
        return refcognateList;
    }
}
