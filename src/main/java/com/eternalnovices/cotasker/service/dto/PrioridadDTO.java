package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class PrioridadDTO {
	
	private UUID idPrioridad;
	private String descripcion;
	
	public PrioridadDTO() {
		setIdPrioridad(UtilUUID.UUIDDEFECTO);
		setDescripcion(UtilTexto.VACIO);
	}
	
	public PrioridadDTO(final UUID id, final String descripcion) {
		setIdPrioridad(id);
		setDescripcion(descripcion);
	}
	
	public static final PrioridadDTO crear() {
		return new PrioridadDTO();
	}
	
	public final UUID getIdPrioridad() {
		return idPrioridad;
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
	
	public final PrioridadDTO setIdPrioridad(final UUID id) {
		this.idPrioridad = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUIDDEFECTO));
		return this;
	}
	
	public final PrioridadDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.obtenerValorDefecto(descripcion,UtilTexto.VACIO);
		return this;
	}
}
