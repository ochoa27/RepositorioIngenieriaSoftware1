package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuarioproyecto;


import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.IdProyectoValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.IdUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.rules.UsuarioProyectoValidationRule;

public class RegistarUsuarioProyectoValidator implements Validator<UsuarioProyectoDomain>{
private static final Validator<UsuarioProyectoDomain> instancia = new RegistarUsuarioProyectoValidator();
	
	private RegistarUsuarioProyectoValidator() {
		super();
	}
	
	public static final void ejecutar(final UsuarioProyectoDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(UsuarioProyectoDomain domain) {
		UsuarioProyectoValidationRule.ejecutarValidacion(domain);
		IdUsuarioValidationRule.ejecutarValidacion(domain.getUsuario().getIdUsuario());
		IdProyectoValidationRule.ejecutarValidacion(domain.getProyecto().getIdProyecto());
	}
}



