package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Cliente;
import entidades.Restaurante;

@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante>{

	@PersistenceContext(unitName = "persistencia")
	private EntityManager em;
	
	public RestauranteFacade() {
		super(Restaurante.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Restaurante buscarRestaurante(String restaurante) {
		Restaurante rest = null;
		Query query = em.createQuery("SELECT a FROM Restaurante a WHERE a.nombre ='"+restaurante+"'");
		rest = (Restaurante)query.getSingleResult();
		return rest;
	}

}
