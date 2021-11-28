/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestordecompras;

import java.util.InputMismatchException;

/**
 *objeto produto no carrinho contem um objeto produto e a quantidade que foi colocada no carrinho do mesmo objeto 
 * 
 */
public class ProdutoNoCarrinho {
    private Produtos produto;
    private int quantidade;

    /**
     * objeto produto no carrinho contem um objeto produto e a quantidade que foi colocada no carrinho do mesmo objeto 
     * @param produto objeto do tipo produtos (produto colocado no carrinho de compras)
     * @param quantidade numero de itens do produto colocados no carrinho se for um numero invalido gera InputMismatchException
     */
    public ProdutoNoCarrinho(Produtos produto, int quantidade)throws InputMismatchException {// tenho de gerar as exceçoes para quando a quantidade nao é a certa ou e superior a quantidade do stock
        setProduto(produto);
        setQuantidade(quantidade);
    }

    public Produtos getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) throws InputMismatchException{
        if(quantidade<=0){
            throw new InputMismatchException("valor de quantidade invalido");
        }else{
        this.quantidade = quantidade;
        }
    }
    
    
}
