package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "translator")
public class Translator {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "trl_id")
  private Long id;

  @Column(name = "trl_language")
  private String language;

  public Translator(String language) {
    this.language = language;
  }
}
