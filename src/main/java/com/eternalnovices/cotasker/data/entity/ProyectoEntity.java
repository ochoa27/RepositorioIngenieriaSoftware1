package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class ProyectoEntity {
	private UUID idProyecto;
	private String nombre;
	private String descripcion;
	private FechasEntity fecha;
	
	private ProyectoEntity(final UUID idProyecto, final String nombre, final String descripcion, final FechasEntity fechas) {
		setIdProyecto(idProyecto);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFechas(fechas);
	}
	
	public static final ProyectoEntity crear(final UUID idProyecto, final String nombre, final String descripcion, final FechasEntity fechas) {
		return new ProyectoEntity(idProyecto, nombre, descripcion, fechas);
	}

	private final void setIdProyecto(final UUID idProyecto) {
		this.idProyecto = idProyecto;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	private final void setFechas(final FechasEntity fechas) {
		this.fecha = fechas;
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

	public final FechasEntity getFechas() {
		return fecha;
	}
}
