/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tuserlate file, choose Tools | Tuserlates
 * and open the tuserlate in the editor.
 */
package aduial.ithildin.controller;

import aduial.ithildin.model.Language;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import aduial.ithildin.model.Simplexicon;
import aduial.ithildin.model.SimplexiconDAO;

import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

/**
 *
 * @author luthien
 */
public class SimplexiconController {

  @FXML
  private TextField searchFormText;
  @FXML
  private TextField searchGlossText;
  @FXML
  private TableView simplexiconTable;
  @FXML
  private TableColumn<Simplexicon, String> formColumn;
  @FXML
  private TableColumn<Simplexicon, String> glossColumn;
  @FXML
  private TableColumn<Simplexicon, String> catColumn;
  @FXML
  private TableColumn<Simplexicon, String> stemColumn;
  @FXML
  private ComboBox<Language> languageChooser;

  private boolean formquery = true;
  //For MultiThreading
  private Executor exec;

  //Initializing the controller class.
  //This method is automatically called after the fxml file has been loaded.
  @FXML
  private void initialize() {
    simplexiconTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    populateLanguageChooser(SimplexiconDAO.fetchLanguages());

    //For multithreading: Create executor that uses daemon threads:
    exec = Executors.newCachedThreadPool((runnable) -> {
      Thread t = new Thread(runnable);
      t.setDaemon(true);
      return t;
    });

    formColumn.setCellValueFactory(cellData -> cellData.getValue().formProperty());
    glossColumn.setCellValueFactory(cellData -> cellData.getValue().glossProperty());
    stemColumn.setCellValueFactory(cellData -> cellData.getValue().stemProperty());
    catColumn.setCellValueFactory(cellData -> cellData.getValue().catProperty());
  }

  //Search a simplexicon entry by form KeyEvent event
  @FXML
  private void searchByForm(KeyEvent event) throws ClassNotFoundException, SQLException {
    formquery = true;
    try {
      ObservableList<Simplexicon> simplexiconList = SimplexiconDAO.searchByForm(searchFormText.getText(),
              languageChooser.getValue().getId());
      populateTable(simplexiconList);
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }

  //Search a simplexicon entry by gloss
  @FXML
  private void searchByGloss(KeyEvent event) throws ClassNotFoundException, SQLException {
    formquery = false;
    try {
      ObservableList<Simplexicon> simplexiconList = SimplexiconDAO.searchByGloss(searchGlossText.getText(),
              languageChooser.getValue().getId());
      populateTable(simplexiconList);
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }

  @FXML
  private void populateLanguageChooser(ObservableList<Language> languageList) {
    languageChooser.setItems(languageList);
    languageChooser.setConverter(new StringConverter<Language>() {

      @Override
      public String toString(Language lang) {
        return lang.getName();
      }

      @Override
      public Language fromString(String string) {
        return languageChooser.getItems().stream().filter(ap
                -> ap.getName().equals(string)).findFirst().orElse(null);
      }
    });
    languageChooser.getSelectionModel().selectFirst();
  }

  @FXML
  private void populateTable(ObservableList<Simplexicon> simplexiconList) throws ClassNotFoundException {
    //Set items to the userTable
    simplexiconTable.setItems(simplexiconList);
  }
  
  @FXML
  private void requery() throws ClassNotFoundException, SQLException {
    if (formquery) {
      try {
        ObservableList<Simplexicon> simplexiconList = SimplexiconDAO.searchByForm(searchFormText.getText(),
                languageChooser.getValue().getId());
        populateTable(simplexiconList);
      } catch (SQLException e) {
        e.printStackTrace();
        throw e;
      }
    } else {
      try {
        ObservableList<Simplexicon> simplexiconList = SimplexiconDAO.searchByGloss(searchGlossText.getText(),
                languageChooser.getValue().getId());
        populateTable(simplexiconList);
      } catch (SQLException e) {
        e.printStackTrace();
        throw e;
      }
    }
  }
}
