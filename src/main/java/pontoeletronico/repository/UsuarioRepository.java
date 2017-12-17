package pontoeletronico.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pontoeletronico.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("SELECT U FROM Usuario U WHERE U.email = ?1")
	public Usuario buscarUsuarioPeloEmail(String login);

}
