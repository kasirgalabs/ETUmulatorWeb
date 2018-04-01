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
package com.kasirgalabs.etumulator.lang;

import static org.junit.Assert.fail;

import org.junit.Test;

public class ConstantValidatorTest {
    /**
     * Test of visitRegisterShiftedByConstant method, of class ConstantValidator.
     */
    @Test
    public void testVisitRegisterShiftedByConstant() {
        try {
            ConstantValidator.validate("add r0, r0, r0, lsl #32\n");
            fail("LSL allow shift must be 0-31");
        } catch(NumberFormatException ex) {
        }
        try {
            ConstantValidator.validate("add r0, r0, r0, lsr #999999\n");
            fail("LSR allow shift must be 1-32");
        } catch(NumberFormatException ex) {
        }
        ConstantValidator.validate("add r0, r0, r0, lsl #0\n");

        try {
            ConstantValidator.validate("add r0, r0, r0, lsr #0\n");
            fail("LSR allow shift must be 1-32");
        } catch(NumberFormatException ex) {
        }
        ConstantValidator.validate("add r0, r0, r0, lsr #32\n");

        try {
            ConstantValidator.validate("add r0, r0, r0, asr #33\n");
            fail("ASR allow shift must be 1-32");
        } catch(NumberFormatException ex) {
        }
        ConstantValidator.validate("add r0, r0, r0, asr #1\n");

        try {
            ConstantValidator.validate("add r0, r0, r0, ror #999999\n");
            fail("ROR allow shift must be 1-31");
        } catch(NumberFormatException ex) {
        }
        ConstantValidator.validate("add r0, r0, r0, ror #1\n");
        ConstantValidator.validate("add r0, r0, r0, ror #31\n");
    }

    /**
     * Test of visitShiftOption method, of class ConstantValidator.
     */
    @Test
    public void testVisitShiftOption() {
    }

    /**
     * Test of visitImm16 method, of class ConstantValidator.
     */
    @Test(expected = NumberFormatException.class)
    public void testVisitImm16() {
        ConstantValidator.validate("movt r0, #999999\n");
    }

    /**
     * Test of visitImm12 method, of class ConstantValidator.
     */
    @Test(expected = NumberFormatException.class)
    public void testVisitImm12() {
        ConstantValidator.validate("add r0, r0, #999999\n");
    }

    /**
     * Test of visitImm8m method, of class ConstantValidator.
     */
    @Test(expected = NumberFormatException.class)
    public void testVisitImm8m() {
        ConstantValidator.validate("adc r0, r0, #999999\n");
    }

    /**
     * Test of visitSh method, of class ConstantValidator.
     */
    @Test
    public void testVisitSh() {
    }

    /**
     * Test of visitOffset method, of class ConstantValidator.
     */
    @Test(expected = NumberFormatException.class)
    public void testVisitOffset() {
        ConstantValidator.validate("ldr r0, [r1], #999999\n");
    }

    /**
     * Test of visitOpsh method, of class ConstantValidator.
     */
    @Test(expected = NumberFormatException.class)
    public void testVisitOpsh() {
        ConstantValidator.validate("ldr r0, [r1, r2, lsl #999999]\n");
    }
}
