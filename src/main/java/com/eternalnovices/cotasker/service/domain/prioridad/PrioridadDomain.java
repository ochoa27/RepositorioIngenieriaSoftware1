package com.eternalnovices.cotasker.service.domain.prioridad;

import java.util.UUID;

public class PrioridadDomain {
	private UUID idPrioridad;
	private String descripcion;
	
	private PrioridadDomain(final UUID idPrioridad, final String descripcion) {
		setIdPrioridad(idPrioridad);
		setDescripcion(descripcion);
	}
	
	public static final PrioridadDomain crear(final UUID idPrioridad, final String descripcion) {
		return new PrioridadDomain(idPrioridad, descripcion);
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
