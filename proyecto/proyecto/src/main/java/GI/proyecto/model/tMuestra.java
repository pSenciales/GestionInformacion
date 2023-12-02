package GI.proyecto.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class tMuestra {
	@Id
	int ID;
	String NIF_PACIENTE;
	String Cultivo;
	@ManyToOne
	tSolucion Solucion;
	
	public tMuestra() {
			
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	public String getNIF_PACIENTE() {
		return NIF_PACIENTE;
	}
	public void setNIF_PACIENTE(String nIF_PACIENTE) {
		NIF_PACIENTE = nIF_PACIENTE;
	}
	public String getCultivo() {
		return Cultivo;
	}
	public void setCultivo(String cultivo) {
		Cultivo = cultivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tMuestra other = (tMuestra) obj;
		return ID == other.ID;
	}
	
	

}
