package pontoeletronico.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pontoeletronico.entity.enums.SimNaoEnum;
import pontoeletronico.util.UtilConstantes;

@Entity
@Table(name = "T_USUARIO")
@SequenceGenerator(name = "S_USUARIO", sequenceName = "S_USUARIO")
public class Usuario {

	@Id
	@Column(name = "ID_USUARIO")
	@SequenceGenerator(name = "USUARIO_SEQUENCE", sequenceName = "S_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQUENCE")
	private Long id;

	@Column(name = "SENHA")
	private String senha;

	@Column(name = "EMAIL")
	private String email;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "T_USUARIO_PERFIL          ", joinColumns = {
			@JoinColumn(name = "ID_USUARIO") }, inverseJoinColumns = { @JoinColumn(name = "ID_PERFIL") })
	private List<Perfil> perfis;

	@Column(name = "FL_ATIVO")
	private String ativo;

	public Usuario() {
		super();
	}

	public Usuario(Usuario usuario) {
		setSenha(usuario.getSenha());
		setEmail(usuario.getEmail());
		setPerfis(usuario.getPerfis());
		setAtivo(usuario.getAtivo());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public SimNaoEnum isAtivo() {
		return UtilConstantes.SIM.equals(this.getAtivo()) ? SimNaoEnum.SIM : SimNaoEnum.NAO;
	}

}
