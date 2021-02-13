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
public class RefelementView{

    private static final long serialVersionUID = 431309474L;

    private final IntegerProperty id      = new SimpleIntegerProperty();
    private final StringProperty  lang    = new SimpleStringProperty();
    private final StringProperty  form    = new SimpleStringProperty();
    private final StringProperty  gloss   = new SimpleStringProperty();
    private final StringProperty  sources = new SimpleStringProperty();

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

    public String getLang() {
        return lang.get();
    }

    public void setLang(String value) {
        lang.set(value);
    }

    public StringProperty langProperty() {
        return lang;
    }

    public String getForm() {
        return form.get();
    }

    public void setForm(String value) {
        form.set(value);
    }

    public StringProperty formProperty() {
        return form;
    }

    public String getGloss() {
        return gloss.get();
    }

    public void setGloss(String value) {
        gloss.set(value);
    }

    public StringProperty glossProperty() {
        return gloss;
    }

    public String getSources() {
        return sources.get();
    }

    public void setSources(String value) {
        sources.set(value);
    }

    public StringProperty sourcesProperty() {
        return sources;
    }

}
