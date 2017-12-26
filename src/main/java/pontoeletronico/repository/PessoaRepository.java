package pontoeletronico.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import pontoeletronico.entity.Pessoa;

@Transactional(rollbackFor = Exception.class)
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	@Query("SELECT P FROM Pessoa P WHERE P.cpf = ?1")
	public Pessoa obterPessoaPeloCpf(String cpf);

}
