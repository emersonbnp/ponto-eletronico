package pontoeletronico.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "T_PERFIL")
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = -3253619241995172528L;

	@Id
	@Column(name = "ID_PERFIL")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Override
	public String getAuthority() {
		return "ROLE_" + id.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
