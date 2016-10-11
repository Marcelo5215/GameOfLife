package br.unb.cic.lp.MementoGol;

import java.util.LinkedList;

public class Caretaker {
	LinkedList<Memento> list = new LinkedList<Memento>(); 
	private int numberOfRestores = 0;
	
	   public void add(Memento state){
		   if(list.size() > 9 ){
		      list.removeFirst();
			  list.addLast(state); 
		   }
		   else{
			  list.addLast(state); 
		   }
		   numberOfRestores = list.size();
	   }

	   public Memento get(int index){
		   return list.get(index);
	   }
	   
	   public Memento get(){
		   if(numberOfRestores == list.size()){
			   numberOfRestores--;
			   return list.getLast();
		   }
		   else if(numberOfRestores < 1){
			   numberOfRestores--;
			   return list.getFirst();
		   }
		   else{
			   return get(numberOfRestores--);
		   }
	   }
}

