package com.eternalnovices.cotasker.service.facade;

import java.util.UUID;

public interface FacadeId<T, U> {
	
	UUID execute(T dto, U id);
}
