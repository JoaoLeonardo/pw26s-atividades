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
public class ReceituarioDoenca {

    public ReceituarioDoenca(Receituario receituario, Doenca doenca) {
        this.receituario = receituario;
        this.doenca = doenca;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="receituario_id")
    private Receituario receituario;

    @ManyToOne
    @JoinColumn(name="doenca_id")
    private Doenca doenca;

}
