package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.PrioridadEntity;


public interface PrioridadDAO {
	void modificar(PrioridadEntity entity);
	
	Optional<PrioridadEntity>consultarPorId(UUID id );
	List <PrioridadEntity>consultar(PrioridadEntity entity);
}
