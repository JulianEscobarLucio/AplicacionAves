package co.com.ias.aplicacionaves.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.com.ias.aplicacionaves.model.Ave;
import co.com.ias.aplicacionaves.model.Pais;
import co.com.ias.aplicacionaves.model.PaisAves;
import co.com.ias.aplicacionaves.model.Zona;

@Transactional
@Repository
public class AveDaoImpl implements AveDao {
  
	@PersistenceContext	
	private EntityManager entityManager;	
	

	@Override
	public void agregarAve(Ave ave) {
		entityManager.persist(ave);
		if(ave.getIdPais() != 0) {
			Pais pais = entityManager.find(Pais.class, ave.getIdPais());
			entityManager.persist(new PaisAves(ave, pais));
		}
	}


	@Override
	public void eliminarAve(Long idAve) {
		entityManager.remove(consultarAve(idAve));
		
	}

	@Override
	public Ave consultarAve(long idAve) {
		return entityManager.find(Ave.class, idAve);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ave> consultarAves(String nombre) {
		String hql = "FROM Ave where nombre_cientifico LIKE ? OR nombre_comun LIKE ? ";
		return (List<Ave>) entityManager.createQuery(hql).setParameter(1, "%"+nombre.trim()+"%").setParameter(2,  "%"+nombre.trim()+"%").getResultList();		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Ave> listarAves() {
		String hql = "From Ave";
		return (List<Ave>) entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> listarPais() {
		String hql = "FROM Pais";
		return (List<Pais>) entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Zona> listarZonas() {
		String hql = "From Zona";
		return (List<Zona>) entityManager.createQuery(hql).getResultList();
	}


	@Override
	public List<Ave> listarAvesZonas(Long zona) {
		String hql = "From Pais where id_zona = ?";
		@SuppressWarnings("unchecked")
		List<Pais> listPais = (List<Pais>) entityManager.createQuery(hql).setParameter(1, zona).getResultList();	
		String hql1 = "From Ave where id_pais = ?";
		@SuppressWarnings("unchecked")
		List<Ave> listAves = (List<Ave>) entityManager.createQuery(hql1).setParameter(1, listPais.get(0).getId()).getResultList();
		return listAves;
	}
}
