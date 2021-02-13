/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduial.ithildin.model;

import javafx.beans.property.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author luthien
 */
@Entity
public class EntryNoteView{

    private static final long serialVersionUID = 3498372493874L;

    private final IntegerProperty entryId  = new SimpleIntegerProperty();
    private final IntegerProperty ordering = new SimpleIntegerProperty();
    private final StringProperty  txt      = new SimpleStringProperty();

    @Id
    public int getEntryId() {
        return entryId.get();
    }

    public void setEntryId(int value) {
        entryId.set(value);
    }

    public IntegerProperty entryIdProperty() {
        return entryId;
    }

    public int getOrdering() {
        return ordering.get();
    }

    public void setOrdering(int value) {
        ordering.set(value);
    }

    public IntegerProperty orderingProperty() {
        return ordering;
    }

    public String getTxt() {
        return txt.get();
    }

    public void setTxt(String value) {
        txt.set(value);
    }

    public StringProperty txtProperty() {
        return txt;
    }

}
