package Projeto;



import javax.swing.JMenuBar;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.sqrt;

public class Frame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Janelas jn = new Janelas();
	
	static int parametroColorir=0;
	static int count=1;
	static int parametroP = 0;
    static int countcor = 0;
    static int countcorP = 0;
    static int pc = 1;
	int cordX,cordY,cordXx,cordYy;
    public BufferedImage telaBuffer;//buffer
    
    
    
    
    public Frame() { //construtor
      
    	addMouseListener(new AcaoMouse());//acao de click
       
        telaBuffer = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_ARGB_PRE);// criar um buffer com o tamanho e o tipo definido, outro tipo comum BufferedImage.TYPE_INT_RGB
      
    }
    
    
    
           /* Captura da acao do mouse */
    
    public class AcaoMouse implements MouseListener, MouseMotionListener {
        public void mouseClicked(MouseEvent e) {
        
        }
        public void mousePressed(MouseEvent e) {
        	
        }
        public void mouseReleased(MouseEvent e) {
        	if(parametroP==1) {
        		if(count==1) {
            		
            	    cordX = e.getX();
            	    cordY = e.getY();
            	   
            	    count++;
            		} else {
            			
            			
            	        cordXx = e.getX();
            	        cordYy = e.getY();
            	       int x1 = cordX,y1 = cordY,x2 =cordXx ,y2 = cordYy;
            	    
            			desenharLinha(x1, y1, x2, y2);
            			count--;
            		}
        	}
        	
        	
        	if(parametroP==2) {
        		if(count==1) {
            		
            	    cordX = e.getX();
            	    cordY = e.getY();
            	   
            	    count++;
            		} else {
            			
            			
            	        cordXx = e.getX();
            	        cordYy = e.getY();
            	       int x1 = cordX,y1 = cordY,x2 =cordXx ,y2 = cordYy;
            	    
            			desenharLinha(x1, y1, x2, y2);
            			cordX=cordXx;
            			cordY=cordYy;
            		}
        	}
        	
        	
        	if(parametroP==3) {
        	
        		if(count==1) {
            		
            	    cordX = e.getX();
            	    cordY = e.getY();
            	    count++;
        		}
            	    else {
            	    	
            	    cordXx = e.getX();
            	    cordYy = e.getY();
            	
            	    int x = (cordX - cordXx);
            	    int y = (cordY - cordYy);
    		
            		circulo(cordX,cordY,(int)(sqrt(((x*x)+(y*y)))));
            	   count--;
            	    }
        		}
            		
        	
        	
        	
        	if(parametroP==4) {
        		if(count==1) {
            		
            	    cordX = e.getX();
            	    cordY = e.getY();
            	  count++;
            	}else {
            		
            	    cordXx = e.getX();
            	    cordYy = e.getY();
            	    int largura = cordX-cordXx;
            	    int altura = cordY-cordYy;
            	 
            	    
            	    
            	    desenharLinha( cordX,       cordY,           cordX-largura,          cordY); // -
            	    
            	    desenharLinha( cordX,cordY-altura,cordX,cordY); // |
            	    
            	    desenharLinha( cordX            ,cordY-altura,     cordX-largura, cordY- altura); // _ 
            	    
            	   desenharLinha( cordX-largura,cordY-altura,cordX-largura,cordY); //          | 
            	     count--;
            	}
        		
        	}
        	if(parametroColorir==1 && pc==1) {
        		 update(getGraphics());//chama o  paintComponent
        		preencher(telaBuffer.getRGB(e.getX(), e.getY()),e.getX(), e.getY()); 
        		 update(getGraphics());//chama o  paintComponent
        	}
        	
        	
        	
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        	
        }
        public void mouseDragged(MouseEvent e) {
        
        }
        public void mouseMoved(MouseEvent e) {
        }
     
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE); //seleciona cor de fundo
        g.fillRect(0, 1, telaBuffer.getWidth(), telaBuffer.getHeight());//retangulo branco (buffer)
        g.drawImage(telaBuffer, 0, 0, null); // pinta o jpanel com o buffer
        g.dispose();
    }
      
    

    
    
    
    
    
    
    
           /* Metodos de implementacao das primitivas */
    
 
    
    void desenharLinha( int x1 , int y1, int x2, int y2) {
    	int x = x1, y = y1, d = 0;
    	int dx = x2 - x1, dy = y2 - y1,loop=1,
    	c, med, xMed = 1, yMed = 1;
    	
    	if (dx < 0){
    		xMed = - 1;
    		dx = - dx;
    	}
    	if (dy < 0){
    		yMed = - 1;
    		dy = - dy;
    		}
    	
    	if (dy <= dx) {
    		 c = 2 * dx; med = 2 * dy;
    		 if (xMed < 0) dx++;
    		 while(loop==1) {
    			 ponto( x, y);
    			 if (x == x2) {
    				 loop=0;
    			 }
    			 x += xMed;
    			 d += med;
    			 if (d >= dx) {y += yMed; d -= c;};
    		 }
    	}
    	else {
    		c = 2 * dy; med = 2 * dx;
    		if (yMed < 0) dy++;
    		while(loop==1) {
    			ponto( x, y);
    			if (y == y2) {
    				loop=0;
    			}
    			y += yMed;
    			d += med;
    			if (d >= dy) {x += xMed; d-= c;};
    		}
    	}
    			
    			
    }
  
    
    public void circulo(int xC, int yC, int r )
    {  
    
    	
    	int x = 0, y = r, u = 1, v = 2 * r - 1, E = 0;
    	
    while (x < y){
    ponto( xC + x, yC + y); // 2 octante
    ponto( xC-y, yC + x); // 4 octante
    ponto( xC - x, yC-y); // 6 octante
    ponto( xC + y, yC- x); // 8 octante
    
  
    x++; E += u; u += 2;
    if (v < 2 * E){
    	y--; E-= v; v-= 2;
    }
    if (x > y) break;
    ponto( xC + y, yC + x); // 1 octante
    ponto( xC-x, yC + y); // 3 octante
    ponto( xC - y, yC-x); // 5 octante
    ponto( xC+ x, yC-y); // 7 octante
    }
    }
    
    
    
    
    
    
    
    /* Metodo para pintar na tela */
    
    public  void ponto(int x, int y) {
  	   Graphics gDoBuffer = telaBuffer.createGraphics();//pega o graphics do buffer para edicao

    	 
    	gDoBuffer.setColor(Color.BLACK);
    	if(countcor==1) {	
    		gDoBuffer.setColor(Color.GREEN);
    	}else if(countcor==2) {
    		gDoBuffer.setColor(Color.BLUE);
    	}else if(countcor==3) {
    		gDoBuffer.setColor(Color.BLACK);
    	}else if(countcor==4) {
    		gDoBuffer.setColor(Color.MAGENTA); 
    	}else if(countcor==5) {
    		gDoBuffer.setColor(Color.RED);
    	}
    	
    	
        gDoBuffer.fillOval(x, y, 3, 3); //desenha um ponto
      
        updateUI();//atualiza o jpanel, ou seja, "diz ao jpanel q seu desenho foi atualizado e  q seja exibido"
    }

    
    
   
   
   
	 public void preencher(int rgb,int x1,int y1) 
	 { 
		
		//if cor antiga for encontrada
		 if(telaBuffer.getRGB(x1, y1)==rgb){
			 if(countcorP==1) {	
				 telaBuffer.setRGB(x1,y1,Color.GREEN.getRGB());
		    	}else if(countcorP==2) {
		    		telaBuffer.setRGB(x1,y1,Color.BLUE.getRGB());
		    	}else if(countcorP==3) {
		    		telaBuffer.setRGB(x1,y1,Color.BLACK.getRGB());
		    	}else if(countcorP==4) {
		    		telaBuffer.setRGB(x1,y1,Color.MAGENTA.getRGB());
		    	}else if(countcorP==5) {
		    		telaBuffer.setRGB(x1,y1,Color.RED.getRGB());
		    	}else {
		    		 telaBuffer.setRGB(x1,y1,Color.ORANGE.getRGB());// sobrepoe a cor da tela (branca)
		    	}
			
	 
			 
			
			 preencher(rgb,x1+1,y1); 
			 preencher(rgb,x1-1,y1); 
			 preencher(rgb,x1,y1-1); 
			 preencher(rgb,x1,y1+1); 
			
			 
			
			 } 
			 
		 } 

   
   /* Main */
   
public static void main(String[] args) {
	
	 Frame f = new Frame();
	
	JFrame jFrame = new JFrame();
   jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
   
   jFrame.setSize(900,700);
   jFrame.getContentPane().add(f);
   
   jFrame.setVisible(true);
   jFrame.setExtendedState(java.awt.Frame.NORMAL); 
   String[] opcoes = {"Fechar"};
   JOptionPane.showOptionDialog(null, "  	Pode acontecer da barra de menu nao aparecer, basta maximizar a tela.\n\n  Comando preencher: Figuras um pouco maiores podem apresentar problemas\n  e vao precisar de mais de um click para preencher.", "PONTOS CRITICOS DO SISTEMA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
   jFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH); 


   JMenuBar menu = new JMenuBar();
   jFrame.setJMenuBar(menu);
   
   
     
   /* Menu das primitivas */
   JMenu primitivas = new JMenu("Primitivas Graficas");
   menu.add(primitivas);
  

   JMenuItem reta = new JMenuItem("Reta");
   primitivas.add(reta);
        
   JMenuItem polilinha = new JMenuItem("Polilinha");
   primitivas.add(polilinha);
   
   JMenuItem circulo = new JMenuItem("Circulo");
   primitivas.add(circulo);
   
   JMenuItem retangulo = new JMenuItem("Retangulo");
   primitivas.add(retangulo);
   
   
   
   /* Acao das primitivas */
   class acaoReta implements ActionListener{
   	public void actionPerformed (ActionEvent e) {
   		count=1;
   		parametroP =1;
   		parametroColorir=0;
   	}
   }
    reta.addActionListener(new acaoReta());
    
   class acaoPolilinha implements ActionListener{
   	public void actionPerformed (ActionEvent e) {
   		count=1;
   		parametroP =2;
   		parametroColorir=0;
   	}
   }
   polilinha.addActionListener(new acaoPolilinha());
   
   class acaoCirculo implements ActionListener{
   	public void actionPerformed (ActionEvent e) {
   		count=1;
   		parametroP = 3;
   		parametroColorir=0;
   	}
   }
   circulo.addActionListener(new acaoCirculo());
   
   class acaoRetangulo implements ActionListener{
   	public void actionPerformed (ActionEvent e) {
   		count=1;
   		parametroP=4;
   		parametroColorir=0;
   	}
   }
   retangulo.addActionListener(new acaoRetangulo());
   
   
   
   
   
   
   
   /* Menu da cor */
   JMenu cor = new JMenu("Cor");
   menu.add(cor);
   
   JMenuItem defineCor = new JMenuItem("Cor da Linha");
   cor.add(defineCor);
   
   JMenuItem defineCorPreencher = new JMenuItem("Cor do preenchimento");
   cor.add(defineCorPreencher);
   
   
   /* Acao das cores */
   class acaoCor implements ActionListener{
   	public void actionPerformed (ActionEvent e) {
   		
   		Janelas.janelaCor();
   	}
   }
    defineCor.addActionListener(new acaoCor());
   
    class acaoCorPreenchimento implements ActionListener{
       	public void actionPerformed (ActionEvent e) {
       		
       		Janelas.janelaCorPreencher();
       	}
       }
        defineCorPreencher.addActionListener(new acaoCorPreenchimento());
        
        
      
        JMenu preencher = new JMenu("Preencher area");
        menu.add(preencher);
        
        JMenuItem itemPreencher = new JMenuItem("Preencher com click");
        preencher.add(itemPreencher);
        
        class acaoPreencher implements ActionListener{
           	public void actionPerformed (ActionEvent e) {
           		parametroP=0;
           		parametroColorir=1;	
           	}
           }
            itemPreencher.addActionListener(new acaoPreencher());
       
 
}



}

