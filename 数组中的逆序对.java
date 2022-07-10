// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
public class Solution {
    int kmod = 1000000007;
    int ret = 0;
    public int InversePairs(int [] array) {
        int[] tmp = new int[array.length];
        merge_sort(array,0,array.length-1,tmp);
        return ret;
    }
    public void merge_sort(int[] array,int l,int r,int[] tmp){
        if(l >= r){
            return;
        }
        int mid = l + (r-l)/2;
        merge_sort(array,l,mid,tmp);
        merge_sort(array,mid+1,r,tmp);
        merge(array,l,mid,r,tmp);
    }
    public void merge(int[] array,int l,int mid,int r,int[] tmp){
        int i = l;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= r){
            if(array[i] > array[j]) {
                tmp[k++] = array[j++];
                ret += (mid - i + 1);
                ret %= kmod;
            }else {
                tmp[k++] = array[i++];
            }
        }
        while(i <= mid){
            tmp[k++] = array[i++];
        }
        while(j <= r){
            tmp[k++] = array[j++];
        }
        for(k = 0,i=l;i<=r;i++,k++){
            array[i] = tmp[k];
        }
    }
}
