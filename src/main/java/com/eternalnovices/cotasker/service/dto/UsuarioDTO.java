package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;


public class UsuarioDTO {
	private UUID id;
	private String nombre;
	private String apellido;
	private String correoElectronico;
	private BooleanDTO correoElectronicoConfirmado;
	private String contrasena;
	
	public UsuarioDTO() {
		setIdUsuario(UtilUUID.UUIDDEFECTO);
		setNombre(UtilTexto.VACIO);
		setApellido(UtilTexto.VACIO);
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(new BooleanDTO());
		setContrasena(UtilTexto.VACIO);
	}
	
	public UsuarioDTO(final UUID id,final  String nombre, final String apellido,final  String correoElectronico,
			final BooleanDTO correoElectronicoConfirmado,final String contrasena) {
		setIdUsuario(id);
		setNombre(nombre);
		setApellido(apellido);
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setContrasena(contrasena);
	}
	
	public static final UsuarioDTO crear() {
		return new UsuarioDTO();
	}
	
	public final UUID getIdUsuario() {
		return id;
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
	
	public final BooleanDTO isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}
	
	public final String getContrasena() {
		return contrasena;
	}
	
	public final UsuarioDTO setIdUsuario(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUIDDEFECTO));
		return this;
	}
	
	public final UsuarioDTO setNombre(String nombre) {
		this.nombre = UtilTexto.obtenerValorDefecto(nombre,UtilTexto.VACIO);
		return this;
	}
	
	public final UsuarioDTO setApellido(String apellido) {
		this.apellido = UtilTexto.obtenerValorDefecto(apellido,UtilTexto.VACIO);
		return this;
	}
	
	public final UsuarioDTO setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = UtilTexto.obtenerValorDefecto(correoElectronico,UtilTexto.VACIO);
		return this;
	}
	
	public final UsuarioDTO setCorreoElectronicoConfirmado(BooleanDTO correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado.isValorDefecto() ? new BooleanDTO(): new BooleanDTO().setValor(correoElectronicoConfirmado.isValor()).setValorDefecto(false);
		return this;
	}
	
	public final UsuarioDTO setContrasena(String contrasena) {
		this.contrasena = UtilTexto.obtenerValorDefecto(contrasena,UtilTexto.VACIO);
		return this;
	}
}
