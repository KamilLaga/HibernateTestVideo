package be.vdab.DAO;

import be.vdab.entities.Reservatie;

public class ReservatieDAO extends AbstractDAO {
	
	public void create(Reservatie reservatie) {
		getEntityManager().persist(reservatie);
	}

}
