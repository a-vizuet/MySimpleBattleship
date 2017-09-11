
package battleship;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TodoElJuego extends JFrame implements ActionListener {
    
    //global
    Container container = getContentPane();
    boolean pase1, pase2, ganador;
    int turno, pj1, pj2;
    
    // variables j1
    JButton tableroj1[][], tableroj2j1[][];
    JLabel txt1j1, txt2j1,j1;
    
    int clicksj1=0;
    
    // variables j2
    JButton tableroj2[][], tableroj1j2[][];
    
    JLabel txt1j2, txt2j2,j2;
    
    int clicksj2=0;
    
    public TodoElJuego(){

        setBounds(0,0,825,935);
        setResizable(true);
        setTitle("BATTLESHIP - Jugador 1");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        InicializarJugadores();
        InicializarJuego();
        
    }

    void InicializarJugadores(){
        
        //j1
        j1 = new JLabel("Jugador 1");
        j1.setBounds(35,0,400,40);
        j1.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        container.add(j1);
        
        // jlabel txt1
        txt1j1 = new JLabel("<html>Posiciona tus barcos.<br>La partida no iniciará si no los posicionas.</html>");
        txt1j1.setBounds(35,55,400,40);
        txt1j1.setFont(new Font("Verdana",Font.CENTER_BASELINE,16));
        container.add(txt1j1);
        
        // tablero 1
        tableroj1 = new JButton[10][10];
        for (int i = 0; i < tableroj1.length; i++) {
            for (int j = 0; j < tableroj1.length; j++) {
                
                tableroj1[i][j] = new JButton();
                tableroj1[i][j].setBounds((i+1)*35, (j+3)*35, 35, 35 );				
		tableroj1[i][j].addActionListener(this);
                tableroj1[i][j].setText("V");
                container.add(tableroj1[i][j]);
                
            }
            
        }
        
        // jlabel txt2
        txt2j1 = new JLabel("Elige una casilla para atacar.");
        txt2j1.setBounds(90,480,400,40);
        txt2j1.setFont(new Font("Verdana",Font.CENTER_BASELINE,16));
        container.add(txt2j1);
       
        // tablero 2
        tableroj2j1 = new JButton[10][10];
        for (int i = 0; i < tableroj2j1.length; i++) {
            for (int j = 0; j < tableroj2j1.length; j++) {
                
                tableroj2j1[i][j] = new JButton();
                tableroj2j1[i][j].setBounds((i+1)*35, (j+15)*35, 35, 35);
                tableroj2j1[i][j].addActionListener(this);
                tableroj2j1[i][j].setText("");
                tableroj2j1[i][j].setEnabled(false);
                container.add(tableroj2j1[i][j]);
                
            }
        }
        
        // j2
        j2 = new JLabel("Jugador 2");
        j2.setBounds(420,0,400,40);
        j2.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        container.add(j2);
        
        // jlabel txt1
        txt1j2 = new JLabel("<html>Posiciona tus barcos.<br>La partida no iniciará si no los posicionas.</html>");
        txt1j2.setBounds(420,55,400,40);
        txt1j2.setFont(new Font("Verdana",Font.CENTER_BASELINE,16));
        container.add(txt1j2);
        
        // tablero 1
        tableroj2 = new JButton[10][10];
        for (int i = 0; i < tableroj2.length; i++) {
            for (int j = 0; j < tableroj2.length; j++) {
                
                tableroj2[i][j] = new JButton();
                tableroj2[i][j].setBounds((i+12)*35, (j+3)*35, 35, 35 );				
		tableroj2[i][j].addActionListener(this);
                tableroj2[i][j].setText("V");
                container.add(tableroj2[i][j]);
                
            }
            
        }
        
        // jlabel txt2
        txt2j2 = new JLabel("Elige una casilla para atacar.");
        txt2j2.setBounds(480,480,400,40);
        txt2j2.setFont(new Font("Verdana",Font.CENTER_BASELINE,16));
        container.add(txt2j2);
       
        // tablero 2
        tableroj1j2 = new JButton[10][10];
        for (int i = 0; i < tableroj1j2.length; i++) {
            for (int j = 0; j < tableroj1j2.length; j++) {
                
                tableroj1j2[i][j] = new JButton();
                tableroj1j2[i][j].setBounds((i+12)*35, (j+15)*35, 35, 35);
                tableroj1j2[i][j].addActionListener(this);
                tableroj1j2[i][j].setText("");
                tableroj1j2[i][j].setEnabled(false);
                container.add(tableroj1j2[i][j]);
                
            }
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       // Poniendo los barquitos
        JButton boton = (JButton) e.getSource();
        
        if (pase1) {
            
            boton.setBackground(Color.green);
            boton.setText("B");
            boton.setEnabled(false);
            
            int a = 0;
            
            clicksj1++;
            
            if (clicksj1==5) {
                
                JOptionPane.showMessageDialog(null, "Ingresa la localización por \ncasilla consecutiva de tu buque (3 lugares).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);        

              
            }else if(clicksj1==8){
            
                JOptionPane.showMessageDialog(null, "Ingresa la localización por \ncasilla consecutiva de tu segundo buque (3 lugares).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
 
            }else if(clicksj1==11){
            
                JOptionPane.showMessageDialog(null, "Ingresa la localización en \ncasilla de tu lancha (1 lugar).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
                
            }else if(clicksj1==12){
            
                JOptionPane.showMessageDialog(null, "Ingresa la localización en \ncasilla de tu segunda lancha (1 lugar).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
                
            }else if(clicksj1==13){
                
                pase1 = false;
                pase2 = true;
                
                ActivarJ2();
                
                for (int i = 0; i < tableroj1.length; i++) {
                    for (int j = 0; j < tableroj1.length; j++) {
                        
                            tableroj1[i][j].setEnabled(false);
                        
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Ingresa la localización por \ncasilla consecutiva de tu portaaviones (5 lugares).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
        
                DesactivarJ1();
                
            }

        }else if(pase2){
        
            boton.setBackground(Color.green);
            boton.setText("B");
            boton.setEnabled(false);
            
            int a = 0;
            
            clicksj2++;
            
            if (clicksj2==5) {
                
                JOptionPane.showMessageDialog(null, "Ingresa la localización por \ncasilla consecutiva de tu buque (3 lugares).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);        
              
            }else if(clicksj2==8){
            
                JOptionPane.showMessageDialog(null, "Ingresa la localización por \ncasilla consecutiva de tu segundo buque (3 lugares).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
 
            }else if(clicksj2==11){
            
                JOptionPane.showMessageDialog(null, "Ingresa la localización en \ncasilla de tu lancha (1 lugar).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
                
            }else if(clicksj2==12){
            
                JOptionPane.showMessageDialog(null, "Ingresa la localización en \ncasilla de tu segunda lancha (1 lugar).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
                
            }else if(clicksj2==13){
            
                pase2 = false;
                
                ActivarJ1();
                
                for (int i = 0; i < tableroj2.length; i++) {
                    for (int j = 0; j < tableroj2.length; j++) {
                        
                        tableroj2[i][j].setEnabled(false);
                        
                    }
                }
                
                for (int i = 0; i < tableroj1j2.length; i++) {
                    for (int j = 0; j < tableroj1j2.length; j++) {
                        
                        tableroj1j2[i][j].setEnabled(true);
                        
                    }
                }
                
                for (int i = 0; i < tableroj2j1.length; i++) {
                    for (int j = 0; j < tableroj2j1.length; j++) {
                        
                        tableroj2j1[i][j].setEnabled(true);
                        
                    }
                }
                
                container.remove(txt1j1);
                container.remove(txt1j2);
                
                turno = 0;
                
                // rellenar mapas
                
                // relleno del mapa del j1 en el mapaj2 del j1
                for (int i = 0; i < tableroj1.length; i++) {
                    for (int j = 0; j < tableroj1.length; j++) {
                    
                        tableroj1j2[i][j].setText(tableroj1[i][j].getText());
                    
                    }
                }
                
                // relleno del mapa del j2 en el mapaj1 del j2
                for (int i = 0; i < tableroj2.length; i++) {
                    for (int j = 0; j < tableroj2.length; j++) {
                        
                        tableroj2j1[i][j].setText(tableroj2[i][j].getText());
                        
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Turno del jugador 1","Turno de..",JOptionPane.INFORMATION_MESSAGE);
                
                DesactivarJ2();
                
            }
            
        }else{
        
            if (turno==0) {
             
                if (boton.getText().equals("B")) {
                    
                    boton.setEnabled(false);
                    boton.setBackground(Color.red);
                    pj1++;
                    
                    JOptionPane.showMessageDialog(null, "Le has dado a un barco!","Qué feliz",JOptionPane.INFORMATION_MESSAGE);
                    
                    turno = 1;
                    
                }else{
                
                    boton.setEnabled(false);
                    boton.setBackground(Color.BLUE);
                    
                    JOptionPane.showMessageDialog(null, "Le has dado al agua!","Qué triste",JOptionPane.INFORMATION_MESSAGE);
                    
                    turno = 1;
                    
                }
                
                DesactivarJ1();
                ActivarJ2();
                
                JOptionPane.showMessageDialog(null, "Turno del jugador 2","Turno de..",JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                
                if(turno==1){
            
                if (boton.getText().equals("B")) {
                    
                    boton.setEnabled(false);
                    boton.setBackground(Color.red);
                    pj2++;
                    
                    JOptionPane.showMessageDialog(null, "Le has dado a un barco!","Qué feliz",JOptionPane.INFORMATION_MESSAGE);
                    
                    turno = 0;
                    
                }else{
                
                    boton.setEnabled(false);
                    boton.setBackground(Color.blue);
                    
                    JOptionPane.showMessageDialog(null, "Le has dado al agua!","Qué triste",JOptionPane.INFORMATION_MESSAGE);
                    
                    turno = 0;
                
                }
                
                DesactivarJ2();
                ActivarJ1();
                
                JOptionPane.showMessageDialog(null, "Turno del jugador 1","Turno de..",JOptionPane.INFORMATION_MESSAGE);
            
                }
            }
            
            ComprobarGanador();
            
        }

    }

    private void InicializarJuego() {
        
        JOptionPane.showMessageDialog(null, "El juego ha comenzado","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
        DesactivarJ2();
        
        pase1 = true;
        JOptionPane.showMessageDialog(null, "Ingresa la localización por \ncasilla consecutiva de tu portaaviones (5 lugares).","Inicializando juego...",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    void DesactivarJ1(){
    
        container.remove(j1);
        container.remove(txt1j1);
        container.remove(txt2j1);
        
        for (int i = 0; i < tableroj1.length; i++) {
            for (int j = 0; j < tableroj1.length; j++) {
                
                container.remove(tableroj1[i][j]);
                
            }
        }
        
        for (int i = 0; i < tableroj2j1.length; i++) {
            for (int j = 0; j < tableroj2j1.length; j++) {
                
                  container.remove(tableroj2j1[i][j]);
                
            }
        }
    
    }
    
    void ActivarJ1(){
        
        container.add(j1);
        container.add(txt1j1);
        container.add(txt2j1);
        
        for (int i = 0; i < tableroj1.length; i++) {
            for (int j = 0; j < tableroj1.length; j++) {
                
                container.add(tableroj1[i][j]);
                
            }
        }
        
        for (int i = 0; i < tableroj2j1.length; i++) {
            for (int j = 0; j < tableroj2j1.length; j++) {
                
                  container.add(tableroj2j1[i][j]);
                
            }
        }
    
    }
    
    void DesactivarJ2(){
        
        container.remove(j2);
        container.remove(txt1j2);
        container.remove(txt2j2);
        
        for (int i = 0; i < tableroj2.length; i++) {
            for (int j = 0; j < tableroj2.length; j++) {
                
                container.remove(tableroj2[i][j]);
                
            }
        }
        
        for (int i = 0; i < tableroj1j2.length; i++) {
            for (int j = 0; j < tableroj1j2.length; j++) {
                
                  container.remove(tableroj1j2[i][j]);
                
            }
        }
    
    }
    
    void ActivarJ2(){
    
        container.add(j2);
        container.add(txt1j2);
        container.add(txt2j2);
        
        for (int i = 0; i < tableroj2.length; i++) {
            for (int j = 0; j < tableroj2.length; j++) {
                
                container.add(tableroj2[i][j]);
                
            }
        }
        
        for (int i = 0; i < tableroj1j2.length; i++) {
            for (int j = 0; j < tableroj1j2.length; j++) {
                
                  container.add(tableroj1j2[i][j]);
                
            }
        }
        
    }

    private void ComprobarGanador() {
        
        if (pj1==13 && pj2<13) {
            
            // ganó jugador 1
            JOptionPane.showMessageDialog(null, "HA GANADO EL JUGADOR 1, FELICIDADES","GANADOR",JOptionPane.INFORMATION_MESSAGE);
            
            ActivarJ1();
            ActivarJ2();

            for (int i = 0; i < tableroj1.length; i++) {
                for (int j = 0; j < tableroj1.length; j++) {
                    
                    tableroj1j2[i][j].setEnabled(false);
                    tableroj2j1[i][j].setEnabled(false);
                    
                }
            }
            
        }else if(pj1<13 && pj2==13){
        
            // ganó jugador 2
            JOptionPane.showMessageDialog(null, "HA GANADO EL JUGADOR 2, FELICIDADES","GANADOR",JOptionPane.INFORMATION_MESSAGE);
            
            ActivarJ1();
            ActivarJ2();
            
            for (int i = 0; i < tableroj1.length; i++) {
                for (int j = 0; j < tableroj1.length; j++) {
                    
                    tableroj1j2[i][j].setEnabled(false);
                    tableroj2j1[i][j].setEnabled(false);
                    
                }
            }
            
        }
  
    }
   
}
