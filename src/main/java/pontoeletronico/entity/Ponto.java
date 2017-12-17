package pontoeletronico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PONTO")
public class Ponto {

	@Id
	@Column(name = "ID_PONTO")
	@SequenceGenerator(name = "PONTO_SEQUENCE", sequenceName = "S_PONTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PONTO_SEQUENCE")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_DIA")
	private Dia dia;

	@Column(name = "HORA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaInicial;

	@Column(name = "HORA_FINAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

}
