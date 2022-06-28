package mts.mtech.dailyread.service.email;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Mitchell Tawanda Severa
 * @created 06/11/2020 - 10:56 PM
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private String subject;
    private String sentBy;
    private String body;
    private Medium medium;
    private String sentByPersonal;
    private String recipients;
}
