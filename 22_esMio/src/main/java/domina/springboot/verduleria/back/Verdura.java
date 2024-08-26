package domina.springboot.verduleria.back;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Verdura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	private Double precio;
	private boolean troceable;
	private String owner;

	public Verdura() {
	}

	public Verdura(long id, String nombre, Double precio, boolean troceable, String owner) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.troceable = troceable;
		this.owner = owner;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public boolean isTroceable() {
		return troceable;
	}

	public void setTroceable(boolean troceable) {
		this.troceable = troceable;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return String.format("Verdura [id=%s, nombre=%s, precio=%s, troceable=%s, owner=%s]", id, nombre, precio,
				troceable, owner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, owner, precio, troceable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Verdura other = (Verdura) obj;
		return id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(owner, other.owner)
				&& Objects.equals(precio, other.precio) && troceable == other.troceable;
	}


}

// Pista de no usar récord: https://discourse.hibernate.org/t/hibernate-6-and-java-records-unable-so-persist/7761