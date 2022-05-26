package mts.mtech.dailyread.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 8:45 PM
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DailyRead implements Serializable {
  @Id
  @GeneratedValue(
      generator = "daily_read_sequence",
      strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column
  private String reading;
  @Column
  private String verse;
  @Column
  private String chapter;
  @Column
  private String book;
  @Column
  private String testament;
  @Column
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dateCreated;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    DailyRead dailyRead = (DailyRead) o;
    return id != null && Objects.equals(id, dailyRead.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
