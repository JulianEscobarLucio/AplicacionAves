package co.com.ias.aplicacionaves.dao;

import java.util.List;

import co.com.ias.aplicacionaves.model.Ave;
import co.com.ias.aplicacionaves.model.Pais;
import co.com.ias.aplicacionaves.model.Zona;

public interface AveDao {
  
	void agregarAve(Ave ave);
	
//	void actualizarAve(Ave ave);
	
	void eliminarAve(Long idAve);
	
	Ave consultarAve(long idAve);
	
	List<Ave> consultarAves(String nombre);
	
	void actualizarAve(Ave ave) ;
	
	List<Ave> listarAves();
	
	List<Pais> listarPais();

	List<Zona> listarZonas();
	
	List<Ave> listarAvesZonas(Long zona);
}
