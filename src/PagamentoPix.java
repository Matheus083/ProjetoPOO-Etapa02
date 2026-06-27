public class PagamentoPix extends Pagamento implements Exportavel {
    private String chavePix;

    public PagamentoPix(int indiceConsulta, double valorBase, String chavePix) {
        super(indiceConsulta, valorBase, "Pix");
        this.chavePix = chavePix;
    }


    @Override
    public double calcularValorFinal() {
        // já apliquei o desconto de 5% também
        return this.getValorBase() * 0.95;
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo() + " | Chave Pix: " + this.chavePix;
    }

    @Override
    public String exportarDados() {
        return "PIX;" + getIndiceConsulta() + ";" + getValorBase() + ";" + calcularValorFinal();
    }

    //getters e settsers
    public String getChavePix() { return this.chavePix; }
    public void setChavePix(String chavePix) { this.chavePix = chavePix; }
}