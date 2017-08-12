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
public class LinkedGrammar {
  
    private static final long serialVersionUID = 34928734384L;

    private final IntegerProperty linkedId = new SimpleIntegerProperty();
    private final IntegerProperty entryId = new SimpleIntegerProperty();
    private final IntegerProperty ordering = new SimpleIntegerProperty();
    private final ObjectProperty<Grammar> grammar = new SimpleObjectProperty<>();
    private final ObjectProperty<Type> grammarType = new SimpleObjectProperty<>();

    @Id
    public int getLinkedId() {
      return linkedId.get();
    }

    public void setLinkedId(int value) {
      linkedId.set(value);
    }

    public IntegerProperty linkedIdProperty() {
        return linkedId;
    }
    
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
    
    @Id
    public int getOrdering() {
      return ordering.get();
    }

    public void setOrdering(int value) {
      ordering.set(value);
    }

    public IntegerProperty orderingProperty() {
        return ordering;
    }
    
    @ManyToOne
    @JoinColumn(name = "grammar_id", referencedColumnName = "id")
    public Grammar getGrammar() {
        return grammar.get();
    }

    public void setGrammar(Grammar value) {
        grammar.set(value);
    }

    public ObjectProperty<Grammar> grammarProperty() {
        return grammar;
    }
    
    @ManyToOne
    @JoinColumn(name = "grammartype_id", referencedColumnName = "id")
    public Type getGrammarType() {
        return grammarType.get();
    }

    public void setGrammarType(Type value) {
        grammarType.set(value);
    }

    public ObjectProperty<Type> grammarTypeProperty() {
        return grammarType;
    }

}
