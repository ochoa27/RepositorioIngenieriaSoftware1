package com.eternalnovices.cotasker.service.domain.usuarioproyecto.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;

public class UsuarioProyectoValidationRule implements ValidationRule<UsuarioProyectoDomain> {
	private static final ValidationRule<UsuarioProyectoDomain> instancia = new UsuarioProyectoValidationRule();
	
	private UsuarioProyectoValidationRule() {
		super();
	}
	@Override
	public void validar(UsuarioProyectoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000262);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	
	public static final void ejecutarValidacion(final UsuarioProyectoDomain data) {
		instancia.validar(data);
	}
	
	
	

}
