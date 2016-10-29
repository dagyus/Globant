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
public class GUI extends JFrame implements FocusListener, ActionListener, ItemListener, WindowListener{
	private static final int ID_INICIO=1;
	private static final long serialVersionUID = 1L;
	private Container container=new Container();
    private JButton apostarInicioPelea, logout;
    private ButtonGroup apuesta;
    private JRadioButton heroe, villano;
    private JTextField puntosApuesta;
    private JLabel puntaje;
    private static ArrayList<Personaje> personajes=new ArrayList<>();
    private Usuario usuario;
    private boolean seleccion=false;
    private ArrayList<JLabel> stats=new ArrayList<>();
    public GUI(Usuario usuario){
        super("Juego");
        container=getContentPane();
        container.setBackground(Color.BLACK);
        container.setForeground(Color.GREEN);
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
        heroe.addItemListener(this);
        villano.addItemListener(this);
        stats.add(new JLabel("Heroe"));
        stats.get(0).setBounds(195, 150, 130, 20);
        stats.add(new JLabel("Raza: "));
        stats.get(1).setBounds(180, 170, 130, 20);
        stats.add(new JLabel("Edad: "));
        stats.get(2).setBounds(180, 190, 130, 20);
        stats.add(new JLabel("Fuerza: "));
        stats.get(3).setBounds(180, 210, 130, 20);
        stats.add(new JLabel("Agilidad: "));
        stats.get(4).setBounds(180, 230, 130, 20);
        stats.add(new JLabel("Velocidad: "));
        stats.get(5).setBounds(180, 250, 130, 20);
        stats.add(new JLabel("Inteligencia: "));
        stats.get(6).setBounds(180, 270, 130, 20);
        stats.add(new JLabel("Precision: "));
        stats.get(7).setBounds(180, 290, 130, 20);
        stats.add(new JLabel("Villano"));
        stats.get(8).setBounds(365, 150, 130, 20);
        stats.add(new JLabel("Raza: "));
        stats.get(9).setBounds(350, 170, 130, 20);
        stats.add(new JLabel("Edad: "));
        stats.get(10).setBounds(350, 190, 130, 20);
        stats.add(new JLabel("Fuerza: "));
        stats.get(11).setBounds(350, 210, 130, 20);
        stats.add(new JLabel("Agilidad: "));
        stats.get(12).setBounds(350, 230, 130, 20);
        stats.add(new JLabel("Velocidad: "));
        stats.get(13).setBounds(350, 250, 130, 20);
        stats.add(new JLabel("Inteligencia: "));
        stats.get(14).setBounds(350, 270, 130, 20);
        stats.add(new JLabel("Precision: "));
        stats.get(15).setBounds(350, 290, 130, 20);
        for(int i=0;i<stats.size();i++){
        	stats.get(i).setSize(160,20);
        	stats.get(i).setForeground(Color.GREEN);
            stats.get(i).setBackground(Color.BLACK);
        	container.add(stats.get(i));
        }
        puntaje=new JLabel("Puntos: "+usuario.getPuntos());
        puntaje.setBounds(480, 20, 120, 20);
        puntaje.setForeground(Color.GREEN);
        puntaje.setBackground(Color.BLACK);
        container.add(puntaje);
        logout=new JButton("Cerrar Sesion");
        logout.setBounds(460, 50, 120, 20);
        logout.setForeground(Color.GREEN);
        logout.setBackground(Color.BLACK);
        container.add(logout);
        logout.addActionListener(this);
        leerHeroes();
        leerVillano();
        setVisible(true);
        super.addWindowListener(this);
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
			if(verificarPuntos(usuario)){
				if(heroe.isSelected() || villano.isSelected()){
					limpiarStats();
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
					modificarStats(idHeroe, idVillano);
					resetearStats(idHeroe);
					resetearStats(idVillano);
					modificarPuntos(pelea, Integer.parseInt(puntosApuesta.getText()));
					puntaje.setText("Puntos: "+usuario.getPuntos());
					idHeroe=1;
					idVillano=1;
				}else{
					JOptionPane.showMessageDialog(null, "No selecciono su apuesta.");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Verificar puntos o campo de apuesta.");
			}
		}
		if(event.getSource().equals(logout)){
			ServicioUsuario.GUI_LOGIN.guardarUsuarios();
			ServicioUsuario.GUI_LOGIN.guiLogin=new ServicioUsuario.GUI_LOGIN();
			super.dispose();
		}
	}
	
	private void limpiarStats(){
		stats.get(1).setText("Raza: ");
		stats.get(2).setText("Edad: ");
		stats.get(3).setText("Fuerza: ");
		stats.get(4).setText("Agilidad: ");
		stats.get(5).setText("Velocidad: ");
		stats.get(6).setText("Inteligencia: ");
		stats.get(7).setText("Precision: ");
		stats.get(9).setText("Raza: ");
		stats.get(10).setText("Edad: ");
		stats.get(11).setText("Fuerza: ");
		stats.get(12).setText("Agilidad: ");
		stats.get(13).setText("Velocidad: ");
		stats.get(14).setText("Inteligencia: ");
		stats.get(15).setText("Precision: ");
	}
	private void modificarStats(int idHeroe, int idVillano) {
		stats.get(1).setText(stats.get(1).getText()+personajes.get(idHeroe).getRaza());
		stats.get(2).setText(stats.get(2).getText()+personajes.get(idHeroe).getEdad());
		stats.get(3).setText(stats.get(3).getText()+personajes.get(idHeroe).getFuerza());
		stats.get(4).setText(stats.get(4).getText()+personajes.get(idHeroe).getAgilidad());
		stats.get(5).setText(stats.get(5).getText()+personajes.get(idHeroe).getVelocidad());
		stats.get(6).setText(stats.get(6).getText()+personajes.get(idHeroe).getInteligencia());
		stats.get(7).setText(stats.get(7).getText()+personajes.get(idHeroe).getPrecision());
		stats.get(9).setText(stats.get(9).getText()+personajes.get(idVillano).getRaza());
		stats.get(10).setText(stats.get(10).getText()+personajes.get(idVillano).getEdad());
		stats.get(11).setText(stats.get(11).getText()+personajes.get(idVillano).getFuerza());
		stats.get(12).setText(stats.get(12).getText()+personajes.get(idVillano).getAgilidad());
		stats.get(13).setText(stats.get(13).getText()+personajes.get(idVillano).getVelocidad());
		stats.get(14).setText(stats.get(14).getText()+personajes.get(idVillano).getInteligencia());
		stats.get(15).setText(stats.get(15).getText()+personajes.get(idVillano).getPrecision());
		
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
	public boolean verificarPuntos(Usuario usuario){
		try{
			int apuesta= Integer.parseInt(puntosApuesta.getText());
			if(usuario.getPuntos()>=apuesta)
				return true;
			else{
				JOptionPane.showMessageDialog(null, "Puntos insuficientes.");
				return false;
			}
				
		} catch(Exception e){
			return false;
		}
	}
	
	private void resetearStats(int id){
		personajes.get(id).setFuerza(0);
		personajes.get(id).setAgilidad(0);
		personajes.get(id).setFuerza(personajes.get(id).calcularFuerza());
		personajes.get(id).setAgilidad(personajes.get(id).calcularAgilidad());
		personajes.get(id).setPrecision(personajes.get(id).calcularPrecision());
	}
	
	private void modificarPuntos(ServicioPelea pelea, int apuesta){
		if(pelea.getGanador().equals("Empate")){
			usuario.setPuntos(usuario.getPuntos());
		}
		if((pelea.getGanador().equals("Heroe") && seleccion) || (pelea.getGanador().equals("Villano") && !seleccion)){
			usuario.setPuntos(usuario.getPuntos()+apuesta);
		}
		if((pelea.getGanador().equals("Heroe") && !seleccion) || (pelea.getGanador().equals("Villano") && seleccion)){
			usuario.setPuntos(usuario.getPuntos()-apuesta);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==heroe){
			
			setSeleccion(true);
		}
		if(e.getSource()==villano){
			setSeleccion(false);
		}
	}
	public boolean isSeleccion() {
		return seleccion;
	}
	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		ServicioUsuario.GUI_LOGIN.guardarUsuarios();
	}
	@Override
	public void windowClosed(WindowEvent e) {

	}
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
}
