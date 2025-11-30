package kr.co.polycube.backendtest.domain.lotto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lotto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private int number1;

  @Column(nullable = false)
  private int number2;

  @Column(nullable = false)
  private int number3;

  @Column(nullable = false)
  private int number4;

  @Column(nullable = false)
  private int number5;

  @Column(nullable = false)
  private int number6;

  public Lotto(int[] numbers){
    this.number1 = numbers[0];
    this.number2 = numbers[1];
    this.number3 = numbers[2];
    this.number4 = numbers[3];
    this.number5 = numbers[4];
    this.number6 = numbers[5];
  }

  public int[] toArray() {
    return new int[]{number1, number2, number3, number4, number5, number6};
  }
}
