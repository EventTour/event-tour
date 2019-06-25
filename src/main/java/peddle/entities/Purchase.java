package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "purchase")
public class Purchase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "p_id")
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "p_event")
  private Event event;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "p_transfer_to")
  private Transfer transferTo;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "p_transfer_from")
  private Transfer transferFrom;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "p_accommodation")
  private Accommodation accommodation;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "p_translator")
  private Translator translator;

  @Column(name = "p_photographer")
  private Boolean photographer;

  public Purchase(Event event, Transfer transferTo, Transfer transferFrom,
                  Accommodation accommodation, Translator translator, Boolean photographer) {
    this.event = event;
    this.transferTo = transferTo;
    this.transferFrom = transferFrom;
    this.accommodation = accommodation;
    this.translator = translator;
    this.photographer = photographer;
  }
}
