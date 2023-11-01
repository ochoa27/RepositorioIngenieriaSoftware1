package com.eternalnovices.cotasker.service.domain.estado.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.estado.EstadoDomain;

public final class EstadoValidationRule implements ValidationRule<EstadoDomain> {
	private static final ValidationRule<EstadoDomain> instancia = new EstadoValidationRule();
	
	private EstadoValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final EstadoDomain data) {
		instancia.validar(data);
	}

	@Override
	public void validar(EstadoDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}
