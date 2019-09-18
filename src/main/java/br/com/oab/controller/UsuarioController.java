//package br.com.oab.controller;
//
//import java.util.Optional;
//
//import br.com.oab.model.Usuario;
//import br.com.oab.response.Response;
//import br.com.oab.service.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//@RequestMapping("/usuarios")
//public class UsuarioController {
//
//	@Autowired
//	private UsuarioService usuarioService;
//
//	@PostMapping(produces = "application/json")
//	public ResponseEntity<Response<Usuario>> create(HttpServletRequest request, @RequestBody Usuario usuario,
//													BindingResult result) {
//
//		Response<Usuario> response = new Response<Usuario>();
//
//		try {
//			validateCreateUsuario(usuario, result);
//
//			if (result.hasErrors()) {
//				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
//				return ResponseEntity.badRequest().body(response);
//			}
//
//			Usuario usuarioPersisted = (Usuario) usuarioService.createOrUpdate(usuario);
//			response.setData(usuarioPersisted);
//
//		} catch (DuplicateKeyException e) {
//
//			response.getErrors().add("E-mail already registered");
//			return ResponseEntity.badRequest().body(response);
//
//		} catch (Exception e) {
//			response.getErrors().add(e.getMessage());
//			return ResponseEntity.badRequest().body(response);
//		}
//
//		return ResponseEntity.ok(response);
//	}
//
//	private void validateCreateUsuario(Usuario usuario, BindingResult result) {
//		if (usuario.getEmail() == null) {
//			result.addError(new ObjectError("Usuario", "E-mail no information"));
//		}
//	}
//
//	@PutMapping(produces = "application/json")
//	public ResponseEntity<Response<Usuario>> update(HttpServletRequest request, @RequestBody Usuario usuario,
//												 BindingResult result) {
//		Response<Usuario> response = new Response<Usuario>();
//
//		try {
//			validateUpdateUsuario(usuario, result);
//			if (result.hasErrors()) {
//				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
//				return ResponseEntity.badRequest().body(response);
//			}
//
//			Usuario usuarioPersisted = (Usuario) usuarioService.createOrUpdate(usuario);
//			response.setData(usuarioPersisted);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			response.getErrors().add(e.getMessage());
//			return ResponseEntity.badRequest().body(response);
//		}
//
//		return ResponseEntity.ok(response);
//	}
//
//	private void validateUpdateUsuario(Usuario usuario, BindingResult result) {
//		if (usuario.getId() == null) {
//			result.addError(new ObjectError("Usuario", "Id no information"));
//		}
//		if (usuario.getEmail() == null) {
//			result.addError(new ObjectError("Usuario", "E-mail no information"));
//		}
//	}
//
//	@GetMapping(value = "{id}")
//	public ResponseEntity<Response<Usuario>> findById(@PathVariable("id") Long id) {
//		Response<Usuario> response = new Response<Usuario>();
//		Optional<Usuario> OptionalUsuario = usuarioService.findById(id);
//
//		Usuario usuario = null;
//
//		if (OptionalUsuario.isPresent()) usuario = OptionalUsuario.get();
//
//		if (usuario == null) {
//			response.getErrors().add("Register not found id: " + id);
//			return ResponseEntity.badRequest().body(response);
//		}
//		response.setData(usuario);
//		return ResponseEntity.ok(response);
//	}
//
//
//	@DeleteMapping(value = "{id}")
//	public ResponseEntity<Response<String>> delete(@PathVariable("id") Long id) {
//		Response<String> response = new Response<String>();
//
//		Optional<Usuario> OptionalUsuario = usuarioService.findById(id);
//
//		Usuario usuario = null;
//
//		if (OptionalUsuario.isPresent()) usuario = OptionalUsuario.get();
//
//		if (usuario == null) {
//			response.getErrors().add("Register not found id: " + id);
//			return ResponseEntity.badRequest().body(response);
//		}
//		usuarioService.delete(id);
//		return ResponseEntity.ok(new Response<String>());
//	}
//
//	@GetMapping(value = "{page}/{count}")
//	public ResponseEntity<Response<Page<Usuario>>> findAll(@PathVariable int page, @PathVariable int count) {
//		Response<Page<Usuario>> response = new Response<Page<Usuario>>();
//		Page<Usuario> usuarios = usuarioService.findAll(page, count);
//		response.setData(usuarios);
//		return ResponseEntity.ok(response);
//	}
//}
