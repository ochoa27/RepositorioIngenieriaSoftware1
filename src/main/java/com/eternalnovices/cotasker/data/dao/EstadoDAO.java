package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.EstadoEntity;


public interface EstadoDAO {
	void modificar(EstadoEntity entity);
	
	Optional<EstadoEntity>consultarPorId(UUID id );
	List <EstadoEntity>consultar(EstadoEntity entity);

}
