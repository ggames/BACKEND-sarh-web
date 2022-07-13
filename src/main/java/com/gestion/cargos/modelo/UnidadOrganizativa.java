package com.gestion.cargos.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="UnidadOrganizativa", schema = "cargos")

public class UnidadOrganizativa {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    
		private String nombre;
		
		private int directorId;
		
		private int viceDirectorId;
		
	    @Temporal(TemporalType.TIMESTAMP) 	
		private Date createdAt;
		
	    @Temporal(TemporalType.TIMESTAMP)
		private Date updatedAt;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getDirectorId() {
			return directorId;
		}
		public void setDirectorId(int directorId) {
			this.directorId = directorId;
		}
		public int getViceDirectorId() {
			return viceDirectorId;
		}
		public void setViceDirectorId(int viceDirectorId) {
			this.viceDirectorId = viceDirectorId;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		
	}



