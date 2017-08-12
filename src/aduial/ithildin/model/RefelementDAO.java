package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 07/07/2017.
 */
public class RefelementDAO {

  public static ObservableList<RefelementView> getRefelementList(int id){
    ObservableList<RefelementView> refelementList = FXCollections.observableArrayList();
    String selectStmt = "SELECT * from refelementview where id = " + id + ";";
    RefelementView refelementView;
      try {
        ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
        while (rs.next()) {
          refelementView = new RefelementView();
          refelementView.setId(rs.getInt("id"));
          refelementView.setLang(rs.getString("lang"));
          refelementView.setForm(rs.getString("form"));
          refelementView.setGloss(rs.getString("gloss"));
          refelementView.setSources(rs.getString("sources"));
          refelementList.add(refelementView);
        }
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error fetching the Refelement rows for Entry / Lexicon "
              + "with id = " + id + ": " + e);
    }
    return refelementList;
  }
}
