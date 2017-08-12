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
 *
 * @author luthien
 */
@Entity
public class Ref {
  
    private static final long serialVersionUID = 45873954857L;

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty entryId = new SimpleIntegerProperty();
    private final IntegerProperty formId = new SimpleIntegerProperty();
    private final IntegerProperty sourceId = new SimpleIntegerProperty();
    private final IntegerProperty glossId = new SimpleIntegerProperty();
    private final IntegerProperty languageId = new SimpleIntegerProperty();
    private final IntegerProperty entryTypeId = new SimpleIntegerProperty();
    private final IntegerProperty ordering = new SimpleIntegerProperty();
    private final StringProperty mark = new SimpleStringProperty();
    private final StringProperty sourcestring = new SimpleStringProperty();
    
    

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
    
    public int getEntryId() {
        return entryId.get();
    }

    public void setEntryId(int value) {
        entryId.set(value);
    }

    public IntegerProperty entryIdProperty() {
        return entryId;
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
    
    public int getSourceId() {
        return sourceId.get();
    }

    public void setSourceId(int value) {
        sourceId.set(value);
    }

    public IntegerProperty sourceIdProperty() {
        return sourceId;
    }
    
    public int getGlossId() {
        return glossId.get();
    }

    public void setGlossId(int value) {
        glossId.set(value);
    }

    public IntegerProperty glossIdProperty() {
        return glossId;
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
    
    public int getEntryTypeId() {
        return entryTypeId.get();
    }

    public void setEntryTypeId(int value) {
        entryTypeId.set(value);
    }

    public IntegerProperty entryTypeIdProperty() {
        return entryTypeId;
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

    public String getSourcestring() {
        return sourcestring.get();
    }

    public void setSourcestring(String value) {
        this.sourcestring.set(value);
    }

    public StringProperty sourcestringProperty() {
        return sourcestring;
    }
    
}
