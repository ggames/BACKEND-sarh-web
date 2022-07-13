package com.gestion.cargos.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Movimiento",schema = "cargos")
public class Movimiento {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date fechaMovimiento;
	
	private int motivoMovimiento;
	
	@ManyToOne
	@JoinColumn(name="planta_id")
	private Planta plantaId;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargoId;
	
	private Date createdAt;
	
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public int getMotivoMovimiento() {
		return motivoMovimiento;
	}

	public void setMotivoMovimiento(int motivoMovimiento) {
		this.motivoMovimiento = motivoMovimiento;
	}

	public Planta getPlantaId() {
		return plantaId;
	}

	public void setPlantaId(Planta plantaId) {
		this.plantaId = plantaId;
	}

	public Cargo getCargoId() {
		return cargoId;
	}

	public void setCargoId(Cargo cargoId) {
		this.cargoId = cargoId;
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
