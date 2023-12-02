package GI.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class tRol {
	@Id
	String rolName;
	String rolDes;
	boolean admin;
	
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
