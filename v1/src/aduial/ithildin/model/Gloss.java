/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduial.ithildin.model;

import javafx.beans.property.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author luthien
 */
@Entity
public class Gloss{

    private static final long serialVersionUID = 12383487394L;

    private final IntegerProperty id         = new SimpleIntegerProperty();
    private final StringProperty  txt        = new SimpleStringProperty();
    private final IntegerProperty languageId = new SimpleIntegerProperty();

    @Id
    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
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

    public int getLanguageId() {
        return languageId.get();
    }

    public void setLanguageId(int value) {
        languageId.set(value);
    }

    public IntegerProperty languageIdProperty() {
        return languageId;
    }

}
