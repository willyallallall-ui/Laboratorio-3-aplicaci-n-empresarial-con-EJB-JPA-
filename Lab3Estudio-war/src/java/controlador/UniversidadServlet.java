/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.CursoEJB;
import ejb.EstudianteEJB;
import entidades.Curso;
import entidades.Estudiante;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Willi
 */
@WebServlet(name = "UniversidadServlet", urlPatterns = {"/UniversidadServlet"})
public class UniversidadServlet extends HttpServlet {

    @EJB
    private EstudianteEJB estudianteEJB;

    @EJB
    private CursoEJB cursoEJB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("crearEstudiante".equals(action)) {
            Estudiante e = new Estudiante();
            e.setNombre(request.getParameter("nombre"));
            e.setApellido(request.getParameter("apellido"));
            e.setSemestre(Integer.parseInt(request.getParameter("semestre")));
            estudianteEJB.crear(e);

        } else if ("crearCurso".equals(action)) {
            Curso c = new Curso();
            c.setCodigo(request.getParameter("codigo"));
            c.setNombre(request.getParameter("nombreCurso"));
            c.setCreditos(Integer.parseInt(request.getParameter("creditos")));
            c.setSemestre(Integer.parseInt(request.getParameter("semestreCurso")));
            c.setEstudiantesAdmitidos(Integer.parseInt(request.getParameter("admitidos")));
            cursoEJB.crear(c);

        } else if ("matricular".equals(action)) {
            int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
            String codigoCurso = request.getParameter("codigoCurso");
            String error = cursoEJB.matricular(idEstudiante, codigoCurso);
            request.setAttribute("mensaje", error);
        }

        request.setAttribute("estudiantes", estudianteEJB.listar());
        request.setAttribute("cursos", cursoEJB.listar());
        request.getRequestDispatcher("universidad.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
