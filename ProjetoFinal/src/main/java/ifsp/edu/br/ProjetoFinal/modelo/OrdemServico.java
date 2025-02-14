package ifsp.edu.br.ProjetoFinal.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ORDEM_SERVICO")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@NotNull
	@OneToOne
	private Usuario cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario instalador;

	@Enumerated(EnumType.ORDINAL)
	private Plano plano;

	@Enumerated(EnumType.ORDINAL)
	private Horario horario;

	private Date dataContratacao;

	private Date dataInicioIntalacao;

	private Date dataFinalInstalacao;

	@PrePersist
	private void batatinha() {
		dataContratacao = new Date();
		dataFinalInstalacao = new Date();
		dataInicioIntalacao = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Date getDataInicioIntalacao() {
		return dataInicioIntalacao;
	}

	public void setDataInicioIntalacao(Date dataInicioIntalacao) {
		this.dataInicioIntalacao = dataInicioIntalacao;
	}

	public Date getDataFinalInstalacao() {
		return dataFinalInstalacao;
	}

	public void setDataFinalInstalacao(Date dataFinalInstalacao) {
		this.dataFinalInstalacao = dataFinalInstalacao;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horarioPreferencial) {
		this.horario = horarioPreferencial;
	}
}
