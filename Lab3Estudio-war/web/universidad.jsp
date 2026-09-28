<%-- 
    Document   : universidad
    Created on : 28/09/2026, 02:36:37 PM
    Author     : Willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Universidad</title>
    </head>
    <body>
        <h1>Estudiantes</h1>
        <form action="UniversidadServlet" method="POST">
            <input type="hidden" name="action" value="crearEstudiante" />
            Nombre: <input type="text" name="nombre" />
            Apellido: <input type="text" name="apellido" />
            Semestre: <input type="text" name="semestre" />
            <input type="submit" value="Crear estudiante" />
        </form>

        <table border="1">
            <tr>
                <th>ID</th><th>Nombre</th><th>Apellido</th><th>Semestre</th><th>Cursos</th>
            </tr>
            <c:forEach items="${estudiantes}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.nombre}</td>
                    <td>${e.apellido}</td>
                    <td>${e.semestre}</td>
                    <td>
                        <c:forEach items="${e.cursos}" var="c">
                            ${c.nombre}<br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h1>Cursos</h1>
        <form action="UniversidadServlet" method="POST">
            <input type="hidden" name="action" value="crearCurso" />
            Codigo: <input type="text" name="codigo" />
            Nombre: <input type="text" name="nombreCurso" />
            Creditos: <input type="text" name="creditos" />
            Semestre: <input type="text" name="semestreCurso" />
            Admitidos: <input type="text" name="admitidos" />
            <input type="submit" value="Crear curso" />
        </form>

        <table border="1">
            <tr>
                <th>Codigo</th><th>Nombre</th><th>Creditos</th><th>Semestre</th><th>Admitidos</th>
            </tr>
            <c:forEach items="${cursos}" var="c">
                <tr>
                    <td>${c.codigo}</td>
                    <td>${c.nombre}</td>
                    <td>${c.creditos}</td>
                    <td>${c.semestre}</td>
                    <td>${c.estudiantesAdmitidos}</td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${not empty mensaje}">
            <p style="color:red;">${mensaje}</p>
        </c:if>
        <h1>Matricular</h1>
        <form action="UniversidadServlet" method="POST">
            <input type="hidden" name="action" value="matricular" />
            Estudiante:
            <select name="idEstudiante">
                <c:forEach items="${estudiantes}" var="e">
                    <option value="${e.id}">${e.id} - ${e.nombre}</option>
                </c:forEach>
            </select>
            Curso:
            <select name="codigoCurso">
                <c:forEach items="${cursos}" var="c">
                    <option value="${c.codigo}">${c.codigo} - ${c.nombre}</option>
                </c:forEach>
            </select>
            
            <input type="submit" value="Matricular" />
        </form>
    </body>
</html>