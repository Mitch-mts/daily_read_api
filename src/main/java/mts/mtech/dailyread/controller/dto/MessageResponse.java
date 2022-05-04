package mts.mtech.dailyread.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Mitchell Tawanda Severa
 * @created 04/05/2022 - 8:29 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MessageResponse {
  private String message;
  private Object object;
}
