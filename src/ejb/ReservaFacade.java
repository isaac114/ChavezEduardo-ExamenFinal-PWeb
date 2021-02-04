package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Reserva;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva>{
	
	@PersistenceContext(unitName = "persistencia")
	private EntityManager em;

	public ReservaFacade() {
		super(Reserva.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	

}
