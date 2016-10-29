package ServicioUsuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;

import Juego.GUI;

public class GUI_LOGIN extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nickname;
	private JPasswordField password;
	private JButton inicioSesion, registrar;
	private JLabel lNickname, lPassword;
	private Container container=new Container();
	public static ArrayList<Usuario> usuarios=new ArrayList<>();
	private static final int ID_INICIO=1;
	private String usuario;
	private char contrasenia[];
	public static GUI_LOGIN guiLogin;
	public GUI_LOGIN(){
		leerUsuarios();
		setTitle("Inicio Sesion");
		container=getContentPane();
		container.setLayout(null);
		container.setBackground(Color.BLACK);
		container.setForeground(Color.GREEN);
		setSize(400,200);
		lNickname=new JLabel("Nickname: ");
		lNickname.setBounds(70, 20, 90, 20);
		lNickname.setBackground(Color.BLACK);
		lNickname.setForeground(Color.GREEN);
		container.add(lNickname);
		nickname=new JTextField();
		nickname.setBounds(200, 20, 90, 20);
		nickname.setBackground(Color.BLACK);
		nickname.setForeground(Color.GREEN);
		container.add(nickname);
		lPassword=new JLabel("Password: ");
		lPassword.setBounds(70, 60, 90, 20);
		lPassword.setBackground(Color.BLACK);
		lPassword.setForeground(Color.GREEN);
		container.add(lPassword);
		password=new JPasswordField();
		password.setBounds(200, 60, 90, 20);
		password.setBackground(Color.BLACK);
		password.setForeground(Color.GREEN);
		container.add(password);
		inicioSesion=new JButton("Iniciar Sesion");
		inicioSesion.setBounds(55, 100, 120, 30);
		inicioSesion.setBackground(Color.BLACK);
		inicioSesion.setForeground(Color.GREEN);
		container.add(inicioSesion);
		registrar=new JButton("Registrar");
		registrar.setBounds(185, 100, 120, 30);
		registrar.setBackground(Color.BLACK);
		registrar.setForeground(Color.GREEN);
		container.add(registrar);
        inicioSesion.addActionListener(this);
		registrar.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
    	guiLogin=new GUI_LOGIN();
    	guiLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(inicioSesion)){
			try{
				boolean flag=false;
				usuario=nickname.getText();
				contrasenia=password.getPassword();
				contrasenia=password.getPassword();
				int i=0;
				while(i<usuarios.size() && !flag){
					if(usuario.trim().equals(usuarios.get(i).getNickname())){
						if(String.valueOf(contrasenia).trim().equals(String.valueOf(usuarios.get(i).getPassword()))){
							super.setVisible(false);
							GUI gui=new GUI(usuarios.get(i));
							gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							guiLogin.dispose();
							flag=true;
						}else{
							JOptionPane.showMessageDialog(null, "Password incorrecta.");
							flag=true;
						}
					}
					i++;
				}
				if(!flag){
					JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
				}
			}catch(Exception exception){
				JOptionPane.showMessageDialog(null, "Algo malo ha ocurrido. Verifique los campos.");
			}
		}
		if(e.getSource().equals(registrar)){
			GUI_REGISTRO gui= new GUI_REGISTRO();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			guiLogin.dispose();
		}
	}
	
	public static void leerUsuarios(){

        FileReader oFileReader = null;
        BufferedReader oBufferedReader = null;

        try {

            oFileReader = new FileReader(new File("usuarios.txt"));
            oBufferedReader = new BufferedReader(oFileReader);

            String linea;
            int edad=0, puntos=0;
            String nickname="";
            char password[]=null;

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
                        	password=cadena.toCharArray();
                        	cadena="";
                        	break;
                        case 4:
                        	nickname=cadena;
                        	cadena="";
                        	break;
                        }
                    }
                    i++;
                }
                if(usuarios.isEmpty()){
                	usuarios.add(new Usuario(ID_INICIO, puntos, edad, password, nickname));
                }else{
                	usuarios.add(new Usuario(usuarios.size()+1, puntos, edad, password, nickname));
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
	public static void guardarUsuarios(){
        FileWriter oFileWriter = null;
        PrintWriter oPrintWriter = null;
        try {
            oFileWriter = new FileWriter("usuarios.txt");
            oPrintWriter = new PrintWriter(oFileWriter);

            for (int i = 0; i < usuarios.size(); i++) {

                oPrintWriter.append(usuarios.get(i).getEdad()+"\t");

                oPrintWriter.append(usuarios.get(i).getPuntos()+"\t");

                oPrintWriter.append(String.valueOf(usuarios.get(i).getPassword())+"\t");

                oPrintWriter.append(usuarios.get(i).getNickname()+"\t");

                oPrintWriter.append("\n");

            }
        } catch (Exception e1) {

        } finally {
            try {

                if (oFileWriter != null) {
                    oPrintWriter.close();
                }
            } catch (Exception e2) {

            }
        }
    }
}
