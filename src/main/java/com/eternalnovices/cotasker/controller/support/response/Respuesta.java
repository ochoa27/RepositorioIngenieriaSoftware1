package com.eternalnovices.cotasker.controller.support.response;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;

public final class Respuesta<T> {
	private List<T> datos;
	private List<String> mensajes;
	
	public Respuesta() {
		super();
		setDatos(new ArrayList<>());
		setMensajes(new ArrayList<>());
	}
	
	public Respuesta(final List<T> datos, final List<String> mensajes) {
		super();
		setDatos(datos);
		setMensajes(mensajes);
	}

	public final List<T> getDatos() {
		return datos;
	}
	
	public final List<String> getMensajes() {
		return mensajes;
	}

	public final void setDatos(final List<T> datos) {
		this.datos = UtilObjeto.obtenerValorDefecto(datos, new ArrayList<>());
	}

	public final void setMensajes(final List<String> mensajes) {
		this.mensajes = UtilObjeto.obtenerValorDefecto(mensajes, new ArrayList<>());
	}
}