/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * objeto mobiliario tem peso, dimensao,  identificador, um nome, um preco por unidade, e o seu stock
 * se os valores de peso e dimensao forem invalido(menores ou iguais a zero) imprime mensagem de erro e armazena o valor -1
 */
public class Mobiliario extends Produtos{
    private int peso;
    private int dimensao;
/**
 * 
 * @param peso numero inteiro que possui o peso do movel(se for menor ou igual a zero imprime mensagem de erro e armazena valor -1)
 * @param dimensao numero inteiro que possui a dimensao do movel(se for menor ou igual a zero imprime mensagem de erro e armazena valor -1)
* @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario numero inteiro com o preco da unidade do produto(se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)

 */
    public Mobiliario(int identificador, String nome, float precoUnitario, int stock, ArrayList<Promocoes> promocao, int peso, int dimensao) {
        super(identificador, nome, precoUnitario, stock,promocao);
        setDimensao(dimensao);
        setPeso(peso);
    }
    

    public int getPeso() {
        return peso;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setPeso(int peso) {
        if (peso<=0) {
            System.out.println("valor do peso invalido");
            this.peso=-1;
        }else{
        this.peso = peso;
        }
    }

    public void setDimensao(int dimensao) {
        if (dimensao<=0) {
            System.out.println("valor de dimensao invalido");
            this.dimensao=-1;
        }else{
        this.dimensao = dimensao;
    }}

    @Override
    public String toString() {
        return getNome()+" preco:"+ getPrecoUnitario()+"   caracteristicas: peso:"+peso+"Kg, dimensao:"+dimensao;
    }
    
}
