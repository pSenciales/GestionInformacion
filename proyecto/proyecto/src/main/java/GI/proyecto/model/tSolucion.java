package GI.proyecto.model;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

@Entity
public class tSolucion {
    @Id
    @GeneratedValue
    private Integer IDSolucion;
	@Nullable
    private String Solucion;
	@Nullable
    private String Uso;
    @OneToMany (mappedBy = "Solucion")
    private List<tMuestra> Muestras;
    
    public tSolucion() {
    }
    public int getId() {
        return IDSolucion;
    }
    public void setId(int id) {
        this.IDSolucion = id;
    }
    public String getSolucion() {
        return Solucion;
    }
    public void setSolucion(String solucion) {
        Solucion = solucion;
    }
    public String getUso() {
        return Uso;
    }
    public void setUso(String uso) {
        Uso = uso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof tSolucion tSolucion)) return false;
        return IDSolucion == tSolucion.IDSolucion && Objects.equals(Solucion, tSolucion.Solucion) && Objects.equals(Uso, tSolucion.Uso);
    }

    @Override
    public int hashCode() {
        return IDSolucion*Solucion.hashCode()*Uso.hashCode();
    }
}
