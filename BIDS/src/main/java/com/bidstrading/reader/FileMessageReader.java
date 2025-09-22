package com.bidstrading.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileMessageReader implements MessageReader {
    // File encoding ?  Assume pitch message encoding is ASCII for now
    final Charset fileEncoding = StandardCharsets.US_ASCII;

    @Override
    public Iterator<String> read() throws IOException, URISyntaxException {
        String fileName = "/Pitch_example_data";
        URL resource = getClass().getResource(fileName);
        return Files.lines(Paths.get(resource.toURI()), fileEncoding).iterator();
    }
}
