package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.tarea;

import com.eternalnovices.cotasker.crosscutting.util.UtilFecha;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.estado.rules.IdEstadoValidationRule;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechaCreacionFechasValidationRule;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.IdListaTareasValidationRule;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.IdPrioridadValidationRule;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.domain.tarea.rules.DescripcionTareaValitationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.IdTareaValidationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.NombreTareaValitadionRule;

public final class ConsultarTareaValidator implements Validator<TareaDomain>{
	private static final Validator<TareaDomain> instancia = new ConsultarTareaValidator();
	
	private ConsultarTareaValidator() {
		super();
	}
	
	public static final void ejecutar(final TareaDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(TareaDomain domain) {
		if(!UtilObjeto.esNulo(domain)) {
			if(!UtilUUID.esNulo(domain.getIdTarea())) {				
				IdTareaValidationRule.ejecutarValidacion(domain.getIdTarea());
			}
			
			if(!UtilTexto.estaVacio(domain.getNombre())) {				
				NombreTareaValitadionRule.ejecutarValidacion(domain.getNombre());
			}
			
			if(!UtilTexto.estaVacio(domain.getDescripcion())) {				
				DescripcionTareaValitationRule.ejecutarValidacion(domain.getDescripcion());
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
			
			if(!UtilObjeto.esNulo((domain.getEstado()))) {
				IdEstadoValidationRule.ejecutarValidacion(domain.getEstado().getIdEstado());
			}
			
			if(!UtilObjeto.esNulo((domain.getListaTareas()))) {
				IdListaTareasValidationRule.ejecutarValidacion(domain.getListaTareas().getIdListaTareas());
			}
			
			
		}
	}

}
