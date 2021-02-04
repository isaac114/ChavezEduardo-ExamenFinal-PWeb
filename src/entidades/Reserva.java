package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity

public class Reserva implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservaid;
	@JoinColumn
	@ManyToOne
	private Cliente cliente;
	@JoinColumn
	@ManyToOne
	private Restaurante restaurante;

	public Reserva() {
		super();
	}

	public Reserva(int reservaid, Cliente cliente, Restaurante restaurante) {
		super();
		this.reservaid = reservaid;
		this.cliente = cliente;
		this.restaurante = restaurante;
	}

	public int getReservaid() {
		return reservaid;
	}

	public void setReservaid(int reservaid) {
		this.reservaid = reservaid;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	
   
}
