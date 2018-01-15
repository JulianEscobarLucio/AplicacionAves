package co.com.ias.aplicacionaves.service;

import java.util.List;
import co.com.ias.aplicacionaves.model.Ave;
import co.com.ias.aplicacionaves.model.Pais;
import co.com.ias.aplicacionaves.model.Zona;

public interface AveService {
  
	boolean  agregarAve(Ave ave);
	
	
	void eliminarAve(Long idAve);
	
	List<Ave> consultarAves(String nombre);
	
	Ave consultarAve(Long Id);
	
	List<Ave> listarAves();
	
	List<Pais> listarPais();
	
	List<Zona> listarZonas();	
	
	List<Ave> listarAvesZonas(Long zona);
	
	
	
}
