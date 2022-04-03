package mts.mtech.dailyread.api;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 10:16 PM
 */

public class SuccessResult {
  private Long total;

  public SuccessResult() {
  }

  private SuccessResult(Long total) {
    this.total = total;
  }

  public static SuccessResult of(Long total) {
    return new SuccessResult(total);
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "SuccessResult{" +
        "total=" + total +
        '}';
  }
}
