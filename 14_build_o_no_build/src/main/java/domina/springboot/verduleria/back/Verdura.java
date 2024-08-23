package domina.springboot.verduleria.back;

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

	@Override
	public String toString() {
		return String.format("Verdura [id=%s, nombre=%s, precio=%s, troceable=%s]", id, nombre, precio, troceable);
	}
}

// Pista de no usar récord: https://discourse.hibernate.org/t/hibernate-6-and-java-records-unable-so-persist/7761