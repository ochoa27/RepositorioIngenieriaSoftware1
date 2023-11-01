package com.eternalnovices.cotasker.service.domain.listatareas;

import java.util.UUID;


import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;


public class ListaTareasDomain {
	
	private UUID idListaTareas;
	private String nombre;
	private String descripcion;
	private FechasDomain fecha;
	private PrioridadDomain prioridad;
	private ProyectoDomain proyecto;
	
	
	private ListaTareasDomain(final UUID idListaTareas, final String nombre, final String descripcion, final FechasDomain fecha,
			final PrioridadDomain prioridad, final ProyectoDomain proyecto) {
		setIdListaTareas(idListaTareas);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
		setPrioridad(prioridad);
		setProyecto(proyecto);
	}
	
	public static final ListaTareasDomain crear(final UUID idListaTareas, final String nombre, final String descripcion, final FechasDomain fecha,
			final PrioridadDomain prioridad, final ProyectoDomain proyecto) {
		return new ListaTareasDomain(idListaTareas, nombre, descripcion, fecha, prioridad, proyecto);
	}

	private final void setIdListaTareas(final UUID idListaTareas) {
		this.idListaTareas = idListaTareas;
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

	private final void setProyecto(final ProyectoDomain proyecto) {
		this.proyecto = proyecto;
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

	public final FechasDomain getFecha() {
		return fecha;
	}

	public final PrioridadDomain getPrioridad() {
		return prioridad;
	}

	public final ProyectoDomain getProyecto() {
		return proyecto;
	}
}
