package pontoeletronico.repository;

import org.springframework.data.repository.CrudRepository;

import pontoeletronico.entity.Ponto;

public interface PontoRepository extends CrudRepository<Ponto, Long> {

}
