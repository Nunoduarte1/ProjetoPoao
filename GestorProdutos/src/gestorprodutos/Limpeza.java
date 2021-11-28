import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *objeto limpeza tem toxicidade, identificador, um nome, um preco por unidade, e o seu stock e um array com as promocoes a que esta sujeito, 
 * se existir erro no valor de toxicidade (fora do intervalo [0,10]) gera iInputMismatchException
 * 
 */
public class Limpeza extends Produtos{
    private int toxicidade;

    /**
     * @param toxicidade numero inteiro entre 0 e 10 representa a toxicidade do produto(se valor for invalido gera InputMismatchException)
     * @param identificador numero inteiro que permite destinguir inequivocamente os produtos
 * @param nome string com o nome do produto
 * @param precoUnitario numero inteiro com o preco da unidade do produto(se este valor for menor que zero gera InputMismatchException)
 * @param stock numero inteiro com a quantidade do produto disponivel na loja (se este valor for menor que zero gera InputMismatchException)
     * @param promocao darray de promocoes  que indica qual as promocoes a que o produto pode estar sujeito(pode ser null se nao tiver nenhuma promocao)
 
     */
  
    public Limpeza(int toxicidade, int identificador, String nome, float precoUnitario, int stock, ArrayList<Promocoes> promocao) throws InputMismatchException {
        super(identificador, nome, precoUnitario, stock, promocao);

        
        setToxicidade(toxicidade);
    }
    

    public void setToxicidade(int toxicidade)throws InputMismatchException {
        if (toxicidade<0 || toxicidade>10) {
            throw new InputMismatchException("valor de toxicidade invalido");
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

