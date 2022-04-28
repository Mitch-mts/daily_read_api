package mts.mtech.dailyread.service.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mts.mtech.dailyread.domain.DailyRead;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 10:10 PM
 */
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
  private String email;
  private String firstname;
  private String lastname;
  private DailyRead dailyRead;
}
