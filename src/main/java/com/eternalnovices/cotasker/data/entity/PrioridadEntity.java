package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;

public class PrioridadEntity {
	private UUID idPrioridad;
	private String descripcion;
	
	private PrioridadEntity(final UUID idPrioridad, final String descripcion) {
		setIdPrioridad(idPrioridad);
		setDescripcion(descripcion);
	}
	
	public static final PrioridadEntity crear(final UUID idPrioridad, final String descripcion) {
		return new PrioridadEntity(idPrioridad, descripcion);
	}
	
	private final void setIdPrioridad(final UUID idPrioridad) {
		this.idPrioridad = idPrioridad;
	}
	
	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public final UUID getIdPrioridad() {
		return idPrioridad;
	}

	public final String getDescripcion() {
		return descripcion;
	}
}
