package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 02/07/2017.
 */
public class SimplexiconDAO {
    
    public static ObservableList<Simplexicon> searchByForm (String term, Integer langId) throws 
            SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM simplexicon WHERE form like '%" +
                term + "%' AND language_id = " + langId.toString() + ";";

        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Simplexicon> simplexiconList = getSimplexiconList(rs);
            return simplexiconList;
        } catch (SQLException e) {
            System.out.println("While searching an Simplexicon containing search "
                    + "term %" + term + "% in FORM value, an error occurred: " + e);
            throw e;
        }
    }
    
    public static ObservableList<Simplexicon> searchByGloss (String term, Integer langId) throws 
            SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM simplexicon WHERE gloss like '%" +
                term + "%' AND language_id = " + langId.toString() + ";";

        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Simplexicon> simplexiconList = getSimplexiconList(rs);
            return simplexiconList;
        } catch (SQLException e) {
            System.out.println("While searching an Simplexicon containing search "
                    + "term %" + term + "% in GLOSS value, an error occurred: " + e);
            throw e;
        }
    }

    private static Simplexicon getSimplexiconFromResultSet(ResultSet rs) 
            throws SQLException
    {
        Simplexicon simplexicon = null;
        if (rs.next()) {
            simplexicon = new Simplexicon();
            simplexicon.setId(rs.getInt("id"));
            simplexicon.setForm(rs.getString("form"));
            simplexicon.setGloss(rs.getString("gloss"));
            simplexicon.setCat(rs.getString("cat"));
            simplexicon.setMark(rs.getString("mark"));
            simplexicon.setStem(rs.getString("stem"));
            simplexicon.setLanguagename(rs.getString("languagename"));
            simplexicon.setEntrytypeId(rs.getInt("entrytype_id"));
        }
        return simplexicon;
    }

    public static ObservableList<Language> fetchLanguages() {
        String selectStmt = "SELECT * FROM language WHERE id < 1000 AND parent_id IS NOT NULL;";
        ObservableList<Language> languageList = null;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
             languageList = getLanguageList(rs);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException occurred: " + e);
        }
        return languageList;
    }
    
    private static ObservableList<Simplexicon> getSimplexiconList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Simplexicon> simplexiconList = FXCollections.observableArrayList();
        Simplexicon simplexicon = null;
        while (rs.next()) {
            simplexicon = new Simplexicon();
            simplexicon.setId(rs.getInt("id"));
            simplexicon.setForm(rs.getString("mark") + " " + rs.getString("form"));
            simplexicon.setGloss(rs.getString("gloss"));
            simplexicon.setCat(rs.getString("cat"));
            simplexicon.setMark(rs.getString("mark"));
            simplexicon.setStem(rs.getString("stem"));
            simplexicon.setEntrytypeId(rs.getInt("entrytype_id"));
            simplexiconList.add(simplexicon);
        }
        return simplexiconList;
    }

    private static ObservableList<Language> getLanguageList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Language> languageList = FXCollections.observableArrayList();
        Language language = null;
        while (rs.next()) {
            language = new Language();
            language.setId(rs.getInt("id"));
            language.setName(rs.getString("name"));
            language.setMnemonic(rs.getString("mnemonic"));
            languageList.add(language);
        }
        return languageList;
    }
}

