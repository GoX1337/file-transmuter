package com.gox.file.transmuter;

import com.gox.file.transmuter.parser.CsvFileParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileTransmuterApplicationTests {

	@Autowired
	private CsvFileParser csvFileParser;

	@Test
	void test() {
	}
}
