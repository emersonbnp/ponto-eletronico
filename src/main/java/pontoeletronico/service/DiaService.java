package pontoeletronico.service;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pontoeletronico.entity.Dia;
import pontoeletronico.entity.Usuario;
import pontoeletronico.exception.PrivilegiosInsuficientesException;
import pontoeletronico.repository.DiaRepository;
import pontoeletronico.repository.UsuarioRepository;
import pontoeletronico.util.UtilConstantes;

@RestController
@RequestMapping("/")
public class DiaService {

	@Autowired
	private DiaRepository diaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/funcionario/listarDiasPorPeriodoFuncionario/{emailUsuario}/{dataInicial}/{dataFinal}/{page}/{count}", method = RequestMethod.GET)
	public @ResponseBody Page<Dia> listarDiasPorPeriodoFuncionario(Principal principal,
			@PathVariable String emailUsuario,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataInicial,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataFinal, 
			@PathVariable int page,
			@PathVariable int count) throws PrivilegiosInsuficientesException, Exception {
		try {
			Usuario usuario = usuarioRepository.buscarUsuarioPeloEmail(principal.getName());
			if (usuario.getEmail().equals(emailUsuario) || usuario.getPerfis().contains(UtilConstantes.ROLE_ADMIN) || usuario.getPerfis().contains(UtilConstantes.ROLE_GESTOR)) {
				if (dataInicial != null && dataFinal != null) {
					Pageable pages = new PageRequest(page, count);
					return diaRepository.buscarDiasPorPeriodo(dataInicial, dataFinal, pages);
				} else {
					throw new Exception("Erro insperado!");
				}
			} else {
				throw new PrivilegiosInsuficientesException(UtilConstantes.ERRO, "Você não possui privilégios suficientes");
			}
		} catch (PrivilegiosInsuficientesException p) {
			p.printStackTrace();
			throw p;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro inesperado!");
		}
	}

}
