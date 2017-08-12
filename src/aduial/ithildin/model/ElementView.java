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
 *
 * @author luthien
 */
@Entity
public class ElementView {
  
    private static final long serialVersionUID = 23984738947L;

    private final IntegerProperty entryidfrom = new SimpleIntegerProperty();
    private final IntegerProperty entryidto = new SimpleIntegerProperty();
    private final IntegerProperty refidfrom = new SimpleIntegerProperty();
    private final IntegerProperty refidto = new SimpleIntegerProperty();
    private final StringProperty languageto = new SimpleStringProperty();
    private final StringProperty formtxt = new SimpleStringProperty();
    private final StringProperty grammartxt = new SimpleStringProperty();
    private final StringProperty sourcename = new SimpleStringProperty();
    private final StringProperty sourceprefix = new SimpleStringProperty();
    private final StringProperty sourcestring = new SimpleStringProperty();
    private final StringProperty sourcetypetxt = new SimpleStringProperty();

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
    
    public int getEntryidto() {
      return entryidto.get();
    }

    public void setEntryidto(int value) {
      entryidto.set(value);
    }

    public IntegerProperty entryidtoProperty() {
        return entryidto;
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
    
    public int getRefidto() {
      return refidto.get();
    }

    public void setRefidto(int value) {
      refidto.set(value);
    }

    public IntegerProperty refidtoProperty() {
        return refidto;
    }
    
    public String getLanguageto() {
      return languageto.get();
    }

    public void setLanguageto(String value) {
      languageto.set(value);
    }

    public StringProperty languagetoProperty() {
        return languageto;
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
    
    public String getGrammartxt() {
      return grammartxt.get();
    }

    public void setGrammartxt(String value) {
      grammartxt.set(value);
    }

    public StringProperty grammartxtProperty() {
        return grammartxt;
    }
    
    public String getSourcename() {
      return sourcename.get();
    }

    public void setSourcename(String value) {
      sourcename.set(value);
    }

    public StringProperty sourcenameProperty() {
        return sourcename;
    }
    
    public String getSourceprefix() {
      return sourceprefix.get();
    }

    public void setSourceprefix(String value) {
      sourceprefix.set(value);
    }

    public StringProperty sourceprefixProperty() {
        return sourceprefix;
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
    
    public String getSourcetypetxt() {
      return sourcetypetxt.get();
    }

    public void setSourcetypetxt(String value) {
      sourcetypetxt.set(value);
    }

    public StringProperty sourcetypetxtProperty() {
        return sourcetypetxt;
    }
    
}
