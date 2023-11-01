	package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class ListaTareasDTO {
	private UUID idListaTareas;
	private String nombre;
	private String descripcion;
	private FechasDTO fecha;
	private PrioridadDTO prioridad;
	private ProyectoDTO proyecto;
	
	public ListaTareasDTO() {
		setIdListaTareas(UtilUUID.UUIDDEFECTO);
		setNombre(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setFecha(new FechasDTO());
		setPrioridad(new PrioridadDTO());
		setProyecto(new ProyectoDTO());
	}
	
	public ListaTareasDTO(final UUID idListaTareas, final String nombre, final String descripcion, final FechasDTO fecha,
			final PrioridadDTO prioridad, final ProyectoDTO proyecto) {
		setIdListaTareas(idListaTareas);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
		setPrioridad(prioridad);
		setProyecto(proyecto);
	}
	
	public static final ListaTareasDTO crear() {
		return new ListaTareasDTO();
	}

	public final UUID getIdListaTareas() {
		return idListaTareas;
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

	public final PrioridadDTO getPrioridad() {
		return prioridad;
	}

	public final ProyectoDTO getProyecto() {
		return proyecto;
	}

	public final ListaTareasDTO setIdListaTareas(final UUID idListaTareas) {
		this.idListaTareas = UtilUUID.obtenerValorDefecto(idListaTareas, UtilUUID.UUIDDEFECTO);
		return this;
	}

	public final ListaTareasDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.obtenerValorDefecto(nombre, UtilTexto.VACIO);
		return this;
	}

	public final ListaTareasDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.obtenerValorDefecto(descripcion, UtilTexto.VACIO);
		return this;
	}

	public final ListaTareasDTO setFecha(final FechasDTO fecha) {
		this.fecha = UtilObjeto.obtenerValorDefecto(fecha, new FechasDTO());
		return this;
	}

	public final ListaTareasDTO setPrioridad(final PrioridadDTO prioridad) {
		this.prioridad = UtilObjeto.obtenerValorDefecto(prioridad, new PrioridadDTO());
		return this;
	}

	public final ListaTareasDTO setProyecto(final ProyectoDTO proyecto) {
		this.proyecto = UtilObjeto.obtenerValorDefecto(proyecto, new ProyectoDTO());
		return this;
	}
}
