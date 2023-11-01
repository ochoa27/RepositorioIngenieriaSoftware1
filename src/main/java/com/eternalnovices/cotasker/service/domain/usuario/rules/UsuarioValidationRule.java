package com.eternalnovices.cotasker.service.domain.usuario.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;

public class UsuarioValidationRule implements ValidationRule<UsuarioDomain>{
	private static final ValidationRule<UsuarioDomain> instancia = new UsuarioValidationRule();
	
	private UsuarioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UsuarioDomain data) {
		instancia.validar(data);
	}
	
	@Override
	public void validar(UsuarioDomain data) {
		if(UtilObjeto.esNulo(data)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000260);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}

