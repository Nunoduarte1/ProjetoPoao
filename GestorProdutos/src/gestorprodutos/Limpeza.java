/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestordecompras;

/**
 *objeto limpeza tem toxicidade, identificador, um nome, um preco por unidade, e o seu stock
 * se existir erro no valor de toxicidade (fora do intervalo [0,10]) imprime mensagem de erro e armazena o valor -1
 * 
 */
public class Limpeza extends Produtos{
    private int toxicidade;

    /**
     * @param toxicidade numero inteiro entre 0 e 10 representa a toxicidade do produto(se valor for invalido é imprimido mensagem de erro e o valor colocado igual a -1)
     * @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario numero inteiro com o preco da unidade do produto(se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero é imprimida mensagem de erro e o valor e colocado igual -1)
     */
    public Limpeza(int toxicidade, int identificador, String nome, float precoUnitario, int stock) {
        super(identificador, nome, precoUnitario, stock);
        setToxicidade(toxicidade);
    }

    public void setToxicidade(int toxicidade) {
        if (toxicidade<0 || toxicidade>10) {
            System.out.println(" valor invalido na toxicidade");
            this.toxicidade=-1;
        }else{
        this.toxicidade = toxicidade;
        }
    }

    public int getToxicidade() {
        return toxicidade;
    }

    @Override
    public String toString() {
        return super.toString()+"Limpeza{" + "toxicidade=" + toxicidade + '}';
    }
    
}
