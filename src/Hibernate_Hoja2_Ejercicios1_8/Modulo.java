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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Modulo", catalog = "profesor")
public class Modulo implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Float creditos;
	private Set<Profesor> profesors = new HashSet<Profesor>(0);

	public Modulo() {
	}

	public Modulo(String nombre, Float creditos, Set<Profesor> profesors) {
		this.nombre = nombre;
		this.creditos = creditos;
		this.profesors = profesors;
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

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "creditos", precision = 12, scale = 0)
	public Float getCreditos() {
		return this.creditos;
	}

	public void setCreditos(Float creditos) {
		this.creditos = creditos;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", profesors=" + profesors.toString() + "]";
	}

	
	
}
