package Model;

import java.io.Serializable;

public class EspecialidadBean implements Serializable{
	private int codigo;
	private String nom_Rol;
	private String descr_Rol;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNom_Rol() {
		return nom_Rol;
	}
	public void setNom_Rol(String nom_Rol) {
		this.nom_Rol = nom_Rol;
	}
	public String getDescr_Rol() {
		return descr_Rol;
	}
	public void setDescr_Rol(String descr_Rol) {
		this.descr_Rol = descr_Rol;
	}

}
