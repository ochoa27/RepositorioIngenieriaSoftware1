package com.eternalnovices.cotasker.service.domain.proyecto;

import java.util.UUID;

import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;



public class ProyectoDomain {
	
	private UUID idProyecto;
	private String nombre;
	private String descripcion;
	private FechasDomain fecha;
	
	private ProyectoDomain(final UUID idProyecto,final String nombre,final String descripcion,final FechasDomain fecha) {
		
		setIdProyecto(idProyecto);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
	}
	
	public  static final ProyectoDomain crear(final UUID idProyecto,final String nombre,final String descripcion,final FechasDomain fecha) {
		return new ProyectoDomain(idProyecto, nombre, descripcion, fecha);
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
	public final FechasDomain getFecha() {
		return fecha;
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
	private final void setFecha(final FechasDomain fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
	
	
	
}
