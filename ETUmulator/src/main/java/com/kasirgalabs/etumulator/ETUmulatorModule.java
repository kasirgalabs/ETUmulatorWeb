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
package com.kasirgalabs.etumulator;

import com.google.inject.AbstractModule;
import com.kasirgalabs.etumulator.console.BaseConsole;
import com.kasirgalabs.etumulator.console.Console;
import com.kasirgalabs.etumulator.document.BaseDocument;
import com.kasirgalabs.etumulator.document.Document;
import com.kasirgalabs.etumulator.processor.GUISafeProcessor;
import com.kasirgalabs.etumulator.processor.GUISafeProcessorUnits;
import com.kasirgalabs.etumulator.processor.Processor;
import com.kasirgalabs.etumulator.processor.ProcessorUnits;
import com.kasirgalabs.etumulator.util.Dispatcher;
import com.kasirgalabs.etumulator.util.GUISafeDispatcher;

public class ETUmulatorModule extends AbstractModule {
    @Override
    public void configure() {
        bind(Processor.class).to(GUISafeProcessor.class);
        bind(ProcessorUnits.class).to(GUISafeProcessorUnits.class);
        bind(Document.class).to(BaseDocument.class);
        bind(Console.class).to(BaseConsole.class);
        bind(Dispatcher.class).to(GUISafeDispatcher.class);
    }
}
