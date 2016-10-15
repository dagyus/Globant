package Juego;

public class Personaje {
	int idInicio;
	private static final int VELOCIDAD_BASE=500;
	private static final int INTELIGENCIA_BASE=300;
	private int id, edad,  agilidad, puntos, fuerza;
	private String raza;
	private double peso, velocidad, inteligencia;
	public Personaje(int id, int edad, int agilidad, int puntos, int fuerza,
			String raza, float peso) {
		this.id = id;
		this.edad = edad;
		this.velocidad = calculaVelocidad();
		this.agilidad = agilidad;
		this.inteligencia = calculaInteligencia();
		this.puntos = puntos;
		this.fuerza = fuerza;
		this.raza = raza;
		this.peso = peso;
	}
	private double calculaVelocidad(){
		velocidad=VELOCIDAD_BASE-(peso*0.3);
		return velocidad;
	}
	private double calculaInteligencia(){
		inteligencia=INTELIGENCIA_BASE+edad;
		return inteligencia;
	}
	
}
