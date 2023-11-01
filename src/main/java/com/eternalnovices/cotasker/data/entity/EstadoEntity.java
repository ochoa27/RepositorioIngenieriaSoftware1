package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;

public class EstadoEntity {
	private UUID idEstado;
	private String descripcion;
	
	private EstadoEntity(final UUID idEstado, final String descripcion) {
		setIdEstado(idEstado);
		setDescripcion(descripcion);
	}
	
	public static final EstadoEntity crear(final UUID idEstado, final String descripcion) {
		return new EstadoEntity(idEstado, descripcion);
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
