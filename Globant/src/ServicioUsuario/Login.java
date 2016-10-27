package ServicioUsuario;
import Juego.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.Spring;

public class Login implements List{
	public static List<Usuario> usuarios=new ArrayList<>();
	private static final int ID_INICIO=1;
	public static void main(String [] args){
		leerUsuarios();
		
	}
	void menu() throws IOException{
		Scanner teclado=new Scanner(System.in);
		System.out.print("LOGIN \n \n ");
		System.out.print("1. INICIAR SECION \n  ");
		System.out.print("2. REGISTRARCE \n ");
		System.out.print("3. SALIR \n ");
		int opc= teclado.nextInt();
		
		switch(opc){
		case 1:
			lectura();
			
			menu();
			break;
		case 2:
			System.out.println("Nickname: \n");
			escritura();
			System.out.println("\nPassword: ");
			escritura();			
			System.out.println("\nGenero: ");
			escritura();			
			System.out.println("\nedad: ");
			escritura(); 
			menu();
			break;
		case 3:
			System.exit(0);
			break;
			
		}
	}
	
	void lectura()throws IOException{
		
		boolean k=false;
		String use;
		String pas;
		Scanner user=new Scanner(System.in);
		use= user.nextLine();
		pas= user.nextLine();
	    BufferedReader archivo=new BufferedReader(new FileReader("usuarios.txt"));
	
		for(int i=0;i<usuarios.size();i++){
			if(use.equals(usuarios.get(i).getNickname())){
				if(pas.equals(usuarios.get(i).getPassword())){
					GUI gui=new GUI(usuarios.get(i));
				}
			}
		}
	
	}
	
	void escritura()throws IOException {
		Scanner teclado=new Scanner(System.in);
		JFileChooser jfc= new JFileChooser();
		jfc.showSaveDialog(null);
		FileWriter fw=new FileWriter(new String(jfc.getSelectedFile().getPath()),true);
		System.out.println("DATOS ...");
		String pal=teclado.next();
		fw.write(pal+ " ");
		fw.flush();
		fw.close();
	
		
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
	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void add(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int arg0, Collection arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
