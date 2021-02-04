package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clienteid;
	private String nombres;
	private String cedula;
	private String correo;
	private String direccion;
	private String telefono;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
	private List<Restaurante> restaurantes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Reserva> reservas;

	public Cliente() {
		super();
	}

	public Cliente(int clienteid, String nombres, String cedula, String correo, String direccion, String telefono) {
		super();
		this.clienteid = clienteid;
		this.nombres = nombres;
		this.cedula = cedula;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
   
}
