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

package com.wudsn.ide.gfx.converter.atari8bit;

import org.eclipse.swt.graphics.RGB;

import com.wudsn.ide.gfx.converter.FilesConverterData;
import com.wudsn.ide.gfx.converter.PaletteMapper;
import com.wudsn.ide.gfx.converter.generic.LinearBitMapConverter;
import com.wudsn.ide.gfx.model.Palette;

public class LinearBitMapGHGConverter extends LinearBitMapConverter {

    public LinearBitMapGHGConverter() {
    }

    @Override
    public boolean canConvertToImage(byte[] bytes) {
	if (bytes == null) {
	    throw new IllegalArgumentException(
		    "Parameter 'bytes' must not be null.");
	}
	return bytes.length == 0x1f43 && Atari8BitUtility.getWord(bytes, 0) > 0
		&& Atari8BitUtility.getWord(bytes, 0) <= 320
		&& (bytes[2] & 0xff) > 0 && (bytes[2] & 0xff) <= 200;
    }

    @Override
    public void convertToImageSizeAndPalette(FilesConverterData data,
	    byte[] bytes) {
	if (data == null) {
	    throw new IllegalArgumentException(
		    "Parameter 'data' must not be null.");
	}
	if (bytes == null) {
	    throw new IllegalArgumentException(
		    "Parameter 'bytes' must not be null.");
	}

	int columns = (Atari8BitUtility.getWord(bytes, 0) + 7) / 8;
	int rows = (bytes[2] & 0xff);
	PaletteMapper paletteMapper = new Atari8BitPaletteMapper();

	RGB[] paletteColors = new RGB[2];
	paletteColors[0] = paletteMapper.getRGB(12);
	paletteColors[1] = paletteMapper.getRGB(2);

	setImageSizeAndPalette(data, columns, rows, Palette.HIRES_MANUAL,
		paletteColors);
    }

    @Override
    public void convertToImageDataSize(FilesConverterData data) {
	data.setImageDataWidth(data.getParameters().getColumns() * 8);
	data.setImageDataHeight(data.getParameters().getRows());
    }

    @Override
    public boolean convertToImageData(FilesConverterData data) {
	if (data == null) {
	    throw new IllegalArgumentException(
		    "Parameter 'data' must not be null.");
	}

	int offset = 3;
	int xpixels = 8;

	for (int y1 = 0; y1 < data.getParameters().getRows(); y1++) {
	    for (int x1 = 0; x1 < data.getParameters().getColumns(); x1++) {
		int b = data.getSourceFileByte(BIT_MAP_FILE, offset++);
		if (b < 0) {
		    return true;
		}
		for (int x2 = 0; x2 < 8; x2++) {
		    int x = x1 * xpixels + x2;
		    int color = (b & mask_1bit[x2]) >>> shift_1bit[x2];
		    data.setPalettePixel(x, y1, color);
		}
	    }
	}
	return true;
    }
}