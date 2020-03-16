public class SortTest {
    public static void main(String[] args) {

    }

    public void bubbleSort(int[] a, int n) {
        if (n < 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            boolean flag = false;

            for (int j = 0; j < n - 1 - i; ++j) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            //没有数据交换提前退出
            if (!flag) break;
        }
    }

    /**
     * 插入排序
     *
     * @param a 数组
     * @param n 数组长度
     */
    public void insertSort(int[] a, int n) {
        if (n < 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            //查找插入的位置
            for (; j <= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort() {

    }



















}
