public class PagamentoCartao extends Pagamento {
    private String bandeira;
    private int parcelas;
    private double taxaCartao;

    public PagamentoCartao(int indiceConsulta, double valorBase, String bandeira, int parcelas, double taxaCartao) {
        super(indiceConsulta, valorBase, "Cartão");
        this.bandeira = bandeira;
        this.parcelas = parcelas;
        this.taxaCartao = taxaCartao;
    }

    //implementação da regra do cartão: valor base + taxa
    @Override
    public double calcularValorFinal() {
        return this.getValorBase() * (1 + taxaCartao);
    }

    //getters e setters específicos do cartão
    public String getBandeira() { return bandeira; }
    public void setBandeira(String bandeira) { this.bandeira = bandeira; }
    public int getParcelas() { return parcelas; }
    public void setParcelas(int parcelas) { this.parcelas = parcelas; }
    public double getTaxaCartao() { return taxaCartao; }
    public void setTaxaCartao(double taxaCartao) { this.taxaCartao = taxaCartao; }
}