package com.gestion.empleados.dto;

public class RequestProjectsAssignmentDTO {
	
	private Long id;
    private Long idProjects;
    private Long idDepartment;
    private String description;
    private String status;

    public RequestProjectsAssignmentDTO() {
    }

    public RequestProjectsAssignmentDTO(Long id, Long idProjects, Long idDepartment, String description, String status) {
        this.id = id;
    	this.idProjects = idProjects;
        this.idDepartment = idDepartment;
        this.description = description;
        this.status = status;
    }

    // Getters y Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdProjects() {
        return idProjects;
    }

    public void setIdProjects(Long idProjects) {
        this.idProjects = idProjects;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
