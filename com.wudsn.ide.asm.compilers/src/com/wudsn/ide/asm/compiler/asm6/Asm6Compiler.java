/**
* Copyright (C) 2009 - 2014 <a href="http://www.wudsn.com" target="_top">Peter Dell</a>
 *
 * This file is part of WUDSN IDE.
 * 
 * WUDSN IDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * WUDSN IDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with WUDSN IDE.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.wudsn.ide.asm.compiler.asm6;

import com.wudsn.ide.asm.compiler.Compiler;
import com.wudsn.ide.asm.compiler.CompilerProcessLogParser;
import com.wudsn.ide.asm.compiler.parser.CompilerSourceParser;

/**
 * Compiler class for ASM6.
 * 
 * @author Peter Dell
 */
public final class Asm6Compiler extends Compiler {

    /**
     * Creates a new instance.
     */
    public Asm6Compiler() {
    }

    @Override
    public CompilerSourceParser createSourceParser() {
	return new Asm6CompilerSourceParser();
    }

    @Override
    public CompilerProcessLogParser createLogParser() {

	return new Asm6CompilerProcessLogParser();
    }

}