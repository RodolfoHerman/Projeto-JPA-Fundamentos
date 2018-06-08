package br.com.rodolfo.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Movimentacoes
 */
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
   
    //Melhor utilizar o BigDecimal para maior precisão
    private BigDecimal valor;
    
    //Para a JPA identificar que o tipo é enum é necessário a anotação 'Enum erated'. O parâmetro 'EnumType.STRING' informa que devemos salvar no banco a STRING, ou seja, o valor 'ENTRADA' ou 'SAIDA' no banco de dados
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    //Cada banco de dados tem sua forma específica de lidar com datas. Necessário a anotação 'TEMPORAL' do JPA para tratar a data. É necessário informar no parâmetro se precisamos salvar só a data, só a hora ou os dois, por isso utiliza-se o 'TemporalType.TIMESTAMP' no nosso caso
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;

    private String descricao;

    //Muitas movimentações para uma conta. O JPA realiza a relação entre as duas tabelas, colocando a chave estrangeira na tabela 'movimentacao'
    @ManyToOne
	private Conta conta;
    
    //Muitas movimentações para muitas categorias. 
    @ManyToMany
    private List<Categoria> categoria;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return BigDecimal return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return TipoMovimentacao return the tipo
     */
    public TipoMovimentacao getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    /**
     * @return Calendar return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return Conta return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }


    /**
     * @return List<Categoria> return the categoria
     */
    public List<Categoria> getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

}