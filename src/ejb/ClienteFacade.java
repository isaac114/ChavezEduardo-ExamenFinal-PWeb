package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
	
	@PersistenceContext(unitName = "persistencia")
	private EntityManager em;

	public ClienteFacade() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Cliente buscarCliente(String cedula) {
		Cliente cli = null;
		Query query = em.createQuery("SELECT a FROM Cliente a WHERE a.cedula ='"+cedula+"'");
		cli = (Cliente)query.getSingleResult();
		return cli;
	}

}
