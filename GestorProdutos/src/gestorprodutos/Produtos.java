import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *Objeto produto tem um identificador, um nome, um preco por unidade,o seu stock, um array de promocoes associada(pode ser null se nao tiver nenhuma promocao)
 * se existir um erro no valor do stock ou no preco unitario(ex serem negativos) gera InputMismatchException
 * o identificador tem 5 digitos, o digito da esquerda se 1->mobilia, 2-> limpeza,3-> comida qualquer outro digito a esquerda gera InputMismatchException
 * 
 */
public abstract class Produtos {
    private int identificador;// !! tem pelomenos 5 digitos o digito da esquerda se 1->mobilia, 2-> limpeza,3-> comida
    private String nome;
    private float precoUnitario;
    private int stock;
    private ArrayList<Promocoes> promocao;

 
    /**
     * 
     constroi um objeto tipo produto 
 * @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario  preco da unidade do produto(se este valor for menor que zero Ã© imprimida mensagem de erro e o valor e colocado igual -1) valor em euros
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero Ã© imprimida mensagem de erro e o valor e colocado igual -1)
     * @param promocao array de promocoes que indica quais as promocoes a que o produto pode estar sujeito(pode ser null se nao tiver nenhuma promocao)
     */
    public Produtos(int identificador, String nome, float precoUnitario, int stock,ArrayList<Promocoes> promocao) throws InputMismatchException{
        setIdentificador(identificador); //5 1-> moveis 2-> alimento 3-> limpeza /10000
        
        setNome(nome);
        setPrecoUnitario(precoUnitario);
        setStock(stock);
        setPromocao(promocao);
      
       
    }

    public void setPromocao(ArrayList<Promocoes> promocao) {
        this.promocao = promocao;
    }

    public ArrayList<Promocoes> getPromocao() {
        return promocao;
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

    public void setIdentificador(int identificador) throws InputMismatchException{
        if (identificador/10000>3 || identificador/10000<1) {// identificador tem 5 digitos, o digito da esquerda se for 1-> movel, 2-> alimento,3->limpeza
            throw new InputMismatchException("valor do identificador invalido");
        }
        this.identificador = identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoUnitario(float precoUnitario)throws InputMismatchException {// estas verificaçoes iram ser feitas usando excessoes 
        if(precoUnitario<=0){
            throw new InputMismatchException("valor do preco unitario invalido");
        }else{
        this.precoUnitario = precoUnitario;
        }
    }

    public void setStock(int stock)throws InputMismatchException {
        if (stock<0) {
            throw new InputMismatchException("valor do stock invalido");
        }else{
        this.stock = stock;
        }
    }

    @Override
    public String toString() {
        return "Produtos{" + "identificador=" + identificador + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", stock=" + stock + ", promocao=" + promocao + '}';
    }


    
    
    
}
