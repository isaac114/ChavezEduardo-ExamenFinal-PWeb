package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


import ejb.RestauranteFacade;
import entidades.Cliente;
import entidades.Restaurante;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class RestauranteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	private String nombre;
	private String direccion;
	private String telefono;
	private String aforo;
	private String resultado;
	private List<Cliente> clientes;
	
	@PostConstruct
	public void init() {
		
	}
	
	public String anadirRestaurante() {
		ArrayList<Cliente> cli = new ArrayList<>();
		int aforo = Integer.parseInt(this.aforo);
		System.out.println("AQUIIII--->"+aforo);
		ejbRestauranteFacade.create(new Restaurante(0, this.nombre, this.direccion, this.telefono, aforo, cli));
		this.nombre = "";
		this.direccion = "";
		this.telefono = "";
		this.aforo = "";
		
		resultado = "Restaurante creado";
		return resultado;
	}

	public RestauranteFacade getEjbRestauranteFacade() {
		return ejbRestauranteFacade;
	}

	public void setEjbRestauranteFacade(RestauranteFacade ejbRestauranteFacade) {
		this.ejbRestauranteFacade = ejbRestauranteFacade;
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

	public String getAforo() {
		return aforo;
	}

	public void setAforo(String aforo) {
		this.aforo = aforo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	

}
