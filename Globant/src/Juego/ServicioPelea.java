package Juego;

import javax.swing.JOptionPane;

public class ServicioPelea {
	private int contadorHeroe=0;
	private int contadorVillano=0;
	private Heroe heroe;
	private Villano villano;
	private String ganador;
	public ServicioPelea(Heroe heroe, Villano villano){
		this.heroe=heroe;
		this.villano=villano;
	}
	public void pelea(){
		compararFuerza();
		compararVelocidad();
		compararInteligencia();
		compararAgilidad();
		compararPrecision();
		if(contadorHeroe>contadorVillano){
			JOptionPane.showMessageDialog(null, "Gano el heroe.");
			this.setGanador("Heroe");
		}
		if(contadorHeroe<contadorVillano){
			JOptionPane.showMessageDialog(null, "Gano el villano.");
			this.setGanador("Villano");
		}
		if(contadorHeroe==contadorVillano){
			JOptionPane.showMessageDialog(null, "Empataron.");
			this.setGanador("Empate");
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
	public String getGanador() {
		return ganador;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
}
