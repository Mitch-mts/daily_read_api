package mts.mtech.dailyread.error;

import lombok.*;

/**
 * @author Mitchell Tawanda Severa
 * 6/27/18
 * 4:10 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Error {
    private int code;
    private String message;
}
