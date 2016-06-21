/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.workbench.screens.guided.dtable.client.widget.analysis.index.select;

import org.drools.workbench.screens.guided.dtable.client.widget.analysis.cache.MultiMap;
import org.drools.workbench.screens.guided.dtable.client.widget.analysis.index.keys.Value;
import org.drools.workbench.screens.guided.dtable.client.widget.analysis.index.matchers.ExactMatcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExactMatcherSearchTest {

    private ExactMatcherSearch<Object> search;

    private MultiMap<Value, Object> map = new MultiMap<>();

    @Before
    public void setUp() throws Exception {
        map.put( new Value( null ),
                 "I am null" );
        map.put( new Value( "helloKey" ),
                 "hello" );

    }

    @Test
    public void testNullSearch() throws Exception {

        search = new ExactMatcherSearch<>( new ExactMatcher( "value",
                                                             null ),
                                           map );
        MultiMap<Value, Object> search1 = search.search();
        assertEquals( "I am null", search1.get( new Value( null ) ).get( 0 ) );

    }

    @Test
    public void testNegatedNullSearch() throws Exception {

        search = new ExactMatcherSearch<>( new ExactMatcher( "value",
                                                             null,
                                                             true ),
                                           map );
        MultiMap<Value, Object> search1 = search.search();
        assertEquals( "hello", search1.get( new Value( "helloKey" ) ).get( 0 ) );

    }
}