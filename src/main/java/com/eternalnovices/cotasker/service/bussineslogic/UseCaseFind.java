package com.eternalnovices.cotasker.service.bussineslogic;

import java.util.List;

public interface UseCaseFind <D> {
	List<D> execute(D domain);
}
