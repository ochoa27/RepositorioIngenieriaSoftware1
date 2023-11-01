package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class EstadoDTO {
	private UUID idEstado;
	private String descripcion;
	
	public EstadoDTO() {
		setIdEstado(UtilUUID.UUIDDEFECTO);
		setDescripcion(UtilTexto.VACIO);
	}
	
	public EstadoDTO(final UUID id, final String descripcion) {
		setIdEstado(id);
		setDescripcion(descripcion);
	}
	
	public static final EstadoDTO crear() {
		return new EstadoDTO();
	}
	
	public final EstadoDTO setIdEstado(final UUID id) {
		this.idEstado = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUIDDEFECTO));
		return  this;
	}
	
	public final EstadoDTO  setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.obtenerValorDefecto(descripcion,UtilTexto.VACIO);
		return this;
	}
	
	public final UUID getIdEstado() {
		return idEstado;
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
}
