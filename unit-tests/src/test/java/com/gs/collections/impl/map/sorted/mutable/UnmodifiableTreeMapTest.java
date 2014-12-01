/*
 * Copyright 2014 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gs.collections.impl.map.sorted.mutable;

import java.util.Comparator;

import com.gs.collections.api.map.sorted.MutableSortedMap;
import com.gs.collections.impl.block.factory.Functions;
import com.gs.collections.impl.factory.Lists;
import com.gs.collections.impl.list.mutable.FastList;
import com.gs.collections.impl.test.Verify;
import com.gs.collections.impl.tuple.ImmutableEntry;
import com.gs.collections.impl.tuple.Tuples;
import com.gs.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableTreeMap}.
 */
public class UnmodifiableTreeMapTest extends MutableSortedMapTestCase
{
    @Override
    public <K, V> MutableSortedMap<K, V> newMap()
    {
        return new UnmodifiableTreeMap<>(new TreeSortedMap<>());
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(K key, V value)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(
                key1, value1, key2, value2, key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(
            K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(
                key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMap(Comparator<? super K> comparator)
    {
        return new UnmodifiableTreeMap<>(new TreeSortedMap<>(comparator));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(Comparator<? super K> comparator, K key, V value)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(comparator, key1, value1, key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(
                comparator,
                key1, value1,
                key2, value2,
                key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(
            Comparator<? super K> comparator,
            K key1, V value1,
            K key2, V value2,
            K key3, V value3,
            K key4, V value4)
    {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(
                comparator,
                key1, value1,
                key2, value2,
                key3, value3,
                key4, value4));
    }

    @Override
    @Test
    public void removeObject()
    {
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.remove("One"));
    }

    @Override
    @Test
    public void removeKey()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.removeKey(1));
    }

    @Override
    @Test
    public void removeFromEntrySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().remove(ImmutableEntry.of(2, "Two")));
    }

    @Override
    @Test
    public void removeAllFromEntrySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of(2, "Two"))));
    }

    @Override
    @Test
    public void retainAllFromEntrySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().retainAll(FastList.newListWith(ImmutableEntry.of(2, "Two"))));
    }

    @Override
    @Test
    public void clearEntrySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().clear());
    }

    @Override
    @Test
    public void removeFromKeySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.keySet().remove(2));
    }

    @Override
    @Test
    public void removeAllFromKeySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
    Verify.assertThrows(UnsupportedOperationException.class, () -> map.keySet().removeAll(FastList.newListWith(1, 2)));
    }

    @Override
    @Test
    public void retainAllFromKeySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.keySet().retainAll(Lists.mutable.of()));
    }

    @Override
    @Test
    public void clearKeySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.keySet().clear());
    }

    @Override
    @Test
    public void removeFromValues()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.values().remove("Two"));
    }

    @Override
    @Test
    public void removeAllFromValues()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
    Verify.assertThrows(UnsupportedOperationException.class, () -> map.values().removeAll(FastList.newListWith("One", "Two")));
    }

    @Override
    @Test
    public void removeNullFromValues()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.values().remove(null));
    }

    @Override
    @Test
    public void retainAllFromValues()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.values().retainAll(Lists.mutable.of()));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut()
    {
        this.newMapWithKeysValues(1, "1", 2, "2", 3, "3").getIfAbsentPut(4, null);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKey()
    {
        this.newMapWithKeysValues(1, 1, 2, 2, 3, 3).getIfAbsentPutWithKey(4, Functions.getIntegerPassThru());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWith()
    {
        this.newMapWithKeysValues(1, "1", 2, "2", 3, "3").getIfAbsentPutWith(4, String::valueOf, 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll()
    {
        this.newMapWithKeysValues(1, "One", 2, "2").putAll(null);
    }

    @Override
    @Test
    public void putAllFromCollection()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.collectKeysAndValues(null, null, null));
    }

    @Override
    @Test
    public void clear()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        Verify.assertThrows(UnsupportedOperationException.class, map::clear);
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        Assert.assertSame(map, map.asUnmodifiable());
    }

    @Test
    public void entrySet()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2").asUnmodifiable();

        Verify.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().remove(null));

        Verify.assertThrows(UnsupportedOperationException.class, () -> Iterate.getFirst(map.entrySet()).setValue("Three"));

        Assert.assertEquals(this.newMapWithKeysValues(1, "One", 2, "2"), map);
    }

    @Test
    public void entrySetToArray()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeyValue(1, "One").asUnmodifiable();
        Object[] entries = map.entrySet().toArray();
        Assert.assertEquals(ImmutableEntry.of(1, "One"), entries[0]);
    }

    @Test
    public void entrySetToArrayWithTarget()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeyValue(1, "One").asUnmodifiable();
        Object[] entries = map.entrySet().toArray(new Object[]{});
        Assert.assertEquals(ImmutableEntry.of(1, "One"), entries[0]);
    }

    @Override
    @Test
    public void put()
    {
        Verify.assertThrows(UnsupportedOperationException.class, UnmodifiableTreeMapTest.super::put);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.newMapWithKeysValues(1, "1", 2, "2").with(Tuples.pair(3, "3"));
    }

    @Override
    @Test
    public void headMap()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");

        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.headMap(3));
        this.checkMutability(map.headMap(3));
    }

    @Override
    @Test
    public void tailMap()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");

        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.tailMap(2));
        this.checkMutability(map.tailMap(2));
    }

    @Override
    @Test
    public void subMap()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");

        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.subMap(1, 3));
        this.checkMutability(map.subMap(1, 3));
    }

    @Override
    @Test
    public void testClone()
    {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertSame(map, map.clone());
        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.clone());
    }

    private void checkMutability(MutableSortedMap<Integer, String> map)
    {
        Verify.assertThrows(UnsupportedOperationException.class, () -> map.put(3, "3"));

        Verify.assertThrows(UnsupportedOperationException.class, () -> map.putAll(TreeSortedMap.newMapWith(1, "1", 2, "2")));

        Verify.assertThrows(UnsupportedOperationException.class, () -> map.remove(2));

        Verify.assertThrows(UnsupportedOperationException.class, map::clear);

        Verify.assertThrows(UnsupportedOperationException.class, () -> map.with(Tuples.pair(1, "1")));
    }
}
