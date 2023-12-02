package GI.proyecto.model;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class tRol {
	@Id
	Roles rolName;
	@Nullable
	String rolDes;
	boolean admin;
	@OneToMany (mappedBy = "nif")
	List<tUsuario> usuario;
	@OneToMany (mappedBy ="pantalla")
	List<tPermiso> permiso;
	
	
	public List<tUsuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<tUsuario> usuario) {
		this.usuario = usuario;
	}

	public tRol() {
		
	}
	
	public Roles getRolName() {
		return rolName;
	}
		
	public void setRolName(Roles rolName) {
		this.rolName = rolName;
	}
	public String getRolDes() {
		return rolDes;
	}
	public void setRolDes(String rolDes) {
		this.rolDes = rolDes;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
	
}
