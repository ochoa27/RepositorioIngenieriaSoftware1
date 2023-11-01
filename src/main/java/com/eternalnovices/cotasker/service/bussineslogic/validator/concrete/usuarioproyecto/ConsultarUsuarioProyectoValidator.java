package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuarioproyecto;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.IdProyectoValidationRule;
import com.eternalnovices.cotasker.service.domain.usuario.rules.IdUsuarioValidationRule;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;

public class ConsultarUsuarioProyectoValidator implements Validator<UsuarioProyectoDomain>{
private static final Validator<UsuarioProyectoDomain> instancia = new ConsultarUsuarioProyectoValidator();
	
	private ConsultarUsuarioProyectoValidator() {
		super();
	}
	
	public static final void ejecutar(final UsuarioProyectoDomain domain) {
		instancia.execute(domain);
	}

	
	
	@Override
	public void execute(UsuarioProyectoDomain domain) {
		if(!UtilObjeto.esNulo(domain)) {
			if(!UtilObjeto.esNulo(domain.getUsuario())) {
				IdUsuarioValidationRule.ejecutarValidacion(domain.getUsuario().getIdUsuario());
			}
			if(!UtilObjeto.esNulo(domain.getProyecto())) {
				IdProyectoValidationRule.ejecutarValidacion(domain.getProyecto().getIdProyecto());
			}
		}
	}
}
