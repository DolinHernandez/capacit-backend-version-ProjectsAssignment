package com.gestion.empleados.repositories;

import com.gestion.empleados.models.ProjectsAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsAssignmentRepositorio extends JpaRepository <ProjectsAssignment, Long> {

	//Encuentra todas las asignaciones de proyectos para un departamento específico//
    @Query(value = "SELECT * FROM Projects_Assignment WHERE ID_DEPARTMENT = :departmentId", nativeQuery = true)
    List<ProjectsAssignment> findByDepartmentId(@Param("departmentId") Long departmentId);

    //Encuentra todas las asignaciones de proyectos con un estado específico//
    @Query(value = "SELECT * FROM Projects_Assignment WHERE STATUS = :status", nativeQuery = true)
    List<ProjectsAssignment> findByStatus(@Param("status") String status);

    //Encuentra todas las asignaciones de proyectos que contienen una palabra clave en la descripción//
    @Query(value = "SELECT * FROM Projects_Assignment WHERE DESCRIPTION LIKE %:keyword%", nativeQuery = true)
    List<ProjectsAssignment> findByDescriptionContaining(@Param("keyword") String keyword);

    //Encuentra una asignación de proyecto específica por su ID de proyecto//
    @Query(value = "SELECT * FROM Projects_Assignment WHERE ID_PROJECTS = :projectId", nativeQuery = true)
    ProjectsAssignment findByProjectId(@Param("projectId") Long projectId);
    
    //Encuentra asignaciones de proyectos por nombre de proyecto (usando un JOIN con la tabla employee_projects)//
    @Query(value = "SELECT pa.* FROM projects_assignment pa " +
                   "INNER JOIN employee_projects ep ON pa.id_projects = ep.id_projects " +
                   "WHERE ep.nombre_proyecto LIKE CONCAT('%', :nombreProyecto, '%')", nativeQuery = true)
    List<ProjectsAssignment> findByProjectName(@Param("nombreProyecto") String nombreProyecto);
    
}