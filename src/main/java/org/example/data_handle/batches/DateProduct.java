package org.example.data_handle.batches;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public interface DateProduct {
    ThreadPoolExecutor setPool();

    List<List<String>> setDateList(List<String> dateList);
}
