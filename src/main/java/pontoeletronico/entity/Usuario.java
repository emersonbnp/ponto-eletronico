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

@Entity
@Table(name = "T_USUARIO")
@SequenceGenerator(name = "S_USUARIO", sequenceName="S_USUARIO")
public class Usuario {

	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_USUARIO")
	private Long id;
	@Column(name = "SENHA")
	private String senha;
	@Column(name = "EMAIL")
	private String email;
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
        name = "T_ROLE_USUARIO", 
        joinColumns = { @JoinColumn(name = "ID_USUARIO") }, 
        inverseJoinColumns = { @JoinColumn(name = "ID_ROLE") }
    )
	private List<Role> roles;
	public Usuario() {
		super();
	}
	public Usuario (Usuario usuario) {
		setSenha(usuario.getSenha());
		setEmail(usuario.getEmail());
		setRoles(usuario.getRoles());
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
	