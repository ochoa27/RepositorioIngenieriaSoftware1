package com.eternalnovices.cotasker.service.domain.listatareas.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;

public class NombreListaTareasValitadionRule implements ValidationRule<String> {
	private static final ValidationRule<String> instancia = new NombreListaTareasValitadionRule();
	
	private NombreListaTareasValitadionRule() {
		super();
	}
	
	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	
	private void validarFormato(String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000230);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}



	private void validarObligatoriedad(String dato) {
		if(UtilTexto.estaVacio(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000231);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}



	private void validarLongitud(String dato) {
		if(!UtilTexto.longitudMaximaValida(dato, 30)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000232);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}
