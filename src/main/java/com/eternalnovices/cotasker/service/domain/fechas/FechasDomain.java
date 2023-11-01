package com.eternalnovices.cotasker.service.domain.fechas;

import java.sql.Date;

public class FechasDomain {
	private Date fechaCreacion;
	private Date fechaEstimadaInicio;
	private Date fechaEstimadaFin;
	
	private FechasDomain(final Date fechaCreacion, final Date fechaEstimadaInicio, final Date fechaEstimadaFin) {
		setFechaCreacion(fechaCreacion);
		setFechaEstimadaInicio(fechaEstimadaInicio);
		setFechaEstimadaFin(fechaEstimadaFin);
	}
	
	public static final FechasDomain crear(final Date fechaCreacion, final Date fechaEstimadaInicio, final Date fechaEstimadaFin) {
		return new FechasDomain(fechaCreacion, fechaEstimadaInicio, fechaEstimadaFin);
	}

	private final void setFechaCreacion(final Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	private final void setFechaEstimadaInicio(final Date fechaEstimadaInicio) {
		this.fechaEstimadaInicio = fechaEstimadaInicio;
	}

	private final void setFechaEstimadaFin(final Date fechaEstimadaFin) {
		this.fechaEstimadaFin = fechaEstimadaFin;
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