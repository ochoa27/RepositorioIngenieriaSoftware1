package com.eternalnovices.cotasker.service.domain.fechas.rules;

import java.sql.Date;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilFecha;
import com.eternalnovices.cotasker.service.domain.ValidationRule;

public class FechaCreacionFechasValidationRule implements ValidationRule<Date> {

	private static final ValidationRule<Date> instancia = new FechaCreacionFechasValidationRule();
	
	private FechaCreacionFechasValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Date dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(Date dato) {
		validarObligatoriedad(dato);
	}
	
	private final void validarObligatoriedad(final Date dato) {
		if(UtilFecha.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000092);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}
