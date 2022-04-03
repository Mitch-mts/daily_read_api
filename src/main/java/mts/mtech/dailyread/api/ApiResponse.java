package mts.mtech.dailyread.api;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 10:13 PM
 */

public class ApiResponse {
  private SuccessResult success;
  private DailyReadApiResponse contents;

  public ApiResponse() {
  }

  public ApiResponse(SuccessResult success,
      DailyReadApiResponse contents) {
    this.success = success;
    this.contents = contents;
  }

  public SuccessResult getSuccess() {
    return success;
  }

  public void setSuccess(SuccessResult success) {
    this.success = success;
  }

  public DailyReadApiResponse getContents() {
    return contents;
  }

  public void setDailyReadApiResponse(DailyReadApiResponse content) {
    this.contents = content;
  }

  @Override
  public String toString() {
    return "ApiResponse{" +
        "success=" + success +
        ", content=" + contents +
        '}';
  }
}
