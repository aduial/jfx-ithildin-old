package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 02/07/2017.
 */
public class SourceDAO{

    public static Source selectSource(int sourceId) {
        String selectStmt = "SELECT * FROM SOURCE WHERE id=" + sourceId;
        Source source     = null;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            if (rs.next()) {
                source = new Source();
                source.setId(rs.getInt("id"));
                source.setName(rs.getString("name"));
                source.setPrefix(rs.getString("prefix"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error fetching the Source with id = " + sourceId + ": " + e);
        }
        return source;
    }
}
