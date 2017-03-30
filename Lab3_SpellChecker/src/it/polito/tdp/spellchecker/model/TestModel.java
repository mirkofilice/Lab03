package it.polito.tdp.spellchecker.model;

import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		
		Dictionary prova= new Dictionary();
		
		prova.loadDictionary("English");
		List <String> temp=new LinkedList<String>();
		
		String s="Hi! How arre yu?";
		String array[]=s.split(" ");
		for (int i=0; i<array.length; i++){
			temp.add(array[i]);
		}
		
		List<RichWord> prova1=new LinkedList<RichWord>(prova.spellCheckText(temp));
		
		/*List<RichWord> prova1=new LinkedList<RichWord>(prova.spellCheckText(array));*/
		
		for(RichWord rw: prova1){
			System.out.println(rw.toString());
		}

	}

}
