import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Venda {
    
    private Map<Produtos,Integer> carrinhoCompras; 
    private Cliente cliente;
    private String dataAtual;
    

    public Venda(Cliente cliente, String dataAtual) {
        carrinhoCompras= new HashMap<Produtos,Integer>(); 
        setCliente(cliente);
        setDataAtual(dataAtual);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public Map<Produtos, Integer> getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void addToCarrinhoCompras(Produtos prod,int quant) {//ve se o prod ja esta no carrinho se ja estiver ve se a nova quantidade somada com a anterior passa o valor do stock se nao passar é adicionado se passar imprime msg de erro e fica com o valor anterior, se nao estiver no carrinho o item e adicionado ao carrinho
        if(carrinhoCompras.containsKey(prod)){
            int valAnterior=carrinhoCompras.get(prod);
            if (valAnterior+quant>prod.getStock()) {
                System.out.println("nao temos disponivel a quantidade que deseja em stock, sera mantida a quantidade anterior do produto no seu carrinho");
                return;
            }else{
             carrinhoCompras.put(prod,valAnterior+quant);
            }
        }else{
             carrinhoCompras.put(prod,quant);//ao deixar o user escolher uma quantidade temos de garantir que essa quantidade seja menor que o stock do prod
        }
    }
    
    public void atualizaStock(){// chamada quando o cliente acaba a sua compra, serve para reduzir os produtos comprados ao stock da loja
        for(Produtos i:carrinhoCompras.keySet()){
            int novoStock=i.getStock()-carrinhoCompras.get(i);
            i.setStock(novoStock);
        }
    }
    /**
     * calcula o preco das compras no carrinho de compras, sempre que algum produto tenha desconto  valido( tem de se verificar com a data do desconto se este ainda esta valido para a data atual)
     * @return valor em euros do preco das compras no carrinho 
     */
    public float calculaPrecoCompras(){// penso que seja private pq so ira ser chamado aqui dentro para ser calculado o valor do preco total
        float precoCompras=0;
        int quantidade=0;
        for(Produtos i:carrinhoCompras.keySet()){
            quantidade=carrinhoCompras.get(i);
            if (i.getPromocao()!=null && descontoValido(i.getPromocao())) {
                precoCompras+=i.getPromocao().calculaCustoComPromocao(quantidade,i.getPrecoUnitario());
            }else{
                precoCompras+=quantidade*i.getPrecoUnitario();
            }
        }
        return precoCompras;
    }

    //penso que seja private pq so ira ser chamado aqui dentro
    private boolean descontoValido(Promocoes promocao) {//!!!!! este metodo nao está criado, vai depender de como metemos as datas
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public float calculaCustoFinal(){
        float custoCompras=calculaPrecoCompras();
        int numeroMoveisPesoSuperior=0;
        
        for(Produtos i:carrinhoCompras.keySet()){
            if(i.getDimensao()>0){// e um movel 
                Mobiliario movel=(Mobiliario)i;
                if(movel.getPeso()>15){
                    numeroMoveisPesoSuperior++;
                }
            }
        }
        float custoTransporte=cliente.calculaPrecoViagem(numeroMoveisPesoSuperior, custoCompras);
        
        float precoFinal=custoCompras+custoTransporte;
        return precoFinal;
    }
    
    
     
}
