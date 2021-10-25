package Atividade1.model.enums;

public enum CuidadosMinimos {

    BEBER_AGUA("Beber água"),
    TOMAR_SOL("Tomar sol"),
    CAMINHAR("Caminhar"),
    COMER_VERDURAS("Comer verduras"),
    TOMAR_SORVETE("Tomar sorvete");

    public String descricao;

    CuidadosMinimos(String descricao) {
        this.descricao = descricao;
    }

}
