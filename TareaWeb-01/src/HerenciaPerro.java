
public class HerenciaPerro extends Animal {

	private String raza;
	private int canVacunas;
	private boolean pedigri;
	private String nombre;

	public HerenciaPerro(String clasificacion_animal, int can_patas, int can_ojo, boolean pelos, boolean cola,
			String raza, int canVacunas, boolean pedigri, String nombre) {
		super(clasificacion_animal, can_patas, can_ojo, pelos, cola);
		this.raza = raza;
		this.canVacunas = canVacunas;
		this.pedigri = pedigri;
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getCanVacunas() {
		return canVacunas;
	}

	public void setCanVacunas(int canVacunas) {
		this.canVacunas = canVacunas;
	}

	public boolean isPedigri() {
		return pedigri;
	}

	public void setPedigri(boolean pedigri) {
		this.pedigri = pedigri;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void mostrar_info() {
		System.out.println("El animal es : "+ getClasificacion_animal());
		System.out.println("Su nombre es : "+ getNombre());
		System.out.println("Tiene  : "+ getCan_patas()+" patas");
		System.out.println("Tiene  : "+ getCan_ojo()+ " ojo/ojos");
		if (isPelos()) {
		System.out.println("Tiene pelos ");
		}
		else {
		System.out.println("No Tiene pelos ");
		}
		if (isCola()) {
			System.out.println("Tiene cola ");
			}
			else {
			System.out.println("No tiene cola ");
		}
		System.out.println("Es de raza: "+ getRaza());
		System.out.println("Tiene  : "+ getCanVacunas()+" vacunas");
		if (isPedigri()) {
			System.out.println("Tiene pedigri ");
			}
			else {
			System.out.println("No tiene pedigri ");
		}

		
		
	}

}
