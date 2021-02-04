package controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ejb.ClienteFacade;
import entidades.Cliente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteFacade ejbClienteFacade;
	private String nombre;
	private String cedula;
	private String Direccion;
	private String telefono;
	private String correo;
	private String resultado1;
	private String resultado2;
	
	@PostConstruct
	public void init() {
		
	}
	
	
	
	public String anadirCliente() {
		ejbClienteFacade.create(new Cliente(0,this.nombre,this.cedula,this.correo,this.Direccion,this.telefono));
		nombre = "";
		cedula = "" ;
		correo = "";
		Direccion = "";
		telefono = "";
		resultado1 = "Usuario Creado Exitosamente";
		return resultado1;
	}

	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}

	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getResultado1() {
		return resultado1;
	}

	public void setResultado1(String resultado1) {
		this.resultado1 = resultado1;
	}

	public String getResultado2() {
		return resultado2;
	}

	public void setResultado2(String resultado2) {
		this.resultado2 = resultado2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
	

}
