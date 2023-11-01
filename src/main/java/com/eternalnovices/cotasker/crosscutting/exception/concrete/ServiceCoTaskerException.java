package com.eternalnovices.cotasker.crosscutting.exception.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.enumerator.LugarException;

public class ServiceCoTaskerException extends CoTaskerException {

	private static final long serialVersionUID = -5918537228378280576L;

	protected ServiceCoTaskerException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.SERVICE, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario) {
		return new ServiceCoTaskerException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceCoTaskerException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceCoTaskerException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
}
