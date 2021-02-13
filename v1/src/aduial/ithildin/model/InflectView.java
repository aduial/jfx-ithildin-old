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
public class InflectView{

    private static final long serialVersionUID = 4593874548574L;

    private final IntegerProperty entryidfrom    = new SimpleIntegerProperty();
    private final IntegerProperty refidfrom      = new SimpleIntegerProperty();
    private final StringProperty  formtxt        = new SimpleStringProperty();
    private final IntegerProperty lgorder        = new SimpleIntegerProperty();
    private final StringProperty  inflection     = new SimpleStringProperty();
    private final StringProperty  inflecttypetxt = new SimpleStringProperty();

    @Id
    public int getEntryidfrom() {
        return entryidfrom.get();
    }

    public void setEntryidfrom(int value) {
        entryidfrom.set(value);
    }

    public IntegerProperty entryidfromProperty() {
        return entryidfrom;
    }

    public int getRefidfrom() {
        return refidfrom.get();
    }

    public void setRefidfrom(int value) {
        refidfrom.set(value);
    }

    public IntegerProperty refidfromProperty() {
        return refidfrom;
    }

    public String getFormtxt() {
        return formtxt.get();
    }

    public void setFormtxt(String value) {
        formtxt.set(value);
    }

    public StringProperty formtxtProperty() {
        return formtxt;
    }

    public int getLgorder() {
        return lgorder.get();
    }

    public void setLgorder(int value) {
        lgorder.set(value);
    }

    public IntegerProperty lgorderProperty() {
        return lgorder;
    }

    public String getInflection() {
        return inflection.get();
    }

    public void setInflection(String value) {
        inflection.set(value);
    }

    public StringProperty inflectionProperty() {
        return inflection;
    }

    public String getInflecttypetxt() {
        return inflecttypetxt.get();
    }

    public void setInflecttypetxt(String value) {
        inflecttypetxt.set(value);
    }

    public StringProperty inflecttypetxtProperty() {
        return inflecttypetxt;
    }

}
