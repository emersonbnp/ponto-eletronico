package pontoeletronico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pontoeletronico.entity.Usuario;
import pontoeletronico.repository.UsuarioRepository;

@RestController
@RequestMapping("/admin")
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public List<Usuario> listarTodos() {
		ArrayList<Usuario> users = (ArrayList<Usuario>) usuarioRepository.findAll();
		return users;
	}

	@RequestMapping("/buscarUsuarioPeloEmail")
	public Usuario buscarUsuarioPeloEmail(@RequestParam(value = "email") String email) {
		// Pageable page = ;
		return usuarioRepository.buscarUsuarioPeloEmail(email);
	}

	@RequestMapping("/addUser")
	public String addUser(@RequestBody Usuario user) {
		try {
			usuarioRepository.save(user);
			return "Usuário salvo com sucesso: " + user.toString();
		} catch (Exception e) {
			return "Erro ao salvar: " + e.getCause();
		}

	}

}