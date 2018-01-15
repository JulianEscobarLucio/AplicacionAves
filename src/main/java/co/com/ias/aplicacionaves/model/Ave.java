package co.com.ias.aplicacionaves.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ave")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Ave implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Ave")
	private long id;
	
	@Column(name="Nombre_Comun")
	private String nombreComun;
	
	@Column(name="Nombre_Cientifico")
	private String nombreCientifico;
	
    @OneToMany(mappedBy="ave", cascade = CascadeType.ALL)
    private List<PaisAves> paisAves;
	
	private long idPais;

	public Ave() {
	}

	public Ave(long id, String nombreComun, String nombreCientifico) {
		super();
		this.id = id;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	
	
	public long getIdPais() {
		return idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}
	

	public List<PaisAves> getPaisAves() {
		return paisAves;
	}

	public void setPaisAves(List<PaisAves> paisAves) {
		this.paisAves = paisAves;
	}

	@Override
	public String toString() {
		return "Ave [id=" + id + ", nombreComun=" + nombreComun + ", nombreCientifico=" + nombreCientifico + "]";
	}


	
	
	

}

