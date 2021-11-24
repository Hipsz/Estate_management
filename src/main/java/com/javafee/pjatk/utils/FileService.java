package com.javafee.pjatk.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.javafee.pjatk.model.Estate;

public class FileService {
	public void save(List<Estate> estates) throws IOException {
		File file = new File("estates.txt");
		if (!file.exists()) file.createNewFile();
		Files.writeString(Paths.get("estates.txt"), estates.toString());
	}
}
