package Hibernate_Hoja2_Ejercicios1_8;
// Generated 9 dic. 2019 19:21:54 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Profesor", catalog = "profesor")
public class Profesor implements java.io.Serializable {

	private Integer id;
	private Direccion direccion;
	private Modulo modulo;
	private String nombre;
	private String ape1;
	private String ape2;
	private Set<Correo> correos = new HashSet<Correo>(0);

	public Profesor() {
	}

	public Profesor(Direccion direccion, Modulo modulo) {
		this.direccion = direccion;
		this.modulo = modulo;
	}

	public Profesor(Direccion direccion, Modulo modulo, String nombre, String ape1, String ape2, Set<Correo> correos) {
		this.direccion = direccion;
		this.modulo = modulo;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.correos = correos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "direccion_id", nullable = false)
	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "modulo_id", nullable = false)
	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ape1")
	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	@Column(name = "ape2")
	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
	public Set<Correo> getCorreos() {
		return this.correos;
	}

	public void setCorreos(Set<Correo> correos) {
		this.correos = correos;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", direccion=" + direccion.toString() + ", modulo=" + modulo + ", nombre=" + nombre
				+ ", ape1=" + ape1 + ", ape2=" + ape2 + ", correos=" + correos + "]";
	}

	
	
	
}
