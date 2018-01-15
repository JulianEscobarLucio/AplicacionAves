package co.com.ias.aplicacionaves.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="ZONA")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Zona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ZONA")
	private long id;
	
	@Column(name="NOMBRE_ZONA")
	private String nombreZona;
	
	@OneToMany(mappedBy ="zona", cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Pais> paises = new ArrayList<Pais>();

	public Zona() {
	}
	
	

	public Zona(long id, String nombreZona) {
		super();
		this.id = id;
		this.nombreZona = nombreZona;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

   

	public List<Pais> getPaises() {
		return paises;
	}



	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}



	@Override
	public String toString() {
		return "Zona [id=" + id + ", nombreZona=" + nombreZona + "]";
	}
	
	
	
}

