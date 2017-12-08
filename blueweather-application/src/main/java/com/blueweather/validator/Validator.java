package com.blueweather.validator;

public interface Validator<T>
{
  public boolean isValid(T object);
}
