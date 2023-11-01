package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class ListaTareasEntity {
	private UUID idListaTareas;
	private String nombre;
	private String descripcion;
	private FechasEntity fecha;
	private PrioridadEntity prioridad;
	private ProyectoEntity proyecto;
	
	private ListaTareasEntity(final UUID idListaTareas, final String nombre, final String descripcion, final FechasEntity fecha,
			final PrioridadEntity prioridad, final ProyectoEntity proyecto) {
		setIdListaTareas(idListaTareas);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
		setPrioridad(prioridad);
		setProyecto(proyecto);
	}
	
	public static final ListaTareasEntity crear(final UUID idListaTareas, final String nombre, final String descripcion, final FechasEntity fecha,
			final PrioridadEntity prioridad, final ProyectoEntity proyecto) {
		return new ListaTareasEntity(idListaTareas, nombre, descripcion, fecha, prioridad, proyecto);
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

	private final void setFecha(final FechasEntity fecha) {
		this.fecha = fecha;
	}

	private final void setPrioridad(final PrioridadEntity prioridad) {
		this.prioridad = prioridad;
	}

	private final void setProyecto(final ProyectoEntity proyecto) {
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

	public final FechasEntity getFecha() {
		return fecha;
	}

	public final PrioridadEntity getPrioridad() {
		return prioridad;
	}

	public final ProyectoEntity getProyecto() {
		return proyecto;
	}
}
