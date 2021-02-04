package controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ejb.ClienteFacade;
import ejb.ReservaFacade;
import ejb.RestauranteFacade;
import entidades.Cliente;
import entidades.Reserva;
import entidades.Restaurante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ReservaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ReservaFacade ejbReservaFacade;
	@EJB
	private ClienteFacade ejbClienteFacade;
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	private Cliente cliente;
	private String cedula;
	private String restaurante;
	public String getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	private boolean cli;
	private String resultado1 = "";
	private String resultado2;
	private String resultado3;
	
	@PostConstruct
	public void init() {
		
	}
	
	public boolean buscarCliente(){
		String cedula = this.cedula;
		cli = false;
		Cliente cliente = ejbClienteFacade.buscarCliente(cedula);
		if(cliente != null) {
			System.out.println(cliente.getNombres());
			resultado1 = "encontrado";
			cli = true;
			return cli;
		}else {
			cli = false;
			resultado1 = "";
			return cli;
			
		}
	}
	
	public void buscarRestaurante() {
		String res = this.restaurante;
		Restaurante rest = ejbRestauranteFacade.buscarRestaurante(res);
		if(rest != null) {
			resultado2 = "encontrado";
		}else {
			resultado2 = "";
		}
	}
	
	public void reservar() {
		String cedula = this.cedula;
		cli = false;
		Cliente cliente = ejbClienteFacade.buscarCliente(cedula);
		String res = this.restaurante;
		Restaurante rest = ejbRestauranteFacade.buscarRestaurante(res);
		ejbReservaFacade.create(new Reserva(0, cliente, rest));
	}

	public ReservaFacade getEjbReservaFacade() {
		return ejbReservaFacade;
	}

	public void setEjbReservaFacade(ReservaFacade ejbReservaFacade) {
		this.ejbReservaFacade = ejbReservaFacade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String getResultado3() {
		return resultado3;
	}

	public void setResultado3(String resultado3) {
		this.resultado3 = resultado3;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}

	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}

	public boolean isCli() {
		return cli;
	}

	public void setCli(boolean cli) {
		this.cli = cli;
	}
	
	

}
