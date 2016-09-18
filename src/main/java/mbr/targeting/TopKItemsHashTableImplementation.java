package mbr.targeting;

import java.util.*;

/**
 * Created by mustafa on 18.09.16.
 */
public class TopKItemsHashTableImplementation {

    private Map<String, Integer> topKFrequentMap;

    public TopKItemsHashTableImplementation(int k) {
        this.topKFrequentMap = new HashMap<String, Integer>(k);
    }


    public void spaceSavingAlgorithm(String item, int k) {

        if (!this.topKFrequentMap.containsKey(item)) {

            addNewElement(item, k);

        } else {

            this.topKFrequentMap.put(item, this.topKFrequentMap.get(item) + 1);
        }
    }

    private void addNewElement(String item, int k) {

        if (this.topKFrequentMap.size() >= k) {

            Map.Entry<String, Integer> minimumCountedItem = getEntryWithMinimumValue();
            this.topKFrequentMap.remove(minimumCountedItem.getKey());
            this.topKFrequentMap.put(item, minimumCountedItem.getValue() + 1);

        } else {

            this.topKFrequentMap.put(item, 1);
        }

    }


    private Map.Entry<String, Integer> getEntryWithMinimumValue() {

        return Collections.min(this.topKFrequentMap.entrySet(), new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }


    public static void main(String[] args) {

        int[] test = {17, 1, 9, 13, 17, 2, 37, 9, 10};
        TopKItemsHashTableImplementation topKItemsHashTableImplementation = new TopKItemsHashTableImplementation(6);

        for (int i = 0; i < test.length; i++) {
            topKItemsHashTableImplementation.spaceSavingAlgorithm(String.valueOf(test[i]), 6);
        }

        System.out.println();

    }
}
