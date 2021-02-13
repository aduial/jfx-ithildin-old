package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 07/07/2017.
 */
public class RefderivDAO{

    public static ObservableList<RefderivView> getRefderivList(int entryIdFrom) {
        ObservableList<RefderivView> refderivList = FXCollections.observableArrayList();
        String                       selectStmt   = "SELECT * from refderivview where entryidfrom = " + entryIdFrom + ";";
        RefderivView                 refderivView;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            while (rs.next()) {
                refderivView = new RefderivView();
                refderivView.setEntryidfrom(rs.getInt("entryidfrom"));
                refderivView.setForm(rs.getString("form"));
                refderivView.setGlosses(rs.getString("glosses"));
                refderivView.setSources(rs.getString("sources"));
                refderivList.add(refderivView);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(
                    "Error fetching the Refderiv rows for Entry / Lexicon " + "with id = " + entryIdFrom + ": " + e);
        }
        return refderivList;
    }
}
