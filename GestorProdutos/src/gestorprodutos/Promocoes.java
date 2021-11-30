/**
 * 
 * gera uma promocao que tem data de inicio e fim
 *  o identifica serve para ao criar os produtos saber quais as promocoes que lhe estao associadas
 */
public abstract class  Promocoes {
    private Data dataInicio;
    private Data dataFim;
    private int identifica;
    
/**
 * 
 * @param dataInicio data em que a promocao comeca a ser aplicada
 * @param dataFim data em que a promocao deixa de ser aplicada 
 */
    public Promocoes(int identifica,Data dataInicio, Data dataFim) {
        setDataFim(dataFim);
        setDataInicio(dataInicio);
        setIdentifica(identifica);
        
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public int getIdentifica() {
        return identifica;
    }

    public void setIdentifica(int identifica) {
        this.identifica = identifica;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * calcula o preco a pagar pela quantidade do produto a que esta associada e devolve esse valor
     * se for promocao pague tres, por cada 4 unidades sao pagas 3 ou seja quantidade a ser paga= quantidadetotal-(quantidadetotal%4)
     * se for promocao pague menos, por cada unidade a mais do que 1 é acumulado um desconto de 5% ate ao maximo de 50% isto é se levar 11 ou mais unidades daquele produto tenho um desconto de 50%=(quantidade-1)*5 percentagem
     * @param quantidade unidades do produto a serem compradas
     * @param precoUnitario preco por unidade do produto
     * @return valor a ser pago pela quantidade do produto com o desconto incluido
     */
    public abstract float calculaCustoComPromocao(int quantidade, float precoUnitario);
    
    /**
     * verifica se a promocao esta a ser aplicada na data atual, ou seja se a data atua esta entre a data de inicio da promocao e a data final da promoca
     * @param atual data atual
     * @return true se a promocao estiver a ser aplicada, false se a promocao nao esta a ser aplicada
     */
    public boolean descontoValido(Data atual){
        boolean descontoVali=atual.checkData(atual, dataInicio, dataFim);
        return descontoVali;
    }
    @Override
    public String toString() {
        return "Promocoes{" + "dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }
    
}
