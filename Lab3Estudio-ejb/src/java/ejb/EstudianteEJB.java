/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
public class EstudianteEJB {

    @PersistenceContext
    private EntityManager em;

    public void crear(Estudiante estudiante) {
        em.persist(estudiante);
    }

    public List<Estudiante> listar() {
        return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
    }
}