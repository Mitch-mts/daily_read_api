package mts.mtech.dailyread.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 8:45 PM
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
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
}
