package co.com.ias.aplicacionaves.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="PAIS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Pais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_PAIS")
	private long id;
	
	@Column(name="NOMBRE_PAIS")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ZONA")
	@JsonIgnore
	private Zona zona;
	
	@OneToMany(mappedBy ="pais", cascade= CascadeType.ALL)
	@JsonIgnore
    private List<PaisAves> paisAves;
	
	
	public Pais() {
	}

	
	public Pais(long id, String nombre, Zona zona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.zona = zona;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@XmlTransient
	public List<PaisAves> getPaisAves() {
		return paisAves;
	}


	public void setPaisAves(List<PaisAves> paisAves) {
		this.paisAves = paisAves;
	}


	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", zona=" + zona + "]";
	}

	
	
}
