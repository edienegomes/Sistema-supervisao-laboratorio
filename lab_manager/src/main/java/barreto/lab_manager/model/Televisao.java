
package barreto.lab_manager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "TELEVISAO")
@PrimaryKeyJoinColumn(name = "id_reproducao")
public class Televisao extends Reproducao {
    // sem atributos próprios
}