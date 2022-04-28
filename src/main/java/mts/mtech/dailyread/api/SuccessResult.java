package mts.mtech.dailyread.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 10:16 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SuccessResult {
  private Long total;
}
