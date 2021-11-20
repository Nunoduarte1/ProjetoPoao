/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestordecompras;

/**
 *objeto alimentares tem calorias, percentagem de Gorduraum, identificador, um nome, um preco por unidade, e o seu stock
 * se existir um erro no valor do stock ou no preco unitario(ex serem negativos) será imprimida mensagem de erro e sera armazenado o valor -1 no atributo
 *
 */
public class Alimentares extends Produtos{
    private int calorias;
    private int percentagemGordura;

    
    /**
     * connstroi um objeto do tipo alimentares que possui as caracteristicas de um objeto tipo produto
     * @param calorias numero inteiro que contem o numero de calorias por cada 100g(se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)
     * @param percentagemGordura numero inteiro (varia entre 0 e 100) que contem a percentagem de gordura(se este valor for menor que zero ou maior que 100 é imprimida mensagem de erro e o valor e colocado igual -1)
     * @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario numero inteiro com o preco da unidade do produto(se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)

     */
    public Alimentares(int calorias, int percentagemGordura, int identificador, String nome, int precoUnitario, int stock) {
        super(identificador, nome, precoUnitario, stock); 
        setCalorias(calorias);
        setPercentagemGordura(percentagemGordura);
    }
    
    
    public int getCalorias() {
        return calorias;
    }

    public int getPercentagemGordura() {
        return percentagemGordura;
    }

    public void setCalorias(int calorias) {
        if (calorias<0) {
            System.out.println("valor de inválido de calorias");
            this.calorias=-1;
        }else{
            this.calorias = calorias;
        }
        
    }

    public void setPercentagemGordura(int percentagemGordura) {
        if (percentagemGordura<0 || percentagemGordura>100) {
            System.out.println("valor invalido na percentagem de gordura");
            this.percentagemGordura=-1;
        }else{
        this.percentagemGordura = percentagemGordura;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"Alimentares{" + "calorias=" + calorias + ", percentagemGordura=" + percentagemGordura + '}';
    }
    
    
}
