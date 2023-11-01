package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class ProyectoDTO {
	private UUID idProyecto;
	private String nombre;
	private String descripcion;
	private FechasDTO fecha;

	public ProyectoDTO() {
		setIdProyecto(UtilUUID.UUIDDEFECTO);
		setNombre(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setFecha(new FechasDTO());
	}

	
	public ProyectoDTO(final UUID idProyecto, final String nombre, final String descripcion, final FechasDTO fecha) {
		setIdProyecto(idProyecto);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
	}
	
	public static final ProyectoDTO crear() {
		return new ProyectoDTO();
	}

	public final UUID getIdProyecto() {
		return idProyecto;
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

	public final ProyectoDTO setIdProyecto(final UUID idProyecto) {
		this.idProyecto = UtilUUID.obtenerValorDefecto(idProyecto, UtilUUID.UUIDDEFECTO);
		return this;
	}

	public final ProyectoDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.obtenerValorDefecto(nombre, UtilTexto.VACIO);
		return this;
	}

	public final ProyectoDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.obtenerValorDefecto(descripcion, UtilTexto.VACIO);
		return this;
	}

	public final ProyectoDTO setFecha(final FechasDTO fecha) {
		this.fecha = UtilObjeto.obtenerValorDefecto(fecha, new FechasDTO());
		return this;
	}
}
