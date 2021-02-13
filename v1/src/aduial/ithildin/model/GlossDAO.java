package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 02/07/2017.
 */
public class GlossDAO{

    public static Gloss selectGloss(int id) {
        String selectStmt = "SELECT * FROM GLOSS WHERE id=" + id;
        Gloss  gloss      = null;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            if (rs.next()) {
                gloss = new Gloss();
                gloss.setId(rs.getInt("id"));
                gloss.setTxt(rs.getString("txt"));
                gloss.setLanguageId(rs.getInt("language_id"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error fetching the Source with id = " + id + ": " + e);
        }
        return gloss;
    }
}
