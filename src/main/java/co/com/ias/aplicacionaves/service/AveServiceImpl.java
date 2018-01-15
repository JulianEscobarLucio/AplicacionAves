package co.com.ias.aplicacionaves.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ias.aplicacionaves.dao.AveDao;
import co.com.ias.aplicacionaves.model.Ave;
import co.com.ias.aplicacionaves.model.Pais;
import co.com.ias.aplicacionaves.model.Zona;

@Service
public class AveServiceImpl implements AveService {
  
	
	@Autowired
	private AveDao aveDao;

	@Override
	public boolean agregarAve(Ave ave) {
        if (aveDao.consultarAve(ave.getId()) != null ) {
        	aveDao.actualizarAve(ave);
        } else {
        	aveDao.agregarAve(ave);
            
        }	
        return true;
	}


	@Override
	public void eliminarAve(Long idAve) {
		aveDao.eliminarAve(idAve);
	}

	@Override
	public List<Ave> consultarAves(String nombre) {
		return aveDao.consultarAves(nombre);
	}
	
	@Override
	public Ave consultarAve(Long Id) {
		return aveDao.consultarAve(Id);
	}

	@Override
	public List<Ave> listarAves() {
		return aveDao.listarAves();
	}

	@Override
	public List<Pais> listarPais() {
		return aveDao.listarPais();
	}

	@Override
	public List<Zona> listarZonas() {
		return aveDao.listarZonas();
	}

	@Override
	public List<Ave> listarAvesZonas(Long zona) {
		return aveDao.listarAvesZonas(zona);
	}
}
