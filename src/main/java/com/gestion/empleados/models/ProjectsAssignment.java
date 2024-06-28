package com.gestion.empleados.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "projects_assignment")
public class ProjectsAssignment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_PROJECTS", nullable = false, length =30)
    private Long idProjects;

    @Column(name = "ID_DEPARTMENT", nullable = false, length =30)
    private Long idDepartment;

    @Column(name = "DESCRIPTION", nullable = false, length = 255)
    private String description;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    public ProjectsAssignment() {
    }

    public ProjectsAssignment(Long id, Long idProjects, Long idDepartment, String description, String status) {
        this.id = id;
        this.idProjects = idProjects;
        this.idDepartment = idDepartment;
        this.description = description;
        this.status = status;
    }

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