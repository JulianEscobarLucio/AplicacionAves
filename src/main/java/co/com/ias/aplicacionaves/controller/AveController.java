package co.com.ias.aplicacionaves.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import co.com.ias.aplicacionaves.model.Ave;
import co.com.ias.aplicacionaves.model.Pais;
import co.com.ias.aplicacionaves.model.Zona;
import co.com.ias.aplicacionaves.service.AveService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AveController {
	
	@Autowired
	private AveService aveService;
	

	@PostMapping("/ave")
	public ResponseEntity<Void> AgregarAve(@RequestBody Ave ave, UriComponentsBuilder builder) {
        if (aveService.agregarAve(ave) == false) {
	       return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
       
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/ave/{id}").buildAndExpand(ave.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	
//	@PutMapping("/ave")
//	public ResponseEntity<Ave> ActualizarAve(@RequestBody Ave ave) {
//		aveService.actualizarAve(ave);
//		return new ResponseEntity<Ave>(ave, HttpStatus.OK);		
//	}
	
	@DeleteMapping("/ave/{id}")
	public ResponseEntity<Void> EliminarAve(@PathVariable("id") Long id) {
		aveService.eliminarAve(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/aves/{nombre}")
	public ResponseEntity<List<Ave>> consultarAve(@PathVariable("nombre") String nombre) {
		List<Ave> aves = aveService.consultarAves(nombre);
		return new ResponseEntity<List<Ave>>(aves, HttpStatus.OK);
		
	}
	
	@GetMapping("/aveid/{id}")
	public ResponseEntity<Ave> consultarAveId(@PathVariable("id") Long id) {
		Ave ave = aveService.consultarAve(id);
		return new ResponseEntity<Ave>(ave, HttpStatus.OK);
		
	}
	
	@GetMapping("/aves")
	public ResponseEntity<List<Ave>>  listarAves() {
		List<Ave> listAves = aveService.listarAves();
		return new ResponseEntity<List<Ave>>(listAves, HttpStatus.OK);
	}
	
	@GetMapping("/paises")
	public ResponseEntity<List<Pais>> listarPais() {
		List<Pais> listPais = aveService.listarPais();
		return new ResponseEntity<List<Pais>>(listPais, HttpStatus.OK);
	}
	
	@GetMapping("/zonas")
	public ResponseEntity<List<Zona>>  listarZonas() {
		List<Zona> listZonas = aveService.listarZonas();
		return new ResponseEntity<List<Zona>>(listZonas, HttpStatus.OK);
	}
	
	@GetMapping("/aveszona/{zona}")
	public ResponseEntity<List<Ave>> listarAvesZonas(@PathVariable("zona") Long zona) {
		List<Ave> listAves = aveService.listarAvesZonas(zona);
		return new ResponseEntity<List<Ave>>(listAves, HttpStatus.OK);
	}
}
