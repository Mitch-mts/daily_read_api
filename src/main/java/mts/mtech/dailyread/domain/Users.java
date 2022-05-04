package mts.mtech.dailyread.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mts.mtech.dailyread.domain.enums.Status;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:19 PM
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class Users implements Serializable {
  @Id
  @GeneratedValue(
      generator = "daily_read_sequence",
      strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column
  private String email;
  @Column
  private String firstname;
  @Column
  private String lastname;
  @Column
  @Enumerated(EnumType.STRING)
  private Status status;
  @Column
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dateCreated;
}
