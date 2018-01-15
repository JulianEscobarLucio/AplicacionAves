package co.com.ias.aplicacionaves.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="PAIS_AVES")
@IdClass(PaisAves.class)
public class PaisAves implements Serializable {
	
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  @Id
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name="ID_AVE")
	  @JsonIgnore
	  private Ave ave;
	   
	  @Id
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name="ID_PAIS")
	  @JsonIgnore
	  private Pais pais;

	  public PaisAves() {
	  }

	 

	public PaisAves(Ave ave, Pais pais) {
		super();
		this.ave = ave;
		this.pais = pais;
	}



	public Ave getAve() {
		return ave;
	}

	public void setAve(Ave ave) {
		this.ave = ave;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}


	  
	  
	  
	  
	  
}
