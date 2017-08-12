package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 02/07/2017.
 */
public class RefDAO {
    
  public static ObservableList<Ref> getRefList(int entryId){
    ObservableList<Ref> refList = FXCollections.observableArrayList();
    String selectStmt = "SELECT * FROM REF "
            + "WHERE ENTRY_ID = " + entryId + ";";
    Ref ref = null;
    try {
      ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
      while (rs.next()) {
        ref = new Ref();
        ref.setId(rs.getInt("id"));
        ref.setFormId(rs.getInt("form_id"));
        ref.setGlossId(rs.getInt("gloss_id"));
        ref.setLanguageId(rs.getInt("language_id"));
        ref.setSourceId(rs.getInt("source_id"));
        ref.setSourcestring(rs.getString("source"));
        ref.setMark(rs.getString("mark"));
        ref.setOrdering(rs.getInt("ordering"));
        ref.setEntryTypeId(rs.getInt("entrytype_id"));
        refList.add(ref);
      }
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error fetching the Refs linked to Entry / Lexicon "
              + "with id = " + entryId + ": " + e);
    }
    return refList;
  }
  
  public static ObservableList<String> getRefGlossList(int entryId){
    ObservableList<String> refGlossList = FXCollections.observableArrayList();
    String selectStmt = "SELECT '\"' || g.txt || '\" ✧ ' || Group_Concat(r.source, '; ') refgloss "
            + "FROM ref r " 
            + "JOIN gloss g ON g.id = r.gloss_id " 
            + "WHERE r.entry_id = " + entryId + " "
            + "AND NOT EXISTS (select * FROM linked l WHERE l.ref_id = r.id) "
            + "GROUP BY LOWER(g.txt);";
    String refGloss;
      try {
        ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
        while (rs.next()) {
          refGloss = rs.getString("refgloss");
          refGlossList.add(refGloss);
        }
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error fetching the Ref Glosses for Entry / Lexicon "
              + "with id = " + entryId + ": " + e);
    }
    return refGlossList;
  }
    
}

