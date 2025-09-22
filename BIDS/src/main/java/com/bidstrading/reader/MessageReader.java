package com.bidstrading.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public interface MessageReader {
    /**
     * Pitch message reader from its source.  I assumed it would be continuous stream of ordered messages.
     *
     * @return Iterator which client can iterate over for messages
     * @throws IOException
     * @throws URISyntaxException
     */
    Iterator<String> read() throws IOException, URISyntaxException;
}
