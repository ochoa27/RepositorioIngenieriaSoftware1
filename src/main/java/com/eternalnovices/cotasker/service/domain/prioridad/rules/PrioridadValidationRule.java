package com.eternalnovices.cotasker.service.domain.prioridad.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;

public final class PrioridadValidationRule implements ValidationRule<PrioridadDomain> {
	private static final ValidationRule<PrioridadDomain> instancia = new PrioridadValidationRule();
	
	private PrioridadValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final PrioridadDomain data) {
		instancia.validar(data);
	}

	@Override
	public void validar(PrioridadDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}
