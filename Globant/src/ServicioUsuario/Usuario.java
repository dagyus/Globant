package ServicioUsuario;

public class Usuario {
	private int id, puntos, edad;
	private String password, nickname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getEdad() {
		return edad;
	}
	public Usuario(int id, int puntos, int edad, String password, String nickname) {
		this.id = id;
		this.puntos = puntos;
		this.edad = edad;
		this.password = password;
		this.nickname = nickname;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
