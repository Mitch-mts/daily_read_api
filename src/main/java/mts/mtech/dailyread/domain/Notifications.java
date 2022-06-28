package mts.mtech.dailyread.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
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
import mts.mtech.dailyread.domain.enums.Status;

/**
 * @author Mitchell Tawanda Severa
 * @created 08/06/2022 - 10:42 PM
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Notifications implements Serializable {
  @Id
  @GeneratedValue(
      generator = "daily_read_sequence",
      strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column
  private String username;
  @Column
  private String recipient;
  @Column
  private String message;
  @Column
  private Status status;
  @Column
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime localDate;
}
