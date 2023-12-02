package GI.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class tPermiso {
    @Id
    String pantalla;
    @ManyToOne
    tRol rolName;
    Boolean acceso;
    Boolean insertar;
    Boolean modificar;
    Boolean borrar;

    public tPermiso(){

    }
    
    public tPermiso(tRol rolName) {
    	this.rolName = rolName;
    	String rol = rolName.getRolName().name();
    	this.acceso = true;
    	this.insertar = false;
		this.modificar = false;
		this.borrar = false;
    	if(rol != "Invitado") {
    		this.modificar = true;
    		if(rol == "Administrador") {
    			this.insertar = true;
    			this.borrar = true;
    		}
    	}
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public tRol getRolName() {
        return rolName;
    }

    public void setRolName(tRol rolName) {
        this.rolName = rolName;
    }

    public Boolean getAcceso() {
        return acceso;
    }

    public void setAcceso(Boolean acceso) {
        this.acceso = acceso;
    }

    public Boolean getInsertar() {
        return insertar;
    }

    public void setInsertar(Boolean insertar) {
        this.insertar = insertar;
    }

    public Boolean getModificar() {
        return modificar;
    }

    public void setModificar(Boolean modificar) {
        this.modificar = modificar;
    }

    public Boolean getBorrar() {
        return borrar;
    }

    public void setBorrar(Boolean borrar) {
        this.borrar = borrar;
    }
}
