package mts.mtech.dailyread.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 10:13 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse {
  private SuccessResult success;
  private DailyReadApiResponse contents;
}
