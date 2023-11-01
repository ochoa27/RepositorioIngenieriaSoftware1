package com.eternalnovices.cotasker.controller.support.request;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.dto.FechasDTO;

public class SolicitarProyecto {
	private UUID idProyecto;
	private UUID idUsuario;
	private String nombre;
	private String descripcion;
	private FechasDTO fecha;
	
	public SolicitarProyecto() {
		setIdProyecto(UtilUUID.UUIDDEFECTO);
		setIdUsuario(UtilUUID.UUIDDEFECTO);
		setNombre(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setFecha(FechasDTO.crear());
	}
	
	public SolicitarProyecto(final UUID idProyecto, final UUID idUsuario, final String nombre, final String descripcion, final FechasDTO fecha) {
		setIdProyecto(idProyecto);
		setIdUsuario(idUsuario);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
	}

	public final UUID getIdProyecto() {
		return idProyecto;
	}
	
	public final UUID getIdUsuario() {
		return idUsuario;
	}
	
	public final String getNombre() {
		return nombre;
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
	
	public final FechasDTO getFecha() {
		return fecha;
	}

	public final void setIdProyecto(final UUID idProyecto) {
		this.idProyecto = idProyecto;
	}

	public final void setIdUsuario(final UUID idUsuario) {
		this.idUsuario = idUsuario;
	}

	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public final void setFecha(final FechasDTO fecha) {
		this.fecha = fecha;
	}
}
