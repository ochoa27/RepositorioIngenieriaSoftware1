package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuario;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.domain.usuario.rules.IdUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.UsuarioValidationRule;

public class EliminarUsuarioValidator implements Validator<UsuarioDomain> {
	private static final Validator<UsuarioDomain> instancia = new EliminarUsuarioValidator();
	
	private EliminarUsuarioValidator() {
		super();
	}
	
	public static final void ejecutar(final UsuarioDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(UsuarioDomain domain) {
		UsuarioValidationRule.ejecutarValidacion(domain);
		IdUsuarioValidationRule.ejecutarValidacion(domain.getIdUsuario());
	}
}
