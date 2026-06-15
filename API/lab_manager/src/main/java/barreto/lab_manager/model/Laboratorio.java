package barreto.lab_manager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LABORATORIO")
public class Laboratorio {
    @Id
    @Column(name = "id_laboratorio")
    private Integer idLaboratorio;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(nullable = false, length = 30)
    private String bloco;
}