package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuario;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.domain.usuario.rules.ApellidoUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.ContrasenaUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.CorreoElectronicoUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.NombreUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.UsuarioValidationRule;

public class RegistrarUsuarioValidator implements Validator<UsuarioDomain>{
	private static final Validator<UsuarioDomain> instancia  = new RegistrarUsuarioValidator();
	
	private RegistrarUsuarioValidator() {
		super();
	}
	
	public static final void ejecutar(final UsuarioDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(UsuarioDomain domain) {
		UsuarioValidationRule.ejecutarValidacion(domain);
		NombreUsuarioValidationRule.ejecutarValidacion(domain.getNombre());
		ApellidoUsuarioValidationRule.ejecutarValidacion(domain.getApellido());
		CorreoElectronicoUsuarioValidationRule.ejecutarValidacion(domain.getCorreoElectronico());
		ContrasenaUsuarioValidationRule.ejecutarValidacion(domain.getContrasena());	
	}
}
