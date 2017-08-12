package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 07/07/2017.
 */
public class RefinflectDAO {

  public static ObservableList<RefinflectView> getRefinflectList(int entryId){
    ObservableList<RefinflectView> refinflectList = FXCollections.observableArrayList();
    String selectStmt = "SELECT * from refinflectview where entry_id = " + entryId + ";";
    RefinflectView refinflectView;
      try {
        ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
        while (rs.next()) {
          refinflectView = new RefinflectView();
          refinflectView.setEntryid(rs.getInt("entry_id"));
          refinflectView.setForm(rs.getString("form"));
          refinflectView.setGrammar(rs.getString("grammar"));
          refinflectView.setGloss(rs.getString("gloss"));
          refinflectView.setSources(rs.getString("sources"));
          refinflectList.add(refinflectView);
        }
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error fetching the Refinflect rows for Entry / Lexicon "
              + "with id = " + entryId + ": " + e);
    }
    return refinflectList;
  }
}
