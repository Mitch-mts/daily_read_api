package mts.mtech.dailyread.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:29 PM
 */

public class DailyReadApiResponse {
  private String verse;
  private String number;
  private String chapter;
  private String book;
  private String testament;
  private Long bookId;
  private String uuid;

  public DailyReadApiResponse() {
  }

  private DailyReadApiResponse(String verse, String number, String chapter, String book,
      String testament, Long bookId, String uuid) {
    this.verse = verse;
    this.number = number;
    this.chapter = chapter;
    this.book = book;
    this.testament = testament;
    this.bookId = bookId;
    this.uuid = uuid;
  }

  public static DailyReadApiResponse of(String verse, String number, String chapter, String book,
      String testament, Long bookId, String uuid) {
    return new DailyReadApiResponse(verse, number, chapter, book, testament, bookId, uuid);
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

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  @Override
  public String toString() {
    return "DailyReadApiResponse{" +
        "verse='" + verse + '\'' +
        ", number='" + number + '\'' +
        ", chapter='" + chapter + '\'' +
        ", book='" + book + '\'' +
        ", testament='" + testament + '\'' +
        ", bookId=" + bookId +
        ", uuid='" + uuid + '\'' +
        '}';
  }
}
