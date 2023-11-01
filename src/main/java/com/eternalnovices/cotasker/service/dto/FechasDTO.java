package com.eternalnovices.cotasker.service.dto;

import java.sql.Date;

import com.eternalnovices.cotasker.crosscutting.util.UtilFecha;

public class FechasDTO {
	private Date fechaCreacion;
	private Date fechaEstimadaInicio;
	private Date fechaEstimadaFin;
	
	public FechasDTO() {
		setFechaCreacion(UtilFecha.FECHADEFECTO);
		setFechaEstimadaInicio(UtilFecha.FECHADEFECTO);
		setFechaEstimadaFin(UtilFecha.FECHADEFECTO);
	}
	
	public FechasDTO(final Date fechaCreacion, final Date fechaEstimadaInicio, final Date fechaEstimadaFin) {
		setFechaCreacion(fechaCreacion);
		setFechaEstimadaInicio(fechaEstimadaInicio);
		setFechaEstimadaFin(fechaEstimadaFin);
	}
	
	public static final FechasDTO crear() {
		return new FechasDTO();
	}

	public final FechasDTO setFechaCreacion(final Date fechaCreacion) {
		this.fechaCreacion = UtilFecha.obtenerValorDefecto(fechaCreacion, UtilFecha.FECHADEFECTO);
		return this;
	}

	public final FechasDTO setFechaEstimadaInicio(final Date fechaEstimadaInicio) {
		this.fechaEstimadaInicio = UtilFecha.obtenerValorDefecto(fechaEstimadaInicio, UtilFecha.FECHADEFECTO);
		return this;
	}

	public final FechasDTO setFechaEstimadaFin(final Date fechaEstimadaFin) {
		this.fechaEstimadaFin = UtilFecha.obtenerValorDefecto(fechaEstimadaFin, UtilFecha.FECHADEFECTO);
		return this;
	}

	public final Date getFechaCreacion() {
		return fechaCreacion;
	}

	public final Date getFechaEstimadaInicio() {
		return fechaEstimadaInicio;
	}

	public final Date getFechaEstimadaFin() {
		return fechaEstimadaFin;
	}
	
	
}
