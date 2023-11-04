package com.eternalnovices.cotasker.service.bussineslogic;

import java.util.UUID;

public interface UseCaseId <D, U> {
	UUID execute(D domain, U id);
}
