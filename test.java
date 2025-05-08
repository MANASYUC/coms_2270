public class test {

    int[] arr1 = {1,2};
    int[] arr2 = {3,4};

    double median = 0;
    int [] merged = new int [ nums1.length + nums2.length ];
    
    for(int i = 0; i < arr1.length;i++)
    {
        merged[i] = arr1[i];
    }
    int k = 0;
    for(int j = merged.length; i > arr1.length; i--)
    {
        merged[j] = arr2[k];
        k++;
    }
     

    for(int g = 0; g < merged.length;g++)
    {
        median+= merged[g];
    }

    return median / merged.length;
}
