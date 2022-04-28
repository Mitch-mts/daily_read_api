package mts.mtech.dailyread.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:29 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DailyReadApiResponse {
  private String verse;
  private String number;
  private String chapter;
  private String book;
  private String testament;
  private Long bookId;
  private String uuid;
}
