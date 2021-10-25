package Atividade1.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoencaMedicamento {

    public DoencaMedicamento(Doenca doenca, Medicamento medicamento) {
        this.doenca = doenca;
        this.medicamento = medicamento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="doenca_id")
    private Doenca doenca;

    @ManyToOne
    @JoinColumn(name="medicamento_id")
    private Medicamento medicamento;

}
