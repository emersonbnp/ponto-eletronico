package pontoeletronico.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_DIA")
public class Dia {

	@Id
	@Column(name = "ID_DIA")
	@SequenceGenerator(name="DIA_SEQUENCE", sequenceName="S_DIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIA_SEQUENCE")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;

	@Column(name = "DATA")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@OneToMany(mappedBy="dia")
	private List<Ponto> pontos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
