public abstract class Cliente {
    private String nome;
    private String morada;
    private String email;
    private String telefone;
    private String dataDeNascimento;
    

    public Cliente(String nome, String morada, String email, String telefone, String dataDeNascimento) {
        setDataDeNascimento(dataDeNascimento);
        setEmail(email);
        setMorada(morada);
        setNome(nome);
        setTelefone(telefone);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
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
   public abstract int calculaPrecoViagem(int numMoveisComPesoSuperior,float despesa);

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                '}';
    }
}
