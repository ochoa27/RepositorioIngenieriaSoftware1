package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.proyecto;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.DescripcionProyectoValitationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.IdProyectoValidationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.NombreProyectoValitadionRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.ProyectoValidationRule;

public class ModificarProyectoValidator implements Validator<ProyectoDomain>{
	 private static final Validator<ProyectoDomain> instancia= new ModificarProyectoValidator();
	 
	 private ModificarProyectoValidator() {
		 super();
	 }
	 
	 public static final void  ejecutar(final ProyectoDomain domain) {
		 instancia.execute(domain);
	 }

	@Override
	public void execute(ProyectoDomain domain) {
		ProyectoValidationRule.ejecutarValidacion(domain);
		IdProyectoValidationRule.ejecutarValidacion(domain.getIdProyecto());
		NombreProyectoValitadionRule.ejecutarValidacion(domain.getNombre());
		DescripcionProyectoValitationRule.ejecutarValidacion(domain.getDescripcion());
	}

}
