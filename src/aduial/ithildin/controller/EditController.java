/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tuserlate file, choose Tools | Tuserlates
 * and open the tuserlate in the editor.
 */
package aduial.ithildin.controller;

import aduial.ithildin.model.LexiconDAO;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ComboBox;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javafx.util.StringConverter;

import aduial.ithildin.model.Language;
import aduial.ithildin.model.Lexicon;
import aduial.ithildin.model.Simplexicon;
import aduial.ithildin.model.SimplexiconDAO;
import aduial.ithildin.view.LexiconPage;
import javafx.event.ActionEvent;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableRow;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

/**
 *
 * @author luthien
 */
public class EditController {

  @FXML
  private TextField searchTextField;
  @FXML
  private TableView<Simplexicon> matchTable;
  @FXML
  private TableColumn<Simplexicon, Number> idColumn;
  @FXML
  private TableColumn<Simplexicon, String> formColumn;
  @FXML
  private TableColumn<Simplexicon, String> glossColumn;
  @FXML
  private TableColumn<Simplexicon, Number> entrytypeIdColumn;
  @FXML
  private ToggleButton glossToggleButton;
  @FXML
  private ComboBox<Language> languageChooser;

  private boolean searchGlosses = false;

  //For MultiThreading
  private Executor exec;

  //Initializing the controller class.
  //This method is automatically called after the fxml file has been loaded.
  @FXML
  private void initialize() {
    matchTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    
    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
    formColumn.setCellValueFactory(cellData -> cellData.getValue().formProperty());
    glossColumn.setCellValueFactory(cellData -> cellData.getValue().glossProperty());
    entrytypeIdColumn.setCellValueFactory(cellData -> cellData.getValue().entrytypeIdProperty());
    idColumn.setVisible(false);
    entrytypeIdColumn.setVisible(false);
  }
}
