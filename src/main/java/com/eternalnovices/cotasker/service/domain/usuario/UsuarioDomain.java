package com.eternalnovices.cotasker.service.domain.usuario;

import java.util.UUID;

import com.eternalnovices.cotasker.service.domain.support.BooleanDomain;

public class UsuarioDomain {
	private UUID idUsuario;
	private String nombre;
	private String apellido;
	private String correoElectronico;
	private BooleanDomain correoElectronicoConfirmado;
	private String contrasena;
	
	private UsuarioDomain(final UUID idUsuario,final String nombre,final String apellido,final String correoElectronico,
			final BooleanDomain correoElectronicoConfirmado,final String contrasena) {
		
		setIdUsuario(idUsuario);
		setNombre(nombre);
		setApellido(apellido);
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setContrasena(contrasena);
	}
	
	public static final  UsuarioDomain crear(final UUID idUsuario, final String nombre,final String apellido,final String correoElectronico,
			final BooleanDomain correoElectronicoConfirmado,final String contrasena  ) {
		
		return  new UsuarioDomain (idUsuario ,nombre,apellido,correoElectronico,correoElectronicoConfirmado,contrasena);
	}
	
	public final UUID getIdUsuario() {
		return idUsuario;
	}
	public final String getNombre() {
		return nombre;
	}
	public final String getApellido() {
		return apellido;
	}
	public final String getCorreoElectronico() {
		return correoElectronico;
	}
	public final BooleanDomain isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}
	public final String getContrasena() {
		return contrasena;
	}
	private final void setIdUsuario(final UUID id) {
		this.idUsuario = id;
	}
	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	private final void setApellido(final String apellido) {
		this.apellido = apellido;
	}
	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	private final void setCorreoElectronicoConfirmado( final BooleanDomain correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}
	private final void setContrasena(final String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
}
