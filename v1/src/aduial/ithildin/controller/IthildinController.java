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
 * @author luthien
 */
public class IthildinController{

    @FXML private TextField                        searchTextField;
    @FXML private TableView<Simplexicon>           matchTable;
    @FXML private TableColumn<Simplexicon, Number> idColumn;
    @FXML private TableColumn<Simplexicon, String> formColumn;
    @FXML private TableColumn<Simplexicon, String> glossColumn;
    @FXML private TableColumn<Simplexicon, Number> entrytypeIdColumn;
    @FXML private ToggleButton                     glossToggleButton;
    @FXML private ComboBox<Language>               languageChooser;
    @FXML private WebView                          primaryWebView;
    @FXML private WebView                          secondaryWebView;
    @FXML private ToggleButton                     glsToggleButton;
    @FXML private ToggleButton                     refToggleButton;
    @FXML private ToggleButton                     drvToggleButton;
    @FXML private ToggleButton                     iflToggleButton;
    @FXML private ToggleButton                     elmToggleButton;
    @FXML private ToggleButton                     cogToggleButton;

    private boolean searchGlosses = false;

    private LexiconPage currentLexiconPage;

    //For MultiThreading
    private Executor exec;

    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize() {
        matchTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        populateLanguageChooser(SimplexiconDAO.fetchLanguages());

        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        formColumn.setCellValueFactory(cellData -> cellData.getValue().formProperty());
        glossColumn.setCellValueFactory(cellData -> cellData.getValue().glossProperty());
        entrytypeIdColumn.setCellValueFactory(cellData -> cellData.getValue().entrytypeIdProperty());
        idColumn.setVisible(false);
        entrytypeIdColumn.setVisible(false);

        matchTable.setRowFactory((TableView<Simplexicon> row) -> new TableRow<Simplexicon>(){
            public void updateItem(Simplexicon entry, boolean empty) {
                super.updateItem(entry, empty);

                if (entry == null || empty) {
                    setStyle("");
                } else {
                    //Now 'item' has all the info of the Person in this row
                    if (entry.getEntrytypeId() == 1033) {
                        //We apply now the changes in all the cells of the row
                        for (int i = 0; i < getChildren().size(); i++) {
                            ((Labeled) getChildren().get(i)).setTextFill(Color.FORESTGREEN);
                            //              ((Labeled) getChildren().get(i)).setStyle("-fx-background-color: honeydew");
                        }
                    } else if (entry.getEntrytypeId() == 1034) {
                        for (int i = 0; i < getChildren().size(); i++) {
                            ((Labeled) getChildren().get(i)).setTextFill(Color.SLATEBLUE);
                            //              ((Labeled) getChildren().get(i)).setStyle("-fx-background-color: lightcyan");
                        }
                    } else {
                        for (int i = 0; i < getChildren().size(); i++) {
                            ((Labeled) getChildren().get(i)).setTextFill(Color.BLACK);
                            //              ((Labeled) getChildren().get(i)).setStyle("-fx-background-color: white");
                        }

                        //            if (getTableView().getSelectionModel().getSelectedItems().contains(entry)) {
                        //              for (int i = 0; i < getChildren().size(); i++) {
                        //                ((Labeled) getChildren().get(i)).setTextFill(Color.WHITE);;
                        //              }
                        //            } else {
                        //              for (int i = 0; i < getChildren().size(); i++) {
                        //                ((Labeled) getChildren().get(i)).setTextFill(Color.BLACK);;
                        //              }
                        //            }
                    }
                }
            }
        });

    }

    @FXML
    private void toggleFormOrGloss(ActionEvent event) throws ClassNotFoundException, SQLException {
        searchGlosses = glossToggleButton.isSelected();
        if (searchGlosses) {
            glossToggleButton.setText("glosses");
        } else {
            glossToggleButton.setText("word forms");
        }
        reallyDoSearchNow();
    }

    @FXML
    private void populateLanguageChooser(ObservableList<Language> languageList) {
        languageChooser.setItems(languageList);
        languageChooser.setConverter(new StringConverter<Language>(){

            @Override
            public String toString(Language lang) {
                return lang.getName();
            }

            @Override
            public Language fromString(String string) {
                return languageChooser.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(
                        null);
            }
        });
        languageChooser.getSelectionModel().select(7);
    }

    @FXML
    private void populateMatchTable(ObservableList<Simplexicon> simplexiconList) throws ClassNotFoundException {
        //Set items to the userTable
        matchTable.setItems(simplexiconList);
    }

    @FXML
    private void doSearch(KeyEvent event) throws ClassNotFoundException, SQLException {
        reallyDoSearchNow();
    }

    @FXML
    private void requery() throws ClassNotFoundException, SQLException {
        reallyDoSearchNow();
    }

    private void reallyDoSearchNow() throws ClassNotFoundException, SQLException {
        ObservableList<Simplexicon> simplexiconList;
        try {
            if (searchGlosses) {
                simplexiconList = SimplexiconDAO.searchByGloss(searchTextField.getText(),
                                                               languageChooser.getValue().getId());
            } else {
                simplexiconList = SimplexiconDAO.searchByForm(searchTextField.getText(),
                                                              languageChooser.getValue().getId());
            }
            populateMatchTable(simplexiconList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void rowClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        Simplexicon selected = matchTable.getSelectionModel().getSelectedItem();
        //    System.out.println("Thou clicketh: " + selected.getId());
        Lexicon selectedLexicon = LexiconDAO.fetchLexicon(selected.getId());
        currentLexiconPage = new LexiconPage(selectedLexicon, refToggleButton.isSelected(),
                                             glsToggleButton.isSelected(), drvToggleButton.isSelected(),
                                             iflToggleButton.isSelected(), elmToggleButton.isSelected(),
                                             cogToggleButton.isSelected());
        currentLexiconPage.display(primaryWebView, secondaryWebView);
    }

    @FXML
    private void scrollFinished(ScrollEvent e) throws SQLException, ClassNotFoundException {
        Simplexicon selected = matchTable.getSelectionModel().getSelectedItem();
        //    System.out.println("Thou clicketh: " + selected.getId());
        Lexicon selectedLexicon = LexiconDAO.fetchLexicon(selected.getId());
        currentLexiconPage = new LexiconPage(selectedLexicon, refToggleButton.isSelected(),
                                             glsToggleButton.isSelected(), drvToggleButton.isSelected(),
                                             iflToggleButton.isSelected(), elmToggleButton.isSelected(),
                                             cogToggleButton.isSelected());
        currentLexiconPage.display(primaryWebView, secondaryWebView);
    }

    @FXML
    private void keyReleased(KeyEvent e) throws SQLException, ClassNotFoundException {
        Simplexicon selected = matchTable.getSelectionModel().getSelectedItem();
        //    System.out.println("Thou clicketh: " + selected.getId());
        Lexicon selectedLexicon = LexiconDAO.fetchLexicon(selected.getId());
        currentLexiconPage = new LexiconPage(selectedLexicon, refToggleButton.isSelected(),
                                             glsToggleButton.isSelected(), drvToggleButton.isSelected(),
                                             iflToggleButton.isSelected(), elmToggleButton.isSelected(),
                                             cogToggleButton.isSelected());
        currentLexiconPage.display(primaryWebView, secondaryWebView);
    }

    @FXML
    private void glsToggleButtonChanged(ActionEvent event) {
        currentLexiconPage.setGlsVisible(glsToggleButton.isSelected());
    }

    @FXML
    private void refToggleButtonChanged(ActionEvent event) {
        currentLexiconPage.setRefVisible(refToggleButton.isSelected());
    }

    @FXML
    private void drvToggleButtonChanged(ActionEvent event) {
        currentLexiconPage.setDrvVisible(drvToggleButton.isSelected());
    }

    @FXML
    private void iflToggleButtonChanged(ActionEvent event) {
        currentLexiconPage.setIflVisible(iflToggleButton.isSelected());
    }

    @FXML
    private void elmToggleButtonChanged(ActionEvent event) {
        currentLexiconPage.setElmVisible(elmToggleButton.isSelected());
    }

    @FXML
    private void cogToggleButtonChanged(ActionEvent event) {
        currentLexiconPage.setCogVisible(cogToggleButton.isSelected());
    }

}
