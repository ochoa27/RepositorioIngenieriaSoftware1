package com.eternalnovices.cotasker.crosscutting.exception.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.enumerator.LugarException;

public class CrosscuttingCoTaskerException extends CoTaskerException {

	private static final long serialVersionUID = 7153707578131740661L;

	protected CrosscuttingCoTaskerException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.CROSSCUTTING, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario) {
		return new CrosscuttingCoTaskerException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new CrosscuttingCoTaskerException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new CrosscuttingCoTaskerException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
}
