package com.eternalnovices.cotasker.service.dto;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;

public class UsuarioProyectoDTO {
	private ProyectoDTO proyecto;
	private UsuarioDTO usuario;
	
	public UsuarioProyectoDTO() {
		setProyecto(new ProyectoDTO());
		setUsuario(new UsuarioDTO());
	}
	
	public UsuarioProyectoDTO(final ProyectoDTO proyecto, final UsuarioDTO usuario) {
		setProyecto(proyecto);
		setUsuario(usuario);
	}
	
	public static final UsuarioProyectoDTO crear() {
		return new UsuarioProyectoDTO();
	}

	public final ProyectoDTO getProyecto() {
		return proyecto;
	}

	public final UsuarioDTO getUsuario() {
		return usuario;
	}

	public final UsuarioProyectoDTO setProyecto(final ProyectoDTO proyecto) {
		this.proyecto = UtilObjeto.obtenerValorDefecto(proyecto, new ProyectoDTO());
		return this;
	}

	public final UsuarioProyectoDTO setUsuario(final UsuarioDTO usuario) {
		this.usuario = UtilObjeto.obtenerValorDefecto(usuario, new UsuarioDTO());
		return this;
	}
}
