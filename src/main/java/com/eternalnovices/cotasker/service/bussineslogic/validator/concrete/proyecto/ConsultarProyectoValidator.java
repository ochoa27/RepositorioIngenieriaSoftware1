package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.proyecto;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.DescripcionProyectoValitationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.IdProyectoValidationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.NombreProyectoValitadionRule;

public class ConsultarProyectoValidator implements Validator<ProyectoDomain>{
	private static final Validator<ProyectoDomain> instancia = new ConsultarProyectoValidator();
	
	private ConsultarProyectoValidator() {
		super();
	}
	
	public static final void ejecutar(final ProyectoDomain domain) {
		instancia.execute(domain);
	}{

}

	@Override
	public void execute(ProyectoDomain domain) {
		if(!UtilObjeto.esNulo(domain)) {
			if(!UtilUUID.esNulo(domain.getIdProyecto())) {
				IdProyectoValidationRule.ejecutarValidacion(domain.getIdProyecto());
			}
			if(!UtilTexto.estaVacio(domain.getNombre())) {
				NombreProyectoValitadionRule.ejecutarValidacion(domain.getNombre());
			}
			if(!UtilTexto.estaVacio(domain.getDescripcion())) {
				DescripcionProyectoValitationRule.ejecutarValidacion(domain.getDescripcion());	
			}
		}
	}
}