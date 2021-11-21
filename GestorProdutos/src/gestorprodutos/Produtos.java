/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestordecompras;

/**
 *Objeto produto tem um identificador, um nome, um preco por unidade,o seu stock, uma promocao associada(pode ser null se nao tiver nenhuma promocao), dimencao para distinguir mobilia dos restantes(nos restantes filhos dimensao=-1)
 * se existir um erro no valor do stock ou no preco unitario(ex serem negativos) serÃ¡ imprimida mensagem de erro e sera armazenado o valor -1 no atributo
 * 
 */
public abstract class Produtos {
    private int identificador;
    private String nome;
    private float precoUnitario;
    private int stock;
    private Promocoes promocao;
    private int dimensao;
 
    /**
     * 
     constroi um objeto tipo produto 
 * @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario  preco da unidade do produto(se este valor for menor que zero Ã© imprimida mensagem de erro e o valor e colocado igual -1) valor em euros
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero Ã© imprimida mensagem de erro e o valor e colocado igual -1)
     * @param promocao objeto do tipo promocao que indica qual a promocao a que o produto pode estar sujeito(pode ser null se nao tiver nenhuma promocao)
     */
    public Produtos(int identificador, String nome, float precoUnitario, int stock, Promocoes promocao) {
        setIdentificador(identificador);
        setNome(nome);
        setPrecoUnitario(precoUnitario);
        setStock(stock);
        setPromocao(promocao);
       
    }
    public Promocoes getPromocao() {
        return promocao;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setPromocao(Promocoes promocao) {
        this.promocao = promocao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }
    
    

    public int getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public float getPrecoUnitario() {
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

    public void setPrecoUnitario(float precoUnitario) {
        if(precoUnitario<=0){
            System.out.println("Preco unitario invalido!");
            this.precoUnitario=-1;
        }else{
        this.precoUnitario = precoUnitario;
        }
    }

    public void setStock(int stock) {
        if (stock<0) {
            System.out.println("Valor de stock invÃ¡lido!");
            this.stock=-1;
        }else{
        this.stock = stock;
        }
    }

    @Override
    public String toString() {
        return "Produtos{" + "identificador=" + identificador + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", stock=" + stock + ", promocao=" + promocao + ", dimensao=" + dimensao + '}';
    }


    
    
    
}
