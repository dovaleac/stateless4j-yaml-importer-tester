package com.example.nongenerated;

import com.example.generated.Delegate;

public class DelegateImpl implements Delegate<String> {

  private final StringBuilder stringBuilder = new StringBuilder();

  String currentHistory() {
    return stringBuilder.toString();
  }

  @Override
  public void entry1() {
    stringBuilder.append("entry1").append('\n');
  }

  @Override
  public void entry21(Integer height) {
    stringBuilder.append("entry21 ").append(height).append('\n');
  }

  @Override
  public void entry22(ParameterizedClass<String, Double> param1, Integer param2) {
    stringBuilder.append("entry22 ").append(param1).append(" ").append(param2).append('\n');
  }

  @Override
  public void exit1() {
    stringBuilder.append("exit1").append('\n');
  }

  @Override
  public void exit31() {
    stringBuilder.append("exit31").append('\n');
  }

  @Override
  public void exit32() {
    stringBuilder.append("exit32").append('\n');
  }
}
