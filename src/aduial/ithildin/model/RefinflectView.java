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
public class RefinflectView {
  
    private static final long serialVersionUID = 4334893471L;

    private final IntegerProperty entryid = new SimpleIntegerProperty();
    private final StringProperty form = new SimpleStringProperty();
    private final StringProperty grammar = new SimpleStringProperty();
    private final StringProperty gloss = new SimpleStringProperty();
    private final StringProperty sources = new SimpleStringProperty();

    @Id
    public int getEntryid() {
      return entryid.get();
    }

    public void setEntryid(int value) {
      entryid.set(value);
    }

    public IntegerProperty entryidProperty() {
        return entryid;
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
    
    public String getGrammar() {
      return grammar.get();
    }

    public void setGrammar(String value) {
      grammar.set(value);
    }

    public StringProperty grammarProperty() {
        return grammar;
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
