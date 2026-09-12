/*
 * Copyright 2015-2026 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(3, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@Test
	@DisplayName("Adding zero preserves the original number")
	void addsZero() {
		Calculator calculator = new Calculator();

		assertEquals(42, calculator.add(42, 0));
	}

	@Test
	@DisplayName("Adding negative numbers produces the expected result")
	void addsNegativeNumbers() {
		Calculator calculator = new Calculator();

		assertEquals(-5, calculator.add(-2, -3));
		assertEquals(1, calculator.add(-2, 3));
	}

	@ParameterizedTest(name = "{0} + {1} = {2}", quoteTextArguments = false)
	@CsvSource(textBlock = """
			0,    1,   1
			1,    2,   3
			49,  51, 100
			1,  100, 101
			""")
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}
}
