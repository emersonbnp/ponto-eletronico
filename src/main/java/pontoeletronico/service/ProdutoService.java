/*package pontoeletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pontoeletronico.entity.Produto;
import pontoeletronico.entity.mensageria.MensagemRetorno;
import pontoeletronico.repository.ProdutoRepository;
import pontoeletronico.util.UtilAvisos;
import pontoeletronico.util.UtilConstantes;

@RestController
@RequestMapping("/produto")
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public @ResponseBody MensagemRetorno adicionarProduto(@RequestBody Produto produto) {
		try {
			if (produtoRepository.findOneByName(produto.getNome()) != null) {
				return new MensagemRetorno(UtilConstantes.ERRO, UtilAvisos.AVISO_PRODUTO_JA_EXISTE);
			} else {
				produtoRepository.save(produto);
				return new MensagemRetorno(UtilConstantes.SUCESSO, UtilAvisos.SUCESSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new MensagemRetorno(UtilConstantes.SUCESSO, UtilAvisos.ERRO_NAO_TRATADO);
		}
	}

	@RequestMapping(value = "/listarTodos/{page}/{count}", method = RequestMethod.GET)
	public @ResponseBody Page<Produto> listarTodos(@PathVariable int page, @PathVariable int count) {
		Pageable pages = new PageRequest(page, count);
		return produtoRepository.listaPaginada(pages);
	}

}
*/