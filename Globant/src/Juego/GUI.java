package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements FocusListener{
    private Container container=new Container();
    private JButton apostarInicioPelea;
    private ButtonGroup apuesta;
    private JRadioButton heroe, villano;
    private JTextField puntosApuesta;
    public GUI(){
        super("Juego");
        container=getContentPane();
        container.setLayout(null);
        setSize(600, 400);
        setBackground(Color.black);
        setForeground(Color.black);
        heroe=new JRadioButton("Heroe");
        heroe.setBounds(230, 10, 60, 40);
        villano=new JRadioButton("Villano");
        villano.setBounds(310, 10, 100, 40);
        apuesta=new ButtonGroup();
        apuesta.add(heroe);
        apuesta.add(villano);
        container.add(heroe);
        container.add(villano);
        puntosApuesta=new JTextField("Cantidad :");
        puntosApuesta.setBounds(230,50,140,30);
        container.add(puntosApuesta);
        apostarInicioPelea=new JButton("Iniciar Pelea");
        apostarInicioPelea.setBounds(230,90,140,40);
        container.add(apostarInicioPelea);
        puntosApuesta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                puntosApuesta.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
	    GUI gui=new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
