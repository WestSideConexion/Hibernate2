package Hibernate_Hoja2_Ejercicios1_8;
// Generated 9 dic. 2019 19:21:54 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Correo", catalog = "profesor")
public class Correo implements java.io.Serializable {

	private Integer id;
	private Profesor profesor;
	private String direccion;
	private String proveedor;

	public Correo() {
	}

	public Correo(Profesor profesor) {
		this.profesor = profesor;
	}

	public Correo(Profesor profesor, String direccion, String proveedor) {
		this.profesor = profesor;
		this.direccion = direccion;
		this.proveedor = proveedor;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profesor_id", nullable = false)
	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Column(name = "direccion", length = 50)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "proveedor", length = 50)
	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Correo [id=" + id + ", profesor=" + profesor.toString() + ", direccion=" + direccion + ", proveedor=" + proveedor
				+ "]";
	}

	
	
}
