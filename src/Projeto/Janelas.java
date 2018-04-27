package Projeto;

import javax.swing.JOptionPane;

public class Janelas {
	public static  void janelaCor() {
		
    	String cor = JOptionPane.showInputDialog("1-Verde | 2-Azul | 3-Preto | 4-Rosa | 5-Vermelho ");
    	if(cor.equals("1")) {
    		new Frame().countcor = 1; 
    	
    	}else if(cor.equals("2")) {
        	
    		new Frame().countcor=2;
        	
    	}else if(cor.equals("3")) {
    		
    		new Frame().countcor=3;	
    	
    	}else if(cor.equals("4")) {
    	
    		new Frame().countcor=4;
    		
    	}else if(cor.equals("5")) {
    		
    		new Frame().countcor=5;	
    		
    	} 	
}


/* JOptionPane da cor do preencher */ 

public static  void janelaCorPreencher() {

    	String cor = JOptionPane.showInputDialog("1-Verde | 2-Azul | 3-Preto | 4-Rosa | 5-Vermelho ");
    	if(cor.equals("1")) {
    		new Frame().countcorP = 1; 
    	
    	}else if(cor.equals("2")) {
        	
    		new Frame().countcorP=2;
        	
    	}else if(cor.equals("3")) {
    		
    		new Frame().countcorP=3;	
    	
    	}else if(cor.equals("4")) {
    	
    		new Frame().countcorP=4;
    		
    	}else if(cor.equals("5")) {
    		
    		new Frame().countcorP=5;	
    		
    	} 	
}
}
