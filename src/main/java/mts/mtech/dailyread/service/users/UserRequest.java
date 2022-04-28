package mts.mtech.dailyread.service.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:27 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class UserRequest {
  private String email;
  private String firstname;
  private String lastname;
}
