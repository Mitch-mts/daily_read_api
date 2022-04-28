package mts.mtech.dailyread.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mitchell T Severa
 * 9/4/2018
 * 12:15 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Error {
    private int code;
    private String message;
}
