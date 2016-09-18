package mbr.targeting;

import java.util.*;

/**
 * Created by mustafa on 17.09.16.
 */
public class TopKItemsHeapImplementation {

    private Set<String> elementSet;
    private PriorityQueue<Pair<String, Integer>> frequentElementsHeap;


    public TopKItemsHeapImplementation(int k) {

        this.elementSet = new HashSet<String>(k);
        this.frequentElementsHeap = new PriorityQueue<Pair<String, Integer>>(k, new Comparator<Pair<String, Integer>>() {
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o1.getR().compareTo(o2.getR());
            }
        });

    }

    public void spaceSavingAlgorithm(String item, int k) {

        if (!this.elementSet.contains(item)) {

            addNewElement(item, k);

        } else {

            updateElementCount(item, k);
        }
    }

    private void addNewElement(String item, int k) {

        if (this.frequentElementsHeap.size() >= k) {

            Pair<String, Integer> tempPair = this.frequentElementsHeap.poll();
            this.elementSet.remove(tempPair.getL());

            this.frequentElementsHeap.add(new Pair<String, Integer>(item, tempPair.getR() + 1));
            this.elementSet.add(item);

        } else {

            this.frequentElementsHeap.add(new Pair<String, Integer>(item, 1));
            this.elementSet.add(item);
        }

    }

    private void updateElementCount(String item, int k) {

        Pair<String, Integer> targetItem = null;
        for (Iterator<Pair<String, Integer>> iterator = this.frequentElementsHeap.iterator(); iterator.hasNext(); ) {

            Pair<String, Integer> currentItem = iterator.next();
            if (currentItem.getL().equals(item)) {
                targetItem = currentItem;
                break;
            }
        }

        if (targetItem != null) {
            this.frequentElementsHeap.remove(targetItem);
            targetItem.setR(targetItem.getR() + 1);
            this.frequentElementsHeap.add(targetItem);
        }
    }

    public static void main(String[] args) {

        int[] test = {17, 1, 9, 13, 17, 2, 37, 9, 10};
        TopKItemsHeapImplementation topKItems = new TopKItemsHeapImplementation(6);

        for (int i = 0; i < test.length; i++) {
            topKItems.spaceSavingAlgorithm(String.valueOf(test[i]), 6);
        }

        System.out.println();

    }
}