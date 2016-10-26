package Juego;

import java.util.Random;
public class Personaje {
	
	private static final int VELOCIDAD_BASE=500;
	private static final int INTELIGENCIA_BASE=300;
	private int id, edad,  agilidad, puntos, fuerza, precision;
	private String raza;
	private double peso, velocidad, inteligencia;
	private Random random=new Random();
	public Personaje(int id, int edad, int puntos, 
			String raza, float peso) {
		this.id = id;
		this.edad = edad;
		this.puntos = puntos;		
		this.raza = raza;
		this.peso = peso;
		this.velocidad = calculaVelocidad();
		this.agilidad = calcularAgilidad();
		this.inteligencia = calculaInteligencia();
		this.fuerza = calcularFuerza();
		this.precision = calcularPrecision();
	}
	private int calcularFuerza() {
		while(fuerza<200)
			fuerza = random.nextInt(700);
		return fuerza;
	}
	private int calcularAgilidad() {
		while(agilidad<200)
			agilidad = random.nextInt(700);
		return agilidad;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	private double calculaVelocidad(){
		velocidad=VELOCIDAD_BASE-(peso*0.3);
		return velocidad;
	}
	private double calculaInteligencia(){
		inteligencia=INTELIGENCIA_BASE+edad;
		return inteligencia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAgilidad() {
		return agilidad;
	}
	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public double getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(double inteligencia) {
		this.inteligencia = inteligencia;
	}
	public static int getVelocidadBase() {
		return VELOCIDAD_BASE;
	}
	public static int getInteligenciaBase() {
		return INTELIGENCIA_BASE;
	}
	public int calcularPrecision(){
		precision=random.nextInt(10);
		return precision;
	}
}
