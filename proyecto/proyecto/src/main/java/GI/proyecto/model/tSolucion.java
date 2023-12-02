package GI.proyecto.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Objects;

@Entity
public class tSolucion {
    @Id
    @OneToMany
    int id;
    String Solucion;
    String Uso;
    public tSolucion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == tSolucion.id && Objects.equals(Solucion, tSolucion.Solucion) && Objects.equals(Uso, tSolucion.Uso);
    }

    @Override
    public int hashCode() {
        return id*Solucion.hashCode()*Uso.hashCode();
    }
}
