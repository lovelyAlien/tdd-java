package io.hhplus.tdd;

import io.hhplus.tdd.point.CustomException;
import io.hhplus.tdd.point.PointValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PointValidatorUnitTest {

  @InjectMocks
  private PointValidator pointValidator;

  @Test
  @DisplayName("입력 포인트 NULL 검증")
  void 사용_또는_충전_포인트_NULL() {
    // given
    Long amount = null;
    assertThrows(CustomException.class, () -> {
      pointValidator.validateAmount(amount);
    });
  }

  @Test
  @DisplayName("입력 포인트 음수 검증")
  void 사용_또는_충전_포인트_음수() {
    // given
    Long amount = -100_000L;
    assertThrows(CustomException.class, () -> {
      pointValidator.validateAmount(amount);
    });
  }
}
