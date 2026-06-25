public class PagamentoPix extends Pagamento {
    private String chavePix;
    private double descontoPix;


    public PagamentoPix(int indiceConsulta, double valorBase, String chavePix, double descontoPix) {
        super(indiceConsulta, valorBase, "Pix");
        this.chavePix = chavePix;
        this.descontoPix = descontoPix;
    }

    //implementação da regra do Pix: valor base - desconto
    @Override
    public double calcularValorFinal() {
        return this.getValorBase() * (1 - descontoPix);
    }

    //getters e setters específicos do Pix
    public String getChavePix() { return chavePix; }
    public void setChavePix(String chavePix) { this.chavePix = chavePix; }
    public double getDescontoPix() { return descontoPix; }
    public void setDescontoPix(double descontoPix) { this.descontoPix = descontoPix; }
}