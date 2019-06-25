package peddle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "accommodation")
public class Accommodation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "a_id")
  private Long id;

  @Column(name = "a_name")
  private String name;

  @Column(name = "a_owner")
  private Long owner;

  @Column(name = "a_price")
  private int price;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "a_location")
  private City city;

  @Column(name = "a_min_order_time")
  private int minOrderTime;

  public Accommodation(String name, Long owner, int price, City city, int minOrderTime) {
    this.name = name;
    this.owner = owner;
    this.price = price;
    this.city = city;
    this.minOrderTime = minOrderTime;
  }
}
