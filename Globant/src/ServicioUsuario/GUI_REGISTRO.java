package ServicioUsuario;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI_REGISTRO extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nickname, edad;
	private JPasswordField password;
	private JButton registrar;
	private JLabel lNickname, lPassword, lEdad;
	private Container container=new Container();
	private String usuario;
	private char contrasenia[];
	private int age;
	private static final int ID_INICIO=1;
	public GUI_REGISTRO(){
		setTitle("Registro");
		container=getContentPane();
		container.setLayout(null);
		container.setBackground(Color.BLACK);
        container.setForeground(Color.GREEN);
		setSize(250,240);
		lNickname=new JLabel("Nickname: ");
		lNickname.setBounds(20, 20, 90, 20);
		lNickname.setBackground(Color.BLACK);
        lNickname.setForeground(Color.GREEN);
		container.add(lNickname);
		nickname=new JTextField();
		nickname.setBounds(120, 20, 90, 20);
		nickname.setBackground(Color.BLACK);
        nickname.setForeground(Color.GREEN);
		container.add(nickname);
		lPassword=new JLabel("Password: ");
		lPassword.setBounds(20, 60, 90, 20);
		lPassword.setBackground(Color.BLACK);
        lPassword.setForeground(Color.GREEN);
		container.add(lPassword);
		password=new JPasswordField();
		password.setBounds(120, 60, 90, 20);
		password.setBackground(Color.BLACK);
        password.setForeground(Color.GREEN);
		container.add(password);
		lEdad=new JLabel("Edad: ");
		lEdad.setBounds(20, 100, 90, 20);
		lEdad.setBackground(Color.BLACK);
        lEdad.setForeground(Color.GREEN);
		container.add(lEdad);
		edad=new JTextField();
		edad.setBounds(120, 100, 90, 20);
		edad.setBackground(Color.BLACK);
        edad.setForeground(Color.GREEN);
		container.add(edad);
		registrar=new JButton("Registrar");
		registrar.setBounds(50, 140, 140, 40);
		registrar.setBackground(Color.BLACK);
        registrar.setForeground(Color.GREEN);
		container.add(registrar);
		registrar.addActionListener(this);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(registrar)){
			try{
				usuario=nickname.getText();
				contrasenia=password.getPassword();
				age=Integer.parseInt(edad.getText());
				int i=0;
				boolean flag=false;
				while(i<GUI_LOGIN.usuarios.size()){
					if(usuario.equals(GUI_LOGIN.usuarios.get(i).getNickname()))
						flag=true;
					i++;
				}
				if(!flag){
					if(GUI_LOGIN.usuarios.isEmpty()){
						GUI_LOGIN.usuarios.add(new Usuario(ID_INICIO, 50, age, contrasenia, usuario));
					}else{
						GUI_LOGIN.usuarios.add(new Usuario(GUI_LOGIN.usuarios.size(), 50, age, contrasenia, usuario));
					}
					GUI_LOGIN.guardarUsuarios();
					GUI_LOGIN.guiLogin=new GUI_LOGIN();
	                super.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Nickname ocupado.");
				}
			}catch(Exception exception){
				JOptionPane.showMessageDialog(null, "Algo ha fallado. Por favor, verifique los campos.");
			}
		}
	}
}