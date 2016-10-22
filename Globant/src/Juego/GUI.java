package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GUI extends JFrame implements FocusListener, ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container=new Container();
    private JButton apostarInicioPelea;
    private ButtonGroup apuesta;
    private JRadioButton heroe, villano;
    private JTextField puntosApuesta;
    private ArrayList<Personaje> personajes=new ArrayList<>();
    public GUI(){
        super("Juego");
        container=getContentPane();
        container.setBackground(Color.BLACK);
        container.setForeground(Color.BLACK);
        setSize(600, 400);
        setBackground(Color.black);
        setForeground(Color.black);
        heroe=new JRadioButton("Heroe");
        heroe.setForeground(Color.GREEN);
        heroe.setBackground(Color.BLACK);
        heroe.setBounds(230, 10, 60, 40);
        villano=new JRadioButton("Villano");
        villano.setBackground(Color.BLACK);
        villano.setForeground(Color.GREEN);
        villano.setBounds(310, 10, 100, 40);
        apuesta=new ButtonGroup();
        apuesta.add(heroe);
        apuesta.add(villano);
        container.setLayout(null);
        container.add(heroe);
        container.add(villano);
        puntosApuesta=new JTextField("Cantidad :");
        puntosApuesta.setBackground(Color.BLACK);
        puntosApuesta.setForeground(Color.GREEN);
        puntosApuesta.setBounds(230, 50, 140, 30);
        container.add(puntosApuesta);
        apostarInicioPelea=new JButton("Iniciar Pelea");
        apostarInicioPelea.setBackground(Color.BLACK);
        apostarInicioPelea.setForeground(Color.GREEN);
        apostarInicioPelea.setBounds(230, 90, 140, 40);
        container.add(apostarInicioPelea);
        puntosApuesta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                puntosApuesta.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(puntosApuesta.getText().equals("")){
            		puntosApuesta.setText("Cantidad: ");
            	}
            }
        });
        leerHeroes();
        leerVillano();
        apostarInicioPelea.addActionListener(this);
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
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(apostarInicioPelea)){
			int idHeroe=0, idVillano=0;
			do{
				idHeroe=(int) Math.random()%(personajes.size()-1);
			}while(!(personajes.get(idHeroe) instanceof Heroe));
			do{
				idVillano=(int) Math.random()%(personajes.size()-1);
			}while(!(personajes.get(idVillano) instanceof Villano));
			ServicioPelea pelea=new ServicioPelea((Heroe) personajes.get(idHeroe), (Villano) personajes.get(idVillano));
			pelea.pelea();
		}
	}
	
	public void leerHeroes(){

        FileReader oFileReader = null;
        BufferedReader oBufferedReader = null;

        try {

            oFileReader = new FileReader(new File("Misc/heroe.txt"));
            oBufferedReader = new BufferedReader(oFileReader);

            String linea;
            int edad=0, agilidad=0, puntos=0, fuerza=0;
            String raza="";
            float peso=0;

            while ((linea = oBufferedReader.readLine()) != null) {
                int campo = 0;
                String cadena = "";
                int i = 0;
                while (i < linea.length()) {
                    if (!linea.substring(i, i + 1).equals("\t")) {
                        cadena = cadena + linea.substring(i, i + 1);
                    } else {
                        campo++;
                        switch (campo) {
                        case 1:
                        	edad=Integer.parseInt(cadena);
                            cadena="";
                            break;
                        case 2:
                        	agilidad=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 3:
                        	puntos=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 4:
                        	fuerza=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 5:
                        	raza=cadena;
                        	cadena="";
                        	break;
                        case 6:
                        	peso=Float.parseFloat(cadena);
                        	cadena="";
                        	break;
                        }
                    }
                    i++;
                }
				personajes.add(new Heroe(edad, agilidad, puntos, fuerza, raza, peso));
            }
        } catch (Exception e) {

        } finally {

            try {
                if (oFileReader != null) {
                    oFileReader.close();
                }
            } catch (Exception e2) {

            }
        }

    }
	
	public void leerVillano(){

        FileReader oFileReader = null;
        BufferedReader oBufferedReader = null;

        try {

            oFileReader = new FileReader(new File("Misc/heroe.txt"));
            oBufferedReader = new BufferedReader(oFileReader);

            String linea;
            int edad=0, agilidad=0, puntos=0, fuerza=0;
            String raza="";
            float peso=0;

            while ((linea = oBufferedReader.readLine()) != null) {
                int campo = 0;
                String cadena = "";
                int i = 0;
                while (i < linea.length()) {
                    if (!linea.substring(i, i + 1).equals("\t")) {
                        cadena = cadena + linea.substring(i, i + 1);
                    } else {
                        campo++;
                        switch (campo) {
                        case 1:
                        	edad=Integer.parseInt(cadena);
                            cadena="";
                            break;
                        case 2:
                        	agilidad=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 3:
                        	puntos=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 4:
                        	fuerza=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 5:
                        	raza=cadena;
                        	cadena="";
                        	break;
                        case 6:
                        	peso=Float.parseFloat(cadena);
                        	cadena="";
                        	break;
                        }
                    }
                    i++;
                }
                personajes.add(new Villano(edad, agilidad, puntos, fuerza, raza, peso));
            }
        } catch (Exception e) {

        } finally {

            try {
                if (oFileReader != null) {
                    oFileReader.close();
                }
            } catch (Exception e2) {

            }
        }

    }
}
