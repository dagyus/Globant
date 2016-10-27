package ServicioUsuario;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI_REGISTRO extends JFrame implements ActionListener{
	private JTextField nickname, edad;
	private JPasswordField password;
	private JButton registrar;
	private JLabel lNickname, lPassword, lEdad;
	private Container container=new Container();
	private String contrasenia, usuario;
	private int age;
	
	public GUI_REGISTRO(){
		setTitle("Inicio Sesion");
		container=getContentPane();
		container.setLayout(null);
		setSize(600,400);
		lNickname=new JLabel("Nickname: ");
		lNickname.setBounds(133, 86, 90, 20);
		container.add(lNickname);
		nickname=new JTextField();
		nickname.setBounds(250, 86, 90, 20);
		container.add(nickname);
		lPassword=new JLabel("Password: ");
		lPassword.setBounds(133, 130, 90, 20);
		container.add(lPassword);
		password=new JPasswordField();
		password.setBounds(250, 130, 90, 20);
		container.add(password);
		lEdad=new JLabel("Edad: ");
		lEdad.setBounds(133, 180, 90, 20);
		container.add(lEdad);
		edad=new JTextField();
		edad.setBounds(250, 180, 90, 20);
		container.add(edad);
		registrar=new JButton("Registrar");
		registrar.setBounds(185, 250, 140, 20);
		container.add(registrar);
		registrar.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
    	GUI_REGISTRO gui=new GUI_REGISTRO();
    	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(registrar)){
			usuario=nickname.getText();
			contrasenia=password.getText();
			age= Integer.parseInt(edad.getText());
			
		}
	}
}
