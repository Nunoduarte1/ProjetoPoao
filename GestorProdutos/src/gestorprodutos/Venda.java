import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * venda representa uma compra realizada por um user, tem o carrinho de compras, um cliente e a data em que a compra foi feita
 * 
 */
public class Venda {
    private ArrayList<ProdutoNoCarrinho> carrinhoCompras;

    private Cliente cliente;
    private Data dataAtual;
    
/**
 * 
 * @param cliente cliente que esta a fazer a compra
 * @param dataAtual data em  que acompra foi feita
 */
    public Venda(Cliente cliente, Data dataAtual) {
        carrinhoCompras=new ArrayList<>();

        setCliente(cliente);
        setDataAtual(dataAtual);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataAtual(Data dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Data getDataAtual() {
        return dataAtual;
    }
/**
 * adicionar itens ao carrinho de compras
 * ver se o item ja la esta, e nesse caso so necessito de aumentar a quantidade, ao aumentar a quantidade se esta passar do valor disponivel em stock gera InputMismatchException e mantem a quantidade anterior
 * se o produto nao estiver no carrinho entao gerado um ProdutoNoCarrinho que contem o produto e a quantidade, 
 * @param prod produto que vou adicionar ao carrinho
 * @param quant quantidade a ser adicionada ao carrinho
 * @throws InputMismatchException 
 */
    public void addToCarrinhoCompras(Produtos prod,int quant)throws InputMismatchException {//ve se o prod ja esta no carrinho se ja estiver ve se a nova quantidade somada com a anterior passa o valor do stock se nao passar é adicionado se passar imprime msg de erro e fica com o valor anterior, se nao estiver no carrinho o item e adicionado ao carrinho
         for(ProdutoNoCarrinho i: carrinhoCompras){
             if(i.getProduto().equals(prod)){//sinal que o produto que estou a adicionar ao carrinho ja la estava quero apenas aumentar a quantidade,,!! tenho de gerar uma excessao aqui por causa do aumento do stock e se nao der para aumentar o csotk deixar o que la estava
                 int quantidadeAnterior=i.getQuantidade();
                 if (quant+quantidadeAnterior>i.getProduto().getStock()) {
                     throw new InputMismatchException("não esta disponivel a quantidade pretendida, sera mantida a quantidade anterior no carrinho");
                 }
                 i.setQuantidade(quant+quantidadeAnterior);// se apanhar aqui o erro deixo ficar o que ja estava 
                 return;// se o produto for aqui colocado ja nao preciso de o adicionar outra vez
             }
        }
        
        ProdutoNoCarrinho itemNovo=new ProdutoNoCarrinho(prod,quant);
        carrinhoCompras.add(itemNovo);    
    }
    
    /**
     * no final da venda e reduzido o stock consoante o numero de itens comprados
     */
    public void atualizaStock(){// chamada quando o cliente acaba a sua compra, serve para reduzir os produtos comprados ao stock da loja
        for(ProdutoNoCarrinho i:carrinhoCompras){
            int novoStock=i.getProduto().getStock()-i.getQuantidade();
            i.getProduto().setStock(novoStock);
        }
    }
    /**
     * calcula o preco das compras no carrinho de compras, sempre que algum produto tenha desconto  valido( tem de se verificar com a data do desconto se este ainda esta valido para a data atual)
     * @return valor em euros do preco das compras no carrinho 
     */
    public float calculaPrecoCompras(){// penso que seja private pq so ira ser chamado aqui dentro para ser calculado o valor do preco total
        ArrayList<Promocoes> promocoes;
        float precoCompras=0;
        int quantidade=0;
        boolean naoTemDesconto;
        for (ProdutoNoCarrinho i: carrinhoCompras){
            naoTemDesconto=true;
            quantidade=i.getQuantidade();
            promocoes=i.getProduto().getPromocao();
            for (Promocoes j:promocoes) {// ver se o que se le de ficheiros sai a null ou a zero se nao tiver la nenhum paramentro 
                if (j!=null && j.descontoValido(dataAtual)) {// se nao tiver desconto o j esta a null se tiver algum desconto vou ver se esta valido para a data atual
                    precoCompras+=j.calculaCustoComPromocao(i.getQuantidade(),i.getProduto().getPrecoUnitario());
                   naoTemDesconto=false;
                }
            }
            if(naoTemDesconto){// nao havia qualquer desconto aplicavel para a data atual
                precoCompras+=i.getQuantidade()*i.getProduto().getPrecoUnitario();
            }
              
        }// ver se há problema em ser comboios se nao sera melhor criar outras variaveis por exemplo ter uma variavel produto em vez de estar sempre a usar i.getprod
        return precoCompras;
    }


    /**
     * calcula o custo final da compra, tem de adicionar o valor do transporte ao valor das compras no carrinho
     * para calcular o valor do transporte conta o numero de moveis com peso superior a 15 kg e usa um metodo da class cliente que calcula o valor do transporte
     * @return o valor em euros do custo final
     */
    public float calculaCustoFinal(){// provavelmente em vez de ter ali um paramentro dimensao irei ter um paramentro peso no pai e irei usar diretamente esse paramentro
        float custoCompras=calculaPrecoCompras();
        int numeroMoveisPesoSuperior=0;
        int peso;
        for (ProdutoNoCarrinho i:carrinhoCompras){
            if(i.getProduto().getIdentificador()/10000==1){// ve qual o digito na esquerda de identividador ( se for 1 e mobilia 
                Mobiliario movel=(Mobiliario)(i.getProduto());
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
