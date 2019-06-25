package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "transport_type")
public class TransportType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tt_id")
  private Long id;

  @Column(name = "tt_name")
  private String name;

  public TransportType(String name) {
    this.name = name;
  }
}
