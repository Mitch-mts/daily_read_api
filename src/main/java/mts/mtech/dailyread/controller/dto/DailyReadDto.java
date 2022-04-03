package mts.mtech.dailyread.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import mts.mtech.dailyread.domain.DailyRead;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:02 PM
 */

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getVerse() {
    return verse;
  }

  public void setVerse(String verse) {
    this.verse = verse;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getChapter() {
    return chapter;
  }

  public void setChapter(String chapter) {
    this.chapter = chapter;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public String getTestament() {
    return testament;
  }

  public void setTestament(String testament) {
    this.testament = testament;
  }

  public LocalDate getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDate dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public String toString() {
    return "DailyReadDto{" +
        "id=" + id +
        ", verse='" + verse + '\'' +
        ", number='" + number + '\'' +
        ", chapter='" + chapter + '\'' +
        ", book='" + book + '\'' +
        ", testament='" + testament + '\'' +
        ", dateCreated=" + dateCreated +
        '}';
  }
}
