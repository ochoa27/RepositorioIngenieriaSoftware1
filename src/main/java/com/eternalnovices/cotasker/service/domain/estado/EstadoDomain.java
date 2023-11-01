package com.eternalnovices.cotasker.service.domain.estado;

import java.util.UUID;

public class EstadoDomain {
	private UUID idEstado;
	private String descripcion;
	
	private EstadoDomain(final UUID idEstado, final String descripcion) {
		setIdEstado(idEstado);
		setDescripcion(descripcion);
	}
	
	public static final EstadoDomain crear(final UUID idEstado, final String descripcion) {
		return new EstadoDomain(idEstado, descripcion);
	}

	private final void setIdEstado(final UUID idEstado) {
		this.idEstado = idEstado;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public final UUID getIdEstado() {
		return idEstado;
	}

	public final String getDescripcion() {
		return descripcion;
	}
}
