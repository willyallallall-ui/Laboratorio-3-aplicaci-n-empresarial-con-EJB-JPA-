/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Curso;
import entidades.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Willi
 */
@Stateless
public class CursoEJB {

    @PersistenceContext
    private EntityManager em;

    public void crear(Curso curso) {
        em.persist(curso);
    }

    public List<Curso> listar() {
        return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
    }

    public String matricular(int idEstudiante, String codigoCurso) {
        Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
        Curso curso = em.find(Curso.class, codigoCurso);

        if (estudiante == null || curso == null) {
            return "Estudiante o curso no encontrado";
        }
        if (estudiante.getCursos().contains(curso)) {
            return "El estudiante ya esta matriculado en ese curso";
        }
        if (curso.getEstudiantes().size() >= curso.getEstudiantesAdmitidos()) {
            return "El curso esta lleno";
        }

        estudiante.getCursos().add(curso);
        curso.getEstudiantes().add(estudiante);
        return null;
    }
}