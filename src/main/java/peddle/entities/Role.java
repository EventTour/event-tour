package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "r_id")
  private Long id;

  @Column(name = "r_name")
  private String name;

  public Role(String name) {
    this.name = name;
  }
}
