package com.eternalnovices.cotasker.crosscutting.exception.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.enumerator.LugarException;

public class ControllerCoTaskerException extends CoTaskerException{

	private static final long serialVersionUID = -5136286767458120375L;

	protected ControllerCoTaskerException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.CONTROLLER, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario) {
		return new ControllerCoTaskerException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final CoTaskerException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerCoTaskerException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final CoTaskerException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerCoTaskerException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
}
