package GI.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class tUsuario {
	
	@Id
	String nif;
	String password;
	@ManyToOne 
	tRol rolName;
	public tUsuario() {
		
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public tRol getRolName() {
		return rolName;
	}

	public void setRolName(tRol rolName) {
		this.rolName = rolName;
	}
}
