/**
R * Copyright (C) 2009 - 2021 <a href="https://www.wudsn.com" target="_top">Peter Dell</a>
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

package com.wudsn.ide.lng.preferences;

import java.util.ArrayList;
import java.util.List;

import com.wudsn.ide.base.hardware.Hardware;
import com.wudsn.ide.lng.Language;
import com.wudsn.ide.lng.Texts;

/**
 * Constants for preferences. The string constants are preferences key suffix
 * that are not used directly but prefixes with the language.
 * 
 * @author Peter Dell
 */
public final class LanguagePreferencesConstants {

	/**
	 * Creation is private.
	 */
	private LanguagePreferencesConstants() {
	}

	/**
	 * Preference key for comment text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_COMMENT = "editor.text.attribute.comment"; //$NON-NLS-1$

	/**
	 * Preferences key for string text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_STRING = "editor.text.attribute.string"; //$NON-NLS-1$

	/**
	 * Preferences key for number text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_NUMBER = "editor.text.attribute.number"; //$NON-NLS-1$

	/**
	 * Preference key for directive text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_DIRECTVE = "editor.text.attribute.directive"; //$NON-NLS-1$

	/**
	 * Preference key for legal opcode text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_OPCODE_LEGAL = "editor.text.attribute.opcode.legal"; //$NON-NLS-1$

	/**
	 * Preference key for illegal opcode text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_OPCODE_ILLEGAL = "editor.text.attribute.opcode.illegal"; //$NON-NLS-1$

	/**
	 * Preference key for pseudo opcode text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_OPCODE_PSEUDO = "editor.text.attribute.opcode.pseudo"; //$NON-NLS-1$

	/**
	 * Preference key for equate identifier text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_EQUATE = "editor.text.attribute.identifier.equate"; //$NON-NLS-1$

	/**
	 * Preference key for label identifier text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_LABEL = "editor.text.attribute.identifier.label"; //$NON-NLS-1$

	/**
	 * Preference key for enum identifier text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_ENUM_DEFINITION_SECTION = "editor.text.attribute.identifier.enum"; //$NON-NLS-1$

	/**
	 * Preference key for structure identifier text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_STRUCTURE_DEFINITION_SECTION = "editor.text.attribute.identifier.structure"; //$NON-NLS-1$

	/**
	 * Preference key for local identifier text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_LOCAL_SECTION = "editor.text.attribute.identifier.local"; //$NON-NLS-1$

	/**
	 * Preference key for macro identifier text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_MACRO_DEFINITION_SECTION = "editor.text.attribute.identifier.macro"; //$NON-NLS-1$

	/**
	 * Preference key for procedure identifier text style.
	 */
	public static final String EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_PROCEDURE_DEFINITION_SECTION = "editor.text.attribute.identifier.procedure"; //$NON-NLS-1$

	/**
	 * Preference key for default case for content assist.
	 */
	static final String EDITOR_CONTENT_ASSIST_PROCESSOR_DEFAULT_CASE = "editor.content.assist.processor.default.case"; //$NON-NLS-1$

	/**
	 * Preference key for positioning for for compiling.
	 * 
	 * @since 1.6.1
	 */
	static final String EDITOR_COMPILE_COMMAND_POSITIONING_MODE = "editor.compile.command.positioning.mode"; //$NON-NLS-1$

	/**
	 * Create the preferences key for a property of a given language.
	 * 
	 * @param language             The language, not <code>null</code>
	 * @param preferencesKeySuffix The suffix as defined by the constants of this
	 *                             class, not empty, not <code>null</code>
	 * @return
	 */
	public static String getPreferencesKey(Language language, String preferencesKeySuffix) {
		return language.name().toLowerCase() + "." + preferencesKeySuffix;
	}

	/**
	 * Get list of all preferences keys that depend on the global JFact text font
	 * setting.
	 */
	public static List<TextAttributeDefinition> getTextAttributeDefinitions(Language language) {
		if (language == null) {
			throw new IllegalArgumentException("Parameter 'language' must not be null.");
		}

		List<TextAttributeDefinition> result = new ArrayList<TextAttributeDefinition>();

		// Comments and literals
		result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_COMMENT),
				Texts.PREFERENCES_TEXT_ATTRIBUTE_COMMENT_NAME));
		result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_NUMBER),
				Texts.PREFERENCES_TEXT_ATTRIBUTE_NUMBER_NAME));
		result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_STRING),
				Texts.PREFERENCES_TEXT_ATTRIBUTE_STRING_NAME));

		switch (language) {
		case ASM: {

			// Built-in
			result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_DIRECTVE),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_DIRECTIVE));
			result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_OPCODE_ILLEGAL),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_OPCODE_ILLEGAL_NAME));
			result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_OPCODE_LEGAL),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_OPCODE_LEGAL_NAME));
			result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_OPCODE_PSEUDO),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_OPCODE_PSEUDO_NAME));

			// Identifiers
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_ENUM_DEFINITION_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_ENUM_DEFINITION_SECTION));
			result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_EQUATE),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_EQUATE));
			result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_LABEL),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_LABEL));
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_LOCAL_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_LOCAL_SECTION));
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_MACRO_DEFINITION_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_MACRO_DEFINITION_SECTION));
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_PROCEDURE_DEFINITION_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_PROCEDURE_DEFINITION_SECTION));
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_STRUCTURE_DEFINITION_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_STRUCTURE_DEFINITION_SECTION));
			break;

		}

		case PAS: {

			// Built-in
			result.add(new TextAttributeDefinition(getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_DIRECTVE),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_DIRECTIVE));

			// Identifiers
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_ENUM_DEFINITION_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_ENUM_DEFINITION_SECTION));
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_PROCEDURE_DEFINITION_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_PROCEDURE_DEFINITION_SECTION));
			result.add(new TextAttributeDefinition(
					getPreferencesKey(language, EDITOR_TEXT_ATTRIBUTE_IDENTIFIER_STRUCTURE_DEFINITION_SECTION),
					Texts.PREFERENCES_TEXT_ATTRIBUTE_IDENTIFIER_STRUCTURE_DEFINITION_SECTION));
			break;

		}
		default:
			throw new IllegalArgumentException("Unsupported language " + language + ".");
		}

		return result;
	}

	/**
	 * Determines if preference key name represents a setting for compiler targets
	 * visibility.
	 * 
	 * @param name The name of the preferences key, not <code>null</code>.
	 * @return <code>true</code> if preference key name represents a setting for
	 *         compiler opcodes visibility, <code>false</code> otherwise.
	 */
	public static boolean isCompilerTargetName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Parameter 'name' must not be null.");
		}
		boolean result = name.startsWith("compiler.") && name.endsWith(".target");
		return result;
	}

	/**
	 * Gets preference key name for the compiler executable path. This is the only
	 * hardware independent compiler setting.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * 
	 * @return The preference key name for the compiler executable path, not empty
	 *         and not <code>null</code>.
	 */
	static String getCompilerExecutablePathName(String compilerId) {

		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		return "compiler." + compilerId + ".executable.path"; //$NON-NLS-1$
	}

	/**
	 * Gets preference key name for the compiler Target visibility.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * 
	 * @return The preference key name for the compiler Target, not empty and not
	 *         <code>null</code>.
	 */
	static String getCompilerTargetName(String compilerId, Hardware hardware) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".target"; //$NON-NLS-1$
	}

	/**
	 * Gets preference key name for the compiler parameters.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * 
	 * @return The preference key name for the compiler parameters, not empty and
	 *         not <code>null</code>.
	 */
	static String getCompilerParametersName(String compilerId, Hardware hardware) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".default.parameters"; //$NON-NLS-1$
	}

	/**
	 * Gets preference key name for the compiler output folder mode.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * 
	 * @return The preference key name for the compiler output folder mode, not
	 *         empty and not <code>null</code>.
	 */
	static String getCompilerOutputFolderModeName(String compilerId, Hardware hardware) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".output.folder.mode"; //$NON-NLS-1$

	}

	/**
	 * Gets preference key name for the compiler output folder path.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * 
	 * @return The preference key name for the compiler output folder path, not
	 *         empty and not <code>null</code>.
	 */
	static String getCompilerOutputFolderPathName(String compilerId, Hardware hardware) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".output.folder.path"; //$NON-NLS-1$

	}

	/**
	 * Gets preference key name for the compiler output file extension.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * 
	 * @return The preference key name for the compiler output file extension, not
	 *         empty and not <code>null</code>.
	 */
	static String getCompilerOutputFileExtensionName(String compilerId, Hardware hardware) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".output.file.extension"; //$NON-NLS-1$

	}

	/**
	 * Gets preference key name for the runner to run the output file.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * 
	 * @return The preference key name for the for the runner to run the output
	 *         file, not empty and not <code>null</code>.
	 */
	static String getCompilerRunnerIdName(String compilerId, Hardware hardware) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".runner.id"; //$NON-NLS-1$

	}

	/**
	 * Gets preference key name for the runner executable path.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * @param runnerId   The runner id, not <code>null</code>.
	 * 
	 * @return The preference key name for the runner executable path, not empty and
	 *         not <code>null</code>.
	 */
	static String getCompilerRunnerExecutablePathName(String compilerId, Hardware hardware, String runnerId) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		if (runnerId == null) {
			throw new IllegalArgumentException("Parameter 'runnerId' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".runner." + runnerId + ".executable.path"; //$NON-NLS-1$

	}

	/**
	 * Gets preference key name for the runner command line.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * @param runnerId   The runner id, not <code>null</code>.
	 * 
	 * @return The preference key name for the runner command line, not empty and
	 *         not <code>null</code>.
	 */
	static String getCompilerRunnerCommandLineName(String compilerId, Hardware hardware, String runnerId) {
		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		if (runnerId == null) {
			throw new IllegalArgumentException("Parameter 'runnerId' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".runner." + runnerId + ".parameters"; //$NON-NLS-1$

	}

	/**
	 * Gets preference key name for the runner wait for completion flag.
	 * 
	 * @param compilerId The compiler id, not <code>null</code>.
	 * @param hardware   The hardware, not <code>null</code>.
	 * @param runnerId   The runner id, not <code>null</code>.
	 * 
	 * @return The preference key name for the runner command line, not empty and
	 *         not <code>null</code>.
	 * @since 1.6.1
	 */
	static String getCompilerRunnerWaitForCompletionName(String compilerId, Hardware hardware, String runnerId) {

		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		if (runnerId == null) {
			throw new IllegalArgumentException("Parameter 'runnerId' must not be null.");
		}
		return getCompilerHardwarePrefix(compilerId, hardware) + ".runner." + runnerId + ".waitForCompletion"; //$NON-NLS-1$

	}

	/**
	 * Gets preference key name prefix for a given hardware and compiler.
	 * 
	 * @param hardware   The hardware, not <code>null</code>.
	 * @param compilerId The compiler id, not <code>null</code>.
	 * 
	 * 
	 * @return The preference key name prefix without trailing dot, not empty and
	 *         not <code>null</code>.
	 */
	private static String getCompilerHardwarePrefix(String compilerId, Hardware hardware) {

		if (compilerId == null) {
			throw new IllegalArgumentException("Parameter 'compilerId' must not be null.");
		}
		if (hardware == null) {
			throw new IllegalArgumentException("Parameter 'hardware' must not be null.");
		}
		return "compiler." + compilerId + "." + hardware.name().toLowerCase();
	}
}
