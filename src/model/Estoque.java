package model;

public class Estoque {
	
	private Integer id;
	private String  produto;
	private String  marca;
	private Integer quantidade;
	private Double  preco;
	private String  descricao;
	
	public Estoque(Integer id, String produto, String marca, Integer quantidade, Double preco, String descricao) {
		this.id = id;
		this.produto = produto;
		this.marca = marca;
		this.quantidade = quantidade;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Estoque [id : " + id + ", Produto : " + produto + ", Marca : " + marca + ", Quantidade : " + quantidade
				+ ", Preco : " + preco + ", Descricao : " + descricao + "]";
	}
	
	
}
