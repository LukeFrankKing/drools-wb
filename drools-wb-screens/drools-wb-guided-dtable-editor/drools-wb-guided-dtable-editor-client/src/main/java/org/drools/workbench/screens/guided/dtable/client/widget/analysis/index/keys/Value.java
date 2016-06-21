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
package org.drools.workbench.screens.guided.dtable.client.widget.analysis.index.keys;

public class Value
        implements Comparable<Value> {

    private final Comparable comparable;

    public Value( final Comparable comparable ) {
        this.comparable = comparable;
    }

    public Comparable getComparable() {
        return comparable;
    }

    @Override
    public int compareTo( final Value value ) {
        if ( comparable == null && value.comparable == null ) {
            return 0;
        } else if ( comparable == null ) {
            return -1;
        } else if ( value.comparable == null ) {
            return 1;
        } else if ( value.comparable.getClass().equals( this.comparable.getClass() ) ) {
            return this.comparable.compareTo( value.comparable );
        } else {
            return this.comparable.getClass().getName().compareTo( value.comparable.getClass().toString() );
        }
    }
}