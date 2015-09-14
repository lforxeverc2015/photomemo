package com.irady.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	public static String saveFile(String rootPath, String name, byte[] data) {
		FileOutputStream fos = null;
		File sf = null;
		File root = new File(rootPath);
		if (!root.exists()) {
			root.mkdir();

		}
		sf = new File(rootPath + File.separator + name);
		try {

			fos = new FileOutputStream(sf);
			fos.write(data);
			fos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
					return sf.getAbsolutePath();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		return "";
	}
}
