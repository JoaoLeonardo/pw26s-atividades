package Atividade1.model;

import Atividade1.model.enums.CuidadosMinimos;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoencaCuidadosMinimos {

    public DoencaCuidadosMinimos(Doenca doenca, CuidadosMinimos cuidadoMinimo) {
        this.doenca = doenca;
        this.cuidadoMinimo = cuidadoMinimo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="doenca_id")
    private Doenca doenca;

    @Column
    @Enumerated(EnumType.STRING)
    private CuidadosMinimos cuidadoMinimo;

}
