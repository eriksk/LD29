package se.skoggy.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;

public class Utils {

	public static Vector2[] toArray(List<Vector2> list){
		Vector2[] ary = new Vector2[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ary[i] = list.get(i);
		}
		return ary;
	}
	
	/*
	 * Removes all items after count
	 */
	public static void trimList(List list, int count){
		while(list.size() > count){
			list.remove(list.size() - 1);
		}
	}

	public static String fileToString(FileHandle file){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(file.reader());
			String content = "";
			String line;
			while((line = reader.readLine()) != null){
				content += line;
			}
			reader.close();
			return content;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
}
