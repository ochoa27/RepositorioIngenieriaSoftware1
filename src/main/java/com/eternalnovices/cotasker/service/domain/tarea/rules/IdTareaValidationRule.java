package com.eternalnovices.cotasker.service.domain.tarea.rules;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.domain.ValidationRule;


public class IdTareaValidationRule implements ValidationRule<UUID> {
	private static final ValidationRule<UUID> instancia = new IdTareaValidationRule();
	
	private IdTareaValidationRule () {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}
	
	
	@Override
	public void validar(UUID dato) {
		validarObligatoriedad(dato);
		
	}

	private final  void validarObligatoriedad(final UUID dato) {
		if(UtilUUID.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000236);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}	
	}
}
