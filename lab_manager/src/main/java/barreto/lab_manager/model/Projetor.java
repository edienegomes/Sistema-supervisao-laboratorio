package barreto.lab_manager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "PROJETOR")
@PrimaryKeyJoinColumn(name = "id_reproducao")
public class Projetor extends Reproducao {
    // sem atributos próprios
}