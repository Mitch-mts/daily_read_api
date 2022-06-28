package mts.mtech.dailyread.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.domain.enums.Status;

/**
 * @author Mitchell Tawanda Severa
 * @created 26/05/2022 - 8:38 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccountDto {
  private Long id;
  private String email;
  private String firstname;
  private String lastname;
  private Status status;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateCreated;

  public static UserAccountDto of(UserAccount userAccount){
    return new UserAccountDto(userAccount.getId(),
                        userAccount.getEmail(),
                        userAccount.getFirstname(),
                        userAccount.getLastname(),
                        userAccount.getStatus(),
                        userAccount.getDateCreated());
  }

  public static List<UserAccountDto> of(List<UserAccount> userAccounts){
    return userAccounts.stream().map(UserAccountDto::of).collect(Collectors.toList());
  }
}
