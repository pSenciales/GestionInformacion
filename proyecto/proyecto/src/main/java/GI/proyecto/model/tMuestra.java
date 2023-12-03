package GI.proyecto.model;

import java.util.Objects;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class tMuestra {
	@Id
	@GeneratedValue
	private Integer IDMuestra;
	@Nullable
	private String NIF_Paciente;
	@Nullable
	private String Cultivo;
	@ManyToOne
	private tSolucion Solucion;
	
	public tMuestra() {}

	public Integer getID() {
		return IDMuestra;
	}
	public void setID(Integer ID) {
		IDMuestra = ID;
	}
	public String getNIF_Paciente() {
		return NIF_Paciente;
	}
	public void setNIF_Paciente(String Nif_Paciente) {
		NIF_Paciente = Nif_Paciente;
	}
	public String getCultivo() {
		return Cultivo;
	}
	public void setCultivo(String cultivo) {
		Cultivo = cultivo;
	}
	public tSolucion getSolucion() { return Solucion; }
	public void setSolucion(tSolucion solucion) { Solucion = solucion; }

	@Override
	public int hashCode() {
		return Objects.hash(IDMuestra);
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
		return IDMuestra == other.IDMuestra;
	}

}
