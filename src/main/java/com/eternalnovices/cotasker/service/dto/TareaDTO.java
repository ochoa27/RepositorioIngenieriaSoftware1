package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class TareaDTO {
	private UUID idTarea;
	private String nombre;
	private String descripcion;
	private FechasDTO fecha;
	private PrioridadDTO prioridad;
	private EstadoDTO estado;
	private ListaTareasDTO listaTareas;
	
	public TareaDTO() {
		setIdTarea(UtilUUID.UUIDDEFECTO);
		setNombre(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setFecha(new FechasDTO());
		setPrioridad(new PrioridadDTO());
		setEstado(new EstadoDTO());
		setListaTareas(new ListaTareasDTO());
	}
	
	public TareaDTO(final UUID idTarea, final String nombre, final String descripcion, final FechasDTO fecha, final PrioridadDTO prioridad,
			final EstadoDTO estado, final ListaTareasDTO listaTareas) {
		setIdTarea(idTarea);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
		setPrioridad(prioridad);
		setEstado(estado);
		setListaTareas(listaTareas);
	}
	
	public static final TareaDTO crear() {
		return new TareaDTO();
	}

	public final UUID getIdTarea() {
		return idTarea;
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

	public final EstadoDTO getEstado() {
		return estado;
	}

	public final ListaTareasDTO getListaTareas() {
		return listaTareas;
	}

	public final TareaDTO setIdTarea(final UUID idTarea) {
		this.idTarea = UtilUUID.obtenerValorDefecto(idTarea, UtilUUID.UUIDDEFECTO);
		return this;
	}

	public final TareaDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.obtenerValorDefecto(nombre, UtilTexto.VACIO);
		return this;
	}

	public final TareaDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.obtenerValorDefecto(descripcion, UtilTexto.VACIO);
		return this;
	}

	public final TareaDTO setFecha(final FechasDTO fecha) {
		this.fecha = UtilObjeto.obtenerValorDefecto(fecha, new FechasDTO());
		return this;
	}

	public final TareaDTO setPrioridad(final PrioridadDTO prioridad) {
		this.prioridad = UtilObjeto.obtenerValorDefecto(prioridad, new PrioridadDTO());
		return this;
	}

	public final TareaDTO setEstado(final EstadoDTO estado) {
		this.estado = UtilObjeto.obtenerValorDefecto(estado, new EstadoDTO());
		return this;
	}

	public final TareaDTO setListaTareas(final ListaTareasDTO listaTareas) {
		this.listaTareas = UtilObjeto.obtenerValorDefecto(listaTareas, new ListaTareasDTO());
		return this;
	}
	
	
	
	
}
