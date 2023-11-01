package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuario;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.tarea.rules.IdTareaValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.domain.usuario.rules.ApellidoUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.ContrasenaUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.CorreoElectronicoUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.NombreUsuarioValidationRule;

public class ConsultarUsuarioValidator implements Validator<UsuarioDomain>{
	private static final Validator<UsuarioDomain> instancia = new ConsultarUsuarioValidator();
	
	private ConsultarUsuarioValidator() {
		super();
	}
	
	public static final void ejecutar(final UsuarioDomain domain) {
		instancia.execute(domain);
	}

	
	
	@Override
	public void execute(UsuarioDomain domain) {
		if(!UtilObjeto.esNulo(domain)) {
			if(!UtilUUID.esNulo(domain.getIdUsuario())) {				
				IdTareaValidationRule.ejecutarValidacion(domain.getIdUsuario());
			}
			if(!UtilTexto.estaVacio(domain.getNombre())) {
				NombreUsuarioValidationRule.ejecutarValidacion(domain.getNombre());
			}
			if(!UtilTexto.estaVacio(domain.getApellido())) {
				ApellidoUsuarioValidationRule.ejecutarValidacion(domain.getApellido());
			}
			if(!UtilTexto.estaVacio(domain.getCorreoElectronico())) {
				CorreoElectronicoUsuarioValidationRule.ejecutarValidacion(domain.getCorreoElectronico());
			}
			if(!UtilTexto.estaVacio(domain.getContrasena())) {
				ContrasenaUsuarioValidationRule.ejecutarValidacion(domain.getContrasena());
			}
		}
	}
	
}
