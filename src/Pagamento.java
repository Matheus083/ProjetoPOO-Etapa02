public abstract class Pagamento {
    private int indiceConsulta;
    private double valorBase;
    private String tipoPagamento;
    private String status;

    //Construtor para status do pagamento
    public Pagamento(int indiceConsulta, double valorBase, String tipoPagamento) {
        this.indiceConsulta = indiceConsulta;
        this.valorBase = valorBase;
        this.tipoPagamento = tipoPagamento;
        this.status = "PAGO";
    }

    //Getters e Setters
    public int getIndiceConsulta() { return this.indiceConsulta; }
    public void setIndiceConsulta(int indiceConsulta) { this.indiceConsulta = indiceConsulta; }

    public double getValorBase() { return this.valorBase; }
    public void setValorBase(double valorBase) { this.valorBase = valorBase; }

    public String getTipoPagamento() { return this.tipoPagamento; }
    public void setTipoPagamento(String tipoPagamento) { this.tipoPagamento = tipoPagamento; }

    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }

    //Calcula valor final
    public abstract double calcularValorFinal();

    public String exibirResumo() {
        return "Consulta #" + this.indiceConsulta +
                " | Valor Base: R$" + this.valorBase +
                " | Tipo: " + this.tipoPagamento +
                " | Status: " + this.status;
    }
}