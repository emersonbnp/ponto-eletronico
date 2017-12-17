package pontoeletronico.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pontoeletronico.entity.Dia;

public interface DiaRepository extends CrudRepository<Dia, Long> {
	
	@Query("SELECT D FROM Dia D WHERE D.data >= ?1 and D.data <= ?2")
	public Page<Dia> buscarDiasPorPeriodo(Date dataInicial, Date dataFinal, Pageable pages);

}
