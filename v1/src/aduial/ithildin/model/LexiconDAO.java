package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;
import aduial.ithildin.model.Cat;
import aduial.ithildin.model.Entry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by luthien on 02/07/2017.
 */
public class LexiconDAO{


    public static Lexicon fetchLexicon(Integer id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM lexicon WHERE id = " + id.toString() + ";";

        try {
            ResultSet rs      = DBUtil.dbExecuteQuery(selectStmt);
            Lexicon   lexicon = getFirstLexicon(rs);
            return lexicon;
        } catch (SQLException e) {
            System.out.println("While fetching the lexicon with id = " + id.toString() + " an error occurred: " + e);
            throw e;
        }
    }

    private static Lexicon getFirstLexicon(ResultSet rs) throws SQLException {
        Lexicon lexicon = null;
        if (rs.next()) {
            lexicon = new Lexicon();
            lexicon.setId(rs.getInt("id"));
            lexicon.setParentId(rs.getInt("parent_id"));
            lexicon.setForm(rs.getString("form"));
            lexicon.setLangMnemonic(rs.getString("lang_mnemonic"));
            lexicon.setLangName(rs.getString("lang_name"));
            lexicon.setGloss(rs.getString("gloss"));
            lexicon.setCat(rs.getString("cat"));
            lexicon.setTengwar(rs.getString("tengwar"));
            lexicon.setMark(rs.getString("mark"));
            lexicon.setEldamoPageid(rs.getString("eldamo_pageid"));
            lexicon.setOrderfield(rs.getString("orderfield"));
            lexicon.setOrdering(rs.getInt("ordering"));
            lexicon.setEntryTypeId(rs.getInt("entrytype_id"));
            lexicon.setEntryType(rs.getString("entry_type"));
        }
        return lexicon;
    }

    public static String getSpeech(int id) {
        String selectStmt = "SELECT g.* FROM GRAMMAR g " + "JOIN LINKED_GRAMMAR lg ON g.ID = lg.GRAMMAR_ID " + "JOIN TYPE t ON lg.GRAMMARTYPE_ID = t.ID " + "WHERE lg.ENTRY_ID = " + id + " " + "AND t.TXT = 'speechform';";
        try {
            ResultSet rs     = DBUtil.dbExecuteQuery(selectStmt);
            String    speech = "";
            if (rs.next()) {
                speech = rs.getString("txt");
            }
            return speech;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(
                    "Error fetching the Speech grammar type linked to Entry / Lexicon " + "with id = " + id + ": " + e);
            return "-";
        }
    }

    public static ObservableList<EntryNoteView> getEntryNoteList(int id) {
        ObservableList<EntryNoteView> entryNoteList = FXCollections.observableArrayList();
        EntryNoteView                 entryNote     = null;
        String selectStmt = "SELECT * FROM entrynoteview env " + "WHERE env.ENTRY_ID = " + id + ";";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            while (rs.next()) {
                entryNote = new EntryNoteView();
                entryNote.setEntryId(rs.getInt("entry_id"));
                entryNote.setOrdering(rs.getInt("ordering"));
                entryNote.setTxt(rs.getString("txt"));
                entryNoteList.add(entryNote);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(
                    "Error fetching the Entry Note (doc) type linked to Entry / Lexicon " + "with id = " + id + ": " + e);
        }
        return entryNoteList;
    }

}
