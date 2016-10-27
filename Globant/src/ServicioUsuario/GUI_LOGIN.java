package ServicioUsuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.*;

import Juego.GUI;

public class GUI_LOGIN extends JFrame implements ActionListener{
	private JTextField nickname;
	private JPasswordField password;
	private JButton inicioSesion, registrar;
	private JLabel lNickname, lPassword, olvidoPassword;
	private Container container=new Container();
	public static ArrayList<Usuario> usuarios=new ArrayList<>();
	private static final int ID_INICIO=1;
	private String usuario, contrasenia;
	public GUI_LOGIN(int i){
		setVisible(false);
	}
	public GUI_LOGIN(){
		setTitle("Inicio Sesion");
		container=getContentPane();
		container.setLayout(null);
		setSize(600,400);
		lNickname=new JLabel("Nickname: ");
		lNickname.setBounds(133, 86, 90, 40);
		container.add(lNickname);
		nickname=new JTextField();
		nickname.setBounds(250, 86, 90, 40);
		container.add(nickname);
		lPassword=new JLabel("Password: ");
		lPassword.setBounds(133, 180, 90, 40);
		container.add(lPassword);
		password=new JPasswordField();
		password.setBounds(250, 180, 90, 40);
		container.add(password);
		inicioSesion=new JButton("Iniciar Sesion");
		inicioSesion.setBounds(190, 250, 140, 40);
		container.add(inicioSesion);
		registrar=new JButton("Registrar");
		registrar.setBounds(400, 250, 140, 40);
		container.add(registrar);
		olvidoPassword=new JLabel("Olvido su Password?");
		olvidoPassword.setBounds(280, 300, 150, 20);
		container.add(olvidoPassword);
		registrar.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		leerUsuarios();
    	GUI_LOGIN gui=new GUI_LOGIN();
    	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(inicioSesion)){
			boolean flag=false;
			usuario=nickname.getText();
			contrasenia=password.getText();
			int i=0;
			while(i<usuarios.size() && !flag){
				if(usuario.equals(usuarios.get(i).getNickname())){
					if(contrasenia.equals(usuarios.get(i).getPassword())){
						GUI gui=new GUI(usuarios.get(i));
						gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						super.setVisible(false);
						flag=true;
					}else
						JOptionPane.showMessageDialog(null, "Password incorrecta.");
				}
			}
			if(!flag){
				JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
			}
		}
		if(e.getSource().equals(registrar)){
			GUI_REGISTRO gui= new GUI_REGISTRO();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		if(e.getSource().equals(olvidoPassword)){
			JOptionPane.showMessageDialog(null, "Aun estamos trabajando en ello.");
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
            String nickname="", password="";

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
                        	password=cadena;
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

}