package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_id")
  private Long id;

  @Column(name = "c_name")
  private String name;

  public City(String name) {
    this.name = name;
  }
}
