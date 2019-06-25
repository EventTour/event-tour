package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "event_extra")
public class EventExtra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ee_id")
  private Long id;

  @Column(name = "ee_photo")
  private String photo;

  @Column(name = "ee_description")
  private String description;

  public EventExtra(String photo, String description) {
    this.photo = photo;
    this.description = description;
  }
}
