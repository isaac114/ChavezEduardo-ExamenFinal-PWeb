package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Restaurante
 *
 */
@Entity

public class Restaurante implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restauranteid;
	private String nombre;
	private String direccion;
	private String telefono;
	private int aforo;
	@JoinColumn
	@ManyToMany
	private List<Cliente> clientes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
	private List<Reserva> reservas;

	public Restaurante() {
		super();
	}
	
	

	public Restaurante(int restauranteid, String nombre, String direccion, String telefono, int aforo,
			List<Cliente> clientes) {
		super();
		this.restauranteid = restauranteid;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.aforo = aforo;
		this.clientes = clientes;
	}



	public int getRestauranteid() {
		return restauranteid;
	}

	public void setRestauranteid(int restauranteid) {
		this.restauranteid = restauranteid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
   
}
