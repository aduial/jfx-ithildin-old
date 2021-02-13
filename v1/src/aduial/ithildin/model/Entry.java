/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduial.ithildin.model;

import java.util.List;

import javafx.beans.property.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author luthien
 */
@Entity
public class Entry{

    private static final long serialVersionUID = 34982794837L;

    private final IntegerProperty          id         = new SimpleIntegerProperty();
    private final IntegerProperty          languageId = new SimpleIntegerProperty();
    private final IntegerProperty          formId     = new SimpleIntegerProperty();
    private final ObjectProperty<Form>     form       = new SimpleObjectProperty<>();
    private final ObjectProperty<Language> language   = new SimpleObjectProperty<>();
    private final ObjectProperty<Gloss>    gloss      = new SimpleObjectProperty<>();
    private final ObjectProperty<Cat>      cat        = new SimpleObjectProperty<>();
    private final IntegerProperty          ordering   = new SimpleIntegerProperty();
    private final StringProperty           mark       = new SimpleStringProperty();
    private final ObjectProperty<Type>     entryType  = new SimpleObjectProperty<>();
    private final ListProperty<Ref>        refs       = new SimpleListProperty<>();
    private final ObjectProperty<Entry>    parent     = new SimpleObjectProperty<>();


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

    public int getLanguageId() {
        return languageId.get();
    }

    public void setLanguageId(int value) {
        languageId.set(value);
    }

    public IntegerProperty languageIdProperty() {
        return languageId;
    }

    public int getFormId() {
        return formId.get();
    }

    public void setFormId(int value) {
        formId.set(value);
    }

    public IntegerProperty formIdProperty() {
        return formId;
    }

    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "id")
    public Form getForm() {
        return form.get();
    }

    public void setForm(Form value) {
        form.set(value);
    }

    public ObjectProperty<Form> formProperty() {
        return form;
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

    @ManyToOne
    @JoinColumn(name = "gloss_id", referencedColumnName = "id")
    public Gloss getGloss() {
        return gloss.get();
    }

    public void setGloss(Gloss value) {
        gloss.set(value);
    }

    public ObjectProperty<Gloss> glossProperty() {
        return gloss;
    }

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    public Cat getCat() {
        return cat.get();
    }

    public void setCat(Cat value) {
        cat.set(value);
    }

    public ObjectProperty<Cat> catProperty() {
        return cat;
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

    public String getMark() {
        return mark.get();
    }

    public void setMark(String value) {
        this.mark.set(value);
    }

    public StringProperty markProperty() {
        return mark;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public Type getEntryType() {
        return entryType.get();
    }

    public void setEntryType(Type value) {
        entryType.set(value);
    }

    public ObjectProperty<Type> entryTypeProperty() {
        return entryType;
    }


    @OneToMany(mappedBy = "ENTRY", cascade = CascadeType.ALL)
    public List<Ref> getRefs() {
        return refs.get();
    }

    public void setRefs(List<Ref> newRefs) {
        refs.addAll(newRefs);
    }

    public ListProperty<Ref> refsProperty() {
        return refs;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public Entry getParent() {
        return parent.get();
    }

    public void setParent(Entry value) {
        parent.set(value);
    }

    public ObjectProperty<Entry> parentProperty() {
        return parent;
    }

}
