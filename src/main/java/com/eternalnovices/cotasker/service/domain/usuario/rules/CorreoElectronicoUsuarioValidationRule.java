package com.eternalnovices.cotasker.service.domain.usuario.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;

public class CorreoElectronicoUsuarioValidationRule implements ValidationRule<String> {
	private static final ValidationRule<String> instancia = new CorreoElectronicoUsuarioValidationRule();
	
	private   CorreoElectronicoUsuarioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(final String dato) {
		validarObligatoriedad(dato);
		validarLongitud(dato);
		validarFormato(dato);
		
	}

	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneFormatoCorreo(dato) ) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000214);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}

	private final  void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000213);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudValida(dato,1, 100)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000212);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}
