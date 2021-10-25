package Atividade1.repository;

import Atividade1.model.Receituario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceituarioRepository extends JpaRepository<Receituario, Long> {

    Receituario findTopByOrderByIdDesc();

}
