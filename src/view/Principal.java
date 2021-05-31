package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.CrudOperations;
import model.Estoque;

public class Principal {

	public static void main(String[] args) throws IOException,SQLException {
		
		try {
			Scanner input = new Scanner(System.in);
			String op = "";
			
				while(!op.equalsIgnoreCase("sair")) {
					System.out.println("------------------------------------\n"
									 + "BEM VINDO AO SISTEMA NOSSA FARMACIA\n"
									 + "------------------------------------\n");
					System.out.print  ("Escolha uma das opcoes:\n"
									 + "1 - Consultar Estoque - TELA CRIADA\n"
									 + "2 - Alterar Produto em Estoque\n"
									 + "3 - Adicionar Item ao Estoque - TELA CRIADA\n"
									 + "4 - Excluir Item do Estoque\n"
									 + "Digite sair para finalizar a secao\n"
									 + "OPCAO:  ");
					
					op = input.next();
					
					switch(Integer.parseInt(op)) {
					case 1:
						System.out.println("-----------------------\n"
								 		 + "CONSULTAS DE ESTOQUE\n"
								 		 + "-----------------------\n");
						System.out.println("1 - Todos os itens em estoque\n"
										 + "2 - Pesquisar produto pelo ID");
						op = input.next();
						
						switch(Integer.parseInt(op)) {
						case 1:
							List<Estoque> estoque = CrudOperations.buscaTudo();
							
							System.out.println("RESULTADO DA PESQUISA: ");
							System.out.println();
							for(Estoque est : estoque) {
								System.out.println(est);
							}
							
							System.out.println("\n\n");
							break;
						case 2:
							System.out.println("Informe o ID a ser pesquisado: ");
							System.out.print("ID: ");
							int identificador = input.nextInt();
							
							while(identificador <= 0) {
								System.out.print("Número invalido...\n"
												 + "Informe: ");
								identificador = input.nextInt();
							}
							
							List<Estoque> resultPesquisa = CrudOperations.buscaPeloId(identificador);
							
							System.out.println("\n\n");
							System.out.println("PRODUTOS EM ESTOQUE");
							
							for(Estoque est : resultPesquisa) {
								System.out.println(est);
							}
							
							
							break;
						default:
							
						}
						
						break;
					case 2:
						System.out.println("INFORME O CAMPO QUE DESEJA ALTERAR: \n"
										 + "1 - PRODUTO\n"
										 + "2 - MARCA\n"
										 + "3 - QUANTIDADE\n"
										 + "4 - PRECO\n"
										 + "5 - DESCRICAO");
						System.out.print("OPCAO: ");
						int menu = input.nextInt();
						
						switch(menu) {
						case 1:
							System.out.println("-----------------------------");
							System.out.print("Informe o ID: ");
							Integer id = input.nextInt();
							
							while(id <= 0) {
								System.out.println("Informe um ID valido: ");
								System.out.print("INFORME UM INTEIRO MAIOR QUE ZERO: ");
								id = input.nextInt();
							}
							input.nextLine();
							System.out.print("Informe o novo nome do produto: ");
							String alteracao = input.nextLine();
							
							System.out.println(CrudOperations.alteraProduto(alteracao, id));
							
							break;
						case 2:
							
							System.out.println("-----------------------------");
							System.out.print("Informe o ID: ");
							id = input.nextInt();
							
							while(id <= 0) {
								System.out.println("Informe um ID valido: ");
								System.out.print("INFORME UM INTEIRO MAIOR QUE ZERO: ");
								id = input.nextInt();
							}
							input.nextLine();
							System.out.print("Informe a nova marca: ");
							alteracao = input.nextLine();
							
							System.out.println(CrudOperations.alteraMarca(alteracao, id));
							
							break;
						case 3:
							
							System.out.println("-----------------------------");
							System.out.print("Informe o ID: ");
							id = input.nextInt();
							
							while(id <= 0) {
								System.out.println("Informe um ID valido: ");
								System.out.print("INFORME UM INTEIRO MAIOR QUE ZERO: ");
								id = input.nextInt();
							}

							System.out.print("Informe a nova Quantidade: ");
							Integer alterInt = input.nextInt();
							
							System.out.println(CrudOperations.alteraQuantidade(alterInt, id));
							
							
							break;
						case 4:
							
							System.out.println("-----------------------------");
							System.out.print("Informe o ID: ");
							id = input.nextInt();
							
							while(id <= 0) {
								System.out.println("Informe um ID valido: ");
								System.out.print("INFORME UM INTEIRO MAIOR QUE ZERO: ");
								id = input.nextInt();
							}

							System.out.print("Informe o novo preco: ");
							Double alterDouble = input.nextDouble();
							
							System.out.println(CrudOperations.alteraPreco(alterDouble, id));
							
							break;
						case 5:
							
							System.out.println("-----------------------------");
							System.out.print("Informe o ID: ");
							id = input.nextInt();
							
							while(id <= 0) {
								System.out.println("Informe um ID valido: ");
								System.out.print("INFORME UM INTEIRO MAIOR QUE ZERO: ");
								id = input.nextInt();
							}
							
							input.nextLine();
							System.out.print("Informe a nova descricao: ");
							String descricao = input.nextLine();
							
							System.out.println(CrudOperations.alteraDescricao(descricao, id));
							
							break;
						default:
							System.out.println("OPCAO INVALIDA REGISTRADA...");
						}
						
						
						
						break;
					case 3:
						
						System.out.println("--------------------------------\n"
										 + "CADASTRO DE PRODUTO NO ESTOQUE\n"
										 + "--------------------------------");
						System.out.print("Informe o produto: ");
						input.nextLine();
						String produto = input.nextLine();
						
						
						System.out.print("Informe a marca: ");
						String marca = input.nextLine();
						
						System.out.println("Informe uma descricao simples do produto: ");
						String descricao = input.nextLine();
						//input.next();
						
						System.out.print("Informe a quantidade (Numero inteiro): ");
						int quantidade = input.nextInt();
						
						while(quantidade <= 0) {
							System.out.print("Informe um valor válido: ");
							quantidade = input.nextInt();
						}
						
						System.out.println("Informe o preco: (Com casas decimais): ");
						Double preco = input.nextDouble();
						
						while(preco <=  0) {
							System.out.print("Informe um valor válido: ");
							preco = input.nextDouble();
						}
						
						System.out.println(CrudOperations.criaProduto(produto, marca, quantidade, preco, descricao));
						
						break;
					case 4:
						System.out.print("--------------------------\n"
										 + "INFORME O ID DO PRODUTO: ");
						Integer id = input.nextInt();
						
						while(id <= 0) {
							System.out.println("Informe um valor valido: ");
							System.out.print("VALOR INTEIRO MAIOR QUE ZERO: ");
							id = input.nextInt();
						}
						
						System.out.println("Deseja realmente apagar o produto de ID: "+ id + " ?");
						System.out.print("informe SIM ou NAO: ");
						String resposta = input.next();
						
						if(resposta.equalsIgnoreCase("sim")) {
							System.out.println(CrudOperations.deletaPeloId(id));
						}else {
							System.out.println("Voltando ao menu...");
							main(args);
						}
						
						break;
					default:
					
					}
					
				}
				input.close();
		} catch (Exception e) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Deseja sair?");
			String op = input.next();
			
				if(op.equalsIgnoreCase("nao") || op.equalsIgnoreCase("não")) {
					main(args);
				}else {
					System.out.println("Saindo...");
				}
			
			
			} 
		
		} 
	
		
	}


