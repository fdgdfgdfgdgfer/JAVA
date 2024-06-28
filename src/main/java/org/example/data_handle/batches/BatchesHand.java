package org.example.data_handle.batches;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class BatchesHand {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("1", "2", "1", "2", "1", "2", "1", "2",
                "1", "2", "1", "2", "1", "2", "1", "2",
                "1", "2", "1", "2", "1", "2", "1", "2",
                "1", "2", "1", "2", "1", "2", "1", "2",
                "1", "2", "1", "2", "1", "2", "1", "2"
        );

        BatchesFactory batchesFactory = new BatchesFactory();
        batchesFactory.batchesHand(list);
    }
}
