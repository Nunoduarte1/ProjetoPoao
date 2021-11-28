import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * objeto alimentares tem calorias, percentagem de Gordura um, identificador, um
 * nome, um preco por unidade, e o seu stock,e um array com as promocaoes a que esta associado
 * se existir um erro no valor do stock ou no preco unitario(ex serem negativos) e gerado uma InputMismatchException
 *
 */
public class Alimentares extends Produtos{

    private int calorias;
    private int percentagemGordura;

    /**
     * connstroi um objeto do tipo alimentares que possui as caracteristicas de
     * um objeto tipo produto 
     *
     * @param calorias numero inteiro que contem o numero de calorias por cada
     * 100g(se este valor for menor que zero gera InputMismatchException)
     * @param percentagemGordura numero inteiro (varia entre 0 e 100) que contem
     * a percentagem de gordura(se este valor for menor que zero ou maior que
     * 100 gera InputMismatchException)
     * @param identificador numero inteiro que permite destinguir
     * inequivocamente os produtos 
     * @param nome string com o nome do produto
     * @param precoUnitario numero inteiro com o preco da unidade do produto(se
     * este valor for menor que zero gera InputMismatchException)
     * @param stock numero inteiro com a quantidade do produto disponivel na
     * loja (se este valor for menor que zero gera InputMismatchException)
     * @param promocao array de promocoes  que indica quais as promocoes a que
     * o produto pode estar sujeito(pode ser null se nao tiver nenhuma promocao)
     *
     */
    public Alimentares(int calorias, int percentagemGordura, int identificador, String nome, float precoUnitario, int stock, ArrayList<Promocoes> promocao) throws InputMismatchException {
        super(identificador, nome, precoUnitario, stock, promocao);        
        setCalorias(calorias);
        setPercentagemGordura(percentagemGordura);
    }

    public int getCalorias() {
        return calorias;
    }

    public int getPercentagemGordura() {
        return percentagemGordura;
    }

    public void setCalorias(int calorias)throws InputMismatchException {
        if (calorias < 0) {
            throw new InputMismatchException("valor de calorias invalido");

        } else {
            this.calorias = calorias;
        }

    }

    public void setPercentagemGordura(int percentagemGordura)throws InputMismatchException {
        if (percentagemGordura < 0 || percentagemGordura > 100) {
            throw new InputMismatchException("valor de percentagem de gordura invalido");

        } else {
            this.percentagemGordura = percentagemGordura;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Alimentares{" + "calorias=" + calorias + ", percentagemGordura=" + percentagemGordura + '}';
    }

}
