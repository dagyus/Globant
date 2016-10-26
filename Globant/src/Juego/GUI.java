package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
public class GUI extends JFrame implements FocusListener, ActionListener{
    /**
	 * 
	 */
	private static final int ID_INICIO=1;
	private static final long serialVersionUID = 1L;
	private Container container=new Container();
    private JButton apostarInicioPelea;
    private ButtonGroup apuesta;
    private JRadioButton heroe, villano;
    private JTextField puntosApuesta;
    private static ArrayList<Personaje> personajes=new ArrayList<>();
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
        apostarInicioPelea.addActionListener(this);
        setVisible(true);
    }
    public static void main(String[] args) {
    	leerHeroes();
        leerVillano();
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
		if(event.getSource()==apostarInicioPelea){
			int idHeroe=1, idVillano=1;
			Random random=new Random();
			do{
				idHeroe= random.nextInt(personajes.size()-1);
			}while(!(personajes.get(idHeroe) instanceof Heroe) || (idHeroe<0));
			do{
				idVillano=random.nextInt(personajes.size()-1);
			}while(!(personajes.get(idVillano) instanceof Villano) || (idVillano<0));
			ServicioPelea pelea=new ServicioPelea((Heroe) personajes.get(idHeroe), (Villano) personajes.get(idVillano));
			pelea.pelea();
			idHeroe=1;
			idVillano=1;
		}
	}
	
	public static void leerHeroes(){

        FileReader oFileReader = null;
        BufferedReader oBufferedReader = null;

        try {

            oFileReader = new FileReader(new File("heroe.txt"));
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
                if(personajes.isEmpty()){
                	personajes.add(new Heroe(ID_INICIO, edad, agilidad, puntos, fuerza, raza, peso));
                }else{
                	personajes.add(new Heroe(personajes.size()+1, edad, agilidad, puntos, fuerza, raza, peso));
                }
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
	
	public static void leerVillano(){

        FileReader oFileReader = null;
        BufferedReader oBufferedReader = null;

        try {

            oFileReader = new FileReader(new File("villano.txt"));
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
                if(personajes.isEmpty()){
                	personajes.add(new Villano(ID_INICIO, edad, agilidad, puntos, fuerza, raza, peso));
                }else{
                	personajes.add(new Villano(personajes.size()+1, edad, agilidad, puntos, fuerza, raza, peso));
                }
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
