package Juego;

import java.util.Random;
public class Personaje {
	
	private static final double VELOCIDAD_BASE=500;
	private static final int INTELIGENCIA_BASE=300;
	private int id, edad,  agilidad, puntos, fuerza, precision;
	private String raza;
	private double velocidad, inteligencia;
	private float peso;
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
	public int calcularFuerza() {
		while(fuerza<200)
			fuerza = random.nextInt(700);
		return fuerza;
	}
	public int calcularAgilidad() {
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
		double parteEntera=Math.floor(velocidad);
		velocidad-=parteEntera;
		velocidad*=Math.pow(10, 2);
		velocidad=Math.round(velocidad);
		velocidad=parteEntera+(velocidad/Math.pow(10, 2));
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
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
	public static double getVelocidadBase() {
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
