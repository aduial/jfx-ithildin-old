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
 *
 * @author luthien
 */
@Entity
public class Lexicon {
  
    private static final long serialVersionUID = 122343243143L;

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty parentId = new SimpleIntegerProperty();
    private final StringProperty form = new SimpleStringProperty();
    private final StringProperty langMnemonic = new SimpleStringProperty();
    private final StringProperty langName = new SimpleStringProperty();
    private final StringProperty gloss = new SimpleStringProperty();
    private final StringProperty cat = new SimpleStringProperty();
    private final StringProperty tengwar = new SimpleStringProperty();
    private final StringProperty mark = new SimpleStringProperty();
    private final StringProperty eldamoPageid = new SimpleStringProperty();
    private final StringProperty orderfield = new SimpleStringProperty();
    private final IntegerProperty ordering = new SimpleIntegerProperty();
    private final IntegerProperty entrytypeId = new SimpleIntegerProperty();
    private final StringProperty entryType = new SimpleStringProperty();
    

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
    
    
    public int getParentId() {
      return parentId.get();
    }

    public void setParentId(int value) {
      parentId.set(value);
    }

    public IntegerProperty parentIdProperty() {
        return parentId;
    }


    public String getForm() {
        return form.get();
    }

    public void setForm(String value) {
        this.form.set(value);
    }

    public StringProperty formProperty() {
        return form;
    }
    

    public String getLangMnemonic() {
        return langMnemonic.get();
    }

    public void setLangMnemonic(String value) {
        this.langMnemonic.set(value);
    }

    public StringProperty langMnemonicProperty() {
        return langMnemonic;
    }
    
    

    public String getLangName() {
        return langName.get();
    }

    public void setLangName(String value) {
        this.langName.set(value);
    }

    public StringProperty langNameProperty() {
        return langName;
    }
    
    

    public String getGloss() {
        return gloss.get();
    }

    public void setGloss(String value) {
        this.gloss.set(value);
    }

    public StringProperty glossProperty() {
        return gloss;
    }
    
    

    public String getCat() {
        return cat.get();
    }

    public void setCat(String value) {
        this.cat.set(value);
    }

    public StringProperty catProperty() {
        return cat;
    }
    
    

    public String getTengwar() {
        return tengwar.get();
    }

    public void setTengwar(String value) {
        this.tengwar.set(value);
    }

    public StringProperty tengwarProperty() {
        return tengwar;
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
    
    

    public String getEldamoPageid() {
        return eldamoPageid.get();
    }

    public void setEldamoPageid(String value) {
        this.eldamoPageid.set(value);
    }

    public StringProperty eldamoPageidProperty() {
        return eldamoPageid;
    }
    
    

    public String getOrderfield() {
        return orderfield.get();
    }

    public void setOrderfield(String value) {
        this.orderfield.set(value);
    }

    public StringProperty orderfieldProperty() {
        return orderfield;
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
    
    
    
    public int getEntryTypeId() {
      return entrytypeId.get();
    }

    public void setEntryTypeId(int value) {
      entrytypeId.set(value);
    }

    public IntegerProperty entrytypeIdProperty() {
        return entrytypeId;
    }

    public String getEntryType() {
        return entryType.get();
    }

    public void setEntryType(String value) {
        this.entryType.set(value);
    }

    public StringProperty entryTypeProperty() {
        return entryType;
    }
    
}
