package com.ifaceinnovation;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public final class ImageUtils {

	private ImageUtils() {
		//avoid to create instance outside
	}

	public static String createThumbnail(File sourceFile, int width, int height) throws IOException {
		try {
			return createThumbnail(sourceFile, width, height, "jpg");
		} catch(IOException e) {
			throw e;
		}
	}

	public static String createThumbnail(File sourceFile, int width, int height, String format) throws IOException {
		try {
			if(sourceFile == null) {
				throw new IllegalArgumentException("Source path not found");
			}
			String source = sourceFile.getAbsolutePath();
			String destination = sourceFile.getParentFile()+"\\thumbnail."+format;
			return crop(source, width, height, destination, format);
		} catch(IOException e) {
			throw e;
		}
	}
	
	private static String crop(String source, int width, int height, String destination, String format) throws IOException {
		try {
			File sourceFile = new File(source);
			BufferedImage img = ImageIO.read(sourceFile);
			BufferedImage thumbImg = Scalr.resize(img, Method.QUALITY,Mode.AUTOMATIC, width, height, Scalr.OP_ANTIALIAS);
			File destFile = new File(destination);
			ImageIO.write(thumbImg, format, destFile);
			return destFile.getAbsolutePath();
		} catch(IOException e) {
			throw e;
		}
	}
}
