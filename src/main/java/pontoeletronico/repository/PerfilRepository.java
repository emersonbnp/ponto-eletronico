package pontoeletronico.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pontoeletronico.entity.Perfil;

public interface PerfilRepository extends CrudRepository<Perfil, Long> {

	@Query("SELECT P FROM Perfil P WHERE P.id = ?1")
	public Perfil obterPerfilPorId(Long id);

}
