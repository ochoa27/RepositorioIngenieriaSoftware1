package com.eternalnovices.cotasker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eternalnovices.cotasker.controller.support.mapper.UsuarioResponseMapper;
import com.eternalnovices.cotasker.controller.support.request.SolicitarUsuario;
import com.eternalnovices.cotasker.controller.support.response.Respuesta;
import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.service.dto.BooleanDTO;
import com.eternalnovices.cotasker.service.dto.UsuarioDTO;
import com.eternalnovices.cotasker.service.facade.concrete.usuario.ConsultarUsuarioFacade;
import com.eternalnovices.cotasker.service.facade.concrete.usuario.RegistrarUsuarioFacade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	private static final Logger logger = LogManager.getLogger(UsuarioController.class);
	
	@GetMapping("/dummy")
	public SolicitarUsuario obtenerDummy() {
		return new SolicitarUsuario();
	}
	
	@PostMapping 
	public ResponseEntity<Respuesta<SolicitarUsuario>> registrar(@RequestBody SolicitarUsuario req){
		final Respuesta<SolicitarUsuario> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarUsuarioFacade facade = new RegistrarUsuarioFacade();
			var dto = UsuarioDTO.crear()
					.setIdUsuario(req.getIdUsuario())
					.setNombre(req.getNombre())
					.setApellido(req.getApellido())
					.setCorreoElectronico(req.getCorreoElectronico())
					.setCorreoElectronicoConfirmado(BooleanDTO.crear())
					.setContrasena(req.getContrasena());
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000338));
		} catch (CoTaskerException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getLugar(), e);
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000254));
			logger.error(e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Respuesta<SolicitarUsuario>> iniciarSesion(@RequestBody SolicitarUsuario req){
		final Respuesta<SolicitarUsuario> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ConsultarUsuarioFacade facade = new ConsultarUsuarioFacade();
			var dto = UsuarioDTO.crear()
					.setCorreoElectronico(req.getCorreoElectronico())
					.setContrasena(req.getContrasena());
			var res = facade.execute(dto);
			respuesta.setDatos(UsuarioResponseMapper.convertListToResponse(res));
			codigoHttp = res.size() == 1  ? HttpStatus.OK: HttpStatus.NOT_FOUND;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(res.size() == 1  ? CodigoMensaje.M0000000313: CodigoMensaje.M0000000314));
		} catch (CoTaskerException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getLugar(), e);
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000254));
			logger.error(e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
}
