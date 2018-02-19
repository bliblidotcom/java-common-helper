package com.blibli.oss.common.helper;

import com.blibli.oss.common.helper.config.SampleEnum;
import com.blibli.oss.common.helper.config.Source;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.blibli.oss.common.helper.CommonHelper.denullify;
import static com.blibli.oss.common.helper.CommonHelper.doIfNotNull;
import static com.blibli.oss.common.helper.CommonHelper.getIfNotNull;
import static com.blibli.oss.common.helper.CommonHelper.toLowerCase;
import static com.blibli.oss.common.helper.CommonHelper.toUpperCase;
import static com.blibli.oss.common.helper.CommonHelper.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CommonHelperTest {

  private static final String ROOT_PATH = "src/test/resources/commonHelperTest";

  @Test
  public void denullifyBoolean() {
    Boolean bool = true;
    boolean result = denullify(bool);
    assertEquals(bool, result);

    bool = false;
    result = denullify(bool);
    assertEquals(bool, result);

    bool = null;
    result = denullify(bool);
    assertEquals(false, result);
  }

  @Test
  public void denullifyDouble() {
    Double num = 1.1;
    Double result = denullify(num);
    assertEquals(num, result);

    num = -2.9;
    result = denullify(num);
    assertEquals(num, result);

    num = null;
    result = denullify(num);
    assertEquals(new Double(0.0), result);
  }

  @Test
  public void denullifyDate() {
    Date date = null;
    Date actual = denullify(date);
    assertNotNull(actual);

    date = new Date();
    actual = denullify(date);
    assertEquals(date, actual);
  }

  @Test
  public void denullifyInteger() {
    Integer num = 1;
    int result = denullify(num);
    assertEquals(num, new Integer(result));

    num = -1;
    result = denullify(num);
    assertEquals(num, new Integer(result));

    num = null;
    result = denullify(num);
    assertEquals(0, result);
  }

  @Test
  public void denullifyLong() {
    Long num = 1L;
    long result = denullify(num);
    assertEquals(num, new Long(result));

    num = -2L;
    result = denullify(num);
    assertEquals(num, new Long(result));

    num = null;
    result = denullify(num);
    assertEquals(0L, result);
  }

  @Test
  public void denullifyMap() {
    Map<String, Source> map = null;
    Map<String, Source> actual = denullify(map);
    assertNotNull(actual);

    map = new HashMap<>();
    map.put("one", new Source());
    actual = denullify(map);
    assertEquals(map, actual);
  }

  @Test
  public void denullifyObject() throws InstantiationException, IllegalAccessException {
    Source sampleObject = null;
    Source actual = denullify(sampleObject, Source.class);
    assertNotNull(actual);

    sampleObject = new Source(1, 1.1, "one", SampleEnum.ENUM_ONE);
    actual = denullify(sampleObject, Source.class);
    assertEquals(sampleObject, actual);
  }

  @Test
  public void denullifyString() {
    String str = "str";
    String result = denullify(str);
    assertEquals(str, result);

    str = null;
    result = denullify(str);
    assertEquals("", result);
  }

  @Test
  public void denullifyList() {
    List<String> list = new ArrayList<>();
    list.add("one");

    List<String> result = denullify(list);
    assertEquals(list, result);

    list = null;
    result = denullify(list);
    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  public void denullifySet() {
    Set<String> set = new HashSet<>();
    set.add("one");

    Set<String> result = denullify(set);
    assertEquals(set, result);

    set = null;
    result = denullify(set);
    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  public void doIfNotNull_notNullInput_actionDone() {
    Source source = new Source();
    source.setIntField(11);
    source.setDoubleField(1.1);

    doIfNotNull(source, e -> e.setDoubleField(2.2));
    assertTrue(new Double(2.2).compareTo(source.getDoubleField()) == 0);
    assertEquals(11, source.getIntField());
  }

  @Test
  public void doIfNotNull_nullInput_actionNotDone() {
    Source source = null;
    doIfNotNull(source, e -> e.setDoubleField(2.2));
    assertNull(source);
  }

  @Test
  public void generateUUID() {
    String uuid = CommonHelper.generateUUID();
    assertNotNull(uuid);
  }

  @Test
  public void getIfNotNull_notNullInput_returnsDesiredValue() {
    Source source = new Source();
    source.setIntField(11);

    int result = getIfNotNull(source, e -> e.getIntField());
    assertEquals(source.getIntField(), result);
  }

  @Test
  public void getIfNotNull_nullInput_returnsNull() {
    Source source = null;
    Integer result = getIfNotNull(source, e -> e.getIntField());
    assertNull(result);
  }

  @Before
  public void setUp() {
    new CommonHelper();
  }

  @After
  public void tearDown() {

  }

  @Test
  public void toLowerCase_valid_returnsLowerCasedString() {
    String input = "ThIS iS a strING";
    String expected = "this is a string";

    String result = toLowerCase(input);
    assertEquals(expected, result);
  }

  @Test
  public void toLowerCase_nullInput_returnsNull() {
    String input = null;
    String result = toLowerCase(input);
    assertNull(result);
  }

  @Test
  public void toUpperCase_valid_returnsUpperCasedString() {
    String input = "ThIS iS a strING";
    String expected = "THIS IS A STRING";

    String result = toUpperCase(input);
    assertEquals(expected, result);
  }

  @Test
  public void toUpperCase_nullInput_returnsNull() {
    String input = null;
    String result = toUpperCase(input);
    assertNull(result);
  }

  @Test
  public void valueOf_emptyString_returnsNull() {
    SampleEnum result = valueOf("", SampleEnum.class);
    assertNull(result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void valueOf_invalidStringRepOfEnum_throwsException() {
    valueOf("non-existent-enum", SampleEnum.class);
  }

  @Test
  public void valueOf_validStringRepOfEnum_returnsEnum() {
    SampleEnum result = valueOf("ENUM_ONE", SampleEnum.class);
    assertEquals(SampleEnum.ENUM_ONE, result);
  }
}
