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
public class Simplexicon{

    private static final long                     serialVersionUID = 98798734343L;
    private final        IntegerProperty          id               = new SimpleIntegerProperty();
    private final        StringProperty           mark             = new SimpleStringProperty();
    private final        StringProperty           form             = new SimpleStringProperty();
    private final        StringProperty           gloss            = new SimpleStringProperty();
    private final        StringProperty           cat              = new SimpleStringProperty();
    private final        StringProperty           stem             = new SimpleStringProperty();
    private final        StringProperty           languagename     = new SimpleStringProperty();
    private final        ObjectProperty<Language> language         = new SimpleObjectProperty<>();
    private final        IntegerProperty          entrytypeId      = new SimpleIntegerProperty();

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

    public String getMark() {
        return mark.get();
    }

    public void setMark(String value) {
        mark.set(value);
    }

    public StringProperty markProperty() {
        return mark;
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

    public String getCat() {
        return cat.get();
    }

    public void setCat(String value) {
        cat.set(value);
    }

    public StringProperty catProperty() {
        return cat;
    }

    public String getStem() {
        return stem.get();
    }

    public void setStem(String value) {
        stem.set(value);
    }

    public StringProperty stemProperty() {
        return stem;
    }

    public String getLanguagename() {
        return languagename.get();
    }

    public void setLanguagename(String value) {
        languagename.set(value);
    }

    public StringProperty languagenameProperty() {
        return languagename;
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    public Language getLanguage() {
        return language.get();
    }

    public void setLanguage(Language value) {
        language.set(value);

    }

    public ObjectProperty<Language> languageProperty() {
        return language;
    }

    public int getEntrytypeId() {
        return entrytypeId.get();
    }

    public void setEntrytypeId(int value) {
        entrytypeId.set(value);
    }

    public IntegerProperty entrytypeIdProperty() {
        return entrytypeId;
    }


}
