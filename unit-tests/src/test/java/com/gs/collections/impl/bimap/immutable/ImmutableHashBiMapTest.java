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

package com.gs.collections.impl.bimap.immutable;

import com.gs.collections.api.bimap.ImmutableBiMap;
import com.gs.collections.impl.bimap.mutable.HashBiMap;
import com.gs.collections.impl.factory.Maps;
import com.gs.collections.impl.map.mutable.UnifiedMap;
import com.gs.collections.impl.set.mutable.UnifiedSet;
import com.gs.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableHashBiMapTest extends AbstractImmutableBiMapTestCase
{
    @Override
    protected ImmutableBiMap<Integer, String> classUnderTest()
    {
        return new ImmutableHashBiMap<>(Maps.immutable.with(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    protected ImmutableBiMap<Integer, String> newEmpty()
    {
        return new ImmutableHashBiMap<>();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithMap()
    {
        return new ImmutableHashBiMap<>(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithHashBiMap()
    {
        return new ImmutableHashBiMap<>(HashBiMap.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithImmutableMap()
    {
        return new ImmutableHashBiMap<>(Maps.immutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    @Test
    public void testToString()
    {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
    }

    @Test
    public void keySet()
    {
        ImmutableHashBiMap<Integer, String> immutableHashBiMap = new ImmutableHashBiMap<>(Maps.immutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, 2, 3, 4), immutableHashBiMap.keySet());
    }
}
