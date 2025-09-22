package com.bidstrading.reader;

import java.util.Iterator;
import java.util.Scanner;

public class StdInReader implements MessageReader {
    @Override
    public Iterator<String> read() {
        return new Scanner(System.in).useDelimiter("\n");
    }
}
