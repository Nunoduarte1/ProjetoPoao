/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestordecompras;

/**
 *Objeto produto tem um identificador, um nome, um preco por unidade, e o seu stock
 * se existir um erro no valor do stock ou no preco unitario(ex serem negativos) será imprimida mensagem de erro e sera armazenado o valor -1 no atributo
 * 
 */
public class Produtos {
    private int identificador;
    private String nome;
    private int precoUnitario;
    private int stock;
/**
 * constroi um objeto tipo produto 
 * @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario numero inteiro com o preco da unidade do produto(se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)
 */
    public Produtos(int identificador, String nome, int precoUnitario, int stock) {
        setIdentificador(identificador);
        setNome(nome);
        setPrecoUnitario(precoUnitario);
        setStock(stock);
    }
    
    

    public int getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public int getPrecoUnitario() {
        return precoUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoUnitario(int precoUnitario) {
        if(precoUnitario<=0){
            System.out.println("Preço unitário invalido!");
            this.precoUnitario=-1;
        }else{
        this.precoUnitario = precoUnitario;
        }
    }

    public void setStock(int stock) {
        if (stock<0) {
            System.out.println("Valor de stock inválido!");
            this.stock=-1;
        }else{
        this.stock = stock;
        }
    }

    @Override
    public String toString() {
        return "Produtos{" + "identificador=" + identificador + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", stock=" + stock + '}';
    }
    
    
}
