/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	Dictionary model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbLanguage"
    private ComboBox<String> cmbLanguage; // Value injected by FXMLLoader

    @FXML // fx:id="txtText"
    private TextArea txtText; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtError"
    private TextArea txtError; // Value injected by FXMLLoader

    @FXML // fx:id="lbNunmerErrors"
    private Label lbNunmerErrors; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="lbTime"
    private Label lbTime; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	
    	txtText.clear();
    	txtError.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	String lingua=cmbLanguage.getValue();
    	model.loadDictionary(lingua);
    	
    	String s=txtText.getText();
    	List <String> temp=new LinkedList<String>();
    	
    	String array[]=s.split(" ");
    	/*for(int i=0; i<array.length; i++){
    		array[i].replaceAll("[\\p{Punct}]", "");
    		array[i].toLowerCase();
    	}*/
		for (int i=0; i<array.length; i++){
			temp.add(array[i]);
		}
		
		List<RichWord> parole=new LinkedList<RichWord>();
		
		long t1=System.nanoTime();
		parole=model.spellCheckText(temp);
		//parole=model.spellCheckText(array);
		long t2=System.nanoTime();
		
		int cnt=0;
		
		for (RichWord rw: parole){
			if(rw.isCorretta()==false){
				cnt++;
				txtError.appendText(rw.getParola()+"\n");
			}
		}
		
		lbNunmerErrors.setText("The text contains "+cnt+" errors");
		lbTime.setText("Spell check completed in "+(t2-t1)/1e9+"seconds");
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtText != null : "fx:id=\"txtText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lbNunmerErrors != null : "fx:id=\"lbNunmerErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lbTime != null : "fx:id=\"lbTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        cmbLanguage.getItems().addAll("English", "Italian");	//la combobox ha internamente una collezione di elementi e 
        if (cmbLanguage.getItems().size()>0)			//getItems restituisce tale lista su cui posso fare tutte le operazioni classiche di una lista
        	cmbLanguage.setValue(cmbLanguage.getItems().get(0));

    }
    
    public void setModel(Dictionary model) {//nel main viene creato il modello e viene chiamato questo metodo che lo setta per il controller
		this.model = model;
	}
}
