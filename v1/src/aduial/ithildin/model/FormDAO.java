package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 02/07/2017.
 */
public class FormDAO{

    public static Form selectForm(int id) {
        String selectStmt = "SELECT * FROM FORM WHERE id=" + id;
        Form   form       = null;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            if (rs.next()) {
                form = new Form();
                form.setId(rs.getInt("id"));
                form.setTxt(rs.getString("txt"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error fetching the Source with id = " + id + ": " + e);
        }
        return form;
    }
}
