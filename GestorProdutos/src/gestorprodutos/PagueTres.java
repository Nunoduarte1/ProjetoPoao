public class PagueTres extends Promocoes{

    public PagueTres(String dataInicio, String dataFim) {
        super(dataInicio, dataFim);
    }
    /**
     * calcula o preco a pagar pela quantidade do produto a que esta associada e devolve esse valor
     * se for promocao pague tres, por cada 4 unidades sao pagas 3 ou seja quantidade a ser paga= quantidadetotal-(quantidadetotal%4)
     * se for promocao pague menos, por cada unidade a mais do que 1 é acumulado um desconto de 5% ate ao maximo de 50% isto é se levar 11 ou mais unidades daquele produto tenho um desconto de 50%=(quantidade-1)*5 percentagem
     * @param quantidade unidades do produto a serem compradas
     * @param precoUnitario preco por unidade do produto
     * @return valor a ser pago pela quantidade do produto com o desconto incluido
     */
    @Override
    public float calculaCustoComPromocao(int quantidade,float precoUnitario) {
   
     quantidade=quantidade-quantidade%4;
     float custoComPromocao=quantidade*precoUnitario;
    
    return custoComPromocao;
    
 }

    @Override
    public String toString() {
        return super.toString()+"PagueTres{" + '}';
    }


    
}

