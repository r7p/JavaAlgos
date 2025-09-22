package com.bidstrading;

import com.bidstrading.model.*;
import com.bidstrading.reader.FileMessageReader;
import com.bidstrading.reader.MessageReader;
import com.bidstrading.reader.StdInReader;
import com.bidstrading.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class MainService {
    private final static Logger LOG = LoggerFactory.getLogger(MainService.class);

    final MessageReader reader;
    final OrderService orderService;

    public MainService(MessageReader reader, OrderService orderService) {
        this.reader = reader;
        this.orderService = orderService;
    }

    public void processMessage() throws IOException, URISyntaxException {
        if (reader instanceof StdInReader) {
            System.out.println("Enter pitch messages below separated by new line.\n" +
                    "Type 'q' or 'quit' when you're done and it'll print top 10 stocks by trading volume.");
        }
        final Iterator<String> iterator = reader.read();
        while (iterator.hasNext()) {
            String msg = iterator.next();
            // to facilitate clean exit while reading from stdin
            if (msg.equals("q") || msg.equals("quit")) {
                break;
            }

            Optional<PitchMessage> messageOptional = PitchMessageFactory.fromPitchMessage(msg);
            messageOptional.ifPresent(pitchMessage -> {
                switch (pitchMessage.messageType) {
                    case "A":
                        orderService.addOrder((AddOrder) pitchMessage);
                        break;
                    case "E":
                        orderService.processOrderExecuted((OrderExecuted) pitchMessage);
                        break;
                    case "X":
                        orderService.processOrderCancel((OrderCancel) pitchMessage);
                        break;
                    case "P":
                        orderService.processTrade((Trade) pitchMessage);
                        break;
                    default:
                        LOG.warn("Skipping message " + pitchMessage);
                }
            });
        }
        printTopByVolume(10);
    }

    public void printTopByVolume(int n) {
        Queue<Tuple<String, Integer>> queue = new PriorityQueue<>((a, b) -> b.y - a.y);

        // Insert volume data in to Priority queue
        orderService.executionVolume().forEach((stock, volume) -> queue.offer(new Tuple<>(stock, volume)));

        System.out.println("\n***** Top 10 stocks by trade volume ******\n");
        int upto = Math.min(n, queue.size());
        for (int i = 1; i <= upto; i++) {
            Tuple<String, Integer> tuple = queue.poll();
            System.out.println(tuple.x + " " + tuple.y);
        }
        System.out.println("\n************** FINISHED *******************");
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        MainService mainService = new MainService(new StdInReader(), new OrderService());
        mainService.processMessage();
    }

    static class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) o;
            return x.equals(tuple.x) && y.equals(tuple.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
