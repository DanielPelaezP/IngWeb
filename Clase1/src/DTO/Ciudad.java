package DTO;
//clase DTO para la cuidad
public class Ciudad {
	private Long codigo;
	private String nombre;
	private String codigoArea;
	//metodos getters y setters
	public Long getCodido(){
		return this.codigo;
	}
	public void setCodigo(Long codigo){
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
}
