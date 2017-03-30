package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
	
	private List <String> dizionario=new LinkedList<String>();
	
	/**
	 * carica il dizionario dal file a seconda della lingua passata come parametro (tendina)
	 * @param language
	 */
	public void loadDictionary(String language){
		
		if (language.equals("English")){
			
			try{
				FileReader fr=new FileReader("rsc/English.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null){
					dizionario.add(word);
				}
				br.close();
				
			} 
			catch (IOException e){
				System.out.println("Errore nella lettura del file");
			}
			
		}
		
		else{
			
			try{
				FileReader fr=new FileReader("rsc/Italian.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null){
					dizionario.add(word);
				}
				br.close();
				
			} 
			catch (IOException e){
				System.out.println("Errore nella lettura del file");
			}
			
		}
	}
	
	public List<RichWord> spellCheckText(List<String> /*String[]*/ inputTextList){
		
		List <RichWord> lista =new LinkedList <RichWord>();
				
		for (String s: inputTextList){
			s=s.replaceAll("[\\p{Punct}]","");
			s=s.toLowerCase();
			if (dizionario.contains(s)==true){
				RichWord temp=new RichWord (s);
				temp.setCorretta(true);
				lista.add(temp);
			}
			else{
				RichWord temp=new RichWord (s);
				lista.add(temp);
			}
		}
		
		/*for (int i=0; i<inputTextList.length; i++){
			inputTextList[i]=inputTextList[i].replaceAll("[\\p{Punct}]","");
			inputTextList[i]=inputTextList[i].toLowerCase();
			if(dizionario.contains(inputTextList[i])==true){
				RichWord temp=new RichWord (inputTextList[i]);
				temp.setCorretta(true);
				lista.add(temp);
			}
			else{
				RichWord temp=new RichWord (inputTextList[i]);
				lista.add(temp);
			}
		}*/
		
		return lista;
		
	}
	

}
