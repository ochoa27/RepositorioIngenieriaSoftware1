package com.eternalnovices.cotasker.crosscutting.exception.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.enumerator.LugarException;

public class DataCoTaskerException extends CoTaskerException {

	private static final long serialVersionUID = -8567819838102794715L;

	protected DataCoTaskerException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.DATA, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario) {
		return new DataCoTaskerException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new DataCoTaskerException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new DataCoTaskerException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
}
