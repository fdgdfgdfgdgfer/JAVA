package org.example.data_handle.batches;


import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class BatchesFactory extends AbstractFactory {


    public BatchesFactory() {
        super.dateProduct = product();
    }


    @Override
    DateProduct product() {
        return new DateProductImp();
    }

    public void batchesHand(List<String> data) {
        ThreadPoolExecutor poolExecutor = super.dateProduct.setPool();

        List<List<String>> lists = super.dateProduct.setDateList(data);

        for (List<String> ol : lists) {
            poolExecutor.execute(() -> {
                System.out.println("存入list" + ol+"............");
            });

        }

    }
}
