package com.gestion.empleados.dto;

public class ResponseProjectsAssignmentDTO {

	        private Long id;
	        private Long idProjects;
	        private Long idDepartment;
	        private String description;
	        private String status;

	        // Constructor vacío
	        public ResponseProjectsAssignmentDTO() {
	        	
	        }

	        // Constructor con todos los campos
	        public ResponseProjectsAssignmentDTO(Long id, Long idProjects, Long idDepartment, String description, String status) {
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
