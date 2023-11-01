package com.eternalnovices.cotasker.service.domain.proyecto.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;

public class DescripcionProyectoValitationRule implements ValidationRule<String>{
private static final ValidationRule<String> instancia = new DescripcionProyectoValitationRule();
	
	private  DescripcionProyectoValitationRule() {
		super();
	}
	
	@Override
	public void validar(final String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	public static final void ejecutarValidacion(final  String dato) {
		instancia.validar(dato);
	}

	
	private void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000159);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}



	private void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000160);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}



	private void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato, 60)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000161);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}

}
