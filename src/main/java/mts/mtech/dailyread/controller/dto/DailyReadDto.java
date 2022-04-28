package mts.mtech.dailyread.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mts.mtech.dailyread.domain.DailyRead;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:02 PM
 */
@NoArgsConstructor
@Data
@Builder
public class DailyReadDto {
  private Long id;
  private String verse;
  private String number;
  private String chapter;
  private String book;
  private String testament;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dateCreated;

  private DailyReadDto(Long id, String verse, String number, String chapter, String book,
      String testament, LocalDate dateCreated) {
    this.id = id;
    this.verse = verse;
    this.number = number;
    this.chapter = chapter;
    this.book = book;
    this.testament = testament;
    this.dateCreated = dateCreated;
  }

  public static DailyReadDto of(DailyRead dailyRead) {
    return new DailyReadDto(dailyRead.getId(),
        dailyRead.getVerse(),
        dailyRead.getNumber(),
        dailyRead.getChapter(),
        dailyRead.getBook(),
        dailyRead.getTestament(),
        dailyRead.getDateCreated());
  }
}
