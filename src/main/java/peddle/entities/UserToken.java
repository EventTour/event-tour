package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class UserToken {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "token_id")
  private Long id;

  @Column(name = "token")
  private String token;

  @OneToOne
  @JoinColumn(name = "u_id", updatable = false, unique = true, nullable = false)
  private User user;

}
