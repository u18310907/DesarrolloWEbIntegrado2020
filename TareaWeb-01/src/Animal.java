
public class Animal {

	private String clasificacion_animal;
	private int can_patas;
	private int can_ojo;
	private boolean pelos;
	private boolean cola;

	public Animal(String clasificacion_animal, int can_patas, int can_ojo, boolean pelos, boolean cola) {
		this.clasificacion_animal = clasificacion_animal;
		this.can_patas = can_patas;
		this.can_ojo = can_ojo;
		this.pelos = pelos;
		this.cola = cola;
	}

	public String getClasificacion_animal() {
		return clasificacion_animal;
	}

	public void setClasificacion_animal(String clasificacion_animal) {
		this.clasificacion_animal = clasificacion_animal;
	}

	public int getCan_patas() {
		return can_patas;
	}

	public void setCan_patas(int can_patas) {
		this.can_patas = can_patas;
	}

	public int getCan_ojo() {
		return can_ojo;
	}

	public void setCan_ojo(int can_ojo) {
		this.can_ojo = can_ojo;
	}

	public boolean isPelos() {
		return pelos;
	}

	public void setPelos(boolean pelos) {
		this.pelos = pelos;
	}

	public boolean isCola() {
		return cola;
	}

	public void setCola(boolean cola) {
		this.cola = cola;
	}
}
