package GI.proyecto.model;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class tRol {
	@Id
	private String rolName;
	@Nullable
	private String rolDes;
	private boolean admin;
	@OneToMany (mappedBy = "nif")
	private List<tUsuario> usuario;
	@OneToMany (mappedBy ="pantalla")
	private List<tPermiso> permiso;
	
	
	public List<tUsuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<tUsuario> usuario) {
		this.usuario = usuario;
	}

	public tRol() {
	}
	
	public String getRolName() {
		return rolName;
	}
	public void setRolName(String rolName) {
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
