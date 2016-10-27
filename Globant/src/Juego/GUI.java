package Juego;
import ServicioUsuario.*;
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
    private Usuario usuario;
    public GUI(Usuario usuario){
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
        this.usuario=usuario;
        leerHeroes();
        leerVillano();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
    	
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
				//if(verificarPuntos(usuario)){
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
				/*}else{
					JOptionPane.showMessageDialog(null, "Verificar puntos o campo de apuesta.");
				}*/
			}
	}
	
	public static void leerHeroes(){

        FileReader oFileReader = null;
        BufferedReader oBufferedReader = null;

        try {

            oFileReader = new FileReader(new File("heroe.txt"));
            oBufferedReader = new BufferedReader(oFileReader);

            String linea;
            int edad=0, puntos=0;
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
                        	puntos=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 3:
                        	raza=cadena;
                        	cadena="";
                        	break;
                        case 4:
                        	peso=Float.parseFloat(cadena);
                        	cadena="";
                        	break;
                        }
                    }
                    i++;
                }
                if(personajes.isEmpty()){
                	personajes.add(new Heroe(ID_INICIO, edad, puntos, raza, peso));
                }else{
                	personajes.add(new Heroe(personajes.size()+1, edad, puntos, raza, peso));
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
            int edad=0, puntos=0;
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
                        	puntos=Integer.parseInt(cadena);
                        	cadena="";
                        	break;
                        case 3:
                        	raza=cadena;
                        	cadena="";
                        	break;
                        case 4:
                        	peso=Float.parseFloat(cadena);
                        	cadena="";
                        	break;
                        }
                    }
                    i++;
                }
                if(personajes.isEmpty()){
                	personajes.add(new Villano(ID_INICIO, edad, puntos, raza, peso));
                }else{
                	personajes.add(new Villano(personajes.size()+1, edad, puntos, raza, peso));
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
	/*public boolean verificarPuntos(Usuario usuario){
		try{
			int apuesta= Integer.parseInt(puntosApuesta.getText());
			if(usuario.getPuntos()>=apuesta)
				return true;
			else
				return false;
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Verifique el campo de texto.");
			return false;
		}finally{
			if(usuario.getPuntos()>=apuesta)
				return true;
			else
				return false;
		}
	}*/
	
	private void resetearStats(int id){
		personajes.get(id).calcularPrecision();
		//personajes.get(id).
	}
}
