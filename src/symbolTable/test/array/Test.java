package symbolTable.test.array;

public class Test {
    public void f1() {
        Integer[] a = new Integer[]{1, null, 3, 4, null, 6, 7};
        int size = 5;
        //j是为了判断是否填充完毕
        for (int i = 0,j = 0; i < a.length; i++) {
            if (j == size)
                break;
            if (a[i] == null) {
                if (a[i + 1] == null && j < size){
                    for (int k = i+2; k<a.length ;k++){
                        if (a[k] != null){
                            a[i] = a[k];
                            a[k] = null;
                            j++;
                            break;
                        }
                    }
                }else {
                    a[i] = a[i + 1];
                    if (a[i + 1] != null)
                        a[i + 1] = null;
                    j++;
                }
            }else {
                j++;
            }
        }
        for (Integer integer : a) {
            System.out.println(integer);
        }

    }
    private  static Integer[] a = new Integer[7];
    public void f2(Integer b){
//        Integer[] a = new Integer[10];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        a[5] = 6;
        a[6] = 8;

        int size = 7;

        System.out.println("是否有该值："+get(b, 0,size));

    }

    public Integer get(Integer b ,int low,int high){
        int index = -1;
        if (low <= high) {
            int mid = (low+high)/2;
            if (a[mid] < b) {    //中间值小了
                return get(b,mid+1,high);
            } else if (a[mid] > b) {  //中间值大了
                return get(b, low,mid-1);
            } else {
                return a[mid];
            }
        }
        return index;   //-1就是找不到
    }

    public static void main(String[] args) {
        new Test().f2(5);
    }
}
