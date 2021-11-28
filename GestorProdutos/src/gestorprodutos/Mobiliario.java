/**
 *
 * objeto mobiliario tem peso, dimensao,  identificador, um nome, um preco por unidade, e o seu stock array de promocoes
 * se os valores de peso e dimensao forem invalido(menores ou iguais a zero)gera InputMismatchException
 */
public class Mobiliario extends Produtos{
    private int peso;
    private int dimensao;
/**
 * 
 * @param peso numero inteiro que possui o peso do movel(gera InputMismatchException) em kg
 * @param dimensao numero inteiro que possui a dimensao do movel(se for menor ou igual a zero gera InputMismatchException)
* @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario numero inteiro com o preco da unidade do produto(se este valor for menor que zero Ã© imprimida mensagem de erro e o valor e colocado igual -1)
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero Ã© imprimida mensagem de erro e o valor e colocado igual -1)
* @param promocao array de promocoes  que indica quais a promocoes a que o produto pode estar sujeito(pode ser null se nao tiver nenhuma promocao)
 
 */


    public Mobiliario(int peso, int dimensao, int identificador, String nome, float precoUnitario, int stock, ArrayList<Promocoes> promocao)throws InputMismatchException {
        super(identificador, nome, precoUnitario, stock, promocao);
        setDimensao(dimensao);
        setPeso(peso);
        

    }
    
    

    public int getPeso() {
        return peso;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setPeso(int peso) throws InputMismatchException{
        if (peso<=0) {
            throw new InputMismatchException("valor do peso invalido");
        }else{
        this.peso = peso;
        }
    }

    public void setDimensao(int dimensao)throws InputMismatchException {
        if (dimensao<=0) {
            throw new InputMismatchException("valor de dimensao invalido");
        }else{
        this.dimensao = dimensao;
    }}

    @Override
    public String toString() {
        return super.toString()+"Mobiliario{" + "peso=" + peso + ", dimensao=" + dimensao + '}';
    }
    
}
