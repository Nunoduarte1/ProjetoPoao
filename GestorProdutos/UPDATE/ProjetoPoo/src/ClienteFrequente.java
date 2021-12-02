/**
 *
 * @author emanuel
 */
public class ClienteFrequente extends Cliente{

    public ClienteFrequente(String nome, String morada, String email, String telefone, String dataDeNascimento) {
        super(nome, morada, email, telefone, dataDeNascimento);
    }
    /**
     * calcula o preço combrado pela transporte das compras ao domicilio
     * se o cliente for frequente nao paga transporte para compras superiores a 40 euros, se forem inferiores paga 15 euros
     * se o cliente for normal paga 20 euros do transporte
     *  o cliente paga 10 euros adicionais por cada movel com peso superior a 15kg(numMoveisComPesoSuperior)
     * @param numMoveisComPesoSuperior numero de moveis com peso superior a 15kg
     * @param despesa preço dos artigos presentes no carrinho de compras em euros
     * @return custo do transporte ao domicilio em euros
     */
    @Override
    public int calculaPrecoViagem(int numMoveisComPesoSuperior,float despesa) {
        int precoViagem=0;
        precoViagem+=numMoveisComPesoSuperior*10;
        if (despesa<40) {
            precoViagem+=15;
        }
        return precoViagem;
    }

    @Override
    public String toString() {
        return "ClienteFrequente{" + super.toString()+'}';
    }

}