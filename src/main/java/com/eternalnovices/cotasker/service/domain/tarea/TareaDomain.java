package com.eternalnovices.cotasker.service.domain.tarea;

import java.util.UUID;

import com.eternalnovices.cotasker.service.domain.estado.EstadoDomain;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;

public class TareaDomain {
	
	private UUID idTarea;
	private String nombre;
	private String descripcion;
	private FechasDomain fecha;
	private PrioridadDomain prioridad;
	private EstadoDomain estado;
	private ListaTareasDomain listaTareas;
	
	private TareaDomain(final UUID idTarea, final String nombre, final String descripcion, final FechasDomain fecha, final PrioridadDomain prioridad,
			final EstadoDomain estado, final ListaTareasDomain listaTareas) {
		setIdTarea(idTarea);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
		setPrioridad(prioridad);
		setEstado(estado);
		setListaTareas(listaTareas);
	}
	
	public static final TareaDomain crear(final UUID idTarea, final String nombre, final String descripcion, final FechasDomain fecha, final PrioridadDomain prioridad,
			final EstadoDomain estado, final ListaTareasDomain listaTareas) {
		return new TareaDomain(idTarea, nombre, descripcion, fecha, prioridad, estado, listaTareas);
	}

	private final void setIdTarea(final UUID idTarea) {
		this.idTarea = idTarea;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	private final void setFecha(final FechasDomain fecha) {
		this.fecha = fecha;
	}

	private final void setPrioridad(final PrioridadDomain prioridad) {
		this.prioridad = prioridad;
	}

	private final void setEstado(final EstadoDomain estado) {
		this.estado = estado;
	}

	private final void setListaTareas(ListaTareasDomain listaTareas) {
		this.listaTareas = listaTareas;
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

	public final FechasDomain getFecha() {
		return fecha;
	}

	public final PrioridadDomain getPrioridad() {
		return prioridad;
	}

	public final EstadoDomain getEstado() {
		return estado;
	}

	public final ListaTareasDomain getListaTareas() {
		return listaTareas;
	}
}
