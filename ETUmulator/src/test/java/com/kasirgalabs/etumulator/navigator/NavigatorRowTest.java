/*
 * Copyright (C) 2017 Kasirgalabs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.kasirgalabs.etumulator.navigator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NavigatorRowTest {
    /**
     * Test of SetValueType and getValue methods, of class NavigatorRow.
     */
    @Test
    public void testSetValueTypeAndGetValue() {
        NavigatorRow navigatorRow = new NavigatorRow("r0", 0xffff_ffff);
        NavigatorRow.setType(NavigatorRow.Type.HEX);
        assertEquals("NavigatorRow result is wrong.",
                "0xffffffff",
                navigatorRow.getValue());

        NavigatorRow.setType(NavigatorRow.Type.DECIMAL);
        assertEquals("NavigatorRow result is wrong.", "-1", navigatorRow.getValue());

        NavigatorRow.setType(NavigatorRow.Type.BINARY);
        assertEquals("NavigatorRow result is wrong.",
                String.format("%0" + 32 + "d", 0).replace('0', '1'),
                navigatorRow.getValue());

        navigatorRow.setValue('x');
        NavigatorRow.setType(NavigatorRow.Type.ASCII);
        assertEquals("NavigatorRow result is wrong.", "x", navigatorRow.getValue());

        navigatorRow.setValue('\n');
        NavigatorRow.setType(NavigatorRow.Type.ASCII);
        assertEquals("NavigatorRow result is wrong.", "\\n", navigatorRow.getValue());

        navigatorRow.setValue(9999);
        NavigatorRow.setType(NavigatorRow.Type.ASCII);
        assertEquals("NavigatorRow result is wrong.", "Non-ASCII", navigatorRow.getValue());

        navigatorRow.setValue(1);
        NavigatorRow.setType(NavigatorRow.Type.BINARY);
        assertEquals("NavigatorRow result is wrong.",
                String.format("%0" + 32 + "d", 1),
                navigatorRow.getValue());

        navigatorRow.setValue(1);
        NavigatorRow.setType(NavigatorRow.Type.HEX);
        assertEquals("NavigatorRow result is wrong.",
                "0x" + String.format("%0" + 8 + "d", 1),
                navigatorRow.getValue());
    }
}
