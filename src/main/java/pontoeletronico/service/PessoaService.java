package pontoeletronico.service;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pontoeletronico.entity.Perfil;
import pontoeletronico.entity.Pessoa;
import pontoeletronico.entity.Usuario;
import pontoeletronico.entity.mensageria.MensagemRetorno;
import pontoeletronico.exception.CampoObrigatorioException;
import pontoeletronico.exception.ErroInternoException;
import pontoeletronico.exception.RestricaoUnicidadeException;
import pontoeletronico.repository.PerfilRepository;
import pontoeletronico.repository.PessoaRepository;
import pontoeletronico.repository.UsuarioRepository;
import pontoeletronico.util.UtilAvisos;
import pontoeletronico.util.UtilConstantes;
import pontoeletronico.util.Validador;

@RestController
@RequestMapping("/")
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Transactional(transactionManager = "jpaTransactionManager", readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	@RequestMapping("/admin/adicionarPessoa")
	public @ResponseBody MensagemRetorno adicionarPessoa(@RequestBody Pessoa pessoa,
			@RequestParam("email") String email) throws Exception {
		try {
			if (!Validador.naoNullOuVazio(pessoa.getNome())) {
				throw new CampoObrigatorioException(UtilConstantes.ERRO, UtilAvisos.eUmCampoObrigatorio("nome"));
			} else if (!Validador.naoNullOuVazio(pessoa.getCpf())) {
				throw new CampoObrigatorioException(UtilConstantes.ERRO, UtilAvisos.eUmCampoObrigatorio("cpf"));
			} else if (!Validador.naoNullOuVazio(pessoa.getCargo())) {
				throw new CampoObrigatorioException(UtilConstantes.ERRO, UtilAvisos.eUmCampoObrigatorio("cargo"));
			} else if (pessoaRepository.obterPessoaPeloCpf(pessoa.getCpf()) != null) {
				throw new RestricaoUnicidadeException(UtilConstantes.ERRO, UtilAvisos.CPF_JA_CADASTRADO);
			}

			Perfil perfil = perfilRepository.obterPerfilPorId(Long.valueOf(UtilConstantes.ROLE_FUNCIONARIO));
			LinkedList<Perfil> perfis = new LinkedList<Perfil>();
			perfis.add(perfil);

			Usuario usuario = new Usuario();
			usuario.setAtivo(UtilConstantes.SIM);
			usuario.setEmail(email);
			usuario.setPerfis(perfis);
			usuario.setSenha(pessoa.getCpf());
			usuarioRepository.save(usuario);

			pessoa.setUsuario(usuario);
			pessoaRepository.save(pessoa);

			return new MensagemRetorno(UtilConstantes.SUCESSO, UtilAvisos.SUCESSO);
		} catch (RestricaoUnicidadeException r) {
			r.printStackTrace();
			throw r;
		} catch (CampoObrigatorioException o) {
			o.printStackTrace();
			throw o;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErroInternoException(UtilConstantes.ERRO, UtilAvisos.ERRO_NAO_TRATADO);
		}

	}

}
