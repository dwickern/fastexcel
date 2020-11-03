/*
 * Copyright 2016 Dhatim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dhatim.fastexcel;

/** This class represents a range of rows/columns for the 
 *      repeating rows/columns feature in the print setup. */
class RepeatRange { 
    
    final int from;
    final int to;
    final RepeatRangeType type;

    public RepeatRange(int from, int to, RepeatRangeType type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    /**
     * Column indexes need to be transformed to the letter form.
     */
    public String colRangeToString() {
        return "$" + Range.colToString(from) + ":$" + Range.colToString(to);
    }

        /**
     * Row indexes need to be increased by 1 
     *  (sheet row indexes start from 1 and not from 0)
     */
    public String rowRangeToString() {
        return "$" + (1 + from) + ":$" + (1 + to);
    }

    public String toString() {
        if (type == RepeatRangeType.ROW) return rowRangeToString();
        else if (type == RepeatRangeType.COLUMN) return colRangeToString();
        else return null;
    }
}