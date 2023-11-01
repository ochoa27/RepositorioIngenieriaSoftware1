package com.eternalnovices.cotasker.service.domain.usuarioproyecto;

import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;


public class UsuarioProyectoDomain {
	private ProyectoDomain proyecto;
	private UsuarioDomain usuario;
	
	private UsuarioProyectoDomain(final ProyectoDomain proyecto,final  UsuarioDomain usuario) {
		setProyecto(proyecto);
		setUsuario(usuario);
	}
	
	public static final UsuarioProyectoDomain crear(final ProyectoDomain proyecto,final  UsuarioDomain usuario) {
		return new UsuarioProyectoDomain(proyecto, usuario);
	}
	
	private final void setProyecto(final ProyectoDomain proyecto) {
		this.proyecto = proyecto;
	}
	private final void setUsuario(final UsuarioDomain usuario) {
		this.usuario = usuario;
	}
	public final ProyectoDomain getProyecto() {
		return proyecto;
	}
	public final UsuarioDomain getUsuario() {
		return usuario;
	}
	
	
}
