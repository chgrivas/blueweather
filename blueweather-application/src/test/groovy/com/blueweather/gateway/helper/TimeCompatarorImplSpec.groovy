package com.blueweather.gateway.helper

import spock.lang.Specification

import java.time.Instant

class TimeCompatarorImplSpec extends Specification {

  TimeComparator timeComparator

  def setup() {
    timeComparator = new TimeComparatorImpl()
  }

  def "Instants in the same minute should be detected as same"() {
    given:
      Instant now = Instant.parse("2000-01-01T00:13:30Z")
      Instant later = Instant.parse("2000-01-01T00:13:00Z")
    when:
      def isSame = timeComparator.isInTheSameMinuteWithLastCheck(now, later);
    then:
      isSame
  }

  def "Instants in different minute should be detected as not same"() {
    given:
      Instant now = Instant.parse("2000-01-01T00:20:00Z")
      Instant later = Instant.parse("2000-01-01T00:13:30Z")
    when:
      def isSame = timeComparator.isInTheSameMinuteWithLastCheck(now, later);
    then:
      !isSame
  }

  def "Instants in the same minute of different day should be detected as not same"() {
    given:
      Instant now = Instant.parse("2000-01-02T00:13:30Z")
      Instant later = Instant.parse("2000-01-01T00:13:00Z")
    when:
      def isSame = timeComparator.isInTheSameMinuteWithLastCheck(now, later);
    then:
      !isSame
  }

  def "Instants in the same day should be detected as same"() {
    given:
      Instant now = Instant.parse("2000-01-01T00:13:30Z")
      Instant later = Instant.parse("2000-01-01T00:13:00Z")
    when:
      def isSame = timeComparator.isInTheSameDayWithLastCheck(now, later);
    then:
      isSame
  }

  def "Instants in different day should be detected as not same"() {
    given:
      Instant now = Instant.parse("2000-01-03T00:20:00Z")
      Instant later = Instant.parse("2000-01-01T00:13:30Z")
    when:
      def isSame = timeComparator.isInTheSameDayWithLastCheck(now, later);
    then:
      !isSame
  }

  def "Instants in the same day of different month should be detected as not same"() {
    given:
      Instant now = Instant.parse("2000-03-01T00:13:30Z")
      Instant later = Instant.parse("2000-01-01T00:13:00Z")
    when:
      def isSame = timeComparator.isInTheSameMinuteWithLastCheck(now, later);
    then:
      !isSame
  }
}