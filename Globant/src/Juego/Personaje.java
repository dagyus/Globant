package Juego;

import java.util.Random;
public class Personaje {
	
	private static final int VELOCIDAD_BASE=500;
	private static final int INTELIGENCIA_BASE=300;
	private int id, edad,  agilidad, puntos, fuerza, precision;
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
		this.precision = calcularPrecision();
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
		Random random=new Random();
		precision=random.nextInt(10);
		return precision;
	}
}
