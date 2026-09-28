/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Id;

/**
 *
 * @author Willi
 */
@Entity
public class Curso implements Serializable {

    @Id
    private String codigo;

    private String nombre;
    private int creditos;
    private int semestre;
    private int estudiantesAdmitidos;
    

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Curso() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getEstudiantesAdmitidos() {
        return estudiantesAdmitidos;
    }

    public void setEstudiantesAdmitidos(int estudiantesAdmitidos) {
        this.estudiantesAdmitidos = estudiantesAdmitidos;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}