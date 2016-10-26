package Juego;

import javax.swing.JOptionPane;

public class ServicioPelea {
	private int contadorHeroe=0;
	private int contadorVillano=0;
	private Heroe heroe;
	private Villano villano;
	public ServicioPelea(Heroe heroe, Villano villano){
		this.heroe=heroe;
		this.villano=villano;
	}
	public void pelea(){
		JOptionPane.showMessageDialog(null, "Pelea iniciada");
		compararFuerza();
		compararVelocidad();
		compararInteligencia();
		compararAgilidad();
		compararPrecision();
		if(contadorHeroe>contadorVillano){
			JOptionPane.showMessageDialog(null, "Gano el heroe.");
		}
		if(contadorHeroe<contadorVillano){
			JOptionPane.showMessageDialog(null, "Gano el villano.");
		}
		if(contadorHeroe==contadorVillano){
			JOptionPane.showMessageDialog(null, "Empataron.");
		}
		heroe=null;
		villano=null;
	}
	
	public void compararFuerza(){
		if(heroe.getFuerza()>villano.getFuerza()){
			contadorHeroe++;
		}
		if(heroe.getFuerza()<villano.getFuerza()){
			contadorVillano++;
		}
	}
	public void compararVelocidad(){
		if(heroe.getVelocidad()>villano.getVelocidad()){
			contadorHeroe++;
		}
		if(heroe.getVelocidad()<villano.getVelocidad()){
			contadorVillano++;
		}
	}
	public void compararInteligencia(){
		if(heroe.getInteligencia()>villano.getInteligencia()){
			contadorHeroe++;
		}
		if(heroe.getInteligencia()<villano.getInteligencia()){
			contadorVillano++;
		}
	}
	public void compararAgilidad(){
		if(heroe.getAgilidad()>villano.getAgilidad()){
			contadorHeroe++;
		}
		if(heroe.getAgilidad()<villano.getAgilidad()){
			contadorVillano++;
		}
	}
	public void compararPrecision(){
		if(heroe.getPrecision()>villano.getPrecision()){
			contadorHeroe++;
		}
		if(heroe.getPrecision()<villano.getPrecision()){
			contadorVillano++;
		}
	}
}
