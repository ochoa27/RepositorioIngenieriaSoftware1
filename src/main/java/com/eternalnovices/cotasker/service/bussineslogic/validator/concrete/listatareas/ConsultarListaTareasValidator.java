package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.listatareas;

import com.eternalnovices.cotasker.crosscutting.util.UtilFecha;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechaCreacionFechasValidationRule;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.DescripcionListaTareasValitationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.IdListaTareasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.NombreListaTareasValitadionRule;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.IdPrioridadValidationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.IdProyectoValidationRule;

public final class ConsultarListaTareasValidator implements Validator<ListaTareasDomain>{
	private static final Validator<ListaTareasDomain> instancia = new ConsultarListaTareasValidator();
	
	private ConsultarListaTareasValidator() {
		super();
	}
	
	public static final void ejecutar(final ListaTareasDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(ListaTareasDomain domain) {
		if(!UtilObjeto.esNulo(domain)) {
			if(!UtilUUID.esNulo(domain.getIdListaTareas())) {				
				IdListaTareasValidationRule.ejecutarValidacion(domain.getIdListaTareas());
			}
			
			if(!UtilTexto.estaVacio(domain.getNombre())) {				
				NombreListaTareasValitadionRule.ejecutarValidacion(domain.getNombre());
			}
			
			if(!UtilTexto.estaVacio(domain.getDescripcion())) {				
				DescripcionListaTareasValitationRule.ejecutarValidacion(domain.getDescripcion());
			}
			
			if(!UtilObjeto.esNulo(domain.getFecha())) {
				if(!UtilFecha.esNulo(domain.getFecha().getFechaCreacion())) {
					FechaCreacionFechasValidationRule.ejecutarValidacion(domain.getFecha().getFechaCreacion());
					FechasValidationRule.ejecutarValidacion(domain.getFecha());
				}
			}
			
			if(!UtilObjeto.esNulo((domain.getPrioridad()))) {
				IdPrioridadValidationRule.ejecutarValidacion(domain.getPrioridad().getIdPrioridad());
			}
			
		
			
			if(!UtilObjeto.esNulo((domain.getProyecto()))) {
				IdProyectoValidationRule.ejecutarValidacion(domain.getProyecto().getIdProyecto());
			}
		}
	}

}
