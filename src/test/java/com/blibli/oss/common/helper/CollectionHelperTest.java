package com.blibli.oss.common.helper;

import com.blibli.oss.common.helper.config.SampleEnum;
import com.blibli.oss.common.helper.config.Source;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionHelperTest {

  private Source source1;
  private Source source2;

  @Test
  public void addToList_nullListAndNullElementArg_returnsNull() {
    List<Source> list = null;
    List<Source> result = CollectionHelper.addToList(list, null);
    assertNull(result);
  }

  @Test
  public void addToList_nullListAndNullElements_returnsNewEmptyArrayList() {
    List<Source> list = null;
    Source source1 = null;
    Source source2 = null;
    List<Source> result = CollectionHelper.addToList(list, source1, source2);
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  @Test
  public void addToList_nullListAndNonNullElements_returnsNewArrayListWithElements() {
    List<Source> list = null;
    Source source1 = new Source(1, 1.1, "one", SampleEnum.ENUM_ONE);
    Source source2 = new Source();

    List<Source> result = CollectionHelper.addToList(list, source1, source2);
    assertNotNull(result);
    assertEquals(2, result.size());
    assertTrue(result.contains(source1));
    assertTrue(result.contains(source2));
  }

  @Test
  public void addToList_nonNullListAndNonNullElements_returnsListAppendedWithElements() {
    Source source1 = new Source(1, 1.1, "one", SampleEnum.ENUM_ONE);
    Source source2 = new Source();
    Source source3 = new Source(3, 3.3, "three", SampleEnum.ENUM_THREE);

    List<Source> list = new ArrayList<>();
    list.add(source1);

    List<Source> result = CollectionHelper.addToList(list, source2, source3);
    assertNotNull(result);
    assertEquals(3, result.size());
    assertTrue(list.contains(source1));
    assertTrue(list.contains(source2));
    assertTrue(list.contains(source3));
  }

  @Test
  public void findInCollection_matchFound_returnsMatchingElement() {
    Set<Source> sources = new HashSet<>();
    sources.add(source1);
    sources.add(source2);

    Source result = CollectionHelper.findInCollection(sources, s -> "two".equals(s.getStringField()));
    assertNotNull(result);
    assertEquals(2, result.getIntField());
  }

  @Test
  public void findInCollection_matchNotFound_returnsNull() {
    Set<Source> sources = new HashSet<>();
    sources.add(source1);
    sources.add(source2);

    Source result = CollectionHelper.findInCollection(sources, s -> "three".equals(s.getStringField()));
    assertNull(result);
  }

  @Test
  public void findInCollection_emptyCollection_returnsNull() {
    Set<Source> sources = new HashSet<>();

    Source result = CollectionHelper.findInCollection(sources, s -> "two".equals(s.getStringField()));
    assertNull(result);
  }

  @Test
  public void findInCollection_nullCollection_returnsNull() {
    Set<Source> sources = null;

    Source result = CollectionHelper.findInCollection(sources, s -> "two".equals(s.getStringField()));
    assertNull(result);
  }

  @Test
  public void forEach_nullFunction_noAction() {
    List<Source> sources = new ArrayList<>();
    sources.add(new Source());
    CollectionHelper.forEach(sources, null);
    assertNotNull(sources);
  }

  @Test
  public void forEach_nullCollection_noAction() {
    List<Source> sources = null;
    CollectionHelper.forEach(sources, e -> e.setDoubleField(3.0));
    assertNull(sources);
  }

  @Test
  public void forEach_emptyCollection_noAction() {
    List<Source> sources = new ArrayList<>();
    CollectionHelper.forEach(sources, e -> e.setDoubleField(1.0));
    assertNotNull(sources);
  }

  @Test
  public void forEach_setValueOnSourceCollection_elementsUpdated() {
    double expectedField = 5.5;
    List<Source> sources = new ArrayList<>();
    sources.add(new Source());
    CollectionHelper.forEach(sources, e -> e.setDoubleField(expectedField));
    assertNotNull(sources);
  }

  @Test
  public void forEach_setValueOnSourceCollectionWithCondition_elementsUpdated() {
    double expectedField = 5.5;
    Source source1 = new Source();
    source1.setSampleEnum(SampleEnum.ENUM_ONE);
    source1.setDoubleField(1.0);

    Source source2 = new Source();
    source2.setSampleEnum(SampleEnum.ENUM_TWO);
    source2.setDoubleField(2.0);

    List<Source> sources = new ArrayList<>();
    sources.add(source1);
    sources.add(source2);

    CollectionHelper.forEach(sources, e -> {
      if (SampleEnum.ENUM_ONE.equals(e.getSampleEnum())) {
        e.setDoubleField(e.getDoubleField() * expectedField);
      }
    });
    assertNotNull(sources);

    for (Source source : sources) {
      if (SampleEnum.ENUM_ONE.equals(source.getSampleEnum())) {
        assertEquals(expectedField, source.getDoubleField(), 0);
      }
    }
  }

  @Test
  public void isEmptyCollection_notEmptyCollection_returnsFalse() {
    List<Source> sources = new ArrayList<>();
    sources.add(source1);

    boolean result = CollectionHelper.isEmpty(sources);
    assertFalse(result);
  }

  @Test
  public void isEmptyCollection_nullCollection_returnsTrue() {
    List<Source> sources = null;
    boolean result = CollectionHelper.isEmpty(sources);
    assertTrue(result);
  }

  @Test
  public void isEmptyCollection_emptyCollection_returnsTrue() {
    List<Source> sources = new ArrayList<>();
    boolean result = CollectionHelper.isEmpty(sources);
    assertTrue(result);
  }

  @Test
  public void isEmptyMap_notEmptyMap_returnsFalse() {
    Map<String, Source> map = new HashMap<>();
    map.put("one", source1);

    boolean result = CollectionHelper.isEmpty(map);
    assertFalse(result);
  }

  @Test
  public void isEmptyMap_emptyMap_returnsTrue() {
    Map<String, Source> map = new HashMap<>();
    boolean result = CollectionHelper.isEmpty(map);
    assertTrue(result);
  }

  @Test
  public void isEmptyMap_nullMap_returnsTrue() {
    Map<String, Source> map = null;
    boolean result = CollectionHelper.isEmpty(map);
    assertTrue(result);
  }

  @Test
  public void isInCollection_matchFound_returnsTrue() {
    List<Source> sources = new ArrayList<>();
    sources.add(source1);
    sources.add(source2);

    boolean result = CollectionHelper.isInCollection(source1, sources);
    assertTrue(result);
  }

  @Test
  public void isInCollection_matchNotFound_returnsFalse() {
    List<Source> sources = new ArrayList<>();
    sources.add(source1);
    sources.add(source2);

    boolean result = CollectionHelper.isInCollection(new Source(), sources);
    assertFalse(result);
  }

  @Test
  public void isInCollection_nullCollection_returnsFalse() {
    List<Source> sources = null;
    boolean result = CollectionHelper.isInCollection(source1, sources);
    assertFalse(result);
  }

  @Test
  public void isInCollection_nullReferencedElement_returnsFalse() {
    List<Source> sources = new ArrayList<>();
    sources.add(source1);
    sources.add(source2);

    boolean result = CollectionHelper.isInCollection(null, sources);
    assertFalse(result);
  }

  @Test
  public void isInCollection_emptyCollection_returnsFalse() {
    List<Source> sources = new ArrayList<>();
    boolean result = CollectionHelper.isInCollection(source1, sources);
    assertFalse(result);
  }

  @Test
  public void isInEnumSet_matchFound_returnsTrue() {
    boolean result = CollectionHelper
        .isInEnumSet(source1.getSampleEnum(), SampleEnum.ENUM_ONE, SampleEnum.ENUM_TWO);
    assertTrue(result);
  }

  @Test
  public void isInEnumSet_matchNotFound_returnsFalse() {
    boolean result = CollectionHelper
        .isInEnumSet(source1.getSampleEnum(), SampleEnum.ENUM_TWO, SampleEnum.ENUM_THREE);
    assertFalse(result);
  }

  @Test
  public void isInEnumSet_nullEnum_returnsFalse() {
    boolean result = CollectionHelper.isInEnumSet(null, SampleEnum.ENUM_ONE, SampleEnum.ENUM_TWO);
    assertFalse(result);
  }

  @Test
  public void isInEnumSet_emptyEnumSet_returnsFalse() {
    boolean result = CollectionHelper.isInEnumSet(source1.getSampleEnum(), null);
    assertFalse(result);
  }

  @Test
  public void isNotEmptyCollection_notEmptyCollection_returnsTrue() {
    List<Source> sources = new ArrayList<>();
    sources.add(source1);
    sources.add(source2);

    boolean result = CollectionHelper.isNotEmpty(sources);
    assertTrue(result);
  }

  @Test
  public void isNotEmptyCollection_emptyCollection_returnsFalse() {
    List<Source> sources = new ArrayList<>();
    boolean result = CollectionHelper.isNotEmpty(sources);
    assertFalse(result);
  }

  @Test
  public void isNotEmptyCollection_nullCollection_returnsFalse() {
    List<Source> sources = null;
    boolean result = CollectionHelper.isNotEmpty(sources);
    assertFalse(result);
  }

  @Test
  public void isNotEmptyMap_notEmptyMap_returnsTrue() {
    Map<String, Source> sourceMap = new HashMap<>();
    sourceMap.put("one", source1);
    sourceMap.put("two", source2);

    boolean result = CollectionHelper.isNotEmpty(sourceMap);
    assertTrue(result);
  }

  @Test
  public void isNotEmptyMap_emptyMap_returnsTrue() {
    Map<String, Source> sourceMap = new HashMap<>();
    boolean result = CollectionHelper.isNotEmpty(sourceMap);
    assertFalse(result);
  }

  @Test
  public void isNotEmptyMap_nullMap_returnsTrue() {
    Map<String, Source> sourceMap = null;
    boolean result = CollectionHelper.isNotEmpty(sourceMap);
    assertFalse(result);
  }

  @Test
  public void sanitizeCollection_notEmptyCollection_returnsSanitizedCollection() {
    List<Source> sources = new ArrayList<>();
    sources.add(source1);
    sources.add(null);
    sources.add(source2);
    sources.add(null);

    assertEquals(4, sources.size());
    CollectionHelper.sanitize(sources);
    assertEquals(2, sources.size());
  }

  @Test
  public void sanitizeCollection_emptyCollection_noActionThenReturnsSameCollection() {
    List<Source> sources = new ArrayList<>();
    CollectionHelper.sanitize(sources);
    assertNotNull(sources);
    assertTrue(sources.isEmpty());
  }

  @Test
  public void sanitizeCollection_nullCollection_noActionThenReturnsNull() {
    List<Source> sources = null;
    CollectionHelper.sanitize(sources);
    assertNull(sources);
  }

  @Test
  public void sanitizeMap_stringMap_returnsSanitizedMap() {
    Map<String, String> map = new HashMap<>();
    map.put("keyone", "valone");
    map.put("", "valtwo");
    map.put(null, "valthree");
    map.put("keyfour", "");
    map.put("keyfive", null);

    CollectionHelper.sanitize(map);
    assertNotNull(map);
    assertEquals(3, map.size());
    assertEquals("valone", map.get("keyone"));
    assertEquals("valtwo", map.get(""));
    assertEquals("", map.get("keyfour"));
  }

  @Test
  public void sanitizeMap_objectMap_returnsSanitizedMap() {
    Map<String, Source> map = new HashMap<>();
    map.put("keyone", source1);
    map.put("", source2);
    map.put(null, source1);
    map.put("keyfour", null);

    CollectionHelper.sanitize(map);
    assertNotNull(map);
    assertEquals(2, map.size());
    assertEquals(source1, map.get("keyone"));
    assertEquals(source2, map.get(""));
  }

  @Test
  public void sanitizeMap_emptyMap_noActionThenReturnsTheSameMap() {
    Map<String, String> map = new HashMap<>();
    CollectionHelper.sanitize(map);
    assertNotNull(map);
    assertTrue(map.isEmpty());
  }

  @Test
  public void sanitizeMap_emptyMap_noActionThenReturnsNull() {
    Map<String, String> map = null;
    CollectionHelper.sanitize(map);
    assertNull(map);
  }

  @Test
  public void sizeOf_emptyCollection_returnsZero() {
    List<String> list = new ArrayList<>();
    assertEquals(0, CollectionHelper.sizeOf(list));
  }

  @Test
  public void sizeOf_nullCollection_returnsZero() {
    List<String> list = null;
    assertEquals(0, CollectionHelper.sizeOf(list));
  }

  @Test
  public void sizeOf_notEmptyCollection_returnsCollectionSize() {
    Set<String> set = new HashSet<>();
    set.add("one");
    set.add("two");

    assertEquals(2, CollectionHelper.sizeOf(set));
  }

  @Test
  public void toSet_nullInput_returnsNewHashSet() {
    Set<String> result = CollectionHelper.toSet(null);
    assertNotNull(result);
    assertTrue(result instanceof HashSet);
  }

  @Test
  public void toSet_properInput_returnsNewHashSetInstance() {
    Set<String> result = CollectionHelper.toSet("one", null, "two");
    assertNotNull(result);
    assertEquals(2, result.size());
  }

  @Test
  public void toList_properInput_returnsNewArrayListInstance() {
    List<String> result = CollectionHelper.toList("one", null, "two");
    assertNotNull(result);
    assertEquals(2, result.size());
    assertTrue(result instanceof ArrayList);
  }

  @Test
  public void toList_nullInput_returnsNewArrayList() {
    List<String> result = CollectionHelper.toList(null);
    assertNotNull(result);
    assertTrue(result instanceof ArrayList);
  }

  @Before
  public void setUp() {
    new CollectionHelper();

    source1 = new Source(1, 1.1, "one", SampleEnum.ENUM_ONE);
    source2 = new Source(2, 2.2, "two", SampleEnum.ENUM_TWO);
  }

  @After
  public void tearDown() {

  }
}
