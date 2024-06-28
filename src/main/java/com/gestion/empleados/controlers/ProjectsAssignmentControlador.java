package com.gestion.empleados.controlers;

import com.gestion.empleados.dto.RequestProjectsAssignmentDTO;
import com.gestion.empleados.dto.ResponseProjectsAssignmentDTO;
import com.gestion.empleados.models.ProjectsAssignment;
import com.gestion.empleados.services.ProjectsAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/ProjectsAssignments")
public class ProjectsAssignmentControlador {

    @Autowired
    private ProjectsAssignmentService projectsAssignmentService;

    // Endpoint para obtener todas las asignaciones de proyectos
    @GetMapping
    public ResponseEntity<List<ResponseProjectsAssignmentDTO>> getAllProjectAssignments() {
        List<ProjectsAssignment> projectsAssignments = projectsAssignmentService.getProjectsAssignments();
        List<ResponseProjectsAssignmentDTO> responseDTOs = projectsAssignments.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    // Endpoint para obtener una asignación de proyecto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseProjectsAssignmentDTO> getProjectAssignmentById(@PathVariable Long id) {
        ProjectsAssignment projectsAssignment = projectsAssignmentService.getProjectsAssignmentById(id)
                .orElse(null); // Puedes manejar aquí la lógica para devolver 404 si no se encuentra
        if (projectsAssignment != null) {
            return ResponseEntity.ok(convertToResponseDTO(projectsAssignment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para crear una nueva asignación de proyecto
    @PostMapping
    public ResponseEntity<ResponseProjectsAssignmentDTO> addProjectAssignment(@RequestBody RequestProjectsAssignmentDTO requestDTO) {
        ProjectsAssignment newProjectsAssignment = convertToEntity(requestDTO);
        ProjectsAssignment savedProjectsAssignment = projectsAssignmentService.saveProjectsAssignment(newProjectsAssignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToResponseDTO(savedProjectsAssignment));
    }

    // Endpoint para actualizar una asignación de proyecto existente
    @PutMapping("/{id}")
    public ResponseEntity<ResponseProjectsAssignmentDTO> updateProjectAssignment(@PathVariable Long id,
                                                                                 @RequestBody RequestProjectsAssignmentDTO requestDTO) {
        ProjectsAssignment existingProjectsAssignment = projectsAssignmentService.getProjectsAssignmentById(id)
                .orElse(null); // Puedes manejar aquí la lógica para devolver 404 si no se encuentra
        if (existingProjectsAssignment != null) {
            ProjectsAssignment updatedProjectsAssignment = updateEntityFromRequest(existingProjectsAssignment, requestDTO);
            ProjectsAssignment savedProjectsAssignment = projectsAssignmentService.saveProjectsAssignment(updatedProjectsAssignment);
            return ResponseEntity.ok(convertToResponseDTO(savedProjectsAssignment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar una asignación de proyecto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectAssignmentById(@PathVariable Long id) {
        projectsAssignmentService.deleteProjectsAssignmentById(id);
        return ResponseEntity.noContent().build();
    }

    // Método auxiliar para convertir de entidad a DTO de respuesta
    private ResponseProjectsAssignmentDTO convertToResponseDTO(ProjectsAssignment projectsAssignment) {
        return new ResponseProjectsAssignmentDTO(
                projectsAssignment.getId(),
                projectsAssignment.getIdProjects(),
                projectsAssignment.getIdDepartment(),
                projectsAssignment.getDescription(),
                projectsAssignment.getStatus()
        );
    }

    // Método auxiliar para convertir de DTO de solicitud a entidad
    private ProjectsAssignment convertToEntity(RequestProjectsAssignmentDTO requestDTO) {
        return new ProjectsAssignment(
                null, // El ID se generará automáticamente por la base de datos
                requestDTO.getIdProjects(),
                requestDTO.getIdDepartment(),
                requestDTO.getDescription(),
                requestDTO.getStatus()
        );
    }

    // Método auxiliar para actualizar entidad desde DTO de solicitud
    private ProjectsAssignment updateEntityFromRequest(ProjectsAssignment projectsAssignment, RequestProjectsAssignmentDTO requestDTO) {
        projectsAssignment.setIdProjects(requestDTO.getIdProjects());
        projectsAssignment.setIdDepartment(requestDTO.getIdDepartment());
        projectsAssignment.setDescription(requestDTO.getDescription());
        projectsAssignment.setStatus(requestDTO.getStatus());
        // No se actualiza el ID ya que es una operación PUT
        return projectsAssignment;
    }
}
