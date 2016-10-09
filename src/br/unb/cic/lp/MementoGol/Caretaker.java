package br.unb.cic.lp.MementoGol;

import java.util.LinkedList;

public class Caretaker {
	LinkedList<Memento> list = new LinkedList<Memento>(); 
	
	   public void add(Memento state){
		   if(list.size() > 9 ){
		      list.remove(0);
		   }
		   else{
			   list.add(state); 
		   }
			   
	   }

	   public Memento get(int index){
		   return list.get(index);
	   }
	   public Memento get(){
		   if(list.size() > 1 ){
			   return list.getLast();
		   }
		   else{
			   return get(0);
		   }
	   }
}

