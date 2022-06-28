package mts.mtech.dailyread.service.save.validations;

/**
 * @author Mitchell Tawanda Severa
 * @created 19/06/2022 - 5:30 PM
 */
@FunctionalInterface
public interface ValidationService <T>{
  void validate(T t);
}
