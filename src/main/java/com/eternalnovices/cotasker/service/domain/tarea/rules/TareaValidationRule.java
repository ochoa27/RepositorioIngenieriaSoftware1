package com.eternalnovices.cotasker.service.domain.tarea.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;

public final class TareaValidationRule implements ValidationRule<TareaDomain> {
	private static final ValidationRule<TareaDomain> instancia = new TareaValidationRule();
	
	private TareaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TareaDomain domain) {
		instancia.validar(domain);
	}
	
	@Override
	public void validar(TareaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000251);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}